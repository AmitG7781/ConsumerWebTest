package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TotalBillAmountPage {

	
	@FindBy(xpath="//p[@class='bill-txt']")
	private WebElement totalBillText;
	
	@FindBy(xpath="(//span[@class='tile-left']/following-sibling::span)[1]")
	private WebElement totalBillAmountTextSecondUser;
	
	@FindBy(xpath="(//span[@class='tile-left']/following-sibling::span)[2]")
	private WebElement amountLeftToPayForSecondUser;
	
	@FindBy(xpath="//span[@class='amount']")
	private WebElement amountPaid;
	
	@FindBy(xpath="//p[@class='bill-amt']")
	private WebElement totalBillAmount;
	
	@FindBy(xpath="//p[@class='name']")
	private WebElement businessName;
	
	@FindBy(xpath="//p[@class='location']/span")
	private WebElement businessLocation;
	
	@FindBy(xpath="//button[@class='btn loading']")
	private WebElement proceedButton;
	
	@FindBy(xpath="//button[@class='btn btn-secondary center center']")
	private WebElement splitBillButton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[1]")
	private WebElement splitEquallyButton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[2]")
	private WebElement enterCustomAmountButton;
	
	@FindBy(xpath="//p[@class='bill-paid-title']")
	private WebElement BillPaidChip;
	
	public TotalBillAmountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTotalBillText() {
		return totalBillText;
	}

	public WebElement getTotalBillAmount() {
		return totalBillAmount;
	}

	public WebElement getBusinessName() {
		return businessName;
	}

	public WebElement getBusinessLocation() {
		return businessLocation;
	}

	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getSplitBillButton() {
		return splitBillButton;
	}

	public WebElement getSplitEquallyButton() {
		return splitEquallyButton;
	}

	public WebElement getEnterCustomAmountButton() {
		return enterCustomAmountButton;
	}

	public WebElement getTotalBillAmountTextSecondUser() {
		return totalBillAmountTextSecondUser;
	}

	public WebElement getAmountLeftToPayForSecondUser() {
		return amountLeftToPayForSecondUser;
	}

	public WebElement getAmountPaid() {
		return amountPaid;
	}

	public WebElement getBillPaidChip() {
		return BillPaidChip;
	}
	
	
}
