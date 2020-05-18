package com_DemoActiTime_Tests;

import java.awt.AWTException;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo4 {
	@Test
	public void TestA() throws InterruptedException, IOException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		WebElement img = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\demo.png"));
		// find the location(x and y axis) and size(height and width)
		int x = img.getLocation().getX();
		int y = img.getLocation().getY();
		int h = img.getSize().getHeight();
		int w = img.getSize().getWidth();

		System.out.println("x " + x);
		System.out.println("y " + y);
		System.out.println("h " + h);
		System.out.println("w " + w);

		// crop the image
		BufferedImage orgimg = ImageIO.read(new File("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\demo.png"));
		BufferedImage subimg = orgimg.getSubimage(x, y, w, h);

		ImageIO.write(subimg, "png", new File("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\org.png"));

		// read act
		BufferedImage aimg = ImageIO.read(new File("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\demo.png"));
		BufferedImage eimg = ImageIO.read(new File("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\org.png"));

		DataBuffer aimgpix = aimg.getData().getDataBuffer();
		DataBuffer eimgpix = eimg.getData().getDataBuffer();

		int apixcount = aimgpix.getSize();
		int epixcount = eimgpix.getSize();

		System.out.println("apix count " + apixcount);
		System.out.println("epix count " + epixcount);

		int matchcount = 0;
		int count = 0;
		if (apixcount > epixcount) {
			count = epixcount;
		} else {
			count = apixcount;
		}
		for (int i = 0; i < count; i++) {
			if (aimgpix.getElem(i) == eimgpix.getElem(i))
				;
			{
				matchcount++;
			}
		}

		int percent = (matchcount * 100) / epixcount;
		System.out.println("percent " + percent);
		Thread.sleep(2000);
		driver.close();
	}
}
