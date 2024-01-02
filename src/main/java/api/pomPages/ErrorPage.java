package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {
	
	@FindBy (xpath="//h2[@class='title']")
	private WebElement errorTitle;
	
	@FindBy (xpath="//p[@class='message']")
	private WebElement errorDescription;
	
	public ErrorPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getErrorTitle() {
		return errorTitle;
	}

	public String getErrorTitleText() {
		return errorTitle.getText();
	}
	public WebElement getErrorDescription() {
		return errorDescription;
	}
	public String getErrorDescriptionText() {
		return errorDescription.getText();
	}
	
	

}
