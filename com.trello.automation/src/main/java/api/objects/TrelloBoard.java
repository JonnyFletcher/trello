package api.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloBoard
{
	private String id;
	private String name;

	private TrelloBoardPreferences preferences;
	private List<TrelloList> lists;

	public TrelloBoard(JSONObject boardJson)
	{
		id = (String)boardJson.get("id");
		name = (String)boardJson.get("name");
		preferences = new TrelloBoardPreferences((JSONObject)boardJson.get("prefs"));
		
		initialiseLists();
	}
	
	public void archiveList(String name)
	{
		for (TrelloList list : lists)
		{
			if (list.getName().equals(name))
			{
				String request = "1/lists/%1s?closed=true&%2s";
				request = String.format(request, list.getId(), APIHelper.getAuthentication());
				
				APIHelper.sendPutRequest(request);
				
				lists.remove(list);
				break;
			}
		}
	}

	public void createList(String name)
	{
		String request = "1/lists?name=%1s&idBoard=%2s&%3s";
		request = String.format(request, name, id, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);

		buildLists();
	}

	public TrelloBoardPreferences getPreferences()
	{
		return preferences;
	}
	
	public String getId()
	{
		return id;
	}
	
	public TrelloList getList(String name)
	{
		TrelloList _list = null;
		
		for (TrelloList list : lists)
		{
			if (list.getName().equals(name))
			{
				_list = list;
				break;
			}
		}
		
		return _list;
	}

	public String getName()
	{
		return name;
	}
	
	public void moveCardToList(String cardName, String listName)
	{
		TrelloCard cardToMove = null;
		
		TrelloList newList = null;
		TrelloList oldList = null;
		
		for (TrelloList list : lists)
		{
			if (list.getName().equals(listName))
			{
				newList = list;
			}
			
			for (TrelloCard card : list.getCards())
			{
				if (card.getName().equals(cardName))
				{
					oldList = list;
					cardToMove = card;
				}
			}
			
			// Break loop if all values have been captured
			if (newList != null &&
				oldList != null)
			{
				break;
			}
		}
		
		String request = "1/cards/%1s?idList=%2s&%3s";
		request = String.format(request, cardToMove.getId(), newList.getId(), APIHelper.getAuthentication());
		
		APIHelper.sendPutRequest(request);
		
		oldList.removeCardAfterMove(cardName);
		newList.refreshCardsAfterMove();
	}

	public void setBackgroundColour(String backgroundColor)
	{
		String request = "1/boards/%1s?prefs/background=%2s&%3s";
		request = String.format(request, id, backgroundColor, APIHelper.getAuthentication());
		
		APIHelper.sendPutRequest(request);
		
		preferences.setBackgroundColor(backgroundColor);
	}

	private void buildLists()
	{
		lists.clear();

		String request = "1/boards/%1s/lists?%2s";
		request = String.format(request, id, APIHelper.getAuthentication());
		
		JSONArray _lists = APIHelper.sendGetRequest(request);
		
		for (Object _list : _lists)
		{
			TrelloList list = new TrelloList((JSONObject)_list);
			lists.add(list);
		}
	}
	
	private void initialiseLists()
	{
		this.lists = new ArrayList<TrelloList>();
		buildLists();
	}
}