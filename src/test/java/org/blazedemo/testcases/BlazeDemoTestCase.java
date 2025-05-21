package org.blazedemo.testcases;

import java.io.IOException;
import java.util.List;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.HomePage;
import org.blazedemo.tests.pages.Purchase;
import org.blazedemo.tests.pages.Reserve;
import org.blazedemo.tests.utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeDemoTestCase extends BaseClass{

	HomePage home;
	Reserve res;
	
	@BeforeMethod
	public void browser() throws IOException {
		browserSetup();
		
	}
	
	
	@DataProvider(name = "dropdownflight")
	public String[][] dropdownHome() throws IOException {
		return ExcelReader.readExcel("home");
	}
	
	@DataProvider(name = "chooseflight")
	public String[][] chooseFlight() throws IOException {
		return ExcelReader.readExcel("tc05");
	}
	
	@DataProvider(name = "bookflight")
	public String[][] bookFlight() throws IOException {
		return ExcelReader.readExcel("tc06");
	}
	
	@Test(priority = 1)
	public void tc01() {
		driver.get("https://blazedemo.com/");
		Assert.assertEquals(driver.getTitle(), "BlazeDemo");
		System.out.println("HomePage Verified");
	}

	@Test(priority = 2)
	public void tc02() {
		driver.get("https://blazedemo.com/");
		HomePage home = new HomePage(driver);
		home.getDepart().click();
	}

	@Test(priority = 3)
	public void tc03() {
		driver.get("https://blazedemo.com/");
		home = new HomePage(driver);
		home.getDest().click();
	}


	
	@Test(dataProvider = "dropdownflight", priority = 4)
	public void tc04(String from, String to) {
		driver.get("https://blazedemo.com/");
		home = new HomePage(driver);
		home.departSelect(from);
		home.destSelect(to);
		home.getFindFlights().click();
	}
	
	@Test(dataProvider = "chooseflight", priority = 5)
	public void tc05(String from, String to, String flight) {
		tc04(from, to);
		
		res = new Reserve(driver);
		
		List<WebElement> trow = driver.findElements(By.xpath("//table[@class = 'table']/tbody/tr"));
		
		for(WebElement row : trow) {
			List<WebElement> col = row.findElements(By.tagName("td"));
			if(col.get(1).getText().equalsIgnoreCase(flight)) {
				col.get(0).findElement(By.tagName("input")).click();
				break;
			}
		}
	}
	

	
	@Test(dataProvider = "bookflight", priority = 6)
	public void tc06(String from, String to, String flight, String name, String addr, String city, String state, String zipcode, String type, String cardnum, String month,
			  String year, String cardname) {
		//driver.get("https://blazedemo.com/purchase.php");
		tc05(from, to, flight);
		
		Purchase pur = new Purchase(driver);
		pur.setName(name);
		pur.setAddress(addr);
		pur.setCity(city);
		pur.setState(state);
		pur.setZip(zipcode);
//		pur.getType(type);
//		pur.setYear(year);
//		pur.setMonth(month);
//		pur.setCredit(cardnum);
//		pur.setCardname(cardname);
//		pur.getRemember().click();
		pur.getPurchase().click();
	}
	
	@Test(dataProvider = "chooseflight", priority = 7)
	public void tc07(String from, String to, String flight) {
		tc05(from, to, flight);
		Purchase pur = new Purchase(driver);
		pur.getPurchase().click();
	}
	
	@Test(dataProvider = "chooseflight", priority = 8)
	public void tc08(String from, String to, String flight) throws InterruptedException {
		tc05(from, to, flight);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
	@Test(dataProvider = "bookflight", priority = 9)
	public void tc11(String from, String to, String flight, String name, String addr, String city, String state, String zipcode, String type, String cardnum, String month,
			  String year, String cardname) {
		tc05(from, to, flight);
		
		Purchase pur = new Purchase(driver);
		pur.setName(name);
		pur.setAddress(addr);
		pur.setCity(city);
		pur.setState(state);
		pur.setZip(zipcode);
		pur.getType(type);
		pur.getYear().clear();
		pur.setYear(year);
		pur.getMonth().clear();
		pur.setMonth(month);
		pur.setCredit(cardnum);
		pur.setCardname(cardname);
		pur.getRemember().click();
		pur.getPurchase().click();
	
	}

	@Test(priority = 10)
	public void tc12() throws InterruptedException {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));      //Desktop
		driver.get("https://blazedemo.com/");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='navbar-inner']")).isDisplayed());
		Thread.sleep(3000);
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(768,1024)); 
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='navbar-inner']")).isDisplayed());
		Thread.sleep(3000);
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(375,667)); 
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='navbar-inner']")).isDisplayed());
		
	}
	
	@AfterMethod
	public void shutdown() {
		down();
	}
	
}
