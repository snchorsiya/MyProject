package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class DeliveryMethodPage extends BaseClass {
	
	@FindBy(name = "shipping_method")
	WebElement clickShippingMethod;
	
	@FindBy(name = "comment")
	WebElement enterComment;
	
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement clickContinueBtn;
	
	
	public DeliveryMethodPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnShippingRedio() {
		Action.click(driver, clickShippingMethod);
	}
	
	public void enterComment(String commt) {
		Action.type(enterComment, commt);
	}
	
	public PaymentMethodPage ClickOnContinu() {
		Action.click(driver, clickContinueBtn);
		return new PaymentMethodPage();
	}

}
