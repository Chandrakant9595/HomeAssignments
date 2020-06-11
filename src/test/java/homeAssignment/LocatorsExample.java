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

public class LocatorsExample {

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
	
	
	@Test(description = "Example of locators")
	public void locators() {
		
		//id
		driver.findElement(By.id("email")).sendKeys("chandrakant");
		
		//name
		driver.findElement(By.name("firstname")).sendKeys("chandrakant");
		
		//className
		String text = driver.findElement(By.className("_5iyx")).getText();
		System.out.println(text);
		
		//tagName
		List <WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+list.size());
		
		//linkText
		String linkText = driver.findElement(By.linkText("Forgotten account?")).getText();
		System.out.println("Link text: "+linkText);
		
		//partialLinkText
		String partialLinkText = driver.findElement(By.partialLinkText("Deve")).getText();
		System.out.println(partialLinkText);
		
		//cssSelector
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Shinde");
		
		//xpath
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9595455315");
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
