package com.Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;

public class BillingDetailsPage extends BaseClass {
	
	@FindBy (xpath = "//input[@value='new']")
	WebElement newAddress;
	
	@FindBy (xpath = "//input[@value='existing']")
	WebElement existBtn;
	
	@FindBy (xpath = "//select[@name='address_id']")
	WebElement addressId;
	
	@FindBy (name = "firstname")
	WebElement firstName;
	
	@FindBy (name = "lastname")
	WebElement lastName;
	
	@FindBy (name = "address_1")
	WebElement addRess;
	
	@FindBy (name = "city")
	WebElement City;
	
	@FindBy (name = "postcode")
	WebElement postCode;
	
	@FindBy (name = "country_id")
	WebElement Country;
	
	@FindBy (name = "zone_id")
	WebElement State;
	
	@FindBy (xpath = "//input[@id='button-payment-address']")
	WebElement clickContinueBtn;
	
	
	public BillingDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void newAddRessClick() {
		Action.click(driver, newAddress);
		
	}
	public void billingDetails(String fName,  String lName, String adrs, String cty, String potCode, String coUntry, String sTutes ) {
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(addRess, adrs);
		Action.type(City, cty);
		Action.type(postCode, potCode);
		Action.selectByVisibleText(coUntry,Country);
		Action.selectByVisibleText(sTutes, State );
		
	}
	
	public DeliveryDetailsPage clickOnChekoutBtn() {
		Action.click(driver, clickContinueBtn);
		return new DeliveryDetailsPage();
	}

	public void existAddress(String add) {
		 Action.click(driver, existBtn);
		 Action.selectByVisibleText(add, addressId);
	}
}
