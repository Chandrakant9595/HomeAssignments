package homeAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDemo {


WebDriver driver;	

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable/");
	}

	@Test
	public void dragExample(){
		
		WebElement des = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement tar = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(des, tar);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
