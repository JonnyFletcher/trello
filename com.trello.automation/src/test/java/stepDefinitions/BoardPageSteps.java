package stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.cucumber.TestContext;
import gui.pageObjects.BoardPage;

public class BoardPageSteps
{
	private BoardPage boardPage;

	public BoardPageSteps(TestContext testContext)
	{
		boardPage = testContext.getPageObjectManager().getBoardPage();
	}
	
	@Given("the board has a list named (.*)")
	public void theBoardHasAListNamedX(String listTitle)
	{
		boardPage.addList(listTitle);
	}

	@Given("the (.*) board has the following lists")
	public void theXBoardHasTheFollowingLists(String boardTitle, DataTable lists)
	{
		List<List<String>> _lists = lists.raw();
		
		for (int i = 0; i < _lists.size(); i++)
		{
			if (i == 0)
			{
				boardPage.addList(_lists.get(i).get(0));
			}
			else
			{
				boardPage.addAnotherList(_lists.get(i).get(0));
			}
		}
	}
	
	@Given("the (.*) list has the following cards")
	public void theXListHasTheFollowingCards(String listTitle, DataTable cards)
	{
		List<List<String>> _cards = cards.raw();
		
		for (int i = 0; i < _cards.size(); i++)
		{
			boardPage.getList(listTitle).addCard(_cards.get(i).get(0));
			boardPage.clickBackground();
		}
	}
	
	@Given("the board has another list named (.*)")
	public void theBoardHasAnotherListNamedX(String listTitle)
	{
		boardPage.addAnotherList(listTitle);
	}

	@Given("I have already added a card named (.*) to the (.*) list")
	public void iHaveAlreadyAddedACardNamedXToTheXList(String cardTitle, String listTitle)
	{
		boardPage.getList(listTitle).addCard(cardTitle);
		boardPage.clickBackground();
	}

	@When("I add a card named (.*) to the (.*) list")
	public void iAddACardNamedXToTheXList(String cardTitle, String listTitle)
	{
		boardPage.getList(listTitle).addCard(cardTitle);
		boardPage.clickBackground();
	}

	@When("I add a list named (.*) to the board")
	public void iAddAListNamedXToTheBoard(String listTitle)
	{
		boardPage.addList(listTitle);
		boardPage.clickBackground();
	}
	
	@When("I add another card named (.*) to the (.*) list")
	public void iAddAnotherCardNamedXToTheXList(String cardTitle, String listTitle)
	{
		boardPage.getList(listTitle).addCard(cardTitle);
		boardPage.clickBackground();
	}

	@When("I move the (.*) card from the (.*) list to the (.*) list")
	public void iMoveTheXCardToTheXList(String cardTitle, String currentListTitle, String newListTitle)
	{
		boardPage.getList(currentListTitle).getCard(cardTitle).moveCard(newListTitle);
		boardPage.clickBackground();
	}

	@Then("the (.*) list is displayed")
	public void theXListIsDisplayed(String listTitle)
	{
		boardPage.assertListIsDisplayed(listTitle);
	}
	
	@Then("the (.*) card is displayed in the (.*) list")
	public void theXCardIsDisplayedInTheXList(String cardTitle, String listTitle)
	{
		boardPage.getList(listTitle).assertCardIsDisplayed(cardTitle);
	}
}
