package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void methodOnBrowser() throws InterruptedException {
		
		//delete cookie
		driver.manage().deleteAllCookies();
		
		//maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//minimize beowser
		driver.manage().window().minimize();
		Thread.sleep(5000);
		
		//retrive sourece code
		String code = driver.getPageSource();
		System.out.println(code);
		
		//active element in webpage
		String active = driver.findElement(By.xpath("//input[@value='Male']")).getAttribute("class");
		if(active.contains("ng-pristine ng-untouched ng-invalid ng-invalid-required")) {
			System.out.println("Not Active");
		}else {
			System.out.println("Active");
		}
		
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		Thread.sleep(5000);
		if(active.contains("ng-dirty ng-valid-parse ng-valid ng-valid-required ng-touched")) {
			System.out.println("Not Active");
		}else {
			System.out.println("Active");
		}
		
		
		//Locate element location
		WebElement e = driver.findElement(By.xpath("//div[@class='container center']/h2"));
		Point p = e.getLocation();
		int yCord = p.getX();
		int xCord = p.getX();
		System.out.println("Y cord is = "+yCord);
		System.out.println("Y cord is = "+xCord);
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
