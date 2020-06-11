package homeAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSL_Certificate {

	WebDriver driver;
	
	@Test(priority=1, description="Test for SSL certification for FireFox browser")
	public void testSSLCertificateForFireFox() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		

		
	}
}
