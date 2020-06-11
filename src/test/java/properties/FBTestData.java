package properties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBTestData extends Base{

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = getObj("URL");
		System.out.println(url);
		driver.get(url);
	}
	
	@Test
	public void getDataFromProp() throws IOException {
		
		String fName = getObj("FirstName");
		System.out.println(fName);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName);
		
		
		String lName = getObj("LastName");
		System.out.println(lName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
