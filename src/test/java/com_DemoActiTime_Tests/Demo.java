package com_DemoActiTime_Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	@Test
	public void TestA() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Binny/Downloads/SVG.html");

		List<WebElement> allelements = driver.findElements(By.xpath("//*"));

		Reporter.log("Total elements " + allelements.size(), true);
		int count = 0;
		Actions act = new Actions(driver);
		for (WebElement ele : allelements) {
			String tname = ele.getTagName();
			if (tname.equals("line")) {
				count++;
				String bfcolor = ele.getCssValue("stroke");
				Reporter.log("Before placing cuser " + bfcolor, true);
				act.moveToElement(ele).perform();
				Thread.sleep(2000);
				String afcolor = ele.getCssValue("stroke");
				Reporter.log("After placing cusor " + afcolor, true);
				Reporter.log("---------------------------", true);
				WebElement tooltip = ele.findElement(By.xpath("./following-sibling::[1]/[2]"));
				String text = tooltip.getText();
				Reporter.log("ToolTip information = " + text, true);
				Reporter.log("================================", true);
			}
		}
		Reporter.log("Total lines " + count, true);
		driver.close();
	}
}
