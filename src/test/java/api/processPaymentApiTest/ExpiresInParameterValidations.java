package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.ErrorPage;
import api.pomPages.ScanQRPageWithoutAmount;
import api.pomPages.TotalBillAmountPage;

public class ExpiresInParameterValidations extends Call{

	/**
	 * 
	 * <b>Title:</b> Launch a payment url by passing expiresIn value as 10 Microseconds<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api by passing expiresIn value as 10 microseconds<p> 
	 * 2. Launch the payment url
	 * <b>Test assertions:</b> Verified the atoa error page on launch<p>
	 * <b>Expected result:</b> <p>
	 * 1. Verify that appropriate error page is displayed
	 * <b>Apis used:</b> <p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
	@Test
	public void completePaymentLinkExpiry10MicroSec(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		expiresIn="10";
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
	
	    setUp(paymentUrl);
		ErrorPage ep = new ErrorPage(driver);
		
		Assert.assertEquals(ep.getErrorTitleText(), "Payment Link Expired", "Error Title");
		Assert.assertEquals(ep.getErrorDescriptionText(), "Please reach out to the business for a new link and attempt to pay again", "Error description");
	
	}

	/**
	 * 
	 * <b>Title:</b> Complete payment by passing expiresIn value as 30 sec<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api by passing expiresIn value as 30 sec<p> 
	 * 2. Complete the payment after 30 sec
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Transaction status should be failed
	 * 2. Appropriate error message is displayed on transaction details page
	 * <b>Apis used:</b> <p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
	@Test
	public void completePaymentWhenLinkExpiry30Sec(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		splitBill=false;
		expiresIn="30000";
		strictExpiry=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
	
	    setUp(paymentUrl);
	    
	    ScanQRPageWithoutAmount sqrwa = new ScanQRPageWithoutAmount(driver);
		
		sqrwa.getContinueOnThisDeviceButton().click();
		
		Thread.sleep(60000);
		
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		tbap.getProceedButton().click();
		
		ErrorPage ep = new ErrorPage(driver);
		
		Assert.assertEquals(ep.getErrorTitleText(), "Payment Link Expired", "Error Title");
		Assert.assertEquals(ep.getErrorDescriptionText(), "Please reach out to the business for a new link and attempt to pay again", "Error description");
    
	}
	
	
}
