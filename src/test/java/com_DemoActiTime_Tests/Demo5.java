package com_DemoActiTime_Tests;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo5
{
	@Test
	public void TestA() throws InterruptedException, IOException, AWTException
	{
		FileReader reader = new FileReader("./src/test/resources/DataA.properties");
		Properties p = new Properties();
		p.load(reader);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys(p.getProperty("un"));
		driver.findElement(By.id("txtPassword")).sendKeys(p.getProperty("pw"));
		driver.findElement(By.id("btnLogin")).click();
		driver.close();
	}
}
