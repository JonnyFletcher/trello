package gui.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;

public class LogInToTrelloPage extends PageObject
{
    @FindBy(how = How.ID, using = "login")
    private WebElement logIn;	
	
    @FindBy(how = How.ID, using = "password")
    private WebElement password;
    
    @FindBy(how = How.ID, using = "user")
    private WebElement username;
    
    public LogInToTrelloPage(WebDriver driver)
    {
        super(driver, "Log in to Trello");
        PageFactory.initElements(driver, this);
    }

    public void clickLogIn()
    {
    	logIn.click();
    	
    	// Wait for page load...
    	waitSeconds(2);
    }
    
    public void inputValidPassword()
    {
        password.sendKeys("helloWorld!123");
    }
    
    public void inputValidUsername()
    {
        username.sendKeys("automation.support@roqit.co.uk");
    }
    
    public void submitValidUsernameAndPassword()
    {
    	inputValidUsername();
    	inputValidPassword();
    	clickLogIn();
    }
}
