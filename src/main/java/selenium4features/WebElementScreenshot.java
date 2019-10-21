package selenium4features;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementScreenshot {
	
	public static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	    //WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
	}
	
	@Test (priority = 1 , description = "takeScreenshot for specific WebElement" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
	
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		WebElement loginbtn = driver.findElement(By.id("btnLogin"));
		WebElement forgotpwd = driver.findElement(By.linkText("Forgot your password?"));
		
		
//		File srcFile = username.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(srcFile, new File("./Screenshots/email.png"));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		
		
		takeWebElementScreenshot(username, "emailElement");
		takeWebElementScreenshot(password, "password");
		takeWebElementScreenshot(loginbtn, "loginbtn");
		takeWebElementScreenshot(forgotpwd, "forgotpasswordlink");
		
		driver.close();
	}

	
	public static void takeWebElementScreenshot(WebElement element, String filename)  {
		
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./Screenshots/" + filename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
