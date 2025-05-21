package org.blazedemo.testcases;

import java.io.IOException;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.HomePage;
import org.blazedemo.tests.utils.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Blazedemo extends BaseClass{

	HomePage home;
	
	@BeforeMethod
	public void test01() throws IOException {		
		browserSetup();
		driver.get("https://blazedemo.com/");
	}
	
	@Test(priority=1)
	public void test02() {
		home = new HomePage(driver);
		home.getdestLink().click();
	}
	
	@Test(priority = 2)
	public void test03() {
		home = new HomePage(driver);
		home.getLogin().click();
	}
	
	@Test(priority = 3)
	public void test04() {
		home = new HomePage(driver);
		home.getTravel().click();
	}
	
	
	@DataProvider(name = "dropdownData")
	public Object[][] dropdown() throws IOException  {
		 return ExcelReader.readExcel("home");
		
	}
	
	@Test(dataProvider = "dropdownData", priority = 4)
	public void test05(String departure, String destination) {
		home = new HomePage(driver);
		home.departSelect(departure);
		home.destSelect(destination);
	}
	
	@Test(priority=5)
	public void test06() {
		home = new HomePage(driver);
		home.getFindFlights().click();
	}
	
	
	@AfterMethod
	public void test10() {
		//down();
	}
}
