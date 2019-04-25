package gui.managers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TestCaseManager
{
	public void setUp_AddCard_EmptyList()
	{
		String boardId = "";
		String boardName = "Add card - Empty list (API setup)";
		String listName = "To Do";
		
		deleteBoard(boardName);
		boardId = createBoard(boardName);
		createList(boardId, listName, "1");
	}
	
	public void setUp_MoveCard_MultipleCardsInList()
	{
		String boardId = "";
		String listId1 = "";
		
		String boardName = "Move card - Multiple cards in list (API setup)";
		String listName1 = "To Do";
		String listName2 = "Doing";
		String listName3 = "Done";
		
		String cardName1 = "Buy eggs";
		String cardName2 = "Buy milk";
		String cardName3 = "Buy coffee";
		String cardName4 = "Buy sugar";
		String cardName5 = "Buy bread";
		String cardName6 = "Buy butter";
		String cardName7 = "Buy tea";
		String cardName8 = "Buy cheese";
		
		deleteBoard(boardName);
		boardId = createBoard(boardName);
		listId1 = createList(boardId, listName1, "1");
		
		createCard(listId1, cardName1);
		createCard(listId1, cardName2);
		createCard(listId1, cardName3);
		createCard(listId1, cardName4);
		createCard(listId1, cardName5);
		createCard(listId1, cardName6);
		createCard(listId1, cardName7);
		createCard(listId1, cardName8);
		
		createList(boardId, listName2, "2");
		createList(boardId, listName3, "3");
	}
	
	public void setUp_MoveCard_SingleCardInList()
	{
		String boardId = "";
		String listId = "";
		
		String boardName = "Move card - Single card in list (API setup)";
		String listName1 = "To Do";
		String listName2 = "Done";
		
		String cardName = "Buy milk";
		
		deleteBoard(boardName);
		boardId = createBoard(boardName);
		listId = createList(boardId, listName1, "1");
		
		createCard(listId, cardName);
		
		createList(boardId, listName2, "3");
	}
	
	private String createBoard(String name)
	{
		String request = "1/boards/?name=%1s&defaultLists=false&%2s";
		request = String.format(request, name, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);
		
		return getBoardId(name);
	}

	private void createCard(String listId, String name)
	{
		String request = "1/cards?name=%1s&idList=%2s&%3s";
		request = String.format(request, name, listId, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);
	}
	
	private String createList(String boardId, String name, String position)
	{
		String request = "1/lists?name=%1s&idBoard=%2s&pos=%3s&%4s";
		request = String.format(request, name, boardId, position, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);
		
		return getListId(boardId, name);
	}

	private void deleteBoard(String name)
	{
		String request = "1/boards/%1s?%2s";
		request = String.format(request, getBoardId(name), APIHelper.getAuthentication());
				
		APIHelper.sendDeleteRequest(request);
	}
	
	private String getBoardId(String name)
	{
		String boardId = "";
		
		String request = "1/members/%1s/boards?fields=all&%2s";
		request = String.format(request, "5b45cb0eaae786b07baece9a", APIHelper.getAuthentication());
		
		JSONArray _boards = APIHelper.sendGetRequest(request);
		
		for (Object _board : _boards)
		{
			JSONObject boardJson = (JSONObject)_board;
			String _name = (String)boardJson.get("name");
			
			if (_name.equals(name))
			{
				boardId = (String)boardJson.get("id");
			}
		}
		
		return boardId;
	}
	
	private String getListId(String boardId, String name)
	{
		String listId = "";
		
		String request = "1/boards/%1s/lists?%2s";
		request = String.format(request, boardId, APIHelper.getAuthentication());
		
		JSONArray _lists = APIHelper.sendGetRequest(request);
		
		for (Object _list : _lists)
		{
			JSONObject listJson = (JSONObject)_list;
			String _name = (String)listJson.get("name");
			
			if (_name.equals(name))
			{
				listId = (String)listJson.get("id");
			}
		}
		
		return listId;
	}
}
