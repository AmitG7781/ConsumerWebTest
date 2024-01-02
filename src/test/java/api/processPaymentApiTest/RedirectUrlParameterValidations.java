package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.PaymentMethodsNormal;

public class RedirectUrlParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Complete a payment by passing redirect url in api only<p>
	 * <b>Test steps:</b><p>
	 * 1. Make sure redirectUrl is not passed in app
	 * 2. Call processPaayment api by passing redirect url in api<p>
	 * 3. Make success payment by using payment url<p>
	 * <b>Test assertions:</b>Checking redirected web page title<p>
	 * <b>Expected result:</b><p>
	 * 1. User should be redirected to the url provided in api<p>
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
		public void redirectedWebsiteTitleVerificationPasssedThroughApiOnly(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			redirectUrl="https://paywithatoa.co.uk";
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
			Thread.sleep(10000);
			utilities.switchingtabs(driver);
			Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("atoaWebsiteTitle"));
			
		}
	
	/**
	 * 
	 * <b>Title:</b> Complete a payment by passing redirect url in app only<p>
	 * <b>Test steps:</b><p>
	 * 1. Make sure redirectUrl is passed in app
	 * 2. Call processPaayment api by not passing any redirect url in api<p>
	 * 3. Make success payment by using payment url<p>
	 * <b>Test assertions:</b>Checking redirected web page title<p>
	 * <b>Expected result:</b><p>
	 * 1. User should be redirected to the url provided in app<p>
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
		public void redirectedWebsiteTitleVerificationPasssedThroughAppOnly(String env, String browserName,
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
			
			driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
			Thread.sleep(10000);
			Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("facebookTitle"));
			
		}
	
		
		/**
		 * 
		 * <b>Title:</b> Complete a payment by passing different redirect urls in api amd app<p>
		 * <b>Test steps:</b><p>
		 * 1. Make sure redirectUrl is passed in app
		 * 2. Call processPaayment api by passing another redirect url in api<p>
		 * 3. Make success payment by using payment url<p>
		 * <b>Test assertions:</b>Checking redirected web page title<p>
		 * <b>Expected result:</b><p>
		 * 1. User should be redirected to the url provided in api<p>
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
		public void redirectedWebsiteTitleVerificationPasssedThroughBothAppAndApi(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2));
			
			redirectUrl="https://paywithatoa.co.uk";
			enableTips=true;
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
			Thread.sleep(10000);
			Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("atoaWebsiteTitle"));
			
		}
		
		/**
		 * 
		 * <b>Title:</b> Pending payment redirection check<p>
		 * <b>Test steps:</b><p>
		 * 1. Make sure redirectUrl is not passed in app
		 * 2. Call processPaayment api by passing redirect url in api<p>
		 * 3. Make payment to go into processing<p>
		 * <b>Test assertions:</b>Checking redirected web page title<p>
		 * <b>Expected result:</b><p>
		 * 1. User should be redirected to the url provided in api<p>
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
			public void pendingPaymentRedirectedWebsiteTitleCheck(String env, String browserName,
					String customerId,String orderId,String amount,String currency,
					String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
					String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
					String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
					boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
			{
				storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
				
				redirectUrl="https://paywithatoa.co.uk";
				
				processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
						 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
						 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
						 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
						 template);
				
				paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
				driver=setUp(paymentUrl);
				
				driver=new PaymentMethodsNormal().makePendingPayment(driver);
				Thread.sleep(15000);
				utilities.switchingtabs(driver);
				Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("atoaWebsiteTitle"));
				
			}
		
		/**
		 * 
		 * <b>Title:</b> Cancelled payment redirection check<p>
		 * <b>Test steps:</b><p>
		 * 1. Make sure redirectUrl is not passed in app
		 * 2. Call processPaayment api by passing redirect url in api<p>
		 * 3. Make cancelled payment<p>
		 * <b>Test assertions:</b>Checking redirected web page title<p>
		 * <b>Expected result:</b><p>
		 * 1. User should be redirected to the url provided in api<p>
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
			public void cancelledPaymentRedirectedWebsiteTitleCheck(String env, String browserName,
					String customerId,String orderId,String amount,String currency,
					String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
					String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
					String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
					boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
			{
				storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
				
				redirectUrl="https://paywithatoa.co.uk";
				
				processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
						 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
						 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
						 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
						 template);
				
				paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
				driver=setUp(paymentUrl);
				
				driver=new PaymentMethodsNormal().makeCancelledPayment(5000,driver);
				Thread.sleep(15000);
				utilities.switchingtabs(driver);
				Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("atoaWebsiteTitle"));
				
			}
		
		/**
		 * 
		 * <b>Title:</b> Failed payment redirection check<p>
		 * <b>Test steps:</b><p>
		 * 1. Make sure redirectUrl is not passed in app
		 * 2. Call processPaayment api by passing redirect url in api<p>
		 * 3. Make failed payment<p>
		 * <b>Test assertions:</b>Checking redirected web page title<p>
		 * <b>Expected result:</b><p>
		 * 1. User should be redirected to the url provided in api<p>
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
			public void failedPaymentRedirectedWebsiteTitleCheck(String env, String browserName,
					String customerId,String orderId,String amount,String currency,
					String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
					String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
					String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
					boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
			{
				storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
				
				redirectUrl="https://paywithatoa.co.uk";
				
				processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
						 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
						 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
						 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
						 template);
				
				paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
				driver=setUp(paymentUrl);
				
				driver=new PaymentMethodsNormal().makeFailedPayment(5000,driver);
				Thread.sleep(15000);
				utilities.switchingtabs(driver);
				Assert.assertEquals(driver.getTitle(), pdata.getSdkPropertydata("atoaWebsiteTitle"));
				
			}
		

}
