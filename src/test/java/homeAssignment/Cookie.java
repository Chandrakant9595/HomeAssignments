package homeAssignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;		
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;		
import java.util.StringTokenizer;
import java.util.TimeZone;		


public class Cookie {

	WebDriver driver;
	
	@Test(priority=1)
	public void storedcookieTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\old chrom\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		//Enter User name
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shindevicky90@fmail.com");
				
		//Enter password
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("c9595c");
				
		//click on login button
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		
		File file = new File("Cookies.data");
		
		try {
			file.delete();	
			
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			
			for(org.openqa.selenium.Cookie ck : driver.manage().getCookies()) {
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"
			+ck.getExpiry()+";"+ck.isSecure()));																									
                Bwrite.newLine();             
			}
			
			Bwrite.close();			
            fileWrite.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	@Test(priority=2)
	public void getStordCookieAndLogin() {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\old chrom\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		File file = new File("Cookies.data");
		
		try{
			 FileReader fr = new FileReader(file);
			 
			 BufferedReader br = new BufferedReader(fr);
			 
			 String dataLine, name=null, value=null, domain=null, expiry=null, secure=null, path=null;
			 Date exp=null, nextYearExp = null;
			 
			 while((dataLine = br.readLine())!=null){
				 String[] cookieData = dataLine.split(",");
				  name = cookieData[0];
				  value = cookieData[1];
				  domain = cookieData[2];
				  path = cookieData[3];
				  expiry = cookieData[4];
				  secure = cookieData[5];
				  
				 
				 if(!(expiry==null)){
					//Set any random day value
					 exp = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
					sdf.setTimeZone(TimeZone.getTimeZone("IST"));
					sdf.format(exp);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, 1);
					nextYearExp = cal.getTime();
					 System.out.println("Exp- "+nextYearExp);
					 
				 }
			 }
			 
			 Boolean isSecure = new Boolean(secure);
			
			 System.out.println(nextYearExp);
			 //Set value to new cookie
			 Cookie cookie = new Cookie(name, value, domain, path, nextYearExp, isSecure);
			 System.out.println(cookie);
			 driver.manage().addCookie(cookie);
			 Thread.sleep(1000);
			 driver.get("http://www.memotome.com/login.asp?display=reminder");
		  	  
		  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
		  	  driver.manage().window().maximize();
	 
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}*/
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
