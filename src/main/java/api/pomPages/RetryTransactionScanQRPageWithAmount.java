package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetryTransactionScanQRPageWithAmount {
	
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
		
		@FindBy(id="total-amount")
		private WebElement totalAmount;
		
		@FindBy(xpath="//p[@class='tip-txt']")
		private WebElement includesTipText;
		
		@FindBy(xpath="//canvas[@class='qr-code']")
		private WebElement qrCode;
		
		@FindBy(xpath="(//img[@class='logo'])[2]")
		private WebElement atoaLogoInQr;
		
		@FindBy(xpath="//button[@class='btn continue-btn']")
		private WebElement continueOnThisDeviceButton;
		
		@FindBy(xpath="//div[@class='title']/descendant::p")
		private WebElement howToPayWithAtoaButton;
		
		@FindBy(xpath="//img[@class='how_it_works']")
		private WebElement howItWorksImage;
		
		@FindBy(xpath="(//p[@class='terms-text terms']/descendant::a)[1]")
		private WebElement terms;
		
		@FindBy(xpath="(//p[@class='terms-text terms']/descendant::a)[2]")
		private WebElement privacyPolicy;

		@FindBy(xpath="(//p[@class='terms-text terms']/descendant::a)[3]")
		private WebElement help;
		
		@FindBy(xpath="//p[@class='poweredby-info']")
		private WebElement poweredBy;

		@FindBy(id="amount-input-box-id")
		private WebElement amountTextBox;
		
		
	// Initialization
		
		public RetryTransactionScanQRPageWithAmount(WebDriver driver) 
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

		public WebElement getIncludesTipText() {
			return includesTipText;
		}

		public WebElement getQrCode() {
			return qrCode;
		}

		public WebElement getAtoaLogoInQr() {
			return atoaLogoInQr;
		}

		public WebElement getContinueOnThisDeviceButton() {
			return continueOnThisDeviceButton;
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

		public WebElement getAmountTextBox() {
			return amountTextBox;
		}
		

}
