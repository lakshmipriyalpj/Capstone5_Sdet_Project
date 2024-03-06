package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_Download_Page extends TC_Home_Page{
	
	@Test(priority=4)
	public void Text_mid() throws IOException {
		String expected = "Get WordPress";
		String actual = dp.Text();
		//System.out.println("Actual Text: " + actual);
	    SoftAssert soft = new SoftAssert();
	    soft.assertEquals(actual, expected);
	    soft.assertAll(); 
	    captureScreenshot("Text_mid");
	}
	@Test(priority = 5)

	public void clickCommunity() throws IOException{
		dp.clickCommunity();
		captureScreenshot("clickCommunity");
	}
	@Test(priority = 6)

	public void click_photo_directory() throws InterruptedException, IOException {
		dp.click_photo_directory();
		Thread.sleep(2000);
		captureScreenshot("click_photo_directory");
	}
}
