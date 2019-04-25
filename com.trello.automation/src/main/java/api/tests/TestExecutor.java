package api.tests;

import org.testng.annotations.Test;

import api.objects.TrelloMember;
import gui.managers.TestCaseManager;

public class TestExecutor
{
	@Test
	private void test()
	{
		String backgroundColor1 = "red";
		String backgroundColor2 = "blue";
		String boardName = "Board";
		String cardName = "Card";
		String checkItemName = "CheckItem";
		String checklistName = "Checklist";
		String listName1 = "Backlog";
		String listName2 = "To Do";
		
		TrelloMember member = new TrelloMember();
		member.deleteBoards();
		member.createBoard(boardName);
		member.getBoard(boardName).setBackgroundColour(backgroundColor1);
		member.getBoard(boardName).setBackgroundColour(backgroundColor2);
		member.getBoard(boardName).createList(listName1);
		member.getBoard(boardName).getList(listName1).createCard(cardName);
		member.getBoard(boardName).moveCardToList(cardName, listName2);
		member.getBoard(boardName).getList(listName2).getCard(cardName).createChecklist(checklistName);
		member.getBoard(boardName).getList(listName2).getCard(cardName).getChecklist(checklistName).createCheckItem(checkItemName);
		member.getBoard(boardName).getList(listName2).getCard(cardName).getChecklist(checklistName).getCheckItem(checkItemName).setStatusToComplete();
		member.getBoard(boardName).getList(listName2).getCard(cardName).getChecklist(checklistName).getCheckItem(checkItemName).setStatusToIncomplete();
		member.getBoard(boardName).getList(listName2).getCard(cardName).getChecklist(checklistName).deleteCheckItem(checkItemName);
		member.getBoard(boardName).getList(listName2).getCard(cardName).deleteChecklist(checklistName);
		member.getBoard(boardName).getList(listName2).deleteCard(cardName);
		member.getBoard(boardName).archiveList(listName1);
		member.deleteBoard(boardName);
	}
	
	@Test
	public void setUp_AddCard_EmptyList()
	{
		TestCaseManager tcManager = new TestCaseManager();
		tcManager.setUp_AddCard_EmptyList();
	}
	
	@Test
	public void setUp_MoveCard_MultipleCardsInList()
	{
		TestCaseManager tcManager = new TestCaseManager();
		tcManager.setUp_MoveCard_MultipleCardsInList();
	}

	@Test
	private void deleteBoards()
	{
		TrelloMember member = new TrelloMember();
		member.deleteBoards();
	}
}