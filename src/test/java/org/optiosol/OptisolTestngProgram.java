package org.optiosol;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v126.page.Page.CaptureScreenshotFormat;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptisolTestngProgram {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void tc1(String browser) throws IOException {
		// TODO Auto-generated method stub
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("CHROME IS LAUNCHED");

		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("EDGE IS LAUNCHED");

		}

	}

	@Test
	public void tc2() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	public void tc3() {
		// TODO Auto-generated method stub
		String actual = driver.getTitle();
		String expect = "FBook";
//		if (actual == expect) {
//			System.out.println("expect is : " + expect);
//		} else {
//			System.out.println("actual is : " + actual);
//		}
		Assert.assertEquals(actual.contains("Facebook – log in or sign up"), expect.contains("FBook"));

	}

	@Test
	public void tc4() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','agilbertmessiah@gmail.com')", email);
		js.executeScript("arguments[0].setAttribute('value','7894561230')", password);

		Thread.sleep(3000);

		Object js1 = js.executeScript("return arguments[0].getAttribute('value')", email);
		System.out.println("E-mail field contains : " + js1);
		System.out.println("****************************");
		Object js2 = js.executeScript("return arguments[0].getAttribute('value')", password);
		System.out.println("Paasword field contains : " + js2);

	}

	@Test
	public void tc7() throws IOException {
		// TODO Auto-generated method stub
		driver.quit();

	}

	@BeforeMethod
	private void tc5() {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println("Date & Time is : " + d);
	}

	private void tc6(String name) throws IOException {
		// TODO Auto-generated method stub
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("F:\\inmakes\\screenshots\\" + name + ".png"));

	}
}
