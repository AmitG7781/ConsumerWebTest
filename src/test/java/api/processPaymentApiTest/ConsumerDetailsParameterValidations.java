package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.Assertions;
import api.reusables.PaymentMethodsNormal;

public class ConsumerDetailsParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Make success payment by passing empty customer details<p>
	 * <b>Test steps:</b><p>
	 * 1. Get store id from getStores api<p>
	 * 2. Call processPayment api by passing this store id and empty customer details<p>
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
		public void paymentUsingEmptyConsumerDetails(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			
			phoneCountryCode="";
			phoneNumber="";
			email="";
			firstName="";
			lastName="";
			
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
