package homeAssignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailSend {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	
	@Test
	public void gmail() throws InterruptedException, AWTException {
		
		Robot r = new Robot();
		
		//Login with Gmail		
		//enter username
		driver.findElement(By.xpath("//input[@id='identifierId']")).clear();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("me9595455315@gmail.com");
				
		//next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();
				
		Thread.sleep(5000);
		//Wait and check user name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headingText\"]/span")));
		String name = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")).getText();
		System.out.println(name);
				
		//Enter password
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("@C9595455315c");
				
		//next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(8000);
		
		//compose email
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")).click();
		Thread.sleep(8000);
		
		//add To value
		driver.findElement(By.xpath("//div[@class='oj']/div/textarea[@name='to']")).sendKeys("automationsquad1@gmail.com");
		
		driver.findElement(By.xpath("//div[@class='oj']/div/textarea[@name='to']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='oj']/div/textarea[@name='to']")).sendKeys("me9595455315@gmail.com");
		driver.findElement(By.xpath("//div[@class='oj']/div/textarea[@name='to']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//subject add
		driver.findElement(By.xpath("//div[@class='aoD az6']/div/input[@name='subjectbox'] ")).sendKeys("Test mail from Chandu");
		Thread.sleep(3000);
		
		//attachment
		driver.findElement(By.xpath("//div[@class='bAK']/div[@class='wG J-Z-I']/div[@class='J-J5-Ji J-Z-I-Kv-H']/"
				+ "div[@class='J-J5-Ji J-Z-I-J6-H']/div[@class='a1 aaA aMZ']")).click();
		Thread.sleep(6000);
	
		
		for(int i=1; i<9; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
		
		for(int i=1; i<23; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			}
		
		for(int i=1; i<3; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(9000);
		
		
		/*//send button
		driver.findElement(By.cssSelector("tr.btC td div:nth-of-type(2).dC")).click();
		
		//compose email
		String subLine = driver.findElement(By.xpath("//tr[@class='zA zE byw']/td[6]/div/div/div/span/span")).getText();
		System.out.println(subLine);
		Assert.assertEquals(subLine, "Test mail from Chandu");*/
	
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}


	
