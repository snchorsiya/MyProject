package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath = "//div[@class='image']//a")
	WebElement productResult;
	
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailble() {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(driver, productResult);
		return new AddToCartPage();
	}

}
