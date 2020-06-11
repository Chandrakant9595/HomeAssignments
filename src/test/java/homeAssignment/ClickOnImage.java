package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickOnImage {
	
WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.javatpoint.com/java-tutorial");
	}

	@Test(priority=1, description="Click on Image")
	public void clickOnImage() {
	
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.javatpoint.com/java-tutorial");
		driver.findElement(By.xpath("//tbody/tr/td/div/a/img")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.javatpoint.com/");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
