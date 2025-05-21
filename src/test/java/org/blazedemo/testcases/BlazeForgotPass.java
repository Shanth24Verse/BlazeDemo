package org.blazedemo.testcases;

import java.io.IOException;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.Forgot;
import org.blazedemo.tests.utils.ExcelReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeForgotPass extends BaseClass{

	@BeforeMethod
	public void browser() throws IOException {
		browserSetup();
		driver.get("https://blazedemo.com/password/reset");
	}
	
	@DataProvider(name = "forgotData")
	public String[][] excelForgotData() throws IOException {
		return ExcelReader.readExcel("forgot");
	}
	
	@Test(dataProvider = "forgotData")
	public void test01(String email) {
		Forgot fg = new Forgot(driver);
		fg.setEmail(email);
		fg.getReset().click();
	}
	
	@Test
	public void test02() {
		Forgot fg = new Forgot(driver);
		fg.getReset().click();
	}
}
