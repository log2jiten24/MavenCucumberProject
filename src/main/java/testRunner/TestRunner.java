package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		
		//features = "F:\\Cucumber_Workspace\\MavenCucumberProject\\FeatureFiles\\Login.feature",
		
	//features = "F:/Cucumber_Workspace/MavenCucumberProject/src/main/java/featurefiles",
		
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
		strict = true //it will check if any step is not defined in the step definition file 
		)

public class TestRunner {
	
	

}
