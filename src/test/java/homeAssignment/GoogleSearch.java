package homeAssignment;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	WebDriver driver;	
	public static Logger log = Logger.getLogger(GoogleSearch.class);
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void googleSearch() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='RNNXgb']/div[@class='SDkEP']/div[2]/input[@class='gLFyf gsfi']")).sendKeys("Selenium Basics");
		log.info("Custom log - Enter the Selenium Basics successfully");
		
		driver.findElement(By.xpath("//div[@class='RNNXgb']/div[@class='SDkEP']/div[2]/input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	
		String url1 = driver.findElement(By.xpath("//*[text()='Selenium Tutorial for Beginners: Learn WebDriver in 7 Days']/parent::a")).getAttribute("href"); 
		System.out.println(url1);
		log.info("Custom log - Site 1 capture");
		
		String url2 = driver.findElement(By.xpath("//*[text()='Free Selenium Tutorial | Selenium WebDriver Tutorials | For ...']/parent::a")).getAttribute("href"); 
		System.out.println(url2);
		log.info("Custom log - Site 2 capture");
		
		String url3 = driver.findElement(By.xpath("//*[text()='Selenium Tutorial - javatpoint']/parent::a")).getAttribute("href"); 
		System.out.println(url3);
		log.info("Custom log - Site 3 capture");
		
		String url4 = driver.findElement(By.xpath("//*[text()='30+ Best Selenium Tutorials: Learn Selenium With Real ...']/parent::a")).getAttribute("href"); 
		System.out.println(url4);
		log.info("Custom log - Site 4 capture");
		
		String url5 = driver.findElement(By.xpath("//*[text()='Free Selenium Testing Framework Tutorial - Selenium Basics ...']/parent::a")).getAttribute("href"); 
		System.out.println(url5);
		log.info("Custom log - Site 5 capture");
		
		
		
	}
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
