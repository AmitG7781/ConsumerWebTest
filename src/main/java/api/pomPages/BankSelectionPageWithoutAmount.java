package api.pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BankSelectionPageWithoutAmount {
	
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
	
	@FindBy(xpath="//label[@class='b-contain accept-terms']/descendant::a")
	private WebElement terms;
	
	@FindBy(xpath="//div[@class='b-input']")
	private WebElement termsCheckbox;
	
	@FindBy(xpath="(//p[@class='terms-text']/descendant::a)[2]")
	private WebElement privacyPolicy;

	@FindBy(xpath="(//p[@class='terms-text']/descendant::a)[3]")
	private WebElement help;
	
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
// Initialization
	public BankSelectionPageWithoutAmount(WebDriver driver) 
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

	public WebElement getTotalAmount() {
		return totalAmount;
	}

	public WebElement getAmountEditButton() {
		return amountEditButton;
	}

	public WebElement getIncludesTipText() {
		return includesTipText;
	}

	public WebElement getSelectBankText() {
		return selectBankText;
	}

	public WebElement getViewAllBanksButton() {
		return viewAllBanksButton;
	}

	public List<WebElement> getBankTabsContainer() {
		return bankTabsContainer;
	}

	public WebElement getHowToPayWithAtoaButton() {
		return howToPayWithAtoaButton;
	}

	public WebElement getHowItWorksImage() {
		return howItWorksImage;
	}

	public WebElement getTerms() {
		return terms;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getHelp() {
		return help;
	}

	public WebElement getPoweredBy() {
		return poweredBy;
	}

	public WebElement getToastText() {
		return toastText;
	}

	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getToastClose() {
		return toastClose;
	}

	public WebElement getAllBanksPageHeader() {
		return allBanksPageHeader;
	}

	public WebElement getBanksSearchBox() {
		return banksSearchBox;
	}

	public List<WebElement> getAllBankList() {
		return allBankList;
	}

	public WebElement getNoBanksMessage() {
		return noBanksMessage;
	}

	public WebElement getLloyds() {
		return lloyds;
	}

	public WebElement getModelo() {
		return modelo;
	}

	public WebElement getRbs() {
		return rbs;
	}

	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	
	
		
}
