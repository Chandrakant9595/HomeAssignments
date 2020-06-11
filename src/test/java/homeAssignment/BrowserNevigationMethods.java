package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserNevigationMethods {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tutorialspoint.com/java/index.htm");
	}

	@Test(description="Browser nevigation methods")
	public void nevigationMethods() {
		
		String javaTpointURL = "https://www.javatpoint.com/java-tutorial";
		String javaTutorial = "https://www.tutorialspoint.com/java/index.htm";
		
		//driver.navigate().to(“url”);
		driver.navigate().to("https://www.javatpoint.com/java-tutorial");
		Assert.assertEquals(javaTpointURL, driver.getCurrentUrl());
		
		//driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(javaTutorial, driver.getCurrentUrl());
		
		//driver.navigate().forward();
		driver.navigate().forward();
		Assert.assertEquals(javaTpointURL, driver.getCurrentUrl());
		
		//driver.navigate().refresh();
		driver.navigate().refresh();
		Assert.assertEquals(javaTpointURL, driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
