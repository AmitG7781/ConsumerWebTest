package web.pomPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

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
}
