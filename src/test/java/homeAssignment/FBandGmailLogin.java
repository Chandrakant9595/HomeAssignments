package homeAssignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBandGmailLogin {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test(description="Flogin FB and Gmail in new TAB of browser")
	public void FBandGmailLoginTest() throws InterruptedException {
		
		//login with FB
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shindevicky90@fmail.com");
		
		//Enter password
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("");
		
		//click on login button
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		//Validat the URL after login
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://www.facebook.com/");
		
		//Login with Gmail
		WebDriver newTAB = driver.switchTo().newWindow(WindowType.TAB);
		newTAB.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
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
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		
		//next button
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
