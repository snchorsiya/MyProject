package com.Project.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.AddToCartPage;
import com.Project.Page.BillingDetailsPage;
import com.Project.Page.ConfirmOrderPage;
import com.Project.Page.DeliveryDetailsPage;
import com.Project.Page.DeliveryMethodPage;
import com.Project.Page.HomePage;
import com.Project.Page.IndexPage;
import com.Project.Page.LoginPage;
import com.Project.Page.PaymentMethodPage;
import com.Project.Page.SearchResultPage;
import com.Project.Page.ShoppingCartPage;
import com.Project.Page.SuccesPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	LoginPage loginPage;
	BillingDetailsPage billingDetailsPage;
	DeliveryDetailsPage deliveryDetailsPage;
	DeliveryMethodPage deliveryMethodPage;
	PaymentMethodPage paymentMethodPage;
	ConfirmOrderPage confirmOrderPage;
	SuccesPage succesPage;
	HomePage homePage;

	public EndToEndTest() {
		super();
	}

	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
		Log.startTestCase("EndToEndTest");
		shoppingCartPage = new ShoppingCartPage();
		loginPage = new LoginPage();
		billingDetailsPage = new BillingDetailsPage();
		deliveryDetailsPage = new DeliveryDetailsPage();
		deliveryMethodPage = new DeliveryMethodPage();
		paymentMethodPage = new PaymentMethodPage();
		confirmOrderPage = new ConfirmOrderPage();
		succesPage = new SuccesPage();
		homePage = new HomePage();
	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Regression")
	public void addToCartTest(String uname, String pswd) throws Exception {
		searchResultPage = indexPage.searchProduct("HP LP3065");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddtoCart();
		Log.info("User click on shoppingcart Link");
		shoppingCartPage = addToCartPage.clickOnShoppingCart();
		Log.info("User click on Checkout Button");
		loginPage = shoppingCartPage.clickOnCheckOut();
		Log.info("User should be login");
	//	billingDetailsPage = loginPage.returninglogin(prop.getProperty("username"), prop.getProperty("password"));
		billingDetailsPage = loginPage.returninglogin(uname, pswd);
	//	billingDetailsPage.newAddRessClick();
	//	billingDetailsPage.billingDetails("sheetal", "chorsiya", "1006, The First", "Ahmedabad", "382430", "American Samoa", "Rose Island");
		Log.info("User select exist Address");
		billingDetailsPage.existAddress("aasssa dsds, asasdas, dasdas, Angus, United Kingdom");
		Log.info("User click on CheckOut Button");
		deliveryDetailsPage = billingDetailsPage.clickOnChekoutBtn();
		Log.info("User click on Readio Button");
		deliveryDetailsPage.clickOnReadioBtn("aasssa dsds, asasdas, dasdas, Angus, United Kingdom");
		Log.info("User click on Continue Button");
		deliveryMethodPage = deliveryDetailsPage.clickOnContinueBtn();
		Log.info("User enter comment");
		deliveryMethodPage.enterComment("This Product Out of Stock");
		Log.info("User click on continue Button");
		paymentMethodPage = deliveryMethodPage.ClickOnContinu();
		Log.info("User click on Agree Button");
		paymentMethodPage.clickOnAgreeBtn();
		Log.info("User click on Payment button");
		confirmOrderPage = paymentMethodPage.clickOnPaymentBtn();
		Log.info("User click on Checkout Button");
		succesPage = confirmOrderPage.clickOnCheckOut();
		Log.info("Application should show validation message");
		String msgg = succesPage.showSuccessMsg();
		System.out.println(msgg);
		homePage = succesPage.clickOnContinuBrn();
		Log.endTestCase("EndToEndTest");
		
		

	}

	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
