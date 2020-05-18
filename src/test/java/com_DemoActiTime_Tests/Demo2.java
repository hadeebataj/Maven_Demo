package com_DemoActiTime_Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class Demo2 
{
	@Test
	public void testA() throws IOException
	{
		URL url = new URL("https://funds.qsp.ca");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		int status = con.getResponseCode();
		System.out.println(status);
		
		String msg = con.getResponseMessage();
		System.out.println(msg);
		
	}
}
