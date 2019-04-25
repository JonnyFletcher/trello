package stepDefinitions.actions;

import cucumber.api.java.en.Given;
import gui.cucumber.TestContext;
import gui.pageObjects.BoardPage;
import gui.pageObjects.BoardsPage;
import gui.pageObjects.HomePage;
import gui.pageObjects.LogInToTrelloPage;

public class ActionSteps
{
	private BoardPage boardPage;
	private BoardsPage boardsPage; 
	private HomePage homePage; 
	private LogInToTrelloPage logInToTrelloPage;
	
	public ActionSteps(TestContext testContext)
	{
		boardPage = testContext.getPageObjectManager().getBoardPage();
		boardsPage = testContext.getPageObjectManager().getBoardsPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		logInToTrelloPage = testContext.getPageObjectManager().getLogInToTrelloPage();
	}

	@Given("I have already created a board named (.*)")
	public void iHaveAlreadyCreatedABoardCalledX(String boardTitle)
	{
		homePage.clickLogin();
		logInToTrelloPage.submitValidUsernameAndPassword();
		boardsPage.createNewBoard(boardTitle);
		boardPage.clickBackground();
	}
	
	@Given("I have created a board named (.*)")
	public void iHaveCreatedABoardNamedX(String boardTitle)
	{
		homePage.clickLogin();
		logInToTrelloPage.submitValidUsernameAndPassword();
		boardsPage.createNewBoard(boardTitle);
		boardPage.clickBackground();
	}
	
	@Given("I have opened the (.*) board")
	public void iHaveOpenedTheXBoard(String boardTitle)
	{
		homePage.clickLogin();
		logInToTrelloPage.submitValidUsernameAndPassword();
		boardsPage.openBoard(boardTitle);
		boardPage.clickBackground();
	}
}
