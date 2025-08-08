package myTestRunner_;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resource/com/features",
	    glue ={"stepDefinitions", "com.AppHooks"},
	    plugin = {"pretty","html:target/cucumber-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    dryRun= false,
	    monochrome = false,
	    tags = "")
	    
public class TestRunner{

}
