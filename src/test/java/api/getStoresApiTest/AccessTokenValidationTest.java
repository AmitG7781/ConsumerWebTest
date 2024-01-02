package api.getStoresApiTest;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;

public class AccessTokenValidationTest extends Call{
	
	/**
	 * 
	 * <b>Title:</b>Check getStores api response by using Merchant Login access token <p>
	 * <b>Test steps:</b><p>
	 * 1. Call sendOtp api, verifyOtp api, login api and get Login token from the response<p>
	 * 2. Input this Merchant login token to getStores api<p>
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 500<p>
	 * <b>Apis used:</b><p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 2. sendOtp: https://api.atoa.me/api/otp/v1/send-otp<p>
	 * 3. verifyOtp: https://api.atoa.me/api/otp/verify-otp<p>
	 * 4. login: https://api.atoa.me/api/auth/login-otp<p>
	 */
	@Parameters({"phoneCountryCode","merchantMobile1"})
	@Test
	public void checkGetStoresApiResponseWithMerchantLoginAccessToken(String phoneCountryCode, String merchantMobile1) throws IOException, JSONException, InterruptedException
	{
		sendOtpPayload(phoneCountryCode, merchantMobile1);
		sendOtp();
		verifyOtpPayload(phoneCountryCode, merchantMobile1,"1234");
		String verifyToken = verifyOtp();
		loginPayload(phoneCountryCode, merchantMobile1, false);
		String loginToken = login(verifyToken);
		
		response = getStoreResponse(loginToken,"0");
	
		Assert.assertEquals(response.getStatusCode(),401);
		
	}
	
	/**
	 * 
	 * <b>Title:</b> Check getStores api response by passing access token empty <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores without passing Access token<p> 
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 401<p>
	 * <b>Apis used:</b> <p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Test
	public void checkGetStoresApiResponseWithEmptyAccessToken() throws IOException, JSONException, InterruptedException
	{
		response = getStoreResponse("","0");
		
		Assert.assertEquals(response.getStatusCode(),401);
		
	}
	
	/**
	 * 
	 * <b>Title:</b> Check getStores api response by passing invalid Access token<p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores by passing invalid Access token<p> 
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 401<p>
	 * <b>Apis used:</b> <p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 */
	@Parameters({"env","merchantMobile1"})
	@Test
	public void checkGetStoresApiResponseWithInvalidAccessToken(String env, String merchantMobile) throws IOException, JSONException, InterruptedException
	{
		response = getStoreResponse(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile+"abc"),"0");
		
		Assert.assertEquals(response.getStatusCode(),401);
		
	}
	
	/**
	 * 
	 * <b>Title:</b> Check getStores api response by passing revoked token <p>
	 * <b>Test Steps:</b> <p>
	 * 1. Call getStores without passing revoked Access token<p> 
	 * <b>Test assertions:</b> Verified the response status code<p>
	 * <b>Expected result:</b> Response status code should be 401<p>
	 * <b>Apis used:</b> <p>
	 * 1. getStores: https://api.atoa.me/api/payments/stores<p>
	 * 
	 */
	@Parameters({"env"})
	@Test
	public void checkGetStoresApiResponseWithRevokedAccessToken(String env) throws IOException, JSONException, InterruptedException
	{
		response = getStoreResponse(pdata.getSdkPropertydata(env+"RevokedAccessToken"),"0");
		
		Assert.assertEquals(response.getStatusCode(),401);
		
	}

}
