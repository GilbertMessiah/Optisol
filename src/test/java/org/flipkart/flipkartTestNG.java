package org.flipkart;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartTestNG {
	WebDriver driver;
	Actions a;
	
	
	@BeforeTest
	public void start() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void date() {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void tc1() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc2() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		//electronics section
		WebElement electronics = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
		//Action class
		Actions a = new Actions(driver);
		//move to element
		a.moveToElement(electronics).perform();
		//screenshot for electronics  section
		Screenshot("Electronic Section");
		//bluetooth option
		WebElement bluetooth = driver.findElement(By.xpath("//a[text()='Bluetooth Headphones']"));
		//click bluetooth section
		bluetooth.click();
		//debug
		Thread.sleep(2000);
		//screenshot bluethooth section
		Screenshot("Bluetooth Section");
	}
	
	private void Screenshot(String name) throws IOException {
		// TODO Auto-generated method stub
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("F:\\inmakes\\screenshots\\"+name+".png"));
	}
	
	@Test
	private void tc3() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//select bluetooth
		WebElement selected_blue = driver.findElement(By.xpath("//img[@alt='Boult Z40 with Zen ENC Mic, 60H Battery Life, Low Latency Gaming, Made In India, 5.3 Bluetooth']"));
		//click selected bluetooth
		selected_blue.click();
		//windows handle
		String parentid = driver.getWindowHandle();
		Set<String> childid = driver.getWindowHandles();
		for (String allid : childid) {
			if (allid != parentid) {
				driver.switchTo().window(allid);
			}
		}
		
	
		//debug
		Thread.sleep(2000);
		//screenshot selected bluethooth
		Screenshot("Selected Bluetooth");
	}
}