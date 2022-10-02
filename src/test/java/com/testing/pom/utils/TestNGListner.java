package com.testing.pom.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestNGListner implements ITestListener{

	ExtentReports extent = ExtentReportNG.setupReport();
	ExtentTest test;
	ThreadLocal<ExtentTest>extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
	extentTest.get().log(Status.PASS, "Login Test Case");	
	}
	
	public void onTestFailure(ITestResult arg0) {
		extentTest.get().log(Status.FAIL, "Due to assertion failure");	
		}
	
	public void onTestSkipped(ITestResult arg0) {
		extentTest.get().log(Status.SKIP, "Skipped Test Cases");	
		}
	
	public void onFinish(ITestContext arg0) {
		extent.flush();
		}
}
