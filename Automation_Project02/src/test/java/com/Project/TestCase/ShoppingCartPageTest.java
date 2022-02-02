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
import com.Project.Page.ShoppingCartPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class ShoppingCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;

	public ShoppingCartPageTest() {

		super();
	}

	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
		Log.startTestCase("shoppingCartPageTest");
		shoppingCartPage = new ShoppingCartPage();
	}

	@Test (groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty) throws Exception {
		Log.info("user enter product name");
		searchResultPage = indexPage.searchProduct(productName);
		Log.info("user click on product button");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("user enter quantity");
		addToCartPage.enterQuantity(qty);
		Log.info("user click on AddToCart");
		addToCartPage.clickOnAddtoCart();
		Log.info("user click on Shopping cart link");
		shoppingCartPage = addToCartPage.clickOnShoppingCart();
		Log.info("user verify unit price");
		Double unitPrice = shoppingCartPage.getUnitPrice();
		Log.info("user verify Totle price");
		Double totlePrice = shoppingCartPage.getTotlePrice();
		Double totleExpectedPrice = (unitPrice*2);
		System.out.println(totlePrice);
		System.out.println(totleExpectedPrice);
		Assert.assertEquals(totlePrice, totleExpectedPrice);
		Log.endTestCase("shoppingCartPageTest");

	}

	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
