package api.cancelPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.ErrorPage;
import api.reusables.Assertions;
import api.reusables.InFlowActions;
import api.reusables.PaymentMethodsNormal;
import io.restassured.path.json.JsonPath;

public class CancelPaymentTest extends Call
{
	/**
	 * 
	 * <b>Title:</b>Cancel payment in between of transaction<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api<p> 
	 * 2. Initiate transaction<p>
	 * 3. Call cancelPayment api<p>
	 * 4. Complete the transaction<p>
	 * <b>Test assertions:</b> Verified the web payment page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Appropriate error message should be displayed<p>
	 * <b>Apis used:</b> <p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. cancelPayment: https://api.atoa.me/api/payment-request/cancel/:paymentRequestId<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
	@Test
	public void cancelTransactionDuringTransaction(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
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
		
		cancelPaymentApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),paymentRequestId);
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(10000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Payment Failed",driver);
		
	}
	
	/**
	 * 
	 * <b>Title:</b>Cancel payment after successful transaction<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call processPayment api<p> 
	 * 2. Initiate transaction<p>
	 * 3. Call cancelPayment api<p>
	 * 4. Complete the transaction<p>
	 * <b>Test assertions:</b> Verified the web payment page<p>
	 * <b>Expected result:</b> <p>
	 * 1. Appropriate error message should be displayed<p>
	 * <b>Apis used:</b> <p>
	 * 1. processPayment: https://api.atoa.me/api/payments/process-payment<p>
	 * 2. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 3. cancelPayment: https://api.atoa.me/api/payment-request/cancel/:paymentRequestId<p>
	 * 
	 */
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
	@Test
	public void cancelTransactionAfterSuccessfulTransaction(String env, String browserName,
			String customerId,String orderId,String amount,String currency,
			String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
			String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
			boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, InterruptedException, JSONException {
		
		storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
		
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
		
		driver=new PaymentMethodsNormal().makeSuccessPaymentAib(10000,driver);
		
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1,"60","20","Paid",driver); 
		
		response=cancelPaymentApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),paymentRequestId);
		
		Assert.assertEquals(response.getStatusCode(),400);
		
		Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("message"),"Your payment has already been processed and can't be cancelled. Please contact us if you need any help.");
	}
	
}
