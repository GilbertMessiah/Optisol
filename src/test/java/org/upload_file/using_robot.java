package org.upload_file;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class using_robot {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/");
		Thread.sleep(3000);
		WebElement pdf2word = driver.findElement(By.xpath("//h3[text()='PDF to Word']"));
		pdf2word.click();
		Thread.sleep(2000);
		WebElement pick = driver.findElement(By.id("pickfiles"));
		pick.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		// COPY FILE PATH TO THE SYSTEM CLIPBOARD
		StringSelection ss = new StringSelection("F:\\inmakes\\dummy.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// PASTE THE COPIED FILE PATH
		// PRESS CONTROL BUTTON
		r.keyPress(KeyEvent.VK_CONTROL);
		// PRESS V BUTTON
		r.keyPress(KeyEvent.VK_V);
		// RELEASE CONTROL BUTTON
		r.keyRelease(KeyEvent.VK_CONTROL);
		// RELEASE V BUTTON
		r.keyRelease(KeyEvent.VK_V);
		// ENTER
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// TAKE SCREENSHOT
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File(
				"C:\\Users\\agilb\\eclipse-workspace\\OptiosolTestNG\\ScreenShots\\file upload using robot class.png"));

	}
}
