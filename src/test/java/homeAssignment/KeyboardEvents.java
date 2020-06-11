package homeAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {

WebDriver driver;	

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/keyboard-events-sample-form/");
	}

	@Test
	public void keyboardEvents() throws AWTException, InterruptedException{
		
		Robot r = new Robot();
	
		for(int i=1; i<32; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	
		//name
		r.keyPress(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_H);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_U);
		 
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_U);
	
		//Current address
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_R);
		r.keyPress(KeyEvent.VK_E);
		r.keyPress(KeyEvent.VK_S);
		r.keyPress(KeyEvent.VK_S);
		r.keyPress(KeyEvent.VK_1);
		 
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_1);
		
		// Permant address
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_R);
		r.keyPress(KeyEvent.VK_E);
		r.keyPress(KeyEvent.VK_S);
		r.keyPress(KeyEvent.VK_S);
		r.keyPress(KeyEvent.VK_2);
		 
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_2);
		
		//submit
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
