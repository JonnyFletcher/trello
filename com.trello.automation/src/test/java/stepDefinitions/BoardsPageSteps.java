package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.cucumber.TestContext;
import gui.pageObjects.BoardPage;
import gui.pageObjects.BoardsPage;

public class BoardsPageSteps
{
	private BoardPage boardPage;
	private BoardsPage boardsPage;
	
	public BoardsPageSteps(TestContext testContext)
	{
		boardPage = testContext.getPageObjectManager().getBoardPage();
		boardsPage = testContext.getPageObjectManager().getBoardsPage();
	}

	@Given("no other boards exist")
	public void noOtherBoardsExist()
	{
		while (boardsPage.boardsExist())
		{
			boardsPage.openNextPersonalBoard();
			boardPage.deleteBoard();
		}
	}
	
	@When("I create a new board")
	public void iCreateANewBoard()
	{
		boardsPage.createNewBoard("JonnyTest");
	}
	
	@Then("the Boards page is displayed")
	public void theBoardsPageIsDisplayed()
	{
		boardsPage.assertPageTitleIsCorrect();
	}
}
