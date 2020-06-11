package homeAssignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhantosJS {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.javatpoint.com/");
	}
	
	@Test(priority=1, description="validate the URL")
	public void validateURL() {
		String currentURL = driver.getCurrentUrl();
		
		//validate the URL
		Assert.assertEquals(currentURL, "https://www.javatpoint.com/");
		System.out.println(currentURL);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
