package homeAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

public class RobotClassExample {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/upload/");
	}

	@Test(priority=1, description="Assert condition")
	public void robotDemo() throws AWTException {
		
		Robot r = new Robot();
		
		driver.findElement(By.xpath("//input[@name='uploadfile_0']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
