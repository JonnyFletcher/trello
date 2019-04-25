package api.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import api.utilities.APIHelper;

public class TrelloMember
{
	private String id;
	
	private List<TrelloBoard> boards;
	
	public TrelloMember()
	{
		this.id = "5b45cb0eaae786b07baece9a";
		initialiseMember();
	}

	public void createBoard(String name)
	{
		String request = "1/boards/?name=%1s&%2s";
		request = String.format(request, name, APIHelper.getAuthentication());
		
		APIHelper.sendPostRequest(request);

		initialiseBoards();
	}
	
	public void deleteBoard(String name)
	{
		for (TrelloBoard board : boards)
		{
			if (board.getName().equals(name))
			{
				String request = "1/boards/%1s?%2s";
				request = String.format(request, board.getId(), APIHelper.getAuthentication());
				
				APIHelper.sendDeleteRequest(request);
				
				boards.remove(board);
				break;
			}
		}
	}
	
	public void deleteBoards()
	{
		for (TrelloBoard board : boards)
		{
			String request = "1/boards/%1s?%2s";
			request = String.format(request, board.getId(), APIHelper.getAuthentication());
			
			APIHelper.sendDeleteRequest(request);
		}

		boards.clear();
	}
	
	public TrelloBoard getBoard(String name)
	{
		TrelloBoard _board = null;
		
		for (TrelloBoard board : boards)
		{
			if (board.getName().equals(name))
			{
				_board = board;
				break;
			}
		}
		
		return _board;
	}
	
	private void initialiseMember()
	{
		this.boards = new ArrayList<TrelloBoard>();	
		initialiseBoards();		
	}
	
	private void initialiseBoards()
	{
		boards.clear();
		
		String request = "1/members/%1s/boards?fields=all&%2s";
		request = String.format(request, id, APIHelper.getAuthentication());
		
		JSONArray _boards = APIHelper.sendGetRequest(request);
		
		for (Object _board : _boards)
		{
			TrelloBoard board = new TrelloBoard((JSONObject)_board);
			boards.add(board);
		}
	}
}
