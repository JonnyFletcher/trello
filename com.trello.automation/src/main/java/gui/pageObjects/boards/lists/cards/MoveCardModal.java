package gui.pageObjects.boards.lists.cards;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import gui.pageObjects.common.PageObject;

public class MoveCardModal extends PageObject
{
	@FindBy(how = How.XPATH, using = "//select[@class='js-select-list']")
    private WebElement listSelector;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Move']")
    private WebElement move;
	
	public MoveCardModal(WebDriver driver)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);
    }

	public void moveCard(String listName)
	{
//		listSelector.selectByValue(listName);
		Select _listSelector = new Select(listSelector);
		_listSelector.selectByVisibleText(listName);
		
		move.click();
	}
}