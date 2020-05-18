package com_DemoActiTime_Tests;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1
{
	@Test
	public void TestA() throws InterruptedException, IOException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(5000);
		WebElement up = driver.findElement(By.id("wdgt-file-upload"));
		up.click();
		//Actions act = new Actions(driver);
		//act.click(up).perform();
		Thread.sleep(2000);
		Robot r = new Robot();
		//get the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//create object of rectangle class
		Rectangle rect = new Rectangle(d);
		BufferedImage img = r.createScreenCapture(rect);
		//store in preferred location
		ImageIO.write(img, "png", new File("./DemoA.png"));
		Thread.sleep(2000);
		driver.close();		
		
	}
}

