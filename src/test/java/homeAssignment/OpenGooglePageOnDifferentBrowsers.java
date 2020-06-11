package homeAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGooglePageOnDifferentBrowsers {

	WebDriver driver;	

		
	@Test(priority=1, description="Open chrome browser")
	public void useChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2, description="Open firefox browser")
	public void useFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=3, description="Open IE browser")
	public void useIEBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
}
