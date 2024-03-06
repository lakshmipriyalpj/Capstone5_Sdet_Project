package com.qa.testscripts;


import java.io.IOException;

import org.testng.annotations.Test;


public class TC_Photo_page extends TC_Download_Page{
	
	
	@Test(priority=7)
	public void enterInsearch() throws InterruptedException, IOException {
		pp.enterInsearch(search);
		captureScreenshot("enterInsearch");
	}
	@Test(priority=8)
	public void verifyImage() throws IOException
	{
		pp.verifyImage();
		captureScreenshot("verifyImage");
	}
}
