package com_DemoActiTime_Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 {
	@Test
	public void TestA() throws InterruptedException, IOException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");

		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));

		for (WebElement link : alllinks) {
			System.out.println("link " + link.getText());
			String href = link.getAttribute("href");
			System.out.println("Url " + href);
			try {
				URL url = new URL(href);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				int code = con.getResponseCode();
				if (code == 200) {
					System.out.println("Link is not Broken");
					System.out.println(con.getResponseMessage());
				} else {
					System.out.println("Link is broken");
					System.out.println(con.getResponseMessage());
				}
				System.out.println("========================");
			} catch (Exception e) {
				System.out.println("Url is invalide");
				System.out.println("==================================");
			}
		}
		Thread.sleep(2000);
		driver.close();

	}
}