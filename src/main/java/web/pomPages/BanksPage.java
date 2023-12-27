package web.pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BanksPage {

	
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
	
	@FindBy(id="total-amount")
	private WebElement totalAmount;
	
	@FindBy(id="selectbank-edit-amount-btn")
	private WebElement amountEditButton;
	
	@FindBy(xpath="//p[@class='tip-txt']")
	private WebElement includesTipText;
	
	@FindBy(xpath="//div[@class='header-options']/descendant::span[text()='Select your Bank']")
	private WebElement selectBankText;
	
	@FindBy(xpath="//div[@class='header-options']/descendant::a[text()='View all']")
	private WebElement viewAllBanksButton;
	
	@FindBys({@FindBy(how=How.XPATH, using="//div[@class='banklist-container']/descendant::label")})
	private List<WebElement> bankTabsContainer;
	
	@FindBy(xpath="//div[@class='title']/descendant::p")
	private WebElement howToPayWithAtoaButton;
	
	@FindBy(xpath="//img[@class='how_it_works']")
	private WebElement howItWorksImage;
	
	@FindBy(xpath="//div[@class='b-input']")
	private WebElement termsCheckbox;
	
	@FindBy(xpath="(//p[@class='terms-text']/descendant::a)[1]")
	private WebElement termsLink;
	
	@FindBy(xpath="(//p[@class='terms-text']/descendant::a)[2]")
	private WebElement privacyPolicyLink;

	@FindBy(xpath="(//p[@class='terms-text']/descendant::a)[3]")
	private WebElement helpLink;
	
	@FindBy(xpath="//p[@class='poweredby-info']")
	private WebElement poweredBy;
	
	@FindBy(id="select-bank-cta")
	private WebElement proceedButton;
	
	@FindBy(xpath="//div[@class='toast-txt']")
	private WebElement toastText;
	
	@FindBy(xpath="//button[@class='close-btn']")
	private WebElement toastClose;
	
	@FindBy(xpath="//span[@class='appbar-title-text']")
	private WebElement allBanksPageHeader;

	@FindBy(xpath="//input[@class='search-input']")
	private WebElement banksSearchBox;
	
	@FindBys({@FindBy(how=How.XPATH, using="//div[@class='card']/descendant::ul[@class='all-bank-list']/descendant::li")})
	public List<WebElement> allBankList;
	
	@FindBy(xpath="//p[@class='no-result']")
	private WebElement noBanksMessage;
	
	@FindBy (id="bank-list-item-lloyds-sandbox")
	private WebElement lloyds;
	
	@FindBy (id="bank-list-item-modelo-sandbox")
	private WebElement modelo;
	
	@FindBy (id="bank-list-item-rbs-sandbox")
	private WebElement rbs;
	
	public BanksPage(WebDriver driver) 
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

	public WebElement getTotalAmount() {
		return totalAmount;
	}
	
	public String getTotalAmountText() {
		return totalAmount.getText();
	}

	public WebElement getAmountEditButton() {
		return amountEditButton;
	}

	public void clickAmountEditButton() {
		 amountEditButton.click();
	}
	
	public WebElement getIncludesTip() {
		return includesTipText;
	}
	
	public String getIncludesTipText() {
		return includesTipText.getText();
	}

	public WebElement getSelectBank() {
		return selectBankText;
	}
	
	public String getSelectBankText() {
		return selectBankText.getText();
	}

	public WebElement getViewAllBanksButton() {
		return viewAllBanksButton;
	}
	
	public void clickViewAllBanksButton() {
		 viewAllBanksButton.click();
	}

	public List<WebElement> getBankTabsContainer() {
		return bankTabsContainer;
	}

	public WebElement getHowToPayWithAtoaButton() {
		return howToPayWithAtoaButton;
	}
	
	public void clickHowToPayWithAtoaButton() {
		 howToPayWithAtoaButton.click();
	}

	public WebElement getHowItWorksImage() {
		return howItWorksImage;
	}

	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	
	public void clickTermsCheckbox() {
		 termsCheckbox.click();
	}

	public WebElement getTermsLink() {
		return termsLink;
	}
	
	public void clickTermsLink() {
		 termsLink.click();
	}

	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}
	
	public void clickPrivacyPolicyLink() {
		 privacyPolicyLink.click();
	}

	public WebElement getHelpLink() {
		return helpLink;
	}
	
	public void clickHelpLink() {
		 helpLink.click();
	}

	public WebElement getPoweredBy() {
		return poweredBy;
	}
	
	public String getPoweredByText() {
		return poweredBy.getText();
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

	public WebElement getToastClose() {
		return toastClose;
	}

	public void clickToastClose() {
		 toastClose.click();
	}
	
	public WebElement getAllBanksPageHeader() {
		return allBanksPageHeader;
	}
	
	public String getAllBanksPageHeaderText() {
		return allBanksPageHeader.getText();
	}

	public WebElement getBanksSearchBox() {
		return banksSearchBox;
	}
	
	public void searchBank(String key) {
		 banksSearchBox.sendKeys(key);
	}

	public List<WebElement> getAllBankList() {
		return allBankList;
	}

	public WebElement getNoBanksMessage() {
		return noBanksMessage;
	}
	
	public String getNoBanksMessageText() {
		return noBanksMessage.getText();
	}

	public WebElement getLloyds() {
		return lloyds;
	}
	
	public void clickLloyds() {
		 lloyds.click();;
	}

	public WebElement getModelo() {
		return modelo;
	}
	
	public void clickModelo() {
		 modelo.click();
	}

	public WebElement getRbs() {
		return rbs;
	}
	
	public void clickRbs() {
		 rbs.click();
	}
	
	
}
