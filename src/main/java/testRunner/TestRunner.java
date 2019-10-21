package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		
		//features = "F:\\Cucumber_Workspace\\MavenCucumberProject\\FeatureFiles\\Login.feature",
		
	   // features = "F:\\Cucumber_Workspace\\MavenCucumberProject\\src\\main\\java\\featurefiles"
	    		//+ "\\Datadrivemap.feature",
		
		//features = "F:\\Cucumber_Workspace\\MavenCucumberProject\\src\\main\\java\\featurefiles"
				//+ "\\datamap.feature",
		
		features = {"featurefiles"},
		//path of feature files
        glue ={"stepDefinitions"} ,//path of the step definitionfiles where exactly the stepdefinition present 
		
		//pretty means - it will generate console output in a very good manner 
		plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json",
				 "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
				 "junit:target/cucumber-results.xml"},
		
		//it will generate cucumber html report 
	    monochrome = true ,//display the console output in proper readable format 
	    dryRun = false, //if its true -it will verify each feature step is having step definition code  with 
	    //correct mapping ,(mapping correct)make it as false to run the tests 
		strict = true ,//it will check if any step is not defined in the step definition file 
		//tags = {"@SmokeTest"},
		//tags = {"@SmokeTest, @RegressionTest"}//OR operator --either Smoke test or Regressiontest
		tags = {"@RegressionTest"}
		//tags = {"@test"}
		)

public class TestRunner {
	
	  //tags = {"@SmokeTest, @RegressionTest"}//OR operator --either Smoke test or Regressiontest
      //tags = {"@SmokeTest", "@RegressionTest"}-- execute all test tagged as SmokeTest and Regression test
	  //tags = {"~@SmokeTest", "@RegressionTest"}	--~keyword is used to ignore the tests/skip test 
	 //tags = {"not @tag@SmokeTest", "not @tag@RegressionTest"}
	
	//hooks - @Before and @After - it is used to define the pre conditions and post condtions to execute --
	//they are known as global hooks 
	//tagged hooks - which is used for before and after for specific scenario -@First @Second 
	//@Before("@First") ,@After("@First")
	
	
}
