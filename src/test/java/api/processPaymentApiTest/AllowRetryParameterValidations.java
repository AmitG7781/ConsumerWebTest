package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.RBSBankPageD;
import api.pomPages.RetryTransactionScanQRPageWithAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;
import api.pomPages.TransactionDetailsPage;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class AllowRetryParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Check transaction details page when allowRetry is false<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api by passing allow retry as false<p> 
	 * 2. Make a canceled payment
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Retry button should not be displayed on transaction details page <p>
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
	public void normalCancelledTransactionAllowRetryFalse(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		splitBill=false;
		allowRetry=false;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeCancelledPayment(5000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Cancelled",driver);
		
	}
	
	
	/**
	 * 
	 * <b>Title:</b> Check transaction details page when allowRetry is true<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api by passing allow retry as false<p> 
	 * 2. Make a canceled payment
	 * 3.Click retry button 
	 * 4. Make a successful payment
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Retry button should not be on transaction details page<p> 
	 * 2. User should be allowed to do a successful payment after retry<p>
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
	public void normalCancelledTransactionAllowRetryTrue(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		splitBill=false;
		allowRetry=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeCancelledPayment(5000,driver);
		

		TransactionDetailsPage tdp = new TransactionDetailsPage(driver);
		tdp.getRetryBtn().click();
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
	}

}
