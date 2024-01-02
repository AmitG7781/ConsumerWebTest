package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class PaymentTypeParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Check processPayment api response by passing empty paymentType field <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores api and get Store id
	 * 2. Enter Store id in processPayment api payload<p>
	 * 3. Call processPayment api by passing empty paymentType field<p>
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
	public void processPaymentResponseWithEmptyPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1,String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		paymentType="";
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
	 * <b>Title:</b> Make success payment by passing REFUND payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as REFUND<p>
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
	public void paymentUsingREFUNDPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="REFUND";
		
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
	 * <b>Title:</b> Make success payment by passing MERCHANTREWARD payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as MERCHANTREWARD<p>
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
	public void paymentUsingMERCHANTREWARDPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="MERCHANTREWARD";
		
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
	 * <b>Title:</b> Make success payment by passing CONSUMERREWARD payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as CONSUMERREWARD<p>
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
	public void paymentUsingCONSUMERREWARDPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="CONSUMERREWARD";
		
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
	 * <b>Title:</b> Make success payment by passing EMPLOYEEREWARD payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as EMPLOYEEREWARD<p>
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
	public void paymentUsingEMPLOYEEREWARDPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="EMPLOYEEREWARD";
		
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
	 * <b>Title:</b> Make success payment by passing MERCHANTCASHBACK payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as MERCHANTCASHBACK<p>
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
	public void paymentUsingMERCHANTCASHBACKPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="MERCHANTCASHBACK";
		
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
	 * <b>Title:</b> Make success payment by passing CONSUMERCASHBACK payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as CONSUMERCASHBACK<p>
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
	public void paymentUsingCONSUMERCASHBACKPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="CONSUMERCASHBACK";
		
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
	 * <b>Title:</b> Make success payment by passing EMPLOYEECASHBACK payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as EMPLOYEECASHBACK<p>
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
	public void paymentUsingEMPLOYEECASHBACKPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="EMPLOYEECASHBACK";
		
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
	 * <b>Title:</b> Make success payment by passing P2P payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as P2P<p>
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
	public void paymentUsingP2PPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="P2P";
		
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
	 * <b>Title:</b> Make success payment by passing INVOICEPAYMENT payment type<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and paymentType as INVOICEPAYMENT<p>
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
	public void paymentUsingINVOICEPAYMENTPaymentType(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
	{
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
		paymentType="INVOICEPAYMENT";
		
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
