package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class StrictExpiryParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Complete Failed payment with strict expiry true <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call process payment api by keeping strict expiry true and expiry 30 sec
	 * 2. Initiate the payment and wait on bank page for the expiry time to complete
	 * 3. Authenticate the payment from bank
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> Transaction details page should show Payment Failed status<p>
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
	public void completePaymentWhenStrictExpiryTrue(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		expiresIn="30000";
		strictExpiry=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(25000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Payment Failed",driver);

	}
	
	/**
	 * 
	 * <b>Title:</b> Make success payment by passing strict expiry as false<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and strict expiry as false and expiry 30 sec <p>
	 * 3. Open paymentUrl obtained from processPayment api<p>
	 * 4. Make success payment<p>
	 * <b>Test assertions:</b>Checking transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Payment link should be generated<p>
	 * 2. Transaction should be completed successfully<p>
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
	public void completePaymentWhenStrictExpiryFalse(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
	storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		expiresIn="30000";
		strictExpiry=false;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(25000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> Complete Failed payment with strict expiry true <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call process payment api by keeping strict expiry true and expiry 30 sec
	 * 2. Initiate the payment and wait on bank page for the expiry time to complete
	 * 3. Authenticate the payment from bank
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b> Transaction details page should show Payment Failed status<p>
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
	public void completePaymentWhenStrictExpiryTrueWaitInBankApp(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		expiresIn="30000";
		strictExpiry=true;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(30000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Payment Failed",driver);

	}
	
	/**
	 * 
	 * <b>Title:</b> Make success payment by passing strict expiry as false<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and strict expiry as false and expiry 30 sec <p>
	 * 3. Open paymentUrl obtained from processPayment api<p>
	 * 4. Make success payment<p>
	 * <b>Test assertions:</b>Checking transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Payment link should be generated<p>
	 * 2. Transaction should be completed successfully<p>
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
	public void completePaymentWhenStrictExpiryFalseWaitInBankApp(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
	storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		expiresIn="30000";
		strictExpiry=false;
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(30000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
	}


}
