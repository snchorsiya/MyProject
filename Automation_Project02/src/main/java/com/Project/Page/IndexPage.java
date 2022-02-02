package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement MyAccountClick;

	@FindBy(linkText = "Login1")
	WebElement MyLoginClick;
	
	@FindBy(xpath = "//a[normalize-space()='Your Store']")
	WebElement MyLogo;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnMyAccount() {
		Action.click(driver, MyAccountClick);
		return new LoginPage();
	}
	
	public LoginPage ClickOnMyLogin() {
		Action.fluentWait(driver, MyLoginClick, 0);
		Action.click(driver, MyLoginClick);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, MyLogo);
	}

	public String getMystoreTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchBox, productName);
		Action.click(driver, searchBtn);
		return new SearchResultPage();
	}
}
