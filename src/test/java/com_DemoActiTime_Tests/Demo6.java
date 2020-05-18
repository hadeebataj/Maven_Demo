package com_DemoActiTime_Tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Demo6
{
	@Test
	public void testA() throws IOException
	{
		FileReader reader = new FileReader(new File("./src/test/resources/DataA.properties"));
		
		Properties p = new Properties();
		p.load(reader);
		
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");
		System.out.println(un);
		System.out.println(pw);
	}
}
