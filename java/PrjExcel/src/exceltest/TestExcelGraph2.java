package exceltest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcelGraph2 {
	public static void main(String... args) {
		new TestExcelGraph2();
	}

	public TestExcelGraph2() {
		//String version = "xls";
		var version = "xlsx";
		// Workbook 취득.
		Workbook workbook = getWorkbook("d:\\tmp\\scores.xlsx", version);
		// Workbook안에 시트 취득.
		Sheet sheet = workbook.getSheetAt(0);

		int[] datas = getFileData();

		dataSet(sheet, datas);

		writeExcel(workbook, "d:\\tmp\\result." + version);
	}

	private int[] getFileData() {
		int[] datas = new int[20];
		String fname = "d:\\tmp\\indata.txt";
		
		int  p = 0;
		FileReader     fr  = null;
		BufferedReader br  = null;
		try { 
			fr  = new FileReader(fname);
			br  = new BufferedReader(fr);
			String line = "";
			br.readLine();
			while( (line=br.readLine()) != null) {
				String [] li = line.split(",");
				datas[p] = Integer.parseInt( li[1].trim() );
				p++;
				datas[p] = Integer.parseInt( li[2].trim() );
				p++;
			}			
		} catch( IOException e) {
			e.printStackTrace();			
		} finally {
			try {
				if( br != null ) br.close();
				if( fr != null ) fr.close();
			} catch (IOException e) {				
			}
		}
		
		return datas;
	}

	private void dataSet(Sheet sheet, int[] datas) {
		// Sheet에서 셀 취득 후 데이터 설정
		int idx = 0;
		for (int i = 1; i <= datas.length/2; i++) {
			getCell(sheet, i, 2).setCellValue(datas[idx]);
			idx++;
			getCell(sheet, i, 3).setCellValue(datas[idx]);
			idx++;
		}

		// 함수값 재 설정
		for (int i = 1; i <= 10; i++) {
			getCell(sheet, i, 1).setCellFormula(String.format("AVERAGE(C%d:D%d)", i + 1, i + 1));
		}

	}

	// Workbook 읽어들이기
	public Workbook getWorkbook(String filename, String version) {
		try (FileInputStream stream = new FileInputStream(filename)) {
			// 표준 xls 버젼
			if ("xls".equals(version)) {
				return new HSSFWorkbook(stream);
				// 확장 xlsx 버젼
			} else if ("xlsx".equals(version)) {
				return new XSSFWorkbook(stream);
			}
			throw new NoClassDefFoundError();
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	// Sheet로 부터 Row를 취득, 생성하기
	public Row getRow(Sheet sheet, int rownum) {
		Row row = sheet.getRow(rownum);
		if (row == null) {
			row = sheet.createRow(rownum);
		}
		return row;
	}

	// Row로 부터 Cell를 취득, 생성하기
	public Cell getCell(Row row, int cellnum) {
		Cell cell = row.getCell(cellnum);
		if (cell == null) {
			cell = row.createCell(cellnum);
		}
		return cell;
	}

	public Cell getCell(Sheet sheet, int rownum, int cellnum) {
		Row row = getRow(sheet, rownum);
		return getCell(row, cellnum);
	}

	public void writeExcel(Workbook workbook, String filepath) {
		try (FileOutputStream stream = new FileOutputStream(filepath)) {
			workbook.write(stream);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
