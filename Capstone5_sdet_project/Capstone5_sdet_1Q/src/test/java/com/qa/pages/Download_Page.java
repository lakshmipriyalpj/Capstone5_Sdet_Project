package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testscripts.Base_Class;

public class Download_Page extends Base_Class {
	WebDriver driver;
	public Download_Page(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath ="//h1[@class=\"wp-block-heading has-text-align-center has-heading-1-font-size\"]" )
	WebElement Text;
	public String Text() {
		String actual = Text.getText();
		return actual;
		
	}

	@FindBy(xpath = "(//span[@class='wp-block-navigation-item__label'])[16]")
	WebElement community;
	public void clickCommunity() {
		community.click();
	}

	@FindBy(xpath = "(//span[@class='wp-block-navigation-item__label'])[18]")
	WebElement photo_directory;
	public void click_photo_directory() {
		photo_directory.click();
	}
}
