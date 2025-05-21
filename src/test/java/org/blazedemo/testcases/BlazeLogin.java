package org.blazedemo.testcases;

import java.io.IOException;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.Login;
import org.blazedemo.tests.utils.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeLogin extends BaseClass{

	Login log;
	
	@BeforeMethod
	public void browser() throws IOException {
		browserSetup();
		driver.get("https://blazedemo.com/login");
	}
	
	@DataProvider(name = "logindata")
	public String[][] excelLoginData() throws IOException {
		return ExcelReader.readExcel("login");
	}
	
	@Test(dataProvider = "logindata", priority = 1)
	public void test01(String email, String pass) {
		log = new Login(driver);
		log.setEmail(email);
		log.setPassword(pass);
		log.getCheck();
		log.getLogin().click();
		
	}
	
	
	@Test(priority = 2, enabled = false)
	public void test02() {
		log = new Login(driver);
		log.getForgot().click();
	}
	
	@AfterMethod
	public void down() {
		driver.close();
	}
	
}
