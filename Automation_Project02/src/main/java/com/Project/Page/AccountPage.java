package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class AccountPage extends BaseClass {
	
	@FindBy(xpath = "//body/div[@id='account-account']/ul[@class='breadcrumb']/li[1]/a[1]")
	WebElement clickHomeIcon;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickOnHomeIcon() {
		Action.click(driver, clickHomeIcon);
		return new HomePage();
	}

	public String getCurentURL() {
		String accountPageUrl = driver.getCurrentUrl();
		return accountPageUrl;
	}

}
