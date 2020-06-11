package homeAssignment;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificationPoints {


WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test(priority=1, description="Verification points in selenium")
	public void verificationPoints() {
		
		//check Page URL
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		//check Page title
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		
		//Check the text
		String text = driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']/span")).getText();
		Assert.assertEquals(text, "Create an account");
		
		//check some web element present on page
		WebElement textbox =  driver.findElement(By.xpath("//input[@name='email']"));
		assertEquals(true, textbox.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
