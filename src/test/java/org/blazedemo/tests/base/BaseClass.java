package org.blazedemo.tests.base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.blazedemo.tests.utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	public void loadproperties() throws IOException {
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\blazedemo\\tests\\config\\config.properties");
		FileReader fr = new FileReader(f);
		prop = new Properties();
		prop.load(fr);
		
	}
	
	public void browserSetup() throws IOException{
		loadproperties();
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			//driver.get(prop.getProperty("projecturl"));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void goTotUrl(String url) {
		driver.get(url);
	}
	
	public static String takeScreenshot() throws AWTException, IOException {
		Robot r = new Robot();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(d);
		BufferedImage bf = r.createScreenCapture(rect);
		File f = new File(".\\Screenshots\\blazedemo"+ System.currentTimeMillis() +".png");
		ImageIO.write(bf, "png", f);
		
		String absolutePath = f.getAbsolutePath();
		return absolutePath;
	}
	
	
	public void down() {
		if(driver!=null) {
		driver.close();
		}
	}
	
}
