package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SplitEquallyPage {

	@FindBy(xpath="//span[@class='appbar-title-text']")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='child']/descendant::p[@class='split-amount-text']")
	private WebElement toShareAmount;
	
	@FindBy(xpath="(//button[@class='btn count-btn'])[1]")
	private WebElement negativePayForButton;
	
	@FindBy(xpath="(//button[@class='btn count-btn'])[2]")
	private WebElement positivePayForButton;
	
	@FindBy(xpath="(//button[@class='btn count-btn'])[3]")
	private WebElement negativeOutOfButton;
	
	@FindBy(xpath="(//button[@class='btn count-btn'])[4]")
	private WebElement positiveOutOfButton;
	
	@FindBy(xpath="(//p[@class='count'])[1]")
	private WebElement payForCount;
	
	@FindBy(xpath="(//p[@class='count'])[2]")
	private WebElement outOfCount;
	
	@FindBy(xpath="//button[@class='btn loading']")
	private WebElement proceedButton;
	
	@FindBy(xpath="//button[@class='btn btn-secondary center center']")
	private WebElement splitDifferentlyButton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[1]")
	private WebElement splitEquallyButton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[2]")
	private WebElement enterCustomAmountButton;
	
	public SplitEquallyPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getToShareAmount() {
		return toShareAmount;
	}

	public WebElement getNegativePayForButton() {
		return negativePayForButton;
	}

	public WebElement getPositivePayForButton() {
		return positivePayForButton;
	}

	public WebElement getNegativeOutOfButton() {
		return negativeOutOfButton;
	}

	public WebElement getPositiveOutOfButton() {
		return positiveOutOfButton;
	}

	public WebElement getPayForCount() {
		return payForCount;
	}

	public WebElement getOutOfCount() {
		return outOfCount;
	}

	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getSplitDifferentlyButton() {
		return splitDifferentlyButton;
	}

	public WebElement getSplitEquallyButton() {
		return splitEquallyButton;
	}

	public WebElement getEnterCustomAmountButton() {
		return enterCustomAmountButton;
	}
	
	
}
