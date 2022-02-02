package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement passWord;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement clickLoginBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement clickContinueBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage login(String uname, String psw) throws Exception {
		Action.type(userName, uname);
		Action.type(passWord, psw);
		Action.JSClick(driver, clickLoginBtn);
		return new AccountPage();
	}
	
	public BillingDetailsPage returninglogin(String uname, String psw) throws Exception {
		Action.type(userName, uname);
		Action.type(passWord, psw);
		Action.JSClick(driver, clickLoginBtn);
		return new BillingDetailsPage();
	}
	
	public AccountCreationPage createNewAccount() {
		Action.click(driver, clickContinueBtn);
		return new AccountCreationPage();
	}

}
