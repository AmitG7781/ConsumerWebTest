package api.sdkPaymentTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.reusables.PaymentMethodsNormal;
import io.restassured.path.json.JsonPath;

public class SignatureTest extends Call{
	
	@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void validAtoaSignatureMatch(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException, java.security.InvalidKeyException
		{
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
			
			driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(5000,driver);
			
	        response= getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
	        String signature=JsonPath.from(response.body().asString()).get("signature");
	        String paymentIdempotencyId=response.jsonPath().getList("transactionDetails.paymentIdempotencyId").get(0).toString();
	        try {
	            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secretKey = new SecretKeySpec(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1).getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	            sha256Hmac.init(secretKey);

	            // Concatenate orderId and paymentRequestId with '|'
	            String dataToHash = orderId + "|" + paymentIdempotencyId;

	            byte[] hmacBytes = sha256Hmac.doFinal(dataToHash.getBytes(StandardCharsets.UTF_8));

	            // Convert the byte array to a hexadecimal string
	            StringBuilder hexStringBuilder = new StringBuilder();
	            for (byte b : hmacBytes) {
	                hexStringBuilder.append(String.format("%02x", b));
	            }

	            String calculatedSignature = hexStringBuilder.toString();

	            Assert.assertEquals(calculatedSignature, signature, "Atoa signature");
	            

	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            e.printStackTrace();
	        }
			
			
	}
		
		@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
			"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
			"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
			"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
			@Test
			public void invalidAtoaSignatureMatch(String env, String browserName,
					String customerId,String orderId,String amount,String currency,
					String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
					String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
					String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
					boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException, java.security.InvalidKeyException
			{
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
				
				driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(5000,driver);
					
		        response= getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
		        String signature=JsonPath.from(response.body().asString()).get("signature");
		        String paymentIdempotencyId=response.jsonPath().getList("transactionDetails.paymentIdempotencyId").get(0).toString();
		        try {
		            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
		            SecretKeySpec secretKey = new SecretKeySpec(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2).getBytes(StandardCharsets.UTF_8), "HmacSHA256");
		            sha256Hmac.init(secretKey);

		            // Concatenate orderId and paymentRequestId with '|'
		            String dataToHash = orderId + "|" + paymentIdempotencyId;

		            byte[] hmacBytes = sha256Hmac.doFinal(dataToHash.getBytes(StandardCharsets.UTF_8));

		            // Convert the byte array to a hexadecimal string
		            StringBuilder hexStringBuilder = new StringBuilder();
		            for (byte b : hmacBytes) {
		                hexStringBuilder.append(String.format("%02x", b));
		            }

		            String calculatedSignature = hexStringBuilder.toString();

		            Assert.assertNotEquals(calculatedSignature, signature, "Atoa signature");
		            

		        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
		            e.printStackTrace();
		        }
			}


		@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
		"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
		@Test
		public void validAtoaSignatureHashMatch(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException, java.security.InvalidKeyException
		{
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
			
			driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(5000,driver);
	
	        //String paymentIdempotencyId = "ATOA1702355663408";
			
	        response= getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
	        String signatureHash=JsonPath.from(response.body().asString()).get("signatureHash");
	        try {
	            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
	            SecretKeySpec secretKey = new SecretKeySpec(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1).getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	            sha256Hmac.init(secretKey);

	            // Concatenate orderId and paymentRequestId with '|'
	            String dataToHash = orderId + "|" + paymentRequestId;

	            byte[] hmacBytes = sha256Hmac.doFinal(dataToHash.getBytes(StandardCharsets.UTF_8));

	            // Convert the byte array to a hexadecimal string
	            StringBuilder hexStringBuilder = new StringBuilder();
	            for (byte b : hmacBytes) {
	                hexStringBuilder.append(String.format("%02x", b));
	            }

	            String calculatedSignature = hexStringBuilder.toString();

	            Assert.assertEquals(calculatedSignature, signatureHash, "Atoa signature hash");
	            

	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            e.printStackTrace();
	        }
			
			
	}
		
		@Parameters({"env","browserName","customerId", "orderId", "amount", "currency", 
			"institutionId", "paymentType", "autoRedirect", "phoneCountryCode", 
			"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
			"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template","merchantMobile1", "merchantMobile2"})
			@Test
			public void invalidAtoaSignatureHashMatch(String env, String browserName,
					String customerId,String orderId,String amount,String currency,
					String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
					String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
					String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
					boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException, java.security.InvalidKeyException
			{
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
				
				driver=new PaymentMethodsNormal().makeSuccessPaymentLloyds(5000,driver);
		
		        //String paymentIdempotencyId = "ATOA1702355663408";
				
		        response= getPaymentStatusApiCall(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1), paymentRequestId);
		        String signatureHash=JsonPath.from(response.body().asString()).get("signatureHash")+"abcd";
		        try {
		            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
		            SecretKeySpec secretKey = new SecretKeySpec(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile2).getBytes(StandardCharsets.UTF_8), "HmacSHA256");
		            sha256Hmac.init(secretKey);

		            // Concatenate orderId and paymentRequestId with '|'
		            String dataToHash = orderId + "|" + paymentRequestId;

		            byte[] hmacBytes = sha256Hmac.doFinal(dataToHash.getBytes(StandardCharsets.UTF_8));

		            // Convert the byte array to a hexadecimal string
		            StringBuilder hexStringBuilder = new StringBuilder();
		            for (byte b : hmacBytes) {
		                hexStringBuilder.append(String.format("%02x", b));
		            }

		            String calculatedSignature = hexStringBuilder.toString();

		            Assert.assertNotEquals(calculatedSignature, signatureHash, "Atoa signature hsah");
		            

		        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
		            e.printStackTrace();
		        }
			}

}
