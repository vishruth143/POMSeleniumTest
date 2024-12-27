package com.pta.qa.util;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.pta.qa.base.TestBase;

public class CustomListener implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {		
		TestBase.test.log(Status.PASS, MarkupHelper.createLabel(result.getName().toUpperCase()+": PASS", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {		
		//TestBase.test.log(Status.FAIL, result.getThrowable().getMessage());
		TestBase.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName().toUpperCase()+": FAIL", ExtentColor.RED));
		try {
			TestBase.test.addScreenCaptureFromPath(TestBase.captureScrenshot());
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}	
}
