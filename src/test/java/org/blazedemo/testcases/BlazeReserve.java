package org.blazedemo.testcases;

import java.io.IOException;
import java.util.List;

import org.blazedemo.tests.base.BaseClass;
import org.blazedemo.tests.pages.Reserve;
import org.blazedemo.tests.utils.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeReserve extends BaseClass{

	@BeforeMethod
	public void getUrl() throws IOException {
		browserSetup();
		driver.get("https://blazedemo.com/reserve.php");
	}
	
	@DataProvider(name = "flightdata")
	public String[][] datafromExcel() throws IOException {
		return ExcelReader.readExcel("reserve");
	}
	
	@Test(dataProvider = "flightdata")
	public void test01(String flight) {
		Reserve res = new Reserve(driver);
		
		List<WebElement> trow = driver.findElements(By.xpath("//table[@class = 'table']/tbody/tr"));
		
		for(WebElement row : trow) {
			List<WebElement> tcol = row.findElements(By.tagName("td"));
			
			if(tcol.get(1).getText().equalsIgnoreCase(flight)) {
				tcol.get(0).findElement(By.tagName("input")).click();
				//res.getChooseFlight().click();
				break;
			}
	}
		
	}
}
