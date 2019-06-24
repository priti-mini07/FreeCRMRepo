package com.crm.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryListener implements IRetryAnalyzer{
    static int counter=0;
    int retryLimit=2;
	@Override
	public boolean retry(ITestResult result) {
		  
		
		if(counter<retryLimit) {
			System.out.println("executed---------------------------" +counter);
			counter++;
			return true;
			
		}
		return false;
	}

}
