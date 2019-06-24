package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BrowserFactory;
import com.google.common.io.Files;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="/Users/krishna/eclipse-workspace/FreeCrmTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static FileInputStream fin=null;
	WebDriver driver=BrowserFactory.getInstance().getDriver();
	
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
			e.printStackTrace();
		} catch (IOException e) {
			
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

	public static void waitForInvisibilityOfSpinner(WebDriver driver, WebElement element, int time){
		new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void clickOn(WebDriver driver, WebElement element, int time){
		new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void sendKEYS(WebDriver driver, WebElement element, int time, String value){
		new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}
		
	public void switchToFrame() {
		
	}
	
	public static void TakeScreenshot(String methodName, WebDriver driver) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/Users/krishna/eclipse-workspace/FreeCrmTest/screenshots/"+methodName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	}
	


