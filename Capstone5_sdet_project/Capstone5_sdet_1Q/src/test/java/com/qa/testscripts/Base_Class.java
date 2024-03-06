package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.pages.Download_Page;
import com.qa.pages.Home_Page;
import com.qa.pages.Photo_page;
import com.qa.utilites.ReadConfig;


public class Base_Class {
	public WebDriver driver;
	public static Photo_page pp;
	public static Home_Page hp ;
	public static Download_Page dp;
	//public ResourceBundle properties;
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String search=readconfig.getSearch();

	@BeforeTest
	public void setUp() throws InterruptedException { 
		
			
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Lakshmi Priya\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");
		driver= new EdgeDriver();
	    driver.manage().window().maximize();
     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     	driver.get(baseURL);
		hp= new Home_Page(driver);
		dp=new Download_Page(driver);	
		pp=new Photo_page(driver);
	}
	
	@AfterTest
    public void tearDown() {
            driver.quit();
        
    }

	public void captureScreenshot(String tName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tName + ".png");
		FileUtils.copyFile(source, target);

	}
}
