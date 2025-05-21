package org.blazedemo.tests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] readExcel(String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\BlazeDemo\\Excel\\balzedemo.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(stream);
		Sheet sheet = wb.getSheet(sheetname);
		int row = sheet.getPhysicalNumberOfRows();
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();
		 System.out.println(row);
		 System.out.println(cell);
		 
		String [][] testData= new String[row-1][cell];
		
		for(int i=1;i<row;i++) {
			for(int j=0;j<cell;j++) {
				DataFormatter format = new DataFormatter();
				testData[i-1][j]=  format.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
		
	}
}
