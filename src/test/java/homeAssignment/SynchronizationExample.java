package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SynchronizationExample {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Implicate wait example
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.javatpoint.com/java-tutorial");
	}

	
	@Test()
	public void waitConditions() throws InterruptedException {
	
		//Explicit wait example 
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.titleIs("Java Tutorial | Learn Java - javatpoint"));
		System.out.println(driver.getTitle());
		
		//Unconditional wait example
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='C++ vs Java ']")).click();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
