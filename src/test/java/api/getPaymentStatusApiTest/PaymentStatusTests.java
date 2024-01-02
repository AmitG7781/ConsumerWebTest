package api.getPaymentStatusApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.PaymentMethodsNormal;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;
public class PaymentStatusTests extends Call{
	/**
	 * 
	 * <b>Title:</b> Check status using status api for successful payment<p>
	 * <b>Test steps:</b>
	 * 1. Make successful payment<p>
	 * 2. Call payment status api using payment request id<p>
	 * <b>Test assertions:</b>Verified parameter values in response of status api<p>
	 * <b>Expected result:</b>
	 * 1. Transaction status should be COMPLETED<p>
	 * 2. Parameter values should be same as supplied in processPayment api<p>
	 * <b>Apis used:</b>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. getPaymentStatus: https://api.atoa.me/api/payments/v1/payment-status/{id}<p>
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void paymentSuccessStatusCheck(String env, String browserName,
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
			
			response=getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			String jsonString = response.getBody().asString();
			paymentUrl = JsonPath.from(jsonString).get("paymentUrl");
			String paymentRequestId= JsonPath.from(jsonString).get("paymentRequestId");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(10000,driver);
	
			response=getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
			
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("paymentRequestId"),paymentRequestId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("customerId"),customerId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("merchantName"),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile1));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("orderId"),orderId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrl"),redirectUrl);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrlParams."+callBackParameter),callBackParameter);		
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.id"),storeId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.locationName"),pdata.getSdkPropertydata(env+"StoreName"));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("currency"),currency);	
			Assert.assertEquals(response.jsonPath().get("paidAmount").equals(60),true);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("status"),"COMPLETED");
			Assert.assertEquals(response.jsonPath().get("tipAmount").equals(20),true);		
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.splitBill").get(0).equals(splitBill),true);
			
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.currency").get(0),currency);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.statusDetails.status").get(0),"COMPLETED");
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.statusDetails.isoStatus.code").get(0),"ACSP");
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.statusDetails.isoStatus.name").get(0),"AcceptedSettlementInProcess");
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.paidAmount").get(0).equals(60),true);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.tipAmount").get(0).equals(20),true);
		
		}
	
	/**
	 * 
	 * <b>Title:</b> Check status using status api for pending payment<p>
	 * <b>Test steps:</b>
	 * 1. Make payment to go into processing<p>
	 * 2. Call payment status api using payment request id<p>
	 * <b>Test assertions:</b>Verified parameter values in response of status api<p>
	 * <b>Expected result:</b>
	 * 1. Transaction status should be AWAITING_AUTHORIZATION<p>
	 * 2. Parameter values should be same as supplied in processPayment api<p>
	 * <b>Apis used:</b>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. getPaymentStatus: https://api.atoa.me/api/payments/v1/payment-status/{id}<p>
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void paymentPendingStatusCheck(String env, String browserName,
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
			
			response=getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			String jsonString = response.getBody().asString();
			paymentUrl = JsonPath.from(jsonString).get("paymentUrl");
			String paymentRequestId= JsonPath.from(jsonString).get("paymentRequestId");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makePendingPayment(driver);
	
			response=getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
			
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("paymentRequestId"),paymentRequestId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("customerId"),customerId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("merchantName"),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile1));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("orderId"),orderId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrl"),redirectUrl);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrlParams."+callBackParameter),callBackParameter);		
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.id"),storeId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.locationName"),pdata.getSdkPropertydata(env+"StoreName"));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("currency"),currency);	
			Assert.assertEquals(response.jsonPath().get("paidAmount").equals(60),true);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("status"),"PENDING");
			Assert.assertEquals(response.jsonPath().get("tipAmount").equals(20),true);		
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.splitBill").get(0).equals(splitBill),true);
			
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.currency").get(0),currency);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.paidAmount").get(0).equals(60),true);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.tipAmount").get(0).equals(20),true);
		
		}
	
	/**
	 * 
	 * <b>Title:</b> Check status using status api for cancelled payment<p>
	 * <b>Test steps:</b>
	 * 1. Cancel payment from bank page<p>
	 * 2. Call payment status api using payment request id<p>
	 * <b>Test assertions:</b>Verified parameter values in response of status api<p>
	 * <b>Expected result:</b>
	 * 1. Transaction status should be PAYMENT_NOT_INITIATED<p>
	 * <b>Apis used:</b>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. getPaymentStatus: https://api.atoa.me/api/payments/v1/payment-status/{id}<p>
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void paymentCancelledStatusCheck(String env, String browserName,
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
			
			response=getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			String jsonString = response.getBody().asString();
			paymentUrl = JsonPath.from(jsonString).get("paymentUrl");
			String paymentRequestId= JsonPath.from(jsonString).get("paymentRequestId");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makeCancelledPayment(10000,driver);
	
			response=getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
			
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("status"),"PAYMENT_NOT_INITIATED");
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("message"),"Payment not initiated");
		
		}
	
	/**
	 * 
	 * <b>Title:</b> Check status using status api for failed payment<p>
	 * <b>Test steps:</b>
	 * 1. Make failed transaction<p>
	 * 2. Call payment status api using payment request id<p>
	 * <b>Test assertions:</b>Verified parameter values in response of status api<p>
	 * <b>Expected result:</b>
	 * 1. Transaction status should be FAILED<p>
	 * <b>Apis used:</b>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. getPaymentStatus: https://api.atoa.me/api/payments/v1/payment-status/{id}<p>
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void paymentFailedStatusCheck(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			redirectUrl="https://paywithatoa.co.uk";
			amount="5000";
			
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			response=getProcessPaymentResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			String jsonString = response.getBody().asString();
			paymentUrl = JsonPath.from(jsonString).get("paymentUrl");
			String paymentRequestId= JsonPath.from(jsonString).get("paymentRequestId");
			driver=setUp(paymentUrl);
			driver=new PaymentMethodsNormal().makeFailedPayment(10000,driver);
	
			response=getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
			response.then().log().all();
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("paymentRequestId"),paymentRequestId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("customerId"),customerId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("merchantName"),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile1));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("orderId"),orderId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrl"),redirectUrl);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("redirectUrlParams."+callBackParameter),callBackParameter);		
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.id"),storeId);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("storeDetails.locationName"),pdata.getSdkPropertydata(env+"StoreName"));
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("currency"),currency);	
			Assert.assertEquals(response.jsonPath().get("paidAmount").equals(5020),true);
			Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("status"),"FAILED");
			Assert.assertEquals(response.jsonPath().get("tipAmount").equals(20),true);		
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.splitBill").get(0).equals(splitBill),true);
			
     		Assert.assertEquals(response.jsonPath().getList("transactionDetails.currency").get(0),currency);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.paidAmount").get(0).equals(5020),true);
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.statusDetails.isoStatus.code").get(0),"RJCT");
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.statusDetails.isoStatus.name").get(0),"Rejected");
			Assert.assertEquals(response.jsonPath().getList("transactionDetails.tipAmount").get(0).equals(20),true);
		
		}

}
