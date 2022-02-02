package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class ShoppingCartPage extends BaseClass {
	
	@FindBy(xpath = "//td[normalize-space()='$122.00']")
	WebElement unitPrice;
	
	@FindBy(xpath = "//tbody//tr//td[6]")
	WebElement totlePrice;
	
	@FindBy(linkText = "Checkout")
	WebElement checkoutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPric = unitPrice.getText();
		String unit = unitPric.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotlePrice() {
		String totlePric = totlePrice.getText();
		String tot = totlePric.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotlePrice = Double.parseDouble(tot);
		return finalTotlePrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.fluentWait(driver, checkoutBtn, 20);
		Action.click(driver, checkoutBtn);
		return new LoginPage();
		
		
	}
	
	

}
