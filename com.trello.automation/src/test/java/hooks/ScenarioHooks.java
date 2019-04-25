package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gui.cucumber.TestContext;
import gui.data.WebBrowser;

public class ScenarioHooks
{
    private TestContext testContext;

    public ScenarioHooks(TestContext testContext)
    {
        this.testContext = testContext;
    }
    
    @Before("@gui")
    public void setupTestCase(Scenario scenario)
    {
    	launchTrello(scenario);
    }

    @Before("@api")
    public void setupTestCaseUsingAPI(Scenario scenario)
    {
    	// Change to switch
    	if (scenario.getName().equals("Add card - Empty list (API setup)"))
    	{
    		testContext.getTestCaseManager().setUp_AddCard_EmptyList();	
    	}
    	else if (scenario.getName().equals("Move card - Single card in list (API setup)"))
    	{
    		testContext.getTestCaseManager().setUp_MoveCard_SingleCardInList();
    	}
    	else if (scenario.getName().equals("Move card - Multiple cards in list (API setup)"))
    	{
    		testContext.getTestCaseManager().setUp_MoveCard_MultipleCardsInList();
    	}
    	
    	launchTrello(scenario);
    }

    @After
    public void teardownTestCase()
    {
        Scenario scenario = testContext.getScenario();

        if (scenario.isFailed())
        {
            byte[] screenshot = testContext.getWebDriverManager().takeScreenshot();
            scenario.embed(screenshot, "image/png");
        }
        
        waitSeconds(2);
        
        testContext.getWebDriverManager().killDriver();
    }
    
    private void launchTrello(Scenario scenario)
    {
        testContext.setScenario(scenario);
        testContext.getWebDriverManager().initialiseDriver(WebBrowser.getType());
        testContext.getWebDriverManager().launchUrl();
    }
    
    private void waitSeconds(int seconds)
    {
    	int milliseconds = seconds * 1000;
    	
        try
        {
			Thread.sleep(milliseconds);
		}
        catch (InterruptedException e)
        {
        	e.printStackTrace();
		}
    }
}