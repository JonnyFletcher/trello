package api.objects;

import org.json.simple.JSONObject;

public class TrelloBoardPreferences
{
//	private String background;
//	private String backgroundBottomColor;
//	private String backgroundBrightness;
	private String backgroundColor;
//	private String backgroundImage;
//	private String backgroundImageScaled;	
//	private String backgroundTopColor;
//	private String cardAging;
//	private String comments;
//	private String invitations;
//	private String permissionLevel;
//	private String voting;
//	
//	private Boolean backgroundTile;
//	private Boolean calendarFeedbackEnabled;
//	private Boolean canBeEnterprise;
//	private Boolean canBeOrg;
//	private Boolean canBePrivate;
//	private Boolean canBePublic;
//	private Boolean canInvite;
//	private Boolean cardCovers;
//	private Boolean selfJoin;
	
	public TrelloBoardPreferences(JSONObject preferences)
	{
//		background = (String)preferences.get("background");
//		backgroundBottomColor = (String)preferences.get("backgroundBottomColor");
//		backgroundBrightness = (String)preferences.get("backgroundBrightness");
		backgroundColor = (String)preferences.get("backgroundColor");
//		backgroundImage = (String)preferences.get("backgroundImage");
//		backgroundImageScaled = (String)preferences.get("backgroundImageScaled");
//		backgroundTopColor = (String)preferences.get("backgroundTopColor");
//		cardAging = (String)preferences.get("cardAging");
//		comments = (String)preferences.get("comments");
//		invitations = (String)preferences.get("invitations");
//		permissionLevel = (String)preferences.get("permissionLevel");
//		voting = (String)preferences.get("voting");
//		
//		backgroundTile = (Boolean)preferences.get("backgroundTile");
//		calendarFeedbackEnabled = (Boolean)preferences.get("calendarFeedEnabled");
//		canBeEnterprise = (Boolean)preferences.get("canBeEnterprise");
//		canBeOrg = (Boolean)preferences.get("canBeOrg");
//		canBePrivate = (Boolean)preferences.get("canBePrivate");
//		canBePublic = (Boolean)preferences.get("canBePublic");
//		canInvite = (Boolean)preferences.get("canInvite");
//		cardCovers = (Boolean)preferences.get("cardCovers");
//		selfJoin = (Boolean)preferences.get("selfJoin");
	}
	
	public String getBackgroundColor()
	{
		return backgroundColor;
	}
	
	public void setBackgroundColor(String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}
}
