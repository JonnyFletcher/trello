package stepDefinitions;

import cucumber.api.java.en.When;
import gui.cucumber.TestContext;
import gui.pageObjects.LogInToTrelloPage;

public class LogInToTrelloSteps
{
	private LogInToTrelloPage logInToTrelloPage;
	
	public LogInToTrelloSteps(TestContext testContext)
	{
		logInToTrelloPage = testContext.getPageObjectManager().getLogInToTrelloPage();
	}
	
	@When("I submit a valid username and password")
	public void iSubmitAValidUsernameAndPassword()
	{
		logInToTrelloPage.submitValidUsernameAndPassword();
	}
}
