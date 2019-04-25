package gui.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.boards.BoardMenu;
import gui.pageObjects.boards.TrelloList;
import gui.pageObjects.common.PageObject;

public class BoardPage extends PageObject
{
	List<TrelloList> lists;
	
	@FindBy(how = How.XPATH, using = "//span[.='Add a list']")
    private WebElement addAList;
	
	@FindBy(how = How.XPATH, using = "//span[.='Add another list']")
    private WebElement addAnotherList;
	
	@FindBy(how = How.ID, using = "board")
	private WebElement background;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Delete']")
	private WebElement delete;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'board-header ')]")
	private WebElement header;
	
	@FindBy(how = How.XPATH, using = "//a[.='Permanently Delete Board…']")
	private WebElement permanentlyDeleteBoard;
	
	private BoardMenu boardMenu;

    public BoardPage(WebDriver driver)
    {
        super(driver, "Boards | Trello");
        PageFactory.initElements(driver, this);
        
        lists = new ArrayList<TrelloList>();
        
        boardMenu = new BoardMenu(driver);
    }

    public void addList(String listTitle)
    {
    	addAList.click();
    	addAList(listTitle);
    }

    public void addAnotherList(String listTitle)
    {
		addAnotherList.click();	
		addAList(listTitle);
    }

    public void assertListIsDisplayed(String listTitle)
    {
		getList(listTitle).assertListIsDisplayed();
    }

    public void clickBackground()
    {
    	background.click();
    	waitSeconds(1);
    }

    public void clickDelete()
    {
    	delete.click(); 
    }
    
    public void clickPermanentlyDeleteBoard()
    {
    	permanentlyDeleteBoard.click();
    }
    
    public TrelloList getList(String listTitle)
    {
    	waitForPageToLoad();
    	
    	TrelloList _list = null;
    	
    	for (TrelloList list : lists)
    	{
    		if (list.getTitle().equals(listTitle))
    		{
    			_list = list;
    			break;
    		}
    	}
    	
    	if (_list == null)
    	{
    		_list = new TrelloList(driver, listTitle);
    		lists.add(_list);
    	}
    	
    	return _list;
    }

    public void deleteBoard()
    {
    	boardMenu.clickMore();
    	boardMenu.clickCloseBoard();
    	boardMenu.clickClose();
    	
    	clickPermanentlyDeleteBoard();
    	clickDelete();
    }
    
    private void addAList(String listTitle)
    {
    	TrelloList list = new TrelloList(driver, listTitle);
    	list.enterListTitle();
    	list.clickAddList();
    	
    	lists.add(list);
    	
    	clickBackground();
    }
}