package api.objects;

import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloCheckItem
{
	private String cardId;
	
	private String id;
	private String name;
	
	public TrelloCheckItem(JSONObject boardJson, String cardId)
	{
		id = (String)boardJson.get("id");
		name = (String)boardJson.get("name");
		
		this.cardId = cardId;
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
	
	public void setStatusToComplete()
	{
		String request = "1/cards/%1s/checkItem/%2s?state=complete&%3s";
		request = String.format(request, cardId, id, APIHelper.getAuthentication());
		
		APIHelper.sendPutRequest(request);
	}
	
	public void setStatusToIncomplete()
	{
		String request = "1/cards/%1s/checkItem/%2s?state=incomplete&%3s";
		request = String.format(request, cardId, id, APIHelper.getAuthentication());
		
		APIHelper.sendPutRequest(request);
	}
}