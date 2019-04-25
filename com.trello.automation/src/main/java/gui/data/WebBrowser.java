package gui.data;

public class WebBrowser
{
	private static String type;
	
	static
	{
		type = "";
	}

	public static String getType()
	{
		return type;
	}

	public static void resetType()
	{
		type = "";
	}
	
	public static void setType(String browserType)
	{
		type = browserType;
	}
}
