package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import functionlibrary.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	static WebDriver driver ;
    static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login" ;

@Given("^User is already on home page$")	
public void user_already_on_loginpage () {
	
	
	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
    driver = new ChromeDriver() ;
	//maximize the window		
	driver.manage().window().maximize(); 	
	driver.get(url);
	
}


@When("^title of login page is OrangeHRM$") 
public void verify_title () {
	
	 String title = driver.getTitle();
     System.out.println("Home Page title ::"+ title);
     Assert.assertEquals(title, "OrangeHRM");
	 Reusablefunctionss.capturescreenshot(driver, "TitleScreenshots taken");
}

@And("^User enters '(.*)' and '(.*)'$")
public void EnterCredentials ( String username ,String password) throws Exception {
	
	 driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	 Reusablefunctionss.wait(3000);
}

@And("^User clicks on login button$")
public void loginclick() throws Exception {
	
	 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	 Reusablefunctionss.wait(3000);
}

@Then("^User is navigated to OrangeHRM Dashboard Page$")
public void navigatedashboard () throws Exception {
	 
	Reusablefunctionss.capturescreenshot(driver, "OrangeHRMDashboard page");
	WebElement Welcome =  driver.findElement(By.xpath("//a[@id='welcome']"));
	 
	//explicit wait 
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.elementToBeClickable(Welcome));
	
}

@Given ("^User is already on dashboard page$")
public void user_already_on_dashboardpage () {

	WebElement Welcome =  driver.findElement(By.xpath("//a[@id='welcome']"));
	String Welcometext = Welcome.getText();
	//Assert.assertEquals(Welcometext, "Welcome Admin");

}

@When("^User navigates to User button and clicks on User link$")
public void usernavigatetoUserLink () throws Exception {
	
	WebElement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
	WebElement UserAdmin = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
	WebElement User = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));
	
	Actions act = new Actions(driver);
	
	act.moveToElement(Admin).moveToElement(UserAdmin).moveToElement(User).click().build().perform();
	Reusablefunctionss.wait(2000);
	
	
}

@When ("^User clicks on Add Button$")
public void user_clicks_addbutton () {
	
	
	WebElement add_button = driver.findElement(By.xpath("//input[@id='btnAdd']")) ;
	add_button.click();
	
}

@And("^User Selects User Role$")
public void user_select_userrole () throws Exception {

	
	Select oSelect = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
	oSelect.selectByVisibleText("Admin");
	
	Reusablefunctionss.wait(3000);
	
 }

@And ("^User enters EmployeeName and Username as '(.*)'$")
public void enterdetails (String username) {
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("John Smith");
	driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(username);

}

@And("^User enters Password details$")
public void enterPasswordDetails () {
	
	driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("jeet47900");
	driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("jeet47900");
}

@And ("^User clicks on Save Button$")
public void clickSaveButton () throws Exception {
	
	Reusablefunctionss.wait(3000);

	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	Reusablefunctionss.capturescreenshot(driver, "Save happened Successfully");
	}
	


@And ("^User Searches with Username as '(.*)'$")
public void UserNameSearch (String username) {
	
	driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	
}

@Then ("^Verify the User is successfully added$")
public void VerifyUserName () {
	
	WebElement tablelink = driver.findElement(By.xpath("//table[@id ='resultTable']//tbody//tr//td[2]//a"));
	tablelink.click();
	Reusablefunctionss.capturescreenshot(driver, "username added successfully");
	
	
}

@And ("^User logouts the OrangeHRM Application$")
public void LogoutHRMApplication () throws Exception {

	 driver.findElement(By.xpath("//a[@id='welcome']")).click();
	 Reusablefunctionss.wait(4000);
	 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
     driver.close();
     
}
             }
