package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hdgf.pointers.Pointer;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragChangePosition {


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
	public void dragPositionChange(){
		
		WebElement des = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		
		Actions action= new Actions(driver);
	    action.clickAndHold(des);
	    action.moveByOffset(100,0);
	    action.release().build();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
