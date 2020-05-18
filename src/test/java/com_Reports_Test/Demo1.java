package com_Reports_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 extends extentReportDemo
{
	@Test
	public void testA()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String atitle = driver.getTitle();
		String etitle = "Googles";
		if(atitle.equals(etitle))
		{
			Reporter.log("psss",true);
			test.log(LogStatus.PASS, "Navigate to specifed url");
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(extentReportDemo.getScreenShot(driver))+ "Incorrect webpage");
		}
		driver.close();
	}
	@Test(dependsOnMethods = "testA")
	public void testB()
	{
		test.log(LogStatus.SKIP, "This method is skipped");
	}

}