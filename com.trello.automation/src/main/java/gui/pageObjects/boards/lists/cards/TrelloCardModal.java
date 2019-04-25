package gui.pageObjects.boards.lists.cards;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.common.PageObject;

public class TrelloCardModal extends PageObject
{
	private MoveCardModal moveCardModal;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@class, 'js-close-window')]")
    private WebElement close;

	@FindBy(how = How.XPATH, using = "//a[@title='Move']")
    private WebElement move;
	
	public TrelloCardModal(WebDriver driver)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);
        
        moveCardModal = new MoveCardModal(driver);
    }
	
	public void clickClose()
	{
		close.click();
	}
		
	public void moveCard(String listName)
	{
		clickMove();
		moveCardModal.moveCard(listName);
		clickClose();
	}
	
	private void clickMove()
	{
		move.click();
	}
}