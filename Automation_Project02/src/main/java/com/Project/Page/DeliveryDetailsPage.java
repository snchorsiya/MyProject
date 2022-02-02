package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class DeliveryDetailsPage extends BaseClass {
	
	@FindBy(name = "shipping_address")
	WebElement clickShippingRd;
	
	@FindBy(xpath = "//div[@id='shipping-existing']//select[@name='address_id']")
	WebElement exitAddress1;
	
	@FindBy(xpath ="//input[@id='button-shipping-address']")
	WebElement clickContinuBtn;
	
	public DeliveryDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnReadioBtn(String adress) {
		 Action.click(driver, clickContinuBtn);
		 Action.selectByVisibleText(adress, exitAddress1);
	}
	
	public DeliveryMethodPage clickOnContinueBtn() {
		Action.click(driver, clickContinuBtn);
		return new DeliveryMethodPage();
	}

}
