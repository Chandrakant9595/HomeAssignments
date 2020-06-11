package homeAssignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptchaScreenShot {

	WebDriver driver;	

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://public.msrtcors.com/ticket_booking/index.php");
	}
	
	
	@Test(description="Screen shot test")
	public void screenShotTest() throws IOException {
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("chandrakant");
		driver.findElement(By.xpath("//input[@name='pwd']")).clear();
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("shinde");
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("ScreenShot\\CaptchaScreenshot.png"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
