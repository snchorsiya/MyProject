package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(name = "quantity")
	WebElement quantity;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement addToCartMsg;
	
	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quty) {
		Action.type(quantity, quty);
	}
	
	public void clickOnAddtoCart() {
		Action.click(driver,addToCartBtn);
	}
	
	public boolean validateAddtoCartMsg() {
		Action.fluentWait(driver, addToCartMsg, 20);
		return Action.isDisplayed(driver, addToCartMsg);
	}
	
	public ShoppingCartPage clickOnShoppingCart() throws Exception {
		Action.click(driver, shoppingCartBtn);
		return new ShoppingCartPage();
	}
	

}
