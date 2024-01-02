package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterAmountPageWithoutAmount {

// Declaration
	
	@FindBy(xpath="//img[@alt='full_logo']")
	private WebElement atoaLogoHeader;
	
	@FindBy(xpath="//img[@alt='merchant_icon']")
	private WebElement merchantIcon;
	
	@FindBy(xpath="(//div[@class='pay_to_name']/descendant::p)[1]")
	private WebElement payingText;
	
	@FindBy(xpath="(//div[@class='pay_to_name']/descendant::p)[2]")
	private WebElement businessName;
	
	@FindBy(xpath="//div[@class='location-name']")
	private WebElement storeLocation;
	
	@FindBy(id="amount-input-box-id")
	private WebElement amountTextBox;
	
	@FindBy(xpath="//div[@class='b-input']")
	private WebElement termsCheckbox;
	
	@FindBy(xpath="//span[@class='input-prefix']")
	private WebElement amountPrefixSymbol;
	
	@FindBy(id="select-bank-cta")
	private WebElement proceedButton;
	
	@FindBy(xpath="//button[@class='btn loading']")
	private WebElement proceedToPayCustomAmountButton;
	
	@FindBy(xpath="//p[@class='input-error']")
	private WebElement inputErrorMessage;
	
	@FindBy(id="tip_input_amount")
	private WebElement tipTextBox;
	
	@FindBy(xpath="//div[@class='bank-icon-name']")
	private WebElement bankName;
	
	@FindBy(id="change-bank-link")
	private WebElement changeBankLink;
	
	@FindBy(xpath="//input[@class='search-input']")
	private WebElement banksSearchBox;
	
	@FindBy (id="bank-list-item-modelo-sandbox")
	private WebElement modelo;
	
	@FindBy (id="bank-list-item-mock-sandbox-v1")
	private WebElement mock1;
	
	@FindBy (id="bank-list-item-rbs-sandbox")
	private WebElement rbs;

// Initialization
	public EnterAmountPageWithoutAmount(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

// Utilization
	
	public WebElement getAtoaLogoHeader() {
		return atoaLogoHeader;
	}

	public WebElement getBusinessName() {
		return businessName;
	}
	
	public WebElement getMerchantIcon() {
		return merchantIcon;
	}

	public WebElement getPayingText() {
		return payingText;
	}

	public WebElement getStoreLocation() {
		return storeLocation;
	}

	public WebElement getAmountTextBox() {
		return amountTextBox;
	}

	public WebElement getAmountPrefixSymbol() {
		return amountPrefixSymbol;
	}

	public WebElement getProceedButton() {
		return proceedButton;
	}
	
	public WebElement getProceedToPayCustomAmountButton() {
		return proceedToPayCustomAmountButton;
	}

	public WebElement getInputErrorMessage() {
		return inputErrorMessage;
	}

	public WebElement getTipTextBox() {
		return tipTextBox;
	}

	public WebElement getBankName() {
		return bankName;
	}

	public WebElement getChangeBankLink() {
		return changeBankLink;
	}

	public WebElement getBanksSearchBox() {
		return banksSearchBox;
	}
	
	public WebElement getModelo() {
		return modelo;
	}

	public WebElement getMock1() {
		return mock1;
	}

	public WebElement getRbs() {
		return rbs;
	}

	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	
	
	
	
}
