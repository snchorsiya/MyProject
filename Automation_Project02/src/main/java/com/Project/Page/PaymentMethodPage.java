package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class PaymentMethodPage extends BaseClass {

	@FindBy(xpath = "//input[@name='payment_method']")
	WebElement clickRedio;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement AgreeBtn;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement clickPaymentBtn;

	public PaymentMethodPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAgreeBtn() throws Exception {
		Action.fluentWait(driver, AgreeBtn, 20);
		System.out.println(AgreeBtn.isSelected());
	//	Action.click(driver, AgreeBtn);
		System.out.println(AgreeBtn.isSelected());

	}

	public ConfirmOrderPage clickOnPaymentBtn() throws Exception {
		Action.click(driver, clickPaymentBtn);
		return new ConfirmOrderPage();
	}
}
