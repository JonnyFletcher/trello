package runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import gui.data.WebBrowser;

@CucumberOptions(
      features = "src/test/resources/Features"
    , glue = {
          "hooks"
        , "runners"
        , "stepDefinitions"
    }
    , plugin = {
    	  "html:target/cucumber"
    	, "json:target/cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests
{
    @BeforeSuite
    @Parameters( {"browser-type"} )
    public void setupTestSuite(String browserType)
    {
        WebBrowser.setType(browserType);
    }
    
    @AfterSuite
    public void teardownTestSuite()
    {
    	WebBrowser.resetType();
    }
}
