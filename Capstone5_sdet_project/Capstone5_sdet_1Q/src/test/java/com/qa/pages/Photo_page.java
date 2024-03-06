package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testscripts.Base_Class;

public class Photo_page extends Base_Class{
	
	WebDriver driver;
	public Photo_page(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(className="search-field")
	WebElement searchAny;
	public void enterInsearch(String text) {
		// TODO Auto-generated method stub
		searchAny.sendKeys(text,Keys.ENTER);
		
	}
	
	@FindBy(xpath="//article[@id=\"post-38512\"]")
	WebElement VerifyImage;
	public void verifyImage()
	{
		VerifyImage.isDisplayed();
	}
}
