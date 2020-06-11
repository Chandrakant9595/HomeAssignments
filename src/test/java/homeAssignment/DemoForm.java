package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoForm {


	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.demoqa.com/automation-practice-form");
	}
	
	@Test
	public void dynamicTable() throws InterruptedException {
		
		//name
		driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Chandrakant");
		
		//last name
		driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys("Chandrakant");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
