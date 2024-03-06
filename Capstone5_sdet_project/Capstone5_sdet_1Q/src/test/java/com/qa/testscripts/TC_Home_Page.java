package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Home_Page extends Base_Class{

	Actions action; 
	@Test(priority = 1)
	public void hover() throws InterruptedException, IOException {
	    action = new Actions(driver); // Initialize Actions here
	    action.moveToElement(hp.mouse_hover).click().build().perform();
	    captureScreenshot("hover");
	    Thread.sleep(5000); 
	  }
	
	@Test(priority = 2)

	public void verifyHomePageTitle() throws IOException {
        String expectedTitle = "Blog Tool, Publishing Platform, and CMS – WordPress.org";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title doesn't match.");
        captureScreenshot("verifyHomePageTitle");
    }
	@Test(priority = 3)

	public void clickGetWordPress() throws IOException {
		hp.clickGetWordPress();
		 captureScreenshot("clickGetWordPress");
	}   
}
