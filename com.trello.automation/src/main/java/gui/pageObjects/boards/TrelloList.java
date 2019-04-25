package gui.pageObjects.boards;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import gui.pageObjects.boards.lists.TrelloCard;
import gui.pageObjects.common.PageObject;

public class TrelloList extends PageObject
{
	private String listTitle;
	private List<TrelloCard> cards;
	
	private By addACardLocator;
	private By addAnotherCardLocator;
	private By addCardLocator;
	private By enterCardTitleLocator;
	private By listLocator;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Add List']")
	private WebElement addList;
	
	@FindBy(how = How.XPATH, using = "//input[@class='list-name-input']")
	private WebElement enterListTitle;
	
	public TrelloList(WebDriver driver, String listTitle)
    {
        super(driver, "");
        PageFactory.initElements(driver, this);
       
        initialiseList(listTitle);
	}

	public void addAnotherCard(String cardTitle)
    {
    	clickAddACard();
    	enterCardTitle(cardTitle);
    	clickAddCard();
    	
    	cards.add(new TrelloCard(driver, listTitle, cardTitle));
    }

    public void addCard(String cardTitle)
    {
    	clickAddACard();
    	enterCardTitle(cardTitle);
    	clickAddCard();
    	
    	cards.add(new TrelloCard(driver, listTitle, cardTitle));
    }

    public void assertCardIsDisplayed(String cardTitle)
    {
    	getCard(cardTitle).assertCardIsDisplayed();    	
    }

	public void assertListIsDisplayed()
	{
		WebElement list = findElement(listLocator);
		assertThat(list.isDisplayed(), is(true));
	}
	
    public void enterListTitle()
    {
    	enterListTitle.sendKeys(listTitle);
    }

    public void clickAddList()
    {
    	addList.click();
    }
    
    public TrelloCard getCard(String cardTitle)
    {
    	TrelloCard _card = null;
    	
    	for (TrelloCard card : cards)
    	{
    		if (card.getCardTitle().equals(cardTitle))
    		{
    			_card = card;
    		}
    	}
    	
    	if (_card == null)
    	{
    		_card = new TrelloCard(driver, listTitle, cardTitle);
    		cards.add(_card);
    	}
    	
    	return _card;
    }

    public String getTitle()
    {
    	return listTitle;
    }

    public void openCard(String cardTitle)
    {
    	TrelloCard card = getCard(cardTitle);
    	card.open();
    }

	private void clickAddACard()
	{
    	WebElement addACard = getAddACardElement();
    	addACard.click();
	}

	private void clickAddCard()
	{
		WebElement addCard = getList().findElement(addCardLocator);
    	addCard.click();
	}

	private void enterCardTitle(String cardTitle)
	{
		WebElement enterCardTitle = getList().findElement(enterCardTitleLocator);
    	enterCardTitle.sendKeys(cardTitle);
	}

	private WebElement getAddACardElement()
	{
		By locator = null;
		
		if (cards.size() > 0)
    	{
			locator = addAnotherCardLocator;
    	}
    	else
    	{
			locator = addACardLocator;
    	}
		
		return getList().findElement(locator);
	}

	private WebElement getList()
	{
		WebElement list = driver.findElement(listLocator);
		return list;
	}

    private void initialiseList(String listTitle)
	{
		this.listTitle = listTitle;
        cards = new ArrayList<TrelloCard>();
        
        String addACardXpath = ".//span[.='Add a card']";
    	String addAnotherCardXpath = ".//span[.='Add another card']";
    	String addCardXpath = ".//input[@value='Add Card']";
    	String enterCardTitleXpath = ".//div[contains(@class, list-card-details)]/textarea[@placeholder='Enter a title for this card…']";
    	
    	String listXpath = "//div[contains(@class, 'list-wrapper') and .//h2[.='%s']]";
		listXpath = String.format(listXpath, listTitle);

		addACardLocator = By.xpath(addACardXpath);
		addAnotherCardLocator = By.xpath(addAnotherCardXpath);
        addCardLocator = By.xpath(addCardXpath);
        enterCardTitleLocator = By.xpath(enterCardTitleXpath);
        listLocator = By.xpath(listXpath);
	}
}