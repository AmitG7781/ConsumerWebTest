package web.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterAmountPage {
	
	@FindBy(xpath="//img[@alt='full_logo']")
	private WebElement headerLogo;
	
	@FindBy(xpath="//img[@class='store-img']")
	private WebElement storeImage;
	
	@FindBy(xpath="(//div[@class='pay_to_name']/descendant::p)[1]")
	private WebElement payingTitle;
	
	@FindBy(xpath="//p[@class='business-name']")
	private WebElement businessName;
	
	@FindBy(xpath="//div[@class='location-name']")
	private WebElement storeName;
	
	@FindBy(xpath="//p[@class='amount-field-label']")
	private WebElement amountFieldTitle;
	
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
	
	@FindBy(xpath="//p[@class='input-info']")
	private WebElement inputInfoMessage;
	
	@FindBy(xpath="//div[@class='bank-icon-name']")
	private WebElement bankName;
	
	@FindBy(id="change-bank-link")
	private WebElement changeBankLink;
	
	
	public EnterAmountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getHeaderLogo() {
		return headerLogo;
	}


	public WebElement getStoreImage() {
		return storeImage;
	}


	public WebElement getPayingTitle() {
		return payingTitle;
	}
	
	
	public String getPayingTitleText() {
		return payingTitle.getText();
	}


	public WebElement getBusinessName() {
		return businessName;
	}

	
	public String getBusinessNameText() {
		return businessName.getText();
	}
	

	public WebElement getStoreName() {
		return storeName;
	}


	public String getStoreNameText() {
		return storeName.getText();
	}
	
	
	public WebElement getAmountFieldTitle() {
		return amountFieldTitle;
	}


	public WebElement getAmountTextBox() {
		return amountTextBox;
	}
	
	
	public void enterAmount(String key) {
		 amountTextBox.sendKeys(key);
	}

	
	public String getAmountTextBoxValue(String key) {
		return amountTextBox.getAttribute(key);
	}
	

	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	
	
	public void clickTermsCheckbox() {
		termsCheckbox.click();
	}


	public WebElement getAmountPrefixSymbol() {
		return amountPrefixSymbol;
	}
	
	
	public String getAmountPrefixSymbolText() {
		return amountPrefixSymbol.getText();
	}


	public WebElement getProceedButton() {
		return proceedButton;
	}

	
	public void clickProceedButton() {
		proceedButton.click();
	}


	public WebElement getInputErrorMessage() {
		return inputErrorMessage;
	}
	
	
	public String getInputErrorMessageText() {
		return inputErrorMessage.getText();
	}


	public WebElement getInputInfoMessage() {
		return inputInfoMessage;
	}

	
	public String getInputInfoMessageText() {
		return inputInfoMessage.getText();
	}

	
	public WebElement getBankName() {
		return bankName;
	}

	
	public String getBankNameText() {
		return bankName.getText();
	}
	

	public WebElement getChangeBankLink() {
		return changeBankLink;
	}

	
	public void clickChangeBankLink() {
		 changeBankLink.click();
	}
	

}
