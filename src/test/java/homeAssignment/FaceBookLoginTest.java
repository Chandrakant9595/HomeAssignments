package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLoginTest {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority=1)
	public void validateURL() {
		String currentURL = driver.getCurrentUrl();
		
		//validate the URL
		Assert.assertEquals(currentURL, "https://www.facebook.com/");
		System.out.println(currentURL);
	}
	
	@Test(priority=2, description="Check the Create an account text")
	public void validateText() {
		String text = driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']/span")).getText();
		
		//validate the text
		Assert.assertEquals(text, "Create an account");
		System.out.println(text);
	}
	
	//@Test(priority=3, description="Check the login functionality")
	public void loginTest() {
		//Enter User name
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shindevicky90@fmail.com");
		
		//Enter password
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("c9595c");
		
		//click on login button
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		//Validat the URL after login
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://www.facebook.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
