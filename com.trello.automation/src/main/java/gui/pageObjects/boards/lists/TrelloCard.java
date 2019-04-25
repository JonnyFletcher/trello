package gui.pageObjects.boards.lists;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.boards.lists.cards.TrelloCardModal;
import gui.pageObjects.common.PageObject;

public class TrelloCard extends PageObject
{	
	private String cardTitle;
	private String listTitle;
	
	private By cardTitleLocator;
	private TrelloCardModal cardModal;
	
	public TrelloCard(WebDriver driver, String listTitle, String cardTitle)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);

        this.cardTitle = cardTitle;
        this.listTitle = listTitle;
        
        initialiseCard();
	}

	public void assertCardIsDisplayed()
	{
		WebElement card = findElement(cardTitleLocator);
		assertThat(card.isDisplayed(), is(true));
	}
	
	public String getCardTitle()
	{
		return cardTitle;
	}
	
	public String getListTitle()
	{
		return listTitle;
	}
	
	public void moveCard(String listTitle)
	{
		open();
		cardModal.moveCard(listTitle);
		
		this.listTitle = listTitle;
	}
	
	public void open()
	{
		WebElement element = findElement(cardTitleLocator);
		element.click();
	}
	
	private void initialiseCard()
	{
		String cardTitleXpath = "//div/h2[.='%1s']/../..//span[contains(., '%2s')]";	
        cardTitleXpath = String.format(cardTitleXpath, listTitle, cardTitle);
        
        cardTitleLocator = By.xpath(cardTitleXpath);
        
        cardModal = new TrelloCardModal(driver);
	}
}