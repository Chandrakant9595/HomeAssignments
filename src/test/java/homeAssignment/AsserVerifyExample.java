package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AsserVerifyExample {

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

	@Test(priority=1, description="Assert condition")
	public void assertConditionTest() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.javatpoint.com/java-tutorial");
	}
	
	@Test(priority=2, description="Verify condition")
	public void verifyConditionTest() {
		String URL = driver.getCurrentUrl();
		if(URL.equals("https://www.javatpoint.com/java-tutorial")) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
