package gui.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;

public class WebDriverManager
{
	private WebDriver driver;
	
	public WebDriverManager()
	{
		driver = null;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void initialiseDriver(String type)
	{
    	switch (type)
    	{
	    	case "chrome" :
	    		driver = initialiseChromeDriver();
	    		break;
	    	case "firefox" :
	    		driver = initialiseFirefoxDriver();
	    		break;
	    	default:
	    		Assert.fail("Driver type cannot be initialised: " + type);
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
	}
	
	public void killDriver()
	{
		driver.quit();
	}
	
	public void launchUrl()
	{
		driver.navigate().to("https://www.trello.com");
	}
	
	public byte[] takeScreenshot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	private WebDriver initialiseChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe"); 
		return new ChromeDriver();
	}
	
	private WebDriver initialiseFirefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver","src/test/resources/Drivers/geckodriver.exe");
		return new FirefoxDriver();
	}
}
