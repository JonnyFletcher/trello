package gui.pageObjects.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;

public class NewBoardModal extends PageObject
{
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Add board title']")
    private WebElement boardTitle;
	
	@FindBy(how = How.XPATH, using = "//span[.='Create Board']")
    private WebElement createBoard;

	public NewBoardModal(WebDriver driver)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);
    }

	public void createNewBoard(String title)
	{
		inputBoardTitle(title);
		clickCreateBoard();
	}
	
	public void clickCreateBoard()
	{
		createBoard.click();
	}
		
	public void inputBoardTitle(String title)
	{
		boardTitle.sendKeys(title);
	}
}
