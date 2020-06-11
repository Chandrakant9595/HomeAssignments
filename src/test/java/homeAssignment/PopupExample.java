package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupExample {

	WebDriver driver;	

	//@BeforeMethod
	@Test
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://demo.automationtesting.in/Alerts.html");
		//driver.get("www.google.com");
		driver.get("https://www.google.com/");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test(priority=1, description="Check the popup methods")
	public void popUpTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
		
		//dismiss method example
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println("dismiss method example");
		Thread.sleep(3000);
		
		//accept method example
		driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
		alert.accept();
		System.out.println("accept method example");
		Thread.sleep(3000);
		
		//get text nethod example
		driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
		System.out.println(alert.getText());
		System.out.println("get text nethod example");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
