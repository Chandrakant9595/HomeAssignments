package homeAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementsFindElements {

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
	
	@Test(priority=1, description="findelement() example")
	public void findElementMethod() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("chandrakant");
	}
	
	@Test(priority=2, description="findelements() example")
	public void eindElementsMethod() {
		 List<WebElement> optionButtons =  driver.findElements(By.name("radiooptions"));
		 System.out.println("Number of option button prest on page:" +optionButtons.size());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
