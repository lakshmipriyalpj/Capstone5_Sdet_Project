package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testscripts.Base_Class;

public class Home_Page extends Base_Class{
	
	WebDriver driver;
	public Home_Page(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="//*[@id=\"modal-1-content\"]/ul/li[4]/button")
	public WebElement mouse_hover;
	public void hover() {
		mouse_hover.isDisplayed();
	}
	
	@FindBy(linkText="Get WordPress")
	public WebElement GetWordPress;
	public void clickGetWordPress() {
		GetWordPress.click();
	}
}
