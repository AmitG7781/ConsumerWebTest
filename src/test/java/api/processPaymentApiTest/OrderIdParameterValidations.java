package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class OrderIdParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing empty orderId<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api without entering orderId<p>
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 400<p>
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
	public void processPaymentResponseWithEmptyOrderId(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1,String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		orderId="";
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		 response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		Assert.assertEquals(response.getStatusCode(),400);
	  
	}
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing orderId exceeding max limit<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by entering orderId more than max limit<p>
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 400<p>
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
	public void processPaymentResponseWithOrderIdExceedingMaxLength(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1,String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		orderId="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		 response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		Assert.assertEquals(response.getStatusCode(),400);
	  
	}
	
	/**
	 * 
	 * <b>Title:</b> Make success payment by passing maximum length of orderId<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and maximum length of orderId<p>
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
		public void paymentUsingMaxLengthOrderId(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			orderId="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwx";
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
				
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
		}
	
	  
	  /**
		 * 
		 * <b>Title:</b> Make success payment by passing minimum length of orderId<p>
		 * <b>Test steps:</b><p>
		 * 1. Get store id from getStores api<p>
		 * 2. Call processPayment api by passing this store id and minimum length of orderId<p>
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
		public void paymentUsingMinLengthOrderId(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			orderId="A";
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
				
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver);
		}

}
