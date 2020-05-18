package com_Reports_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Demo2 extends extentReportDemo
{
	@Test
	public void testC()
	{
		test.log(LogStatus.INFO, "Test C information");
	}
	@Test
	public void testD()
	{
		test.log(LogStatus.ERROR,"test D error");
		Assert.fail();
	}
	
	@Test
	public void testE()
	{
		test.log(LogStatus.FATAL, " leading to failure");
	}
	
	@Test
	public void testF()
	{
		test.log(LogStatus.PASS, "Test F is pass");
	}	
	
}