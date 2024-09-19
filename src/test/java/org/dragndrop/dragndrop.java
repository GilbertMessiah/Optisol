package org.dragndrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragndrop {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/drag-and-drop-circles");
		WebElement source = driver.findElement(By.className("red"));
		WebElement target = driver.findElement(By.id("target"));
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
}
