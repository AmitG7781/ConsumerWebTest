package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionDetailsPage {

// Declaration	
	@FindBy(xpath="//img[@alt='full_logo']")
	private WebElement atoaLogoHeader;
	
	@FindBy (xpath="(//div[@class='payment_status_wrapper']/descendant::p)[1]")
	private WebElement paymentSuccessStatus;
	
	@FindBy (xpath="(//div[@class='payment_status_wrapper']/descendant::p)[1]")
	private WebElement paymentCancelledStatus;
	
	@FindBy (id="open-help-widget-action")
	private WebElement getHelp;
	
	@FindBy (id="download-receipt-action")
	private WebElement downloadReciept;
	
	@FindBy (xpath="(//div[@class='action_img_box'])[1]")
	private WebElement reportMerchant;
	
	@FindBy (xpath="//span[@class='merchant_name']/descendant::p")
	private WebElement businessHeader;
	
	@FindBy (xpath="//img[@class='show']")
	private WebElement storeIcon ;
	
	@FindBy (xpath="//div[@class='payment_info']/descendant::td[2]")
	private WebElement businessName;
	
	@FindBy(xpath="//span[@class='store_location']")
	private WebElement storeLocation;
	
	@FindBy(xpath="//span[@class='store_address']")
	private WebElement storeAddress;
	
	@FindBy (xpath="(//div[@class='payment_status_wrapper']/descendant::p)[1]")
	private WebElement paymentPendingStatus;
	
	@FindBy (xpath="(//div[@class='payment_status_wrapper']/descendant::p)[1]")
	private WebElement paymentFailedStatus;
	
	@FindBy (xpath="//div[@class='elements__SearchHeader-sc-8yny41-2 lbKAai']/descendant::h5[@class='elements__SearchTitle-sc-8yny41-3 eOgqou']")
	private WebElement gotQuest;
	
	@FindBy (xpath="(//a[@class='article-link elements__ArticleLink-sc-1lq865d-3 dOUSgU'])[1]")
	private WebElement gotQuest1;
	
	@FindBy (xpath="//div[@class='WidgetHeader__CloseWrapper-e8xmgj-3 jgmQql']")
	private WebElement closeHelpFrameBtn;
	
	@FindBy (id="payment-retry")
	private WebElement retryBtn;
	
	@FindBy (xpath="//div[@class='payment_status_content']/descendant::p")
	private WebElement failedMsg1;
	
	@FindBy (xpath="//div[@class='payment_status_content']/descendant::p")
	private WebElement pendingMsg;
	
	@FindBy (xpath="//p[@class='tip-txt']")
	private WebElement tipText;
	
	@FindBy(xpath="//div[@class='amount-text']")
	private WebElement amountText;

	@FindBy(xpath="//p[@class='payment_datetime']")
	private WebElement paymentDateAndTime;
	
	@FindBy(xpath="//div[@class='cashback-banner']")
	private WebElement cashbackBanner;
	
	@FindBy(xpath="//div[@class='cashback-banner-text-container']/descendant::p[@class='title']")
	private WebElement cashbackBannerTitle;
	
	@FindBy(xpath="//div[@class='cashback-banner-text-container']/descendant::p[@class='subtitle']")
	private WebElement cashbackBannerSubitle;
	
	@FindBy(xpath="//p[@class='cashback-terms']")
	private WebElement cashbackTermsText;
	
	@FindBy(xpath="//div[@class='banner-wrapper']/descendant::div[@class='banner-text-box']/descendant::canvas[@class='qr-code']")
	private WebElement qr;

	@FindBy(xpath="//section[@class='carousel']")
	private WebElement carousel;
	
	@FindBy(xpath="//div[@class='label']")
	private WebElement mobileNumberText;
	
	@FindBy(xpath="//input[@type='number']")
	private WebElement mobileNumberTextField;
	
	@FindBy(xpath="//p[@class='spam-alert']")
	private WebElement spamAlert;
	
	@FindBy(xpath="//div[@class='b-input']")
	private WebElement atoaTermsCheckbox;
	
	@FindBy(xpath="//label[@class='b-contain accept-terms']")
	private WebElement atoaTermsText;
	
	@FindBy(xpath="//button[contains(@class,'verify-number-btn')]")
	private WebElement verifyBtn;

	@FindBy(xpath="//div[@style='display: flex;']")
	private WebElement otpField;
	
	@FindBy(xpath="(//input[@type='tel'])[1]")
	private WebElement otp1;
	
	@FindBy(xpath="(//input[@type='tel'])[2]")
	private WebElement otp2;
	
	@FindBy(xpath="(//input[@type='tel'])[3]")
	private WebElement otp3;
	
	@FindBy(xpath="(//input[@type='tel'])[4]")
	private WebElement otp4;
	
	@FindBy(xpath="//button[@class='btn-small resend-btn']")
	private WebElement resendBtn;
	
	@FindBy(xpath="//button[@class='btn-small']")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//p[@class='change-number']")
	private WebElement changeNumberBtn;
	
	@FindBy(xpath="//div[@class='toast-txt']")
	private WebElement toastText;
	
	@FindBy(xpath="//button[@class='close-btn']")
	private WebElement toastCloseBtn;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[1]")
	private WebElement merchantText;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[2]")
	private WebElement merchantName;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[3]")
	private WebElement referenceText;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[4]")
	private WebElement referenceNumber;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[5]")
	private WebElement noteText;
	
	@FindBy(xpath="(//div[@class='payment_info']/descendant::tr/descendant::td)[6]")
	private WebElement note;
	
	@FindBy(xpath="//button[@class='btn btn-secondary center']")
	private WebElement goBackToBillButton;
	
	
	
// Initialization

	public TransactionDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	
// Utilization
	public WebElement getAtoaLogoHeader() {
		return atoaLogoHeader;
	}
	
	public WebElement getBusinessHeader() {
		return businessHeader;
	}

	
	
	public WebElement getStoreIcon() {
		return storeIcon;
	}


	public WebElement getStoreLocation() {
		return storeLocation;
	}


	public WebElement getStoreAddress() {
		return storeAddress;
	}


	public WebElement getPaymentSuccessStatus() {
		return paymentSuccessStatus;
	}

	public WebElement getPaymentCancelledStatus() {
		return paymentCancelledStatus;
	}
	
	public WebElement getPaymentPendingStatus() {
		return paymentPendingStatus;
	}

	public WebElement getPaymentFailedStatus() {
		return paymentFailedStatus;
	}

	public WebElement getGetHelp() {
		return getHelp;
	}

	public WebElement getDownloadReciept() {
		return downloadReciept;
	}

	public WebElement getReportMerchant() {
		return reportMerchant;
	}

	public WebElement getBusinessName() {
		return businessName;
	}


	public WebElement getGotQuest() {
		return gotQuest;
	}

	public WebElement getGotQuest1() {
		return gotQuest1;
	}

	public WebElement getCloseHelpFrameBtn() {
		return closeHelpFrameBtn;
	}

	public WebElement getRetryBtn() {
		return retryBtn;
	}

	public WebElement getFailedMsg1() {
		return failedMsg1;
	}

	public WebElement getPendingMsg() {
		return pendingMsg;
	}

	public WebElement getTipText() {
		return tipText;
	}

	public WebElement getAmountText() {
		return amountText;
	}

	public WebElement getPaymentDateAndTime() {
		return paymentDateAndTime;
	}

	public WebElement getCashbackTermsText() {
		return cashbackTermsText;
	}


	public WebElement getCashbackBanner() {
		return cashbackBanner;
	}
	

	public WebElement getCashbackBannerTitle() {
		return cashbackBannerTitle;
	}


	public WebElement getCashbackBannerSubitle() {
		return cashbackBannerSubitle;
	}


	public WebElement getQr() {
		return qr;
	}

	public WebElement getCarousel()
	{
		return carousel;		
	}

	public WebElement getMobileNumberText() {
		return mobileNumberText;
	}

	public WebElement getMobileNumberTextField() {
		return mobileNumberTextField;
	}

	public WebElement getSpamAlert() {
		return spamAlert;
	}

	public WebElement getAtoaTermsCheckbox() {
		return atoaTermsCheckbox;
	}

	public WebElement getAtoaTermsText() {
		return atoaTermsText;
	}

	public WebElement getVerifyButton() {
		return verifyBtn;
	}

	public WebElement getOtpField() {
		return otpField;
	}

	public WebElement getOtp1() {
		return otp1;
	}

	public WebElement getOtp2() {
		return otp2;
	}

	public WebElement getOtp3() {
		return otp3;
	}

	public WebElement getOtp4() {
		return otp4;
	}

	public WebElement getResendButton() {
		return resendBtn;
	}

	public WebElement getConfirmButton() {
		return confirmBtn;
	}

	public WebElement getChangeNumberBtn() {
		return changeNumberBtn;
	}

	public WebElement getToastText() {
		return toastText;
	}

	public WebElement getToastCloseBtn() {
		return toastCloseBtn;
	}


	public WebElement getVerifyBtn() {
		return verifyBtn;
	}


	public WebElement getResendBtn() {
		return resendBtn;
	}


	public WebElement getConfirmBtn() {
		return confirmBtn;
	}


	public WebElement getMerchantText() {
		return merchantText;
	}


	public WebElement getMerchantName() {
		return merchantName;
	}


	public WebElement getReferenceText() {
		return referenceText;
	}


	public WebElement getReferenceNumber() {
		return referenceNumber;
	}


	public WebElement getNoteText() {
		return noteText;
	}


	public WebElement getNote() {
		return note;
	}


	public WebElement getGoBackToBillButton() {
		return goBackToBillButton;
	}

	
	
	
}
