package com.Project.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.IndexPage;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	public IndexPageTest() {
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		Log.startTestCase("indexPageTest");
		indexPage = new IndexPage();
	}
	
	@Test (priority = 1, groups = "Smoke")
	public void verifyLogo() {
		Log.info("user verify logo");
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("user verify logo successfully");
	}
	
	@Test (priority = 2, groups = "Smoke")
	public void verifyTitle() {
		Log.info("user verify title");
		String title =indexPage.getMystoreTitle();
		System.out.println("Title name: "+ title);
		Log.info("user verify title successfully");
		Log.endTestCase("indexPageTest");
	}
	

	
	
	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
