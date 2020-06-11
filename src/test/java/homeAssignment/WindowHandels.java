package homeAssignment;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandels {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
	}
		
	@Test(description="Example of window handel and window handels")
	public void screenShotTest() throws IOException {
		
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		String parent_window = driver.getWindowHandle();  
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		Set<String> set =driver.getWindowHandles();
		java.util.Iterator<String> itr= set.iterator();
		while(itr.hasNext()) {
			String child_Window = itr.next();
			if(!parent_window.equalsIgnoreCase(child_Window)){
				driver.switchTo().window(child_Window);
				
				Assert.assertEquals(driver.getCurrentUrl(), "http://www.sakinalium.in/");
				
				//close example
				driver.close();
			}
		}
		
		driver.switchTo().window(parent_window);
		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.automationtesting.in/Windows.html");
	}
	
	@AfterMethod
	public void tearDown() {
		//Quit example
		driver.quit();
	}
}
