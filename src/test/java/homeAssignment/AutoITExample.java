package homeAssignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITExample {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/vicky/Desktop/FileUpload.html");
	}
	
	@Test(description="AutoIT demo")
	public void autoITTest() throws IOException, InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('1').click();");
				
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\Work_Assignment\\AutoITScript\\FileUpload2.exe");
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
