package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="/Users/krishna/eclipse-workspace/FreeCrmTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static FileInputStream fin=null;
	
	public static Object[][] getDataFromExcel(String sheetName){
		try {
			fin= new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fin);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
		 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			 System.out.println(data[i][j]);
			
		 }
		}
		return data;
		 
		
		
	}

}
