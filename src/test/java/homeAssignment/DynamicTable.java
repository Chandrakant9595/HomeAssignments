package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
	}
	
	@Test
	public void dynamicTable() throws InterruptedException {
		
		//user name
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("me9595455315@gmail.com");
		
		//username
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("@C9595455315c");
		
		//login button
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		//click on company link
		driver.findElement(By.xpath("//span[text()='Companies']")).click();
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//get values of table
		
		String name1 = driver.findElement(By.xpath("//tr/td/following-sibling::td[text()='KPIT']")).getText();
		System.out.println(name1);
		String city1 = driver.findElement(By.xpath("//tr/td/following-sibling::td[2][text()='Mumbai']")).getText();
		System.out.println(city1);
		System.out.println("");
		
		String name2 = driver.findElement(By.xpath("//tr/td/following-sibling::td[text()='SLK']")).getText();
		System.out.println(name2);
		String city2 = driver.findElement(By.xpath("//tr/td/following-sibling::td[2][text()='Bangalore']")).getText();
		System.out.println(city2);
		System.out.println("");
		
		String name3 = driver.findElement(By.xpath("//tr/td/following-sibling::td[text()='TCS']")).getText();
		System.out.println(name3);
		String city3 = driver.findElement(By.xpath("//tr/td/following-sibling::td[2][text()='Pune']")).getText();
		System.out.println(city3);
		System.out.println("");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
