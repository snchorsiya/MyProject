package com.Project.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.AccountPage;
import com.Project.Page.HomePage;
import com.Project.Page.IndexPage;
import com.Project.Page.LoginPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountPage accountPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		Log.startTestCase("homePageTest");
		homePage = new HomePage();
		accountPage = new AccountPage();
	}
	
	
	@Test (dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void featuredListTest(String uname, String pswd) throws Exception {
		Log.info("User click on MyAccount button");
		loginPage=indexPage.clickOnMyAccount();
		Log.info("User click on MyLogin button");
		loginPage = indexPage.ClickOnMyLogin();
		Log.info("User enter username and password");
	//	accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountPage = loginPage.login(uname, pswd);
		Log.info("Verifying if user click on Home Icon");
		homePage = accountPage.clickOnHomeIcon();
		boolean result = homePage.validFeature();
		Assert.assertTrue(result);
		Log.endTestCase("homePageTest");
		
	}
	
	
	
	
	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
