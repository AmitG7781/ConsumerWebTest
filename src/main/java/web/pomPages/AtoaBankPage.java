package web.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtoaBankPage {
	
	@FindBy(id="paymentIdempotencyId")
	private WebElement idempodencyId;
	
	@FindBy(id="status")
	private WebElement statusDropdown;
	
	@FindBy(id="isocode")
	private WebElement isoCodeDropdown;
	
	@FindBy(id="//button[@type='submit']")
	private WebElement submitButton;
	
	
	public AtoaBankPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getIdempodencyId() {
		return idempodencyId;
	}
	
	public void enterIdempodencyId(String key) {
		idempodencyId.sendKeys(key);;
	}


	public WebElement getStatusDropdown() {
		return statusDropdown;
	}


	public WebElement getIsoCodeDropdown() {
		return isoCodeDropdown;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	
}
