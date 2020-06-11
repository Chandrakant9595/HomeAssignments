package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerExample {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/");
	}
	
	@Test
	public void datePickerExample() {
		
		WebElement dateData = driver.findElement(By.cssSelector("input[name='bdaytime']"));
		
		dateData.sendKeys("05112020");
		
		dateData.sendKeys(Keys.TAB);
		
		dateData.sendKeys("1010AM");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
