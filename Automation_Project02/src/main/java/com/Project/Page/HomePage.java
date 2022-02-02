package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy (xpath = "//h3[normalize-space()='Featured']")
	WebElement featuredShow;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurentURL() {
		String homePageUrl = driver.getCurrentUrl();
		return homePageUrl;
		
	}
	
	public boolean validFeature() {
		return Action.isDisplayed(driver, featuredShow);
	}

	
}
