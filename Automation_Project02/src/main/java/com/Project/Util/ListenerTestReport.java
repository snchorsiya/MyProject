package com.Project.Util;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Project.ActionDriver.Action;
import com.Project.Base.BaseClass;


public class ListenerTestReport extends BaseClass  implements ITestListener {
	Action action= new Action();
	
	@Override
	public void onTestStart(ITestResult rt) {
	

	}

	@Override
	public void onTestSuccess(ITestResult rt) {
		
	}

	
	@Override
	public void onTestFailure(ITestResult rt) {
		System.out.println("FAILED Test");
		try {
			faileScreenShot(rt.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Override
	public void onTestSkipped(ITestResult rt) {

	}

}
