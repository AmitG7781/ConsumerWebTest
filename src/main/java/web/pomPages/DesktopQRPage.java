package web.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopQRPage {
	
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
	
	@FindBy(xpath="//canvas[@class='qr-code']")
	private WebElement qrCode;
	
	@FindBy(xpath="//img[@class='logo']")
	private WebElement atoaLogoInQr;
	
	@FindBy(xpath="//button[@class='btn continue-btn']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='title dark']")
	private WebElement howToPayWithAtoaButton;
	
	@FindBy(xpath="//img[@class='how_it_works']")
	private WebElement howItWorksImage;
	
	@FindBy(xpath="(//p[@class='terms-text dark terms']/descendant::a)[1]")
	private WebElement termsLink;
	
	@FindBy(xpath="(//p[@class='terms-text dark terms']/descendant::a)[2]")
	private WebElement privacyPolicyLink;

	@FindBy(xpath="(//p[@class='terms-text dark terms']/descendant::a)[3]")
	private WebElement helpLink;
	
	@FindBy(xpath="//p[@class='poweredby-info']")
	private WebElement poweredBy;

	
	public DesktopQRPage(WebDriver driver) 
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
	
	
	public WebElement getTotalAmountText() {
		return totalAmount;
	}


	public WebElement getQrCode() {
		return qrCode;
	}


	public WebElement getAtoaLogoInQr() {
		return atoaLogoInQr;
	}


	public WebElement getContinueButton() {
		return continueButton;
	}
	
	
	public void clickContinueButton() {
		 continueButton.click();
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

	
}
