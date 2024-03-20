package exceltest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class  ExcelReadWrite {
	// 엑셀 저장하기
	public void writeExcel() {
		
		String  ext = "xlsx";  // 새버전
		// String  ext = "xls";  // 얫날 버전 97 - 2003
		
		// Workbook 생성 -> 엑셀 파일 (.xls)
		Workbook    workbook   =  createWorkbook(ext);
		
		// Workbook 안에 sheet 생성  (import ss : xlsx)
		Sheet      sheet1      =  workbook.createSheet("강도현");  
		
		// sheet 안에 특정 cell 생성
		Cell       cell1       =  getCell( sheet1, 0, 0 );
		
		// cell 데이터를 저장
		cell1.setCellValue( "Test 결과" );
		
		// cell 데이터 저장(숫자)
		cell1                 =  getCell(sheet1, 0, 1);
		cell1.setCellValue( 123 );
		
		// cell 날짜 저장
		cell1                 =  getCell(sheet1, 0, 2);
		cell1.setCellValue(  Calendar.getInstance().getTime() );
			
		
		//// 추가설정 시작
		// cell 에 데이터 포맷 지정
		CellStyle   style   =  workbook.createCellStyle();
		
		// 날짜 포맷
		style.setDataFormat(
			HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm")	
				);
		
		// 정렬포맷
		style.setAlignment(HorizontalAlignment.CENTER);
		//style.setVerticalAlignment(VerticalAlignment.TOP);
		
		// 넓이
		int   width = 256*50; // 너비 (1/256 단위 - 50글자기준)
		sheet1.autoSizeColumn(2, false); // 2번 cell 자동넓이설정 false
		sheet1.setColumnWidth(2, width);
		
		// 글꼴, 글자색상 (import org.apache.poi.ss.usermodel.Font;)
		Font  font  =  workbook.createFont();
		font.setFontName("HY견고딕");
		font.setColor( IndexedColors.GREEN.index );
		style.setFont( font );
		
		// 동작하지 않음
		// style.setFillBackgroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		// https://byul91oh.tistory.com/501
		// 색상 
		// 배경색 설정
		style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
				
		// style 적용
		cell1.setCellStyle(style);
		
		// 새로운 데이터
		 cell1    =   getCell(sheet1, 2, 0); 
		 cell1.setCellValue(  123 );
		 
		 cell1    =   getCell(sheet1, 2, 1);
		 cell1.setCellValue(  230 );
		 
		 cell1    =   getCell(sheet1, 2, 3);
		 //cell1.setCellValue("Sum(a3:b3)");  // 엑셀 수식
		 cell1.setCellFormula("Sum(a3:b3)");
		
		
		//------------------------------
		// 엑셀 저장
		String path = "D:\\tmp\\";
		File file = new File (path);
		if (!file.exists()) { //폴더가 존재하지 않으면
			file.mkdir();	//폴더를 만들어라 : make directory
		}
		String  filepath  = path+"excel1." + ext;
		this.writeExcelFile ( workbook, filepath  );
		System.out.println(filepath + "이 저장됨");		
	}
	
	//-------------------------------------------------
	// 엑셀 파일 저장
	private void writeExcelFile(Workbook workbook, String filepath) {
		File    file   =  new   File( filepath );
		// 자동 close 가 되는 try catch 문 : stream.close() 를 자동으로 수행
		try ( FileOutputStream  stream  
			= new FileOutputStream(filepath) ) {
			workbook.write( stream );   //  excel 파일 저장
		} catch( Throwable  e ) {
			e.printStackTrace();
		}
	}

	//----------------------------
	private Cell getCell(Sheet sheet, int rownum, int cellnum) {
		Row   row    =   getRow(sheet, rownum);		
		return   getCell(row, cellnum);
	}

	private Cell getCell(Row row, int cellnum) {
		Cell     cell   =  row.getCell(cellnum);
		if( cell == null )
			cell  =   row.createCell(cellnum);
		return   cell;
	}

	private Row getRow(Sheet sheet, int rownum) {
		Row   row    =  sheet.getRow(rownum);
		if(  row == null )
			row = sheet.createRow(rownum);
		return   row;
	}

	// Workbook 만들기
	private Workbook createWorkbook(String ext) {
		switch( ext ) {
		case   "xls":
			return   new HSSFWorkbook();
		case   "xlsx":
			return   new XSSFWorkbook();
		default:
			throw  new  NoClassDefFoundError();  // 강제로 예외를 발생시킨다 
		}		
	}
	
}

public class TestExcelReadWrite {
    // 라이브러리 추가 : \lib 폴더에 jar 를 복사
	// Java Build Path : Libraries Tab 
	// modules X
	// classpath 에 *.jar 추가	
	
	public static void main(String[] args) {
		ExcelReadWrite  excel = new ExcelReadWrite();
		excel.writeExcel();
	}

}












