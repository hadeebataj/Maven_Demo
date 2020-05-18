package com_Reports_Test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class extentReportDemo
{
	static ExtentReports reports;
	static ExtentTest test;
	@BeforeSuite
	public void StartReports()
	{
		reports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports.html",true);
		test = reports.startTest("Extent Demo");
	}
	@AfterSuite
	public void EndReports()
	{
		reports.endTest(test);
		reports.flush();
	}
	
	
	public static String getScreenShot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest  = new File("./"+System.currentTimeMillis()+".png");
		String efile = dest.getAbsolutePath();
		try
		{
			Files.copy(src, dest);
		}
		catch (Exception e) 
		{
			// Ignore
		}
		return efile;
	}

}
