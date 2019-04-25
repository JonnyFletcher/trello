package api.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloCard
{
	private String id;
	private String name;

	private List<TrelloChecklist> checklists;

	public TrelloCard(JSONObject cardJson)
	{
		id = (String)cardJson.get("id");
		name = (String)cardJson.get("name");
		
		initialiseCard();
	}

	public void createChecklist(String name)
	{
		String request = "1/cards/%1s/checklists?name=%2s&%3s";
		request = String.format(request, id, name, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);

		initialiseChecklists();
	}
	
	public void deleteChecklist(String name)
	{
		for (TrelloChecklist checklist : checklists)
		{
			if (checklist.getName().equals(name))
			{
				String request = "1/checklists/%1s?%2s";
				request = String.format(request, checklist.getId(), APIHelper.getAuthentication());
				
				APIHelper.sendDeleteRequest(request);
				
				checklists.remove(checklist);
				break;
			}
		}
	}
	
	public TrelloChecklist getChecklist(String name)
	{
		TrelloChecklist _checklist = null;
		
		for (TrelloChecklist checklist : checklists)
		{
			if (checklist.getName().equals(name))
			{
				_checklist = checklist;
				break;
			}
		}
		
		return _checklist;
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
	
	private void initialiseCard()
	{
		this.checklists = new ArrayList<TrelloChecklist>();
		initialiseChecklists();
	}
	
	private void initialiseChecklists()
	{
		checklists.clear();
		
		String request = "1/cards/%1s/checklists?%2s";
		request = String.format(request, id, APIHelper.getAuthentication());
		
		JSONArray _checklists = APIHelper.sendGetRequest(request);
		
		for (Object _checklist : _checklists)
		{
			TrelloChecklist checklist = new TrelloChecklist((JSONObject)_checklist);
			checklists.add(checklist);
		}
	}
}