package com_Reports_Test;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Log4j 
{
	private static final Logger logger = Logger.getLogger(Log4j.class);

	@Test
	public void testA()
	{
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warn message");
		logger.fatal("This is fatal message");
		logger.error("This is error message");
		System.out.println("hiii");
	}
}
