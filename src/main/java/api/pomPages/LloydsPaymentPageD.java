package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LloydsPaymentPageD 
{
//	
	@FindBy (xpath="(//div[@class='account Aligner'])[5]")
	private WebElement lloydsSelectAcc;
	
	@FindBy (id="IDToken1")
	private WebElement lloydsUsn;
	
	@FindBy (id="mat-input-1")
	private WebElement lloydsPass;
	
	public WebElement getLloydsPass() {
		return lloydsPass;
	}

	public WebElement getLloydsNext() {
		return lloydsNext;
	}
	@FindBy (xpath="//span[text()=' NEXT ']")
	private WebElement lloydsNext;
	
	public WebElement getLloydsSelectAcc() {
		return lloydsSelectAcc;
	}

	public WebElement getLloydsProceed() {
		return lloydsProceed;
	}
	public WebElement getLloydsUsername() {
		return lloydsUsn;
	}
	//input[@placeholder='User Name']
	public WebElement getLloydsYes() {
		return lloydsYes;
	}
	@FindBy (xpath="//span[text()=' Proceed ']")
	private WebElement lloydsProceed;
	
	@FindBy (xpath="//span[text()=' Yes ']")
	private WebElement lloydsYes;
	
	@FindBy (id="api-type")
	private WebElement apiDD;
	
	@FindBy (xpath="//option[text()='Payments']")
	private WebElement paymentOption;
	
	@FindBy (id="business-unit")
	private WebElement businessUnitDD;
	
	@FindBy (xpath="//option[text()='Barclays Business Banking']")
	private WebElement businessUnitOption;
	
	@FindBy (id="test-case")
	private WebElement testCaseDD;
	
	@FindBy (xpath="//option[text()='Success - Current account']")
	private WebElement testCaseOption;
	
	@FindBy (id="submit")
	private WebElement submitBtn;

//
	public LloydsPaymentPageD(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//
	public void clickApiDD() 
	{
		apiDD.click();
	}
	public void clickApiOption() 
	{
		paymentOption.click();
	}
	public void clickBusinessUnitDD() 
	{
		businessUnitDD.click();
	}
	public void clickBusinessUnitOption() 
	{
		businessUnitOption.click();
	}
	public void clickTestCaseDD() 
	{
		testCaseDD.click();
	}
	public void clickTestCaseOption() 
	{
		testCaseOption.click();
	}
	public void submitButton()
	{
		submitBtn.click();
	}
	
	
	
	
	
}
