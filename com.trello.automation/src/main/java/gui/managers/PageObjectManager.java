package gui.managers;

import org.openqa.selenium.WebDriver;

import gui.pageObjects.BoardPage;
import gui.pageObjects.BoardsPage;
import gui.pageObjects.HomePage;
import gui.pageObjects.LogInToTrelloPage;
import gui.pageObjects.modals.NewBoardModal;

public class PageObjectManager
{
    private WebDriver driver;
    
    // Pages
    private BoardPage boardPage;
    private BoardsPage boardsPage;
    private HomePage homePage;
    private LogInToTrelloPage logInToTrelloPage;
    
    // Sections
    private NewBoardModal newBoardModal;
    
    public PageObjectManager(WebDriver driver)
    {
         this.driver = driver;
    }

    public BoardPage getBoardPage()
    {
    	return (boardPage == null) ? boardPage = new BoardPage(driver) : boardPage;
    }
    
    public BoardsPage getBoardsPage()
    {
    	return (boardsPage == null) ? boardsPage = new BoardsPage(driver) : boardsPage;
    }
    
    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    
    public LogInToTrelloPage getLogInToTrelloPage()
    {
    	return (logInToTrelloPage == null) ? logInToTrelloPage = new LogInToTrelloPage(driver) : logInToTrelloPage;
    }
    
    public NewBoardModal getNewBoardModal()
    {
    	return (newBoardModal == null) ? newBoardModal = new NewBoardModal(driver) : newBoardModal;
    }
}