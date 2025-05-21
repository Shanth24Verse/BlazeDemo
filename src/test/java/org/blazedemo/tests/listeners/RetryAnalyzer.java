package org.blazedemo.tests.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		
		int max = 3, min = 1;
		
		while(min<=max) {
			min++;
			return true;
		}
		
		return false;
	}

}
