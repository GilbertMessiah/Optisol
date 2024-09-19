package windows_handle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WH {
	WebDriver driver;
	List list;

	@BeforeMethod
	private void s_date() {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println("Start Date & Time :" + d);
	}

	@AfterMethod
	private void e_date() {
		// TODO Auto-generated method stub
		Date d = new Date();
		System.out.println("End Date and Time :" + d);
	}

	@BeforeTest
	private void s_browser() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
	}

	private void ss(String name) throws IOException {
		// TODO Auto-generated method stub
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("F:\\inmakes\\screenshots\\windows handling\\" + name + ".png"));

	}

	@Test
	private void tc1() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		driver.get("https://www.pexels.com/search/cat/");
		String first_tab = driver.getCurrentUrl();
		System.out.println("First Tab URL :"+first_tab);
		Thread.sleep(3000);
		ss("1st_tab");
	}

	@AfterTest
	private void e_browser() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	private void tc2() throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		//target image
		WebElement cat_img = driver.findElement(By.xpath("(//img[@class='spacing_noMargin__F5u9R MediaCard_image__yVXRE'])[1]"));
		//Action class
		Actions a = new Actions(driver);
		a.contextClick(cat_img).perform();
		//Robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		//Windows handling
		String parent_win = driver.getWindowHandle();
		System.out.println("parent window id :"+parent_win);
		Set<String> child = driver.getWindowHandles();
		System.out.println("child window id :"+child);
		List<String> list=new ArrayList<String>(child);
		driver.switchTo().window(list.get(1));
		String second_tab = driver.getCurrentUrl();
		System.out.println("Second Tab URL :"+second_tab);
		Thread.sleep(2000);
		ss("2nd tab");
	}
	
	@Test
	private void tc3() throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		//target 3rd tab
		WebElement cat = driver.findElement(By.xpath("//img[@class='spacing_noMargin__F5u9R PhotoZoom_image__2c8qM']"));
		//Action class
		Actions a = new Actions(driver);
		a.contextClick(cat).perform();
		//Robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//Windows Handling
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(2));
		//third tab url
		String third_tab = driver.getCurrentUrl();
		System.out.println("Third Tab URL :"+third_tab);
		//screenshot method
		ss("3rd tab");
	}
	
	@Test
	private void tc4() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(0));
		String again_1st_tab = driver.getCurrentUrl();
		System.out.println("Again 1st tab :"+again_1st_tab);
	}

}