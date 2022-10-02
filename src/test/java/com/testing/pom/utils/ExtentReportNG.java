package com.testing.pom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportNG {

	static ExtentReports extent;
	public static ExtentReports setupReport() {
		String path = "test-output/TestReport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("POM Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Queue Codes");
		extent.setSystemInfo("User Name", "Nagesh Kale");
		return extent;
		
		
	}
}
