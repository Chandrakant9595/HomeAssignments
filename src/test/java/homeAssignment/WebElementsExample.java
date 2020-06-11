package homeAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementsExample {

	WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test(priority=1, description="Enter value in textbox")
	public void enetrValueInTextBox() {
		System.out.println("Enter value in text box");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("chandrakant");
		
	}
	
	@Test(priority=2, description="select value in drop-down")
	public void selectValueFromDropDown(){
		//select value from drop down
		WebElement element = driver.findElement(By.xpath("//select[@id='Skills']"));
		Select select = new Select(element);
		select.selectByVisibleText("APIs");
	}
	
	@Test(priority=3, description="check box select")
	public void checkboxSelect() {
		//check box select
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
		driver.findElement(By.xpath("//input[@id='checkbox3']")).click();
	}
	
	@Test(priority=4, description="option button select")
	public void optionButtonSelect() {
		//option button select
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();
	}
	
	@Test(priority=5, description="mouse over on menu bar")
	public void mouseOverOnMenuBar() {
		//mouse over on menu bar
		WebElement menu = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
	}
	
	@Test(priority=6, description="right click")
	public void rightClick() throws InterruptedException {
		//right click
		WebElement menu = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
		Thread.sleep(2000);
		WebElement link = driver.findElement(By.xpath("//a[text()='Alerts']"));
		
		action.contextClick(link).build().perform();
		Thread.sleep(2000);
	}
	
	@Test(priority=7, description="double click")
	public void doubleClick() {
		//double click
		WebElement menu = driver.findElement(By.xpath("//div[@class='container center']/h2"));
		Actions action = new Actions(driver);
		action.doubleClick(menu).build().perform();
	}
	
	@Test(priority=8, description="Dran and Drop")
	public void dargAndDrop() throws InterruptedException {
		//Dran and drop
		WebElement menulink = driver.findElement(By.xpath("//a[text()='Interactions ']"));
		Actions action = new Actions(driver);
		action.moveToElement(menulink).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Drag and Drop ']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Static ']")).click();
		
		WebElement source = driver.findElement(By.xpath("//img[@id='angular']"));
		WebElement tagert = driver.findElement(By.xpath("//div[@id='droparea']"));
		action.dragAndDrop(source, tagert).build().perform();
	}
	
	@Test(priority=9, description="Page up and down")
	public void pageUpAndDown() throws InterruptedException {
		//page down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		//page down
		//js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
	}
		
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
