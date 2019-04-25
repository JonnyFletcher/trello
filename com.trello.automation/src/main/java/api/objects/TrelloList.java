package api.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloList
{
	private String id;
	private String name;
	
	private List<TrelloCard> cards;
	
	public TrelloList(JSONObject listJson)
	{
		id = (String)listJson.get("id");
		name = (String)listJson.get("name");
		
		initialiseList();
	}

	public void createCard(String name)
	{
		String request = "1/cards?name=%1s&idList=%2s&%3s";
		request = String.format(request, name, id, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);

		initialiseCards();
	}
	
	public void deleteCard(String name)
	{
		for (TrelloCard card : cards)
		{
			if (card.getName().equals(name))
			{
				String request = "1/cards/%1s?%2s";
				request = String.format(request, card.getId(), APIHelper.getAuthentication());
				
				APIHelper.sendDeleteRequest(request);
				
				cards.remove(card);
				break;
			}
		}
	}
	
	public TrelloCard getCard(String name)
	{
		TrelloCard _card = null;
		
		for (TrelloCard card : cards)
		{
			if (card.getName().equals(name))
			{
				_card = card;
				break;
			}
		}
		
		return _card;
	}

	public List<TrelloCard> getCards()
	{
		return cards;
	}

	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void refreshCardsAfterMove()
	{
		initialiseCards();
	}
	
	public void removeCardAfterMove(String name)
	{
		cards.remove(getCard(name));
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	private void initialiseList()
	{
		this.cards = new ArrayList<TrelloCard>();
		initialiseCards();
	}
	
	private void initialiseCards()
	{
		cards.clear();
		
		String request = "1/lists/%1s/cards?%2s";
		request = String.format(request, id, APIHelper.getAuthentication());
		
		JSONArray _cards = APIHelper.sendGetRequest(request);
		
		for (Object _card : _cards)
		{
			TrelloCard card = new TrelloCard((JSONObject)_card);
			cards.add(card);
		}
	}
}