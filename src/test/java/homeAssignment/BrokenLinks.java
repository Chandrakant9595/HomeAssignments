package homeAssignment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test(description="Test the broken links")
	public void testTheBrokenLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size()); 
		
		for(int i=0; i<links.size(); i++) {
			WebElement element = links.get(i);
			String url=element.getAttribute("href");
			verifyLink(url);
		}
	}
	
	public static void verifyLink(String urlLink) {
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if(httpConn.getResponseCode()== 200) {
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
			if(httpConn.getResponseCode()== 404){
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
