package org.upload_file;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class using_sendkey_methods {
	static WebDriver driver;

	@BeforeClass
	private static void s_browser() {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	@Test
	private void tc1() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		WebElement findElement1 = driver.findElement(By.xpath("//input[@type='file']"));
		findElement1.sendKeys("E:\\movies\\Ayali\\www.1TamilMV.mobi - Ayali (2023) S01E01.mkv");
		ss("file upload image 1");
	}

	private void ss(String name) throws IOException {
		// TODO Auto-generated method stub
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\agilb\\eclipse-workspace\\OptiosolTestNG\\ScreenShots\\" + name + ".png"));
	}

	@Test
	private void tc2() throws IOException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("E:\\\\movies\\\\Ayali\\\\www.1TamilMV.mobi - Ayali (2023) S01E01.mkv");
		ss("file upload image 2");
	}

}