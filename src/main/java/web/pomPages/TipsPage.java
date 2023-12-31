package web.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TipsPage {
	
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
	
	@FindBy(xpath="(//span[@class='input-prefix'])[1]")
	private WebElement amountPrefixSymbol;
	
	@FindBy(id="amount-input-box-id")
	private WebElement amountTextBox;
	
	@FindBy(xpath="//span[@class='form-input rq-form-element']")
	private WebElement amountText;
	
	@FindBy(id="payment-edit-amount-btn")
	private WebElement amountEditButton;
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement tipBoxTitle;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[1]")
	private WebElement tipOption1;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[2]")
	private WebElement tipOption2;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[3]")
	private WebElement tipOption3;
	
	@FindBy(xpath="(//div[@class='tip-option-content'])[4]")
	private WebElement customTipOption;
	
	@FindBy(xpath="//div[@class='tip-option-chip selected']")
	private WebElement tipOptionSelected;
	
	@FindBy(xpath="(//span[@class='input-prefix'])[2]")
	private WebElement tipPrefixSymbol;
	
	@FindBy(id="tip_input_amount")
	private WebElement tipTextBox;
	
	@FindBy(xpath="//img[@class='close-icon']")
	private WebElement tipCloseButton;
	
	@FindBy(id="select-bank-cta")
	private WebElement proceedButton;
	
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
	
	
	public TipsPage(WebDriver driver) 
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
	
	
	public WebElement getAmountPrefixSymbol() {
		return amountPrefixSymbol;
	}


	public String getAmountPrefixSymbolText() {
		return amountPrefixSymbol.getText();
	}
	
	
	public WebElement getAmountTextBox() {
		return amountTextBox;
	}

	
	public String getAmountTextBoxText() {
		return amountTextBox.getText();
	}
	

	public WebElement getAmount() {
		return amountText;
	}

	
	public String getAmountText() {
		return amountText.getText();
	}
	

	public WebElement getAmountEditButton() {
		return amountEditButton;
	}
	
	
	public void clickAmountEditButton() {
		 amountEditButton.click();
	}


	public WebElement getTipBoxTitle() {
		return tipBoxTitle;
	}
	
	
	public String getTipBoxTitleText() {
		return tipBoxTitle.getText();
	}


	public WebElement getTipOption1() {
		return tipOption1;
	}

	
	public String getTipOption1Text() {
		return tipOption1.getText();
	}
	

	public void clickTipOption1() {
		 tipOption1.click();
	}
	
	
	public WebElement getTipOption2() {
		return tipOption2;
	}
	
	
	public String getTipOption2Text() {
		return tipOption2.getText();
	}
	
	
	public void clickTipOption2() {
		 tipOption2.click();
	}

	
	public WebElement getTipOption3() {
		return tipOption3;
	}

	
	public String getTipOption3Text() {
		return tipOption3.getText();
	}
	
	
	public void clickTipOption3() {
		 tipOption3.click();
	}
	

	public WebElement getCustomTipOption() {
		return customTipOption;
	}
	
	
	public void clickCustomTipOption() {
		customTipOption.click();
	}


	public WebElement getTipOptionSelected() {
		return tipOptionSelected;
	}

	
	public String getTipOptionSelectedText() {
		return tipOptionSelected.getText();
	}
	

	public WebElement getTipPrefixSymbol() {
		return tipPrefixSymbol;
	}
	
	
	public String getTipPrefixSymbolText() {
		return tipPrefixSymbol.getText();
	}


	public WebElement getTipTextBox() {
		return tipTextBox;
	}
	
	
	public void enterTip(String key) {
		tipTextBox.sendKeys(key);;
	}


	public WebElement getTipCloseButton() {
		return tipCloseButton;
	}
	
	
	public void clickTipCloseButton() {
		 tipCloseButton.click();
	}


	public WebElement getProceedButton() {
		return proceedButton;
	}
	
	
	public void clickProceedButton() {
		 proceedButton.click();
	}


	public WebElement getToast() {
		return toastText;
	}
	
	
	public String getToastText() {
		return toastText.getText();
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

	
	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	
	
	public void clickTermsCheckbox() {
		 termsCheckbox.click();
	}
	
	
	
	

}
