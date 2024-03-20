package exceltest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcelReadWrite2 {

	public static void main(String[] args) {
		String  filename  =  "D:\\tmp\\excel1.xlsx";
	//	excelWrite(filename);
		excelRead(filename);

	}

	// 엑셀 저장
	private static void excelWrite(String filename) {
		XSSFWorkbook      workbook  =  new  XSSFWorkbook();
		XSSFSheet         sheet     =  workbook.createSheet("시트 1");
		XSSFRow           row       =  sheet.createRow( 0 );
		XSSFCell          cell      =  row.createCell( 0 );
		cell.setCellValue("테스트 데이터");
		
		FileOutputStream    fos  = null;
	    try {
	    	fos  =  new FileOutputStream(filename);
	    	workbook.write( fos );
	    	System.out.println("파일저장 Ok");
		} catch (IOException e) {			
			System.out.println("파일저장 fail " + e.getMessage() );			
		} finally {
			try {
				fos.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}
		
	}

	// 엑셀 읽기
	private static void excelRead(String filename) {
		try (FileInputStream   fis        =  new  FileInputStream(filename) ) {
			XSSFWorkbook       workbook   =  new  XSSFWorkbook( fis );
			XSSFSheet          sheet      =  workbook.getSheetAt(0);
			int                rows       =  sheet.getLastRowNum() + 1;
			System.out.println(rows);
			
			for (int i = 0; i < rows; i++) {
				XSSFRow    row   =   sheet.getRow( i );
				if(row != null) {
					// int  cells  =  row.getPhysicalNumberOfCells();  // 해당줄의 cell 수
					int  cells  =  row.getLastCellNum();  // 해당줄의 cell 수
					for (int j = 0; j < cells; j++) {
						XSSFCell    cell   =  row.getCell( j );
						if( cell == null) {
							System.out.println( " ,");
							continue;
						}
						String      value  =  "";
						System.out.println(j);
						// 각셀에 담긴 데이터의 type 을 처리한다
						switch( cell.getCellType()  ) {
						case BLANK:
							value = "";
							break;
						case NUMERIC:   
							if( DateUtil.isCellDateFormatted(cell) )
								value = cell.getDateCellValue() + "";  // 날짜 type
							else
								value = cell.getNumericCellValue() + ""; // 숫자 								
							break;							
						case STRING:   
							value = cell.getStringCellValue();
							break;							
						case BOOLEAN:  
							value = cell.getBooleanCellValue() + "";							
							break;							
						case ERROR:  
							value = cell.getErrorCellString();
							break;							
						case FORMULA:   
							value = cell.getCellFormula();
							break;	
						}  // switch end
						
						System.out.print( value + ", " );
					} // for j end
					System.out.println();
				} // if end
			} // for i end
					
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
	}

}














