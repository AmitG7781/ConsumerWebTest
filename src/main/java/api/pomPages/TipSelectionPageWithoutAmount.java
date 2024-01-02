package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TipSelectionPageWithoutAmount {

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
	
	@FindBy(xpath="(//span[@class='input-prefix'])[1]")
	private WebElement amountPrefixSymbol;
	
	@FindBy(id="amount-input-box-id")
	private WebElement amountTextBox;
	
	@FindBy(id="payment-edit-amount-btn")
	private WebElement amountEditButton;
	
	@FindBy(xpath="//div[@class='tip-input-wrapper']/descendant::span[@class='title']")
	private WebElement tipBoxTitle;
	
	@FindBy(xpath="(//span[@class='input-prefix'])[2]")
	private WebElement tipPrefixSymbol;
	
	@FindBy(id="tip_input_amount")
	private WebElement tipTextBox;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[1]")
	private WebElement tipSuggestion1;
	@FindBy(xpath="(//div[@class='tip-option-content']/descendant::p[@class='option-label'])[1]")
	private WebElement tipSuggestion11;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[2]")
	private WebElement tipSuggestion2;
	@FindBy(xpath="(//div[@class='tip-option-content']/descendant::p[@class='option-label'])[2]")
	private WebElement tipSuggestion22;
	
	@FindBy(xpath="//div[@class='tip-option-chip selected']")
	private WebElement tipSuggestionSelected;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[3]")
	private WebElement tipSuggestion3;
	@FindBy(xpath="(//div[@class='tip-option-content']/descendant::p[@class='option-label'])[3]")
	private WebElement tipSuggestion33;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[4]")
	private WebElement tipSuggestion4;
	
	@FindBy(xpath="//img[@class='close-icon']")
	private WebElement tipCloseButton;
	
	@FindBy(id="select-bank-cta")
	private WebElement proceedButton;
	
	@FindBy(xpath="//div[@class='header-options']/descendant::span[text()='Select your Bank']")
	private WebElement selectBankText;
	
	@FindBy(xpath="//div[@class='toast-txt']")
	private WebElement toastText;
	
	@FindBy(xpath="//div[@class='bank-icon-name']")
	private WebElement bankName;
	
	@FindBy(id="change-bank-link")
	private WebElement changeBankLink;
	
	@FindBy(xpath="//input[@class='search-input']")
	private WebElement banksSearchBox;
	
	@FindBy (id="bank-list-item-mock-sandbox-v1")
	private WebElement mock1;
	
	@FindBy(xpath="//div[@class='b-input']")
	private WebElement termsCheckbox;
// Initialization
	
	public TipSelectionPageWithoutAmount(WebDriver driver) 
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

	public WebElement getAmountPrefixSymbol() {
		return amountPrefixSymbol;
	}

	public WebElement getAmountTextBox() {
		return amountTextBox;
	}

	public WebElement getAmountEditButton() {
		return amountEditButton;
	}

	public WebElement getTipBoxTitle() {
		return tipBoxTitle;
	}

	public WebElement getTipPrefixSymbol() {
		return tipPrefixSymbol;
	}

	public WebElement getTipTextBox() {
		return tipTextBox;
	}

	public WebElement getTipSuggestion1() {
		return tipSuggestion1;
	}

	public WebElement getTipSuggestion2() {
		return tipSuggestion2;
	}

	public WebElement getTipSuggestion3() {
		return tipSuggestion3;
	}
	
	public WebElement getTipSuggestion11() {
		return tipSuggestion11;
	}


	public WebElement getTipSuggestion22() {
		return tipSuggestion22;
	}


	public WebElement getTipSuggestion33() {
		return tipSuggestion33;
	}


	public WebElement getTipSuggestion4() {
		return tipSuggestion4;
	}

	
	public WebElement getTipCloseButton() {
		return tipCloseButton;
	}
	
	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getSelectBankText() {
		return selectBankText;
	}

	public WebElement getToastText() {
		return toastText;
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

	public WebElement getMock1() {
		return mock1;
	}


	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}


	public WebElement getTipSuggestionSelected() {
		return tipSuggestionSelected;
	}
	
	
}
