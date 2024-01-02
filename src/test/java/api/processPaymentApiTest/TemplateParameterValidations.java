package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import io.restassured.path.json.JsonPath;

public class TemplateParameterValidations extends Call{
	

	/**
	 * 
	 * <b>Title:</b> Check processPayment api response when invalid template value is passed<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing template value as 'ABCD'<p>
	 * <b>Test assertions:</b>Checking the url in the response status code<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should not be generated<p>
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
	public void processPaymentResponseForInvlaidTemplateValue(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template="ABCD";
		
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
	 * <b>Title:</b> Check processPayment api response when empty template value is passed<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing invalid template value <p>
	 * <b>Test assertions:</b>Checking the url in the response status code<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should not be generated<p>
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
	public void processPaymentResponseForEmptyTemplateValue(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template="";
		
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
	 * <b>Title:</b> Check processPayment api response by passing EXTERNAL_DISPLAY as template value<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing EXTERNAL_DISPLAY template value <p>
	 * <b>Test assertions:</b>Checking the url in the response status code and url generated<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should be generated of appropriate type<p>
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
	public void processPaymentResponseForExternalDisplay(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template=pdata.getSdkPropertydata("templateType1");
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		String jsonString = response.getBody().asString();
		
		String templateUrl= JsonPath.from(jsonString).get("templateUrl");
		Assert.assertEquals(templateUrl.contains("external-display_payment-qr-codes"),true,"Template url is not correct");
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing RECEIPT as template value<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing RECEIPT template value <p>
	 * <b>Test assertions:</b>Checking the url in the response status code and url generated<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should be generated of appropriate type<p>
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
	public void processPaymentResponseForReceipt(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template=pdata.getSdkPropertydata("templateType2");
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		String jsonString = response.getBody().asString();
		
		String templateUrl= JsonPath.from(jsonString).get("templateUrl");
		Assert.assertEquals(templateUrl.contains("receipt-payment-qr-codes"),true,"Template url is not correct");

		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing EXTERNAL_DISPLAY_PNG as template value<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing EXTERNAL_DISPLAY_PNG template value <p>
	 * <b>Test assertions:</b>Checking the url in the response status code and url generated<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should be generated of appropriate type<p>
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
	public void processPaymentResponseForExternalDisplayPNG(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template=pdata.getSdkPropertydata("templateType3");
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		String jsonString = response.getBody().asString();
		
		String templateUrl= JsonPath.from(jsonString).get("templateUrl");
		Assert.assertEquals(templateUrl.contains("external-display-png_payment-qr-codes"),true,"Template url is not correct");

		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing RECEIPT_PNG as template value<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing RECEIPT_PNG template value <p>
	 * <b>Test assertions:</b>Checking the url in the response status code and url generated<p>
	 * <b>Expected result:</b><p>
	 * 1. templateUrl should be generated of appropriate type<p>
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
	public void processPaymentResponseForReceiptPNG(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		template=pdata.getSdkPropertydata("templateType4");
		
		processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
				 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
				 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
				 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
				 template);
		
		response = getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		String jsonString = response.getBody().asString();
		
		String templateUrl= JsonPath.from(jsonString).get("templateUrl");
		Assert.assertEquals(templateUrl.contains("receipt-payment-qr-codes"),true,"Template url is not correct");
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
