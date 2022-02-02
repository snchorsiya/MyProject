package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;


public class ConfirmOrderPage extends BaseClass {
	
	@FindBy(linkText = "HP LP3065")
	WebElement oroductName;
	
	@FindBy(xpath = "//td[normalize-space()='$122.00']")
	WebElement untiPrice;
	
	@FindBy(xpath = "//td[normalize-space()='$252.00']")
	WebElement totlePrice;
	
	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement clickConfirmOrder;
	
	public ConfirmOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPric = untiPrice.getText();
		String unit = unitPric.replaceAll("[^a-zA-Z0-9", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotlePrice() {
		String totlePric = totlePrice.getText();
		String tot = totlePric.replaceAll("[^a-zA-Z0-9", "");
		double finalTotlePrice = Double.parseDouble(tot);
		return finalTotlePrice/100;
	}
	
	public SuccesPage clickOnCheckOut() {
		Action.fluentWait(driver, clickConfirmOrder, 30);
		Action.click(driver, clickConfirmOrder);
		return new SuccesPage();
	} 

}
