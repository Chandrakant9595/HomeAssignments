package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RefreshPage {
	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test(priority=1, description="Page refresh methods")
	public void pageRefreshMethods() {
		
		//Using driver.navigate().refresh() command
		driver.navigate().refresh();
		
		//Using driver.get(“URL”) 
		//already used in @BeforeMethod
		
		//Using driver.navigate().to(“URL”) 
		driver.navigate().to("https://www.facebook.com/");
		
		//Using sendKeys(Keys.F5) 
		driver.findElement(By.name("email")).sendKeys(Keys.F5);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
