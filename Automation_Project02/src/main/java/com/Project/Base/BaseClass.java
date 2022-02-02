package com.Project.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.Project.ActionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
	}

	public BaseClass() {

		prop = new Properties();
		System.out.println("super constructor invoked");
		try {
			FileInputStream file = new FileInputStream(
					"E:\\SeleniumAutomation2022\\Automation_Project02\\src\\main\\java\\com\\Project\\Config\\Config.properties");
			prop.load(file);
			System.out.println("driver: " + driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void initialization(String browser) {

	//	String br = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));
		Action.implicitWait(driver, 30);
		Action.pageLoadTimeOut(driver, 40);
	}
	
	public void faileScreenShot(String tname) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		String destDir = dateFormat.format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShot/" + destDir + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot taken....");
	}

}
