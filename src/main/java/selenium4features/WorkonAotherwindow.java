package selenium4features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctionss;

public class WorkonAotherwindow {

	
	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	    System.setProperty("webdriver.chrome.silentOutput", "true");
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "open the url and switch to another window" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	
	//get the session id for parent window 
	String parentWindow = driver.getWindowHandle() ;
	System.out.println ("parent window :" + parentWindow);
	
	
	//opening new child tab 
	//WebDriver newTab  = driver.switchTo().newWindow(WindowType.TAB);
	
	//opening new child window
	WebDriver newTab  = driver.switchTo().newWindow(WindowType.WINDOW);
	
	
	//get the session id for child window 
	String childWindow = newTab.getWindowHandle() ;
	System.out.println ("child window :" + childWindow);
	
	newTab.get("https://www.google.co.in/");
	
	newTab.findElement(By.name("q")).sendKeys("Testing");
	
	Thread.sleep(3000);
	
	newTab.close();
	
	//switching to parent window 
	driver.switchTo().window(parentWindow);
	
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	
	Reusablefunctionss.capturescreenshot(newTab, "username and password entered");
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	Thread.sleep(3000);
	
	driver.close();
	
	}
}
