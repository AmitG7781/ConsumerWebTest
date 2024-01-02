package api.sdkPaymentTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.InFlowActions;
import api.reusables.PaymentMethodsNormal;

public class NormalPaymentPagesVerification extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Normal SDK payment<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Make successful payment on the url obtained<p>
	 * <b>Test assertions:</b> Verified all the pages in the payment flow<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on all the pages<p>
	 * <b>Apis used:</b><p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void normalPaymentPagesVerification(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new Assertions().scanQRPageVerification(env, merchantMobile1, amount, driver);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new Assertions().tipsPageVerification(env, merchantMobile1, amount, "10", "20", "50", "Proceed without Tip", driver);
			
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(10000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "60","20","Paid", driver);
					
		}
	
	/**
	 * 
	 * <b>Title:</b> Pending payment details page<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing redirect url<p>
	 * 2. Make pending payment on the url obtained<p>
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details page<p>
	 * <b>Apis used:</b><p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void pendingPaymentDetailsPageVerification(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsNormal().makePendingPayment(driver);
			
			Thread.sleep(10000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "60","20","Processing", driver);
					
		}
	
	/**
	 * 
	 * <b>Title:</b> Failed payment details page verification<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing redirect url<p>
	 * 2. Make failed payment on the url obtained<p>
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details page<p>
	 * <b>Apis used:</b><p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void failedPaymentDetailsPageVerification(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			amount="5000";
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsNormal().makeFailedPayment(5000,driver);
			
			Thread.sleep(10000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "60","20","Payment Failed", driver);
					
		}
	
	/**
	 * 
	 * <b>Title:</b> Cancelled payment details page verification<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing redirect url<p>
	 * 2. Cancel the payment from the bank website<p>
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details page<p>
	 * <b>Apis used:</b><p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void cancelledPaymentDetailsPageVerification(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsNormal().makeCancelledPayment(5000,driver);
			
			Thread.sleep(10000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "60","20","Cancelled", driver);
					
		}
}
