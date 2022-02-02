package com.Project.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project.Base.BaseClass;
import com.Project.Page.AccountPage;
import com.Project.Page.IndexPage;
import com.Project.Page.LoginPage;
import com.Project.TestData.DataProviders;
import com.Project.Util.ListenerTestReport;
import com.Project.Util.Log;

@Listeners(ListenerTestReport.class)
public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginPageTest() {
		super();
	}
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		initialization(browser);
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
	}
	
	@Test (priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class , groups = {"Smoke", "Sanity"})
	public void userLogin(String uname, String pswd) throws Exception {
		Log.info("user is going to click on MyAccount");
		loginPage = indexPage.clickOnMyAccount();
		Log.info("user is going to click on MyLogin");
		loginPage = indexPage.ClickOnMyLogin();
		Log.info("Enter Username and Password");
	//	accountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountPage = loginPage.login(uname, pswd);
		String actualURL = accountPage.getCurentURL();
		String expectedURL = "https://demo.opencart.com/index.php?route=account/account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.endTestCase("loginTest");

	}

	@AfterMethod (groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}


}
