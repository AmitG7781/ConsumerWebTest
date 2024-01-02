package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class EnableTipsParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Make successful payment when enableTips is true and Tips are enabled in app<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Make sure that tips are enabled in Atoa Business app 
	 * 2. Call processPayment api by passing enableTips as true<p> 
	 * 3. Make a successful payment by including tip
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Verify that tip selection page is displayed and tip values are same as those set in Atoa Business app<p>
	 * 2. 'Includes tip' message should be displayed on transaction details page<p> 
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
		public void paymentEnableTipsTrueAppTipsTrue(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		enableTips=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,enableTips,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> Make successful payment when enableTips is true and Tips are enabled in app<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Make sure that tips are disabled in Atoa Business app 
	 * 2. Call processPayment api by passing enableTips as true<p> 
	 * 3. Make a successful payment by including tip
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Verify that tip selection page is displayed and tip values are same as those set in Atoa Business app<p>
	 * 2. 'Includes tip' message should be displayed on transaction details page<p> 
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
		public void paymentEnableTipsTrueAppTipsFalse(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2));
		
		enableTips=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2),"paymentUrl");
		driver=setUp(paymentUrl);
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,enableTips,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile2,"60","20","Paid",driver);

	}
	
	/**
	 * 
	 * <b>Title:</b> Make successful payment when enableTips is false and Tips are enabled in app<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Make sure that tips are enabled in Atoa Business app 
	 * 2. Call processPayment api by passing enableTips as false<p> 
	 * 3. Make a successful payment by including tip
	 * <b>Test assertions:</b> Verified tips page and transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Verify that tip selection page is not displayed<p>
	 * 2. 'Includes tip' message should not be displayed on transaction details page <p>
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
		public void paymentEnableTipsFalseAppTipsTrue(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		enableTips=false;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,enableTips,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","0","Paid",driver);

	}
	
	/**
	 * 
	 * <b>Title:</b> Make successful payment when enableTips is false and Tips are disabled in app<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Make sure that tips are disabled in Atoa Business app 
	 * 2. Call processPayment api by passing enableTips as false<p> 
	 * 3. Make a successful payment by including tip
	 * <b>Test assertions:</b> Verified tips page and transaction details page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Verify that tip selection page is not displayed<p>
	 * 2. 'Includes tip' message should not be displayed on transaction details page <p>
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
		public void paymentEnableTipsFalseAppTipsFalse(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2));
		
		enableTips=false;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2),"paymentUrl");
		driver=setUp(paymentUrl);
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,enableTips,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile2,"60","0","Paid",driver);

	}

}
