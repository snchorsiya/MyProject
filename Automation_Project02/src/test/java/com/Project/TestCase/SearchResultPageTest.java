package com.Project.TestCase;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.IndexPage;
import com.Project.Page.SearchResultPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	public SearchResultPageTest() {
		super();
	}
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		Log.startTestCase("searchResultPageTest");
		searchResultPage = new SearchResultPage();
	}
	
	@Test (groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvialbilityTest(String productName) {
		Log.info("user search product");
		searchResultPage = indexPage.searchProduct(productName);
		boolean result = searchResultPage.isProductAvailble();
		assertTrue(result);
		Log.info("Product availble");
		Log.endTestCase("searchResultPageTest");
	}
	
	
	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
