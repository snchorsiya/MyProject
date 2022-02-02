package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class SuccesPage extends BaseClass {
	
	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	WebElement successMesg;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement clickContinuBtn;
	
	public SuccesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String showSuccessMsg() {
		String msg = successMesg.getText();
		return msg;
	}

	public HomePage clickOnContinuBrn() {
		Action.click(driver, clickContinuBtn);
		return new HomePage();
	}
}
