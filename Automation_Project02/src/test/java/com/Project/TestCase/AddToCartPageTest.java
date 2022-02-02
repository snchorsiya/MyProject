package com.Project.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.AddToCartPage;
import com.Project.Page.IndexPage;
import com.Project.Page.SearchResultPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	public AddToCartPageTest() {

		super();
	}

	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		Log.startTestCase("AddToCart Test");
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
	}

	@Test (groups = {"Regression", "Sanity"},dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty) {
		Log.info("user search product");
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("user enter quantity");
		addToCartPage.enterQuantity(qty);
		Log.info("user click on AddToCart product");
		addToCartPage.clickOnAddtoCart();
		boolean result = addToCartPage.validateAddtoCartMsg();
		Assert.assertTrue(result);
		Log.endTestCase("AddToCart Test");
		
	}

	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
