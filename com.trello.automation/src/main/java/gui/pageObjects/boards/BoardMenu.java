package gui.pageObjects.boards;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;

public class BoardMenu extends PageObject
{
	@FindBy(how = How.XPATH, using = "//input[@value='Close']")
	private WebElement close;
	
	@FindBy(how = How.XPATH, using = "//li[@class='board-menu-navigation-item']/a[contains(., 'Close Board')]")
	private WebElement closeBoard;
	
	@FindBy(how = How.XPATH, using = "//li[@class='board-menu-navigation-item']/a[contains(., 'More')]")
	private WebElement more;

	public BoardMenu(WebDriver driver)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);
	}
	
	public void clickClose()
	{
		close.click();
	}
	
	public void clickCloseBoard()
	{
		closeBoard.click();
	}
	
	public void clickMore()
	{
		more.click();
	}
}
