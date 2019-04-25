package gui.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;
import gui.pageObjects.modals.NewBoardModal;

public class BoardsPage extends PageObject
{
	private NewBoardModal newBoardModal;
	
	@FindBy(how = How.XPATH, using = "//span[.='Create new board…']")
    private WebElement createANewBoard;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//h3[.='Personal Boards']/../..//li/a[contains(@class, 'board-tile')]"))
    private List<WebElement> personalBoards;
    
	public BoardsPage(WebDriver driver)
    {
        super(driver, "Boards | Trello");
        PageFactory.initElements(driver, this);
        
        newBoardModal = new NewBoardModal(driver);
    }

	public Boolean boardsExist()
	{
		return personalBoards.size() > 0;
	}
	
    public void clickCreateNewBoard()
    {
    	createANewBoard.click();
    }

    public void createNewBoard(String title)
    {
    	createANewBoard.click();
    	newBoardModal.createNewBoard(title);
    }

    public void openNextPersonalBoard()
    {
    	personalBoards.get(0).click();
    }
    
    public void openBoard(String boardTitle)
    {
    	String boardXpath = "//div[@class='board-tile-details-name' and div[.='%s']]";
    	boardXpath = String.format(boardXpath, boardTitle);
    	
    	WebElement element = driver.findElement(By.xpath(boardXpath));
    	element.click();
    }
}