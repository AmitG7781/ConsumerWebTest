package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.ErrorPage;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class AmountParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing special characters in Amount field <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by entering special characters in amount field<p>
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
	public void processPaymentResponseWithSpecialCharactersInAmount(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1,String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		amount="$123";
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
	 * <b>Title:</b> Check processPayment api response by passing alphabets in Amount field <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by entering alphabets in amount field<p>
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
	public void processPaymentResponseWithAlphabetsInAmount(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1,String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		amount="123Pound";
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
	 * <b>Title:</b> Check processPayment api response by passing amount less than 1 pound <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by entering 0.5 in amount field<p>
	 * <b>Test assertions:</b> Verified the Atoa error web page<p>
	 * <b>Expected result:</b> Appropriate error message should be displayed>
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
	public void paymentUsingAmountLessThan1(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		amount="0.5";
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		
	    driver=setUp(paymentUrl);
		
	    ErrorPage ep = new ErrorPage(driver);
	    Assert.assertEquals(ep.getErrorTitleText(),"Error Processing Payment" );
	    Assert.assertEquals(ep.getErrorDescriptionText(),"Amount can't be less than £1.00 or greater than £15,000.00" );
	
	}
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing amount more than 15000 pounds <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by entering 15001 in amount field<p>
	 * <b>Test assertions:</b> Verified the Atoa error web page<p>
	 * <b>Expected result:</b> Appropriate error message should be displayed>
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
	public void paymentUsingAmountMoreThan15000(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		amount="15001";
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		
	    driver=setUp(paymentUrl);
		
	    ErrorPage ep = new ErrorPage(driver);
	    Assert.assertEquals(ep.getErrorTitleText(),"Error Processing Payment" );
	    Assert.assertEquals(ep.getErrorDescriptionText(),"Amount can't be less than £1.00 or greater than £15,000.00" );
	
	}
	
	/**
	 * 
	 * <b>Title:</b> Make success payment by passing maximum amount allowed>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and amount of 15000 pounds<p>
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
	public void paymentUsingMaxAmount(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		amount="14980";
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
		driver=setUp(paymentUrl);
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(5000,driver);
			
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"15,000","20","Paid",driver);
	}

}
