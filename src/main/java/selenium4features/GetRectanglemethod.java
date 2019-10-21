package selenium4features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRectanglemethod {
	
	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "open the url and switch to another window" , enabled = true)
	public void openurlandlogin() throws Exception 
	{

	WebElement login_btn = driver.findElement(By.xpath("//input[@id='btnLogin']")) ;
	
	//selenium3 features
	Dimension loginbtn = login_btn.getSize();
	
	System.out.println ("get the height of webelement sel3 :" + loginbtn.getHeight()) ;
	System.out.println ("get the width of  webelement sel3 :" + loginbtn.getWidth()) ;
	
	Point p = login_btn.getLocation();
	System.out.println(p.getX());
	System.out.println(p.getY());
	
	//selenium 4 features
	
	Rectangle loginrectbtn = login_btn.getRect();
	System.out.println ("get the height of webelement sel4 :" + loginrectbtn.getHeight()) ;
	System.out.println ("get the width of  webelement sel4 :" + loginrectbtn.getWidth()) ;
	
	System.out.println (loginrectbtn.getX());
	System.out.println (loginrectbtn.getY());
	
	driver.close();
		
    }
           }