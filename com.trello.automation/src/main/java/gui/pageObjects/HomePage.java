package gui.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;

public class HomePage extends PageObject
{    
    @FindBy(how = How.LINK_TEXT, using = "Log In")
    private WebElement logIn;

    public HomePage(WebDriver driver)
    {
        super(driver, "Trello");
        PageFactory.initElements(driver, this);
    }

    public void clickLogin()
    {
        logIn.click();
    }
}
