package api.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloChecklist
{
	private String cardId;
	private String id;
	private String name;
	
	private List<TrelloCheckItem> checkItems;
	
	public TrelloChecklist(JSONObject boardJson)
	{
		id = (String)boardJson.get("id");
		cardId = (String)boardJson.get("idCard");
		name = (String)boardJson.get("name");
		
		initialiseCheckList();
	}

	public void createCheckItem(String name)
	{
		String request = "1/checklists/%1s/checkItems?name=%2s&%3s";
		request = String.format(request, id, name, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);

		initialiseCheckItems();
	}
	
	public void deleteCheckItem(String name)
	{
		for (TrelloCheckItem checkItem : checkItems)
		{
			if (checkItem.getName().equals(name))
			{
				String request = "1/checklists/%1s/checkItems/%2s?%3s";
				request = String.format(request, id, checkItem.getId(), APIHelper.getAuthentication());
				
				APIHelper.sendDeleteRequest(request);
				
				checkItems.remove(checkItem);
				break;
			}
		}
	}
	
	public TrelloCheckItem getCheckItem(String name)
	{
		TrelloCheckItem _checkItem = null;
		
		for (TrelloCheckItem checkItem : checkItems)
		{
			if (checkItem.getName().equals(name))
			{
				_checkItem = checkItem;
				break;
			}
		}
		
		return _checkItem;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	private void initialiseCheckItems()
	{
		checkItems.clear();
		
		String request = "1/checklists/%1s/checkItems?%2s";
		request = String.format(request, id, APIHelper.getAuthentication());
		
		JSONArray _checkItems = APIHelper.sendGetRequest(request);
		
		for (Object _checkItem : _checkItems)
		{
			TrelloCheckItem checkItem = new TrelloCheckItem((JSONObject)_checkItem, cardId);
			checkItems.add(checkItem);
		}
	}

	private void initialiseCheckList()
	{
		this.checkItems = new ArrayList<TrelloCheckItem>();
		initialiseCheckItems();
	}
}