package gui.pageObjects.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject
{
	protected WebDriver driver;
	protected String expectedPageTitle;
    
    public PageObject(WebDriver driver, String pageTitle)
    {
        this.driver = driver;
        this.expectedPageTitle = pageTitle;
    }

    public void assertElementIsDisplayed(WebElement element)
    {
        assertThat(element.isDisplayed(), is(equalTo(true)));
    }

    public void assertPageTitleIsCorrect()
    {
    	waitForPageToLoad();
    	
    	String actualPageTitle = driver.getTitle();
    	assertThat(actualPageTitle, is(equalTo(expectedPageTitle)));
    }
    
    public String getElementAttribute(WebElement element, String attribute)
    {
        return element.getAttribute(attribute); 
    }

    protected WebElement findElement(By locator)
    {
        return driver.findElement(locator);
    }
    
    protected List<WebElement> findElements(By locator)
    {
        return driver.findElements(locator);
    }
    
    protected void throwUnknownElementException(String elementName)
    {
        String errorMessage = "Element with name '%s' does not exist";
        errorMessage = String.format(errorMessage, elementName);
        
        throw new RuntimeException(errorMessage);
    }

    protected void waitForElement(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void waitForElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    protected void waitForPageToLoad()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10); 
    	JavascriptExecutor jsExec = (JavascriptExecutor) driver;
    	
    	ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
 
    	boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
	    
    	if (!jsReady)
	    {
	    	wait.until(jsLoad);
	    }
    }
    
    protected void waitSeconds(int seconds)
    {
        try
        {
            int milliseconds = seconds * 1000;
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            // Do nothing
        }
    }
}