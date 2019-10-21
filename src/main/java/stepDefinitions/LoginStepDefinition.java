package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;
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

import com.beust.jcommander.Strings;

import functionlibrary.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {

	static WebDriver driver;
	static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	//Global hooks 
//	@Before
//	public void setup () {
//	
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver() ;
//	System.setProperty("webdriver.chrome.silentOutput", "true");
//	driver.get(url);
//	System.out.println ("Browser launched ");
//	}
//
//	//Global hooks
//	@After
//	
//	public void teardown () {
//		
//	System.out.println ("close the browser ") ;	
//	driver.close();
//	
//	}
	
	@Given("^User is already on home page$")
	public void user_already_on_loginpage() {

		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		// maximize the window
		driver.manage().window().maximize();
		driver.get(url);

	}

	@When("^title of login page is OrangeHRM$")
	public void verify_title() {

		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals(title, "OrangeHRM");
		Reusablefunctionss.capturescreenshot(driver, "TitleScreenshots taken");
	}

	@And("^User enters '(.*)' and '(.*)'$") // usage of regular expressions
	public void EnterCredentials(String username, String password) throws Exception {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		Reusablefunctionss.wait(3000);
	}

	@And("^User enters \"(.*)\" and \"(.*)\"$")
	public void EnterCredentialsHRM(String username, String password) throws Exception {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		Reusablefunctionss.wait(3000);
	}

	@And("^User enters Username and Password$")
	public void enterusernamepassworddattable(DataTable credentials) throws Exception {

		List<String> data = credentials.asList();
		// asList method is used to store the data table credentials inside the list and
		// returns the string data
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(data.get(0));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(data.get(1));

		Reusablefunctionss.wait(3000);

	}

	// creating data map
	@And("^User enters Map  Username and Password$")
	public void map_username_password(DataTable credentials) {

		// create map and iterate over the data map
	for (Map<String, String> data : credentials.asMaps()) {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(data.get("Username"));
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(data.get("Password"));
		
		}
	
	}
	@And("^User clicks on login button$")
	public void loginclick() throws Exception {

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Reusablefunctionss.wait(3000);
	}

	@Then("^User closes the browser")
	public void closebrowser() {

		driver.quit();
	}

	@Then("^User is navigated to OrangeHRM Dashboard Page$")
	public void navigatedashboard() throws Exception {

		Reusablefunctionss.capturescreenshot(driver, "OrangeHRMDashboard page");
		WebElement Welcome = driver.findElement(By.xpath("//a[@id='welcome']"));

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(Welcome));

	}

	@Given("^User is already on dashboard page$")
	public void user_already_on_dashboardpage() {

		WebElement Welcome = driver.findElement(By.xpath("//a[@id='welcome']"));
		String Welcometext = Welcome.getText();
		// Assert.assertEquals(Welcometext, "Welcome Admin");

	}

	@When("^User navigates to User button and clicks on User link$")
	public void usernavigatetoUserLink() throws Exception {

		WebElement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		WebElement UserAdmin = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		WebElement User = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));

		Actions act = new Actions(driver);

		act.moveToElement(Admin).moveToElement(UserAdmin).moveToElement(User).click().build().perform();
		Reusablefunctionss.wait(2000);

	}

	@When("^User clicks on Add Button$")
	public void user_clicks_addbutton() {

		WebElement add_button = driver.findElement(By.xpath("//input[@id='btnAdd']"));
		add_button.click();

	}

	@And("^User Selects User Role$")
	public void user_select_userrole() throws Exception {

		Select oSelect = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
		oSelect.selectByVisibleText("Admin");

		Reusablefunctionss.wait(3000);

	}

	@And("^User enters EmployeeName and Username as '(.*)'$")
	public void enterdetails(String username) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("John Smith");
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(username);

	}

//creating data table 
	@And("^User enters EmployeeName and Username$")
	public void enterEmployeeandUsername(DataTable details) {

		List<List<String>> datavalues = details.asLists();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// zeroth row zero column value
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']"))
				.sendKeys(datavalues.get(0).get(0));
		// zeoth row 1st column value
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(datavalues.get(0).get(1));

	}

	// creating datamap
	@And("^User enters Mapexample  EmployeeName and Username$")
	public void enter_employeename_username(DataTable userdata) {

		for (Map<Object, Object> data : userdata.asMaps(String.class, String.class)) {

			driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).
			sendKeys( (CharSequence[]) data.get("EmployeeName"));

			driver.findElement(By.xpath("//input[@id='systemUser_userName']")).
			sendKeys( (CharSequence[]) data.get("Username"));
		}
	}

	@And("^User enters Password details$")
	public void enterPasswordDetails() {

		driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("jeet47900");
		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("jeet47900");
	}

	@And("^User clicks on Save Button$")
	public void clickSaveButton() throws Exception {

		Reusablefunctionss.wait(3000);

		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Reusablefunctionss.capturescreenshot(driver, "Save happened Successfully");
	}

	@And("^User Searches with Username as '(.*)'$")
	public void UserNameSearch(String username) {

		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

	}

	@And("^User Searches with Username$")
	public void usersearches(DataTable user) throws Exception {

		List<List<String>> datavalues = user.asLists();

		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(datavalues.get(0).get(0));

		Reusablefunctionss.wait(4000);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

	}

	@And("^User Searches with Username Map$")
	public void usernameSearches(DataTable usernames) throws Exception {

		for (Map<String , String> username : usernames.asMaps()){

			driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).
			sendKeys(username.get("username"));

			Reusablefunctionss.wait(4000);
			driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		}
	}

	@Then("^Verify the User is successfully added$")
	public void VerifyUserName() {

		WebElement tablelink = driver.findElement(By.xpath("//table[@id ='resultTable']//tbody//tr//td[2]//a"));

		Reusablefunctionss.captureWebElementScreenshot(tablelink, "username created");
		tablelink.click();
		Reusablefunctionss.capturescreenshot(driver, "username added successfully");

	}

	@And("^User logouts the OrangeHRM Application$")
	public void LogoutHRMApplication() throws Exception {

		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Reusablefunctionss.wait(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();

	}

	@When("^User is navigated to OrangeHRM Dashboard Page and logout of the page$")
	public void logoutHRM() throws Exception {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Reusablefunctionss.wait(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.close();

	}
	
	@Given("^user is on orangehrm page$")
	public void user_homepage () {
		
	System.out.println ("user is on home page ");	
	}
	
	@And("^User enters credentials'(.*)' and '(.*)'$")
	public void Enteruser(String username, String password) throws Exception {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		Reusablefunctionss.wait(3000);
	}
	
	@Then("User logins successfully$")
	public void loginsuccess() throws Exception {
	
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Reusablefunctionss.wait(3000);
		System.out.println ("login succcessfully");
	}
	
	@Then("User logout application$")
	public void logoutsuccess () {
	
		System.out.println ("logout successfully :");
	}
}
