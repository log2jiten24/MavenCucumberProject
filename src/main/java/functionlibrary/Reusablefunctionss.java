package functionlibrary;

import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;


public class Reusablefunctionss {
	
	public static WebDriver driver ;
	//public static ExtentReports report;
	//public  static ExtentTest logger ;

	public static void capturescreenshot (WebDriver driver ,String screenshotname)
	{
		try {
		//TakesScreenshot is an interface ,we are typecasting interface to create object
		TakesScreenshot ts = (TakesScreenshot)driver  ;
		//getScreenshotAs - method to take screenshot and store in the memory
		File src = ts.getScreenshotAs(OutputType.FILE) ;
		//store the source file into the destination
		
		//Files.copy(src, new File("./Screenshots/+ "+screenshotname+".png"));
		FileUtils.copyFile(src, new File("./Screenshots/+ "+screenshotname+".png"));
		
		
		System.out.println ("Screenshots taken");
		} catch (Exception e) 
		{
		System.out.println("Screenshot failure :" + e.getMessage());
		}
	}
	
//	public static  void ExtentReports () {
////		//create object of ExtentHTMLTeporter
//		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OpenHRMpage.html")) ;		
//		report = new ExtentReports ();
//    	report.attachReporter(extent);	
//		}
	
	
	
	//to format current timestamp
		public static String getCurrentDateTime () {
		DateFormat customformat = new SimpleDateFormat("MM_dd_YYYY_HM_MM_SS") ;	
			
		Date currentDate = new Date ();
		return customformat.format(currentDate);
		
			
		}
		
		//capture screenshot
		
		
		public static String takeScreenshot (WebDriver driver) {
			
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/OpenHRM"+ getCurrentDateTime()+ ".png ";
		try {
		FileHandler.copy(src, new File(screenshotpath));	
		
		System.out.println ("Screenshot captured");
		}catch (IOException e ) {
		System.out.println ("unable to capture screenshots "+ e.getMessage());	
		}
		
		return screenshotpath ;
		}
		
		
		
		//method to get the sheetname , rownumber, columnnumber from excel sheet 
	     @SuppressWarnings("unused")
		public static String getData (String filepath,int sheetname , int rownumber , int columnnumber) 
	     {
	    	
	        File src = new File (filepath);
	         // Create Workbook to read the whole excel 
	       XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(src);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       //now load the sheet name which to read 
	       //getSheetAt method it retrieves the first Sheet 
	       XSSFSheet sh1 = wb.getSheetAt(sheetname);
	       // it will retrieve the total number of rows 
	    	sh1 = wb.getSheetAt(sheetname) ;
	    	//int rowcount = sh1.getLastRowNum();
	    	int rowcount = sh1.getPhysicalNumberOfRows();
	       System.out.println("total number of rows is " + rowcount);
	       
	    	for (int i = 0 ; i < rowcount ; i++) {
	    	String datastore = sh1.getRow(rownumber).getCell(columnnumber).getStringCellValue() ;
	    	return datastore ;
	             }
		return filepath;
	    	
	
	                 } 
	     
	     //to wait for time 
	     public static void wait (int seconds) throws Exception {
	    	 Thread.sleep(seconds);
	     }
	     
	     //to wait for specific amount of time
	     
	     public static void elementTimeOut (String time ) throws Exception {
	    
	     driver.manage().timeouts().implicitlyWait(Integer.parseInt(time), TimeUnit.SECONDS)	; 
	     }
	     
	     //to wait for the specified amount of time for page load 
	     public static void pageLoadTimeOut (String time) throws Exception {
	     
	     driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(time), TimeUnit.SECONDS) ;	 
	     }
	     
	     //to select the locator 
	     
	     public static By elementLocator (String locator ) throws Exception {
	    	 
	     if (locator.startsWith("xpath"))	
	        return By.xpath(locator.substring(6))	 ;
	     else if (locator.startsWith("css"))
	       return By.cssSelector(locator.substring(4));
	     else if (locator.startsWith("id"))
	        return By.id(locator.substring(3))	;
	     else if (locator.startsWith("class"))
	       return By.className(locator.substring(6));
	     else if (locator.startsWith("name"))
	       return By.name(locator.substring(5)) ;
	     else if (locator.startsWith("tag"))
	       return By.tagName(locator.substring(4));
	     else if (locator.startsWith("link"))
	        return By.linkText(locator.substring(5)) ;
	     
	     else {
	    	throw new IllegalArgumentException("Invalid locator format : " + locator ) ;
	     }
	    	 
	     }
	     
	     //verify the existence of the element 
	     
	     public static boolean isElementExists (By by) {
	     
	    	 boolean isExists = false ;
	    	 if (driver.findElements(by).size() > 0)
	    	isExists =  true ;
	    	 return isExists ;
	     }
	     
	     //click on any  element 
	     
	     public static void click (String locator ) throws Exception {
	     
	     wait (2000) ;
	     By byLocator = elementLocator(locator);
	     
	     if (isElementExists(byLocator) & driver.findElement(byLocator).isEnabled() ) {
	      driver.findElement(byLocator).click(); 
	     }else {
	    System.out.println ("element not displayed : ") ;	 
	     }	 
	       }
	     
	     //This method extracts the text from the specified location 
	     public static String getText (String locator ) throws Exception {
	     
	     By byLocator = elementLocator(locator)	 ;
	     return driver.findElement(byLocator).getText();
	    	 
	     }
	     
	     //This method extracts the title from the specified location 
	     public static String getTitle ( ) {
	     
	     return driver.getTitle();
	    	 
	     }
	     
	     //method performs click using Javascript 
	     
	     public static void JavaScriptClick (String locator ) throws Exception {
	    
	     By byLocator = elementLocator(locator)	 ;
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver ;
	     js.executeScript("arguments[0].click();", driver.findElement(byLocator)) ;
	     }
	     
	     
	     //this method performs enter action 
	     
	     public static void presskeyBoardEnter () throws Exception {
	    
	     Robot robot = new Robot () ;
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
	    	 
	     }
	     
	     
	     //this method waits for maximum of 10seconds until the web element is visible on the page 
	     
	     public static void waitforElement (String locator ) throws Exception  
	     {
	    	 
	     By byLocator = elementLocator(locator) ;
	     WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	     
	     }
	     
	     //this method enters text in the specified text box 
	     
	     public static void type (String locator , String text) throws Exception 
	     {
	     By bylocator = elementLocator(locator)	 ;
	     driver.findElement(bylocator).sendKeys(text);
	     }
	     
	     
	     //this method selects option from the dropdown with respect to text option
	     
	     public static void selectFromDropdown (String locator , String option ) throws Exception {
	    	 
	     //wait for expected element 
	     waitforElement(locator);
	     
	     By byLocator = elementLocator(locator);
	     
	     Select dropdown = new Select (driver.findElement(byLocator)) ;
	     dropdown.selectByVisibleText(option);
	     
	     }
	     
        //this method selects option from the dropdown with respect to index 
	     
	     public static void selectFromDropdownByIndex (String locator , String index ) throws Exception {
	    	 
	     //wait for expected element 
	     waitforElement(locator);
	     
	     By byLocator = elementLocator(locator);
	     
	     Select dropdown = new Select (driver.findElement(byLocator)) ;
	     dropdown.selectByIndex(Integer.parseInt(index));
	     
	     }
	     
	     //switch the element to the frame 
	     public static void switchtoFrame (String framename ) {
	    
	     driver.switchTo().frame(framename)	 ;
	     }
	     
	     //close one instance of browser
	     public static void closebrowser () {
	     
	      driver.close();	 
	     }
	     
	     //close all the browser 
	     public static void closeallbrowser () {
	    
	    	 try {
	     driver.quit();	
	    }catch (Exception e) {
	    	
	    }
	     }
	     
	     //launch the browser with the url 
	     public static void launchbrowser (String browsername ,String url ) 
	     {
	    
	    	if (browsername.equalsIgnoreCase("Chrome")) 
	    	{
	    	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	    	//DesiredCapabilities capabilities = DesiredCapabilities.chrome() ;
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("disable-infobars");
	    	options.addArguments("--disable-web-security");
	    	options.addArguments("--allow-running-insecure-content");
//	    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	    	
//	    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    	
	    	//driver = new ChromeDriver (capabilities);
	    	driver = new ChromeDriver(options);
	    	
	    	
	    	
	    	  }
	    	
	    	else if (browsername.equalsIgnoreCase("IE")) {
	    	System.setProperty("webdriver.ie.driver", "E:\\Drivers\\IEDriverServer.exe");
	    	
	    	//DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	    	InternetExplorerOptions ioptions = new InternetExplorerOptions();
	    	ioptions.setAcceptInsecureCerts(true);
//	    	capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//	    	capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
//	    	capab.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//	    	capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	    	driver = new InternetExplorerDriver(ioptions);
	    	}
	    	else {
	    		Assert.assertTrue("Invalid Browser", false);
	    	}
	    	driver.manage().window().maximize();
	    	driver.get(url);
	    	try {
				wait(20);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println ("problem in opening url");
			}
	     }
	     
	     
	     //take Screenshot of particular WebElement 
	 	public static void takeWebElementScreenshot(WebElement element, String filename)  {
			
			File srcFile = element.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(srcFile, new File("./Screenshots/" + filename + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	    
	 	
	 	//take Screenshot of particular WebElement -2nd way 
		public static void captureWebElementScreenshot (WebElement element , String fileName ) {
			
			TakesScreenshot ts = ((TakesScreenshot)element) ;
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcfile, new File ("./Screenshots/" + fileName +".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		      }

		          }

