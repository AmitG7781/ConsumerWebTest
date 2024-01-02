package api.sdkPaymentTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.SplitEquallyPage;
import api.reusables.Assertions;
import api.reusables.InFlowActions;

public class SplitPaymentFunctionalityTests extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Testing split- pay for 10 out of 15 people<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Set split out of 15 people<p>
	 * 3. Set pay for 10 people and complete the payment<p>
	 * 4. Pay for remaining people from 2nd user account<p>
	 * <b>Test assertions:</b> Verified the transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details page <p>
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
		public void splitOutOf15PeopleAndPayFor10People(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			splitBill=true;
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);

			driver=new InFlowActions().selectSplitOption(driver, "Equally");
			
			driver=new InFlowActions().setOutOfPeopleValues(driver, 15);
			
			driver=new Assertions().splitPageVerification(driver, amount,1,15,((Integer.parseInt(amount))/20)*1);
			
			driver=new InFlowActions().setPayForPeopleValues(driver, 10);
			
			driver=new Assertions().splitPageVerification(driver, amount,10,15,((Integer.parseInt(amount))/15)*10);
			
			driver=new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			driver=new Assertions().tipsPageVerification(env, merchantMobile1, String.valueOf(((Integer.parseInt(amount))/15)*10), "10", "20", "50", "Proceed without Tip", driver);
		
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, String.valueOf((((Integer.parseInt(amount))/15)*10)+20),"20","Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			Thread.sleep(3000);
			driver=new InFlowActions().selectSplitOption2ndUser(driver, "equally");
			
			driver=new Assertions().splitPageVerification(driver, amount,1,((Integer.parseInt(amount))/15)*1);
			//System.out.println(new SplitEquallyPage(driver).getPayForCount().getText());
			
			driver=new InFlowActions().setPayForPeopleValues(driver, 10);
			
			driver=new Assertions().splitPageVerification(driver, amount,5,((Integer.parseInt(amount))/15)*5);
			
			driver=new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			driver=new Assertions().tipsPageVerification(env, merchantMobile1, String.valueOf(((Integer.parseInt(amount))/15)*5), "10", "20", "50", "Proceed without Tip", driver);
		
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, String.valueOf((((Integer.parseInt(amount))/15)*5)+20),"20","Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
				
			driver=new Assertions().paidBillPageVerification(driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> Testing split Out of people and pay for people fields<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Try to set out of people value above 20 and verify the out of text field<p>
	 * 3. Try to set pay people value above out of people and verify the pay for text field<p>
	 * 4. Try to set out of people value less than pay for people and verify the out of text field<p>
	 * <b>Test assertions:</b> Verified the Out of and Pay for text field values<p>
	 * <b>Expected result:</b><p>
	 * 1. Max limit for Out of and Pay for values should be 20<p>
	 * 2. Pay for value should not get greater than Out of value<p>
	 * 3. Out of value should not get lesser than Pay for value<p>
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
		public void splitOutOfPeopleAndPayForPeopleLimitValidation(String env, String browserName,
				String customerId,String orderId,String amount,String currency,
				String institutionId,String paymentType,boolean autoRedirect,String phoneCountryCode,
				String phoneNumber,String email,String firstName,String lastName,String callBackParameter,
				String expiresIn,boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,
				boolean splitBill,String template, String merchantMobile1, String merchantMobile2) throws IOException, JSONException, InterruptedException
		{
			storeId = getStoreId(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1));
			splitBill=true;
			processPaymentPayload(env,browserName,customerId,orderId,amount,currency,
					 institutionId, storeId, paymentType, autoRedirect, phoneCountryCode,
					 phoneNumber, email, firstName, lastName, callBackParameter, expiresIn,
					 enableTips, allowRetry, strictExpiry, redirectUrl, splitBill,
					 template);
			
			paymentUrl = getProcessPaymentUrl(pdata.getSdkPropertydata(env+"BearerToken"+merchantMobile1),"paymentUrl");
			driver=setUp(paymentUrl);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);

			driver=new InFlowActions().selectSplitOption(driver, "Equally");
			
			driver=new InFlowActions().setOutOfPeopleValues(driver, 30);
			driver=new Assertions().splitPageVerification(driver, amount,1,20,((Integer.parseInt(amount))/20)*1);
			
			driver=new InFlowActions().setPayForPeopleValues(driver, 30);
			driver=new Assertions().splitPageVerification(driver, amount,20,20,((Integer.parseInt(amount))/20)*20);
			
			driver=new InFlowActions().setOutOfPeopleValues(driver, 10);
			driver=new Assertions().splitPageVerification(driver, amount,20,20,((Integer.parseInt(amount))/20)*20);
			
			driver=new InFlowActions().setPayForPeopleValues(driver, 10);
			driver=new Assertions().splitPageVerification(driver, amount,10,20,((Integer.parseInt(amount))/20)*10);
			
			driver=new InFlowActions().setOutOfPeopleValues(driver, 5);
			driver=new Assertions().splitPageVerification(driver, amount,10,10,((Integer.parseInt(amount))/10)*10);
			
	}
	
	
}
