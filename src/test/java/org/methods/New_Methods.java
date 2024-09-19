package org.methods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

public class New_Methods {
	private static final boolean File = false;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		Thread.sleep(1000);
		// WebElement forms =
		// driver.findElement(By.id("div-gpt-ad-ez-companion-ez-4998"));
		// Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", forms);
		// first name
		WebElement fname = driver.findElement(By.name("firstname"));
		Object firstname = js.executeScript("arguments[0].setAttribute('value','Gilbert')", fname);
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.doubleClick(fname).perform();
		// last name
		WebElement lname = driver.findElement(By.name("lastname"));
		Object lastname = js.executeScript("arguments[0].setAttribute('value','Messiah')", lname);
		Thread.sleep(3000);

		Object given_name1 = js.executeScript("return arguments[0].getAttribute('value')", fname);
		System.out.println("**************************************");
		System.out.println("FORM DETAILS");
		System.out.println("**************************************");
		System.out.println("First Name: " + given_name1);
		Object given_name2 = js.executeScript("return arguments[0].getAttribute('value')", lname);
		System.out.println("Last Name : " + given_name2);
		Thread.sleep(3000);
		// scroll
		WebElement emty_space = driver.findElement(By.id("div-gpt-ad-ez-companion-ez-4998"));
		js.executeScript("arguments[0].scrollIntoView(true)", emty_space);
		// male
		WebElement male = driver.findElement(By.xpath("//input[@value='Male']"));
		male.click();
		// check male is selected ot not
		boolean radio = male.isSelected();
		System.out.println("The Gender Male Radio Button is Selected ?" + radio);
		// female
		WebElement fmale = driver.findElement(By.xpath("//input[@value='Female']"));
		// check female is selected or not
		boolean radio2 = fmale.isSelected();
		System.out.println("The Gender Female Radio is Selected ?" + radio2);
		// screenshot method
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("F:\\inmakes\\screenshots\\methods.jpg"));


		driver.quit();
	}
}
