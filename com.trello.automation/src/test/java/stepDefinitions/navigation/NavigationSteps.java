package stepDefinitions.navigation;

import cucumber.api.java.en.Given;
import gui.cucumber.TestContext;
import gui.pageObjects.HomePage;
import gui.pageObjects.LogInToTrelloPage;

public class NavigationSteps
{
	private HomePage homePage;
	private LogInToTrelloPage logInToTrelloPage;
	
	public NavigationSteps(TestContext testContext)
	{
		homePage = testContext.getPageObjectManager().getHomePage();
		logInToTrelloPage = testContext.getPageObjectManager().getLogInToTrelloPage();
	}
	
	@Given("I am on the Boards page")
	public void iAmOnTheBoardsPage()
	{
		homePage.clickLogin();
		logInToTrelloPage.submitValidUsernameAndPassword();
	}
	
	@Given("I am on the Log In page")
	public void iAmOnTheLogInPage()
	{
		homePage.clickLogin();
	}
}
