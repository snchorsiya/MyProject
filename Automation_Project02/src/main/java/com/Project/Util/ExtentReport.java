package com.Project.Util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReport extends TestListenerAdapter {
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";

		// ExtentReports extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName).viewConfigurer()
				.viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();

		final File CONF = new File("extent-config.xml");

		try {
			spark.loadXMLConfig(CONF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();

		extent.attachReporter(spark);
		extent.setSystemInfo("HostName", "localhost");
		extent.setSystemInfo("ProjectName", "OpenCart");
		extent.setSystemInfo("Tester", "Sheetal");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("browser", "chrome");

		spark.config().setDocumentTitle("OpenCartProject"); // Tile of report
		// spark.config().setReportName("Functional Test Automation Report"); // name of
		// the report
		spark.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		String destDir = dateFormat.format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/ScreenShot/" + destDir + tr.getName() + ".png";

		if (tr.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test case faild" + screenshotPath);
			logger.log(Status.FAIL, "Test case faild" + tr.getThrowable());

			//logger.addScreenCaptureFromPath(screenshotPath);
			logger.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();

	}
}
