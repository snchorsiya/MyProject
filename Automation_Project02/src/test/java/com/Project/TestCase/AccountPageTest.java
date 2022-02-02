package com.Project.TestCase;

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
public class AccountPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountPage accountPage;
	HomePage homePage;
	
	public AccountPageTest() {
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		Log.startTestCase("Account create Test");
		accountPage = new AccountPage();
		homePage = new HomePage();
	}
	
	@Test (dataProvider = "credentials", dataProviderClass = DataProviders.class , groups = "Sanity")
	public void clickOnHomeicon(String uname, String pswd) throws Exception {
		Log.info("user is going to click on MyAccount");
		loginPage = indexPage.clickOnMyAccount();
		Log.info("user is going to click on MyLogin");
		loginPage = indexPage.ClickOnMyLogin();
		Log.info("Enter Username and Password");
	//	accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountPage = loginPage.login(uname, pswd);
		Log.info("Verifying if user click on Home Icon");
		homePage = accountPage.clickOnHomeIcon();
		Log.endTestCase("Account create Test");
	}
	
	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
