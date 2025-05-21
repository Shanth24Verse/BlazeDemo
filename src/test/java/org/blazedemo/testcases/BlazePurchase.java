package org.blazedemo.testcases;

import java.io.IOException;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.Purchase;
import org.blazedemo.tests.utils.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazePurchase extends BaseClass{

	Purchase pur;
	
	@BeforeMethod
	public void browser() throws IOException {
		browserSetup();
		driver.get("https://blazedemo.com/purchase.php");
	}
	
	@DataProvider(name = "purchase")
	public String[][] readdatas() throws IOException {
		return ExcelReader.readExcel("purchase");
	}
	
	@Test(dataProvider = "purchase", priority = 1)
	public void test01(String name, String addr, String city, String state, String zipcode, String type, String cardnum, String month,
															  String year, String cardname) {
		pur = new Purchase(driver);
		pur.setName(name);
		pur.setAddress(addr);
		pur.setCity(city);
		pur.setState(state);
		pur.setZip(zipcode);
		pur.getType(type);
		pur.setYear(year);
		pur.setMonth(month);
		pur.setCredit(cardnum);
		pur.setCardname(cardname);
		pur.getRemember().click();
		pur.getPurchase().click();
	}

	@Test(priority=2)
	public void checkbox() {
		pur = new Purchase(driver);
		pur.getRemember().click();
	}
	
	@Test(priority=3)
	public void test03() {
		pur = new Purchase(driver);
		System.out.println(pur.getRemember().isEnabled());
	}
	
	@Test(priority = 4)
	public void test02() {
		pur = new Purchase(driver);
		pur.getPurchase().click();
	}
	
	@AfterMethod
	public void down() {
		driver.close();
	}
}
