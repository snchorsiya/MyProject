package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.Base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	@FindBy (xpath = "//h1[normalize-space()='Register Account']")
	WebElement showRegistAccount;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String showRegisterMsg() {
		String regMsg = showRegistAccount.getText();
		return regMsg;
	}

}
