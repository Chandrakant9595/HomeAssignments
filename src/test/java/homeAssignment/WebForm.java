package homeAssignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebForm {

WebDriver driver;	

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
	}

	@Test
	public void formDemo() throws IOException, InterruptedException{
	
		//name
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Chandrakant");
		
		//last name
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Shinde");
		
		//male
		driver.findElement(By.cssSelector("input[id='sex-0']")).click();
		
		//experiance
		driver.findElement(By.cssSelector("input[id='exp-3']")).click();
		
		//date
		driver.findElement(By.cssSelector("input[id='datepicker']")).sendKeys("30/10/2005");
		
		//Profession 
		driver.findElement(By.cssSelector("input[id='profession-1']")).click();
		
		//Automation Tools
		driver.findElement(By.cssSelector("input[id='tool-2']")).click();
		
		//Continents
		WebElement dropDown = driver.findElement(By.cssSelector("select[id='continents']"));
		Select select  = new Select(dropDown);
		select.selectByVisibleText("Europe");
		
		//Selenium commands
		WebElement dropDown2 = driver.findElement(By.cssSelector("select[id='selenium_commands']"));
		Select select2  = new Select(dropDown2);
		select2.selectByVisibleText("Browser Commands");
		
		//upload file
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('photo').click();");
		Runtime.getRuntime().exec("D:\\Work_Assignment\\AutoITScript\\FileUpload2.exe");
		
		//download link
		driver.findElement(By.linkText("Click here to Download File")).click();
		driver.navigate().back();
	
		//button
		driver.findElement(By.cssSelector("button[id='submit']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
