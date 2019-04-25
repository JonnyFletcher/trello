package gui.cucumber;

import cucumber.api.Scenario;
import gui.managers.PageObjectManager;
import gui.managers.TestCaseManager;
import gui.managers.WebDriverManager;

public class TestContext
{
	// Managers
    private PageObjectManager pageObjectManager;
    private TestCaseManager testCaseManager;
    private WebDriverManager webDriverManager;
    
    // Cucumber
    private Scenario scenario;

    public PageObjectManager getPageObjectManager()
    {
        return (pageObjectManager == null) ? pageObjectManager = new PageObjectManager(webDriverManager.getDriver()) : pageObjectManager;
    }

    public TestCaseManager getTestCaseManager()
    {
        return (testCaseManager == null) ? testCaseManager = new TestCaseManager() : testCaseManager;
    }

    public WebDriverManager getWebDriverManager()
    {
    	return (webDriverManager == null) ? webDriverManager = new WebDriverManager() : webDriverManager;
    }

    public Scenario getScenario()
    {
        return scenario;
    }
    
    public void setScenario(Scenario scenario)
    {
        this.scenario = scenario;
    }
    
    public void waitSeconds(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e)
        {
            // Do nothing
        }
    }
}