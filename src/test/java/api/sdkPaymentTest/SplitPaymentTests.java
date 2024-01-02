package api.sdkPaymentTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.EnterAmountPageWithoutAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.SplitEquallyPage;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;
import api.pomPages.TransactionDetailsPage;
import api.reusables.Assertions;
import api.reusables.InFlowActions;
import api.reusables.PaymentMethodsSplitBill;

public class SplitPaymentTests extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Pay full amount by 1 person<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Pay full amount by 1 person<p>
	 * <b>Test assertions:</b> Verified transaction details page<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details pages<p>
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
		public void payFullAmountBy1Person(String env, String browserName,
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
			Thread.sleep(3000);
			driver=new InFlowActions().selectSplitOption(driver, "full");
			
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(10000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "60", "20", "Paid", driver);
			
			closeApp();
			
			driver=setUp(paymentUrl);
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new Assertions().paidBillPageVerification(driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> Split bill- Equal custom amount payment by 2 people<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Pay equal part of custom amount by 1st user<p>
	 * 3. Pay equal part of custom amount by 2nd user<p>
	 * <b>Test assertions:</b> Verified transaction details of both the users<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details pages<p>
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
		public void payEqualPartOfCustomAmountBy2Users(String env, String browserName,
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
			
			driver=new PaymentMethodsSplitBill().makeSuccessPaymentCustomAmountLloyds("20","User1",5000, driver);
		
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40", "20", "Paid", driver);
			closeApp();
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsSplitBill().makeSuccessPaymentCustomAmountLloyds("20","User2",5000, driver);
			
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40", "20", "Paid", driver);
			closeApp();
			driver=setUp(paymentUrl);
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new Assertions().paidBillPageVerification(driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> 1st person pays split amount and 2nd person pays custom amount<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Pay equal part of split amount by 1st user<p>
	 * 3. Pay equal part of custom amount by 2nd user<p>
	 * <b>Test assertions:</b> Verified transaction details of both the users<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details pages<p>
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
		public void successfullyPaySplitAmountby1stUserAndCustomAmountBy2ndPerson(String env, String browserName,
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
			
			driver= new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			
			driver=new PaymentMethodsSplitBill().makeSuccessPaymentCustomAmountLloyds("20","User2",5000, driver);
			
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40", "20", "Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new Assertions().paidBillPageVerification(driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> 1st person pays split amount and 2nd person pays what's left amount<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Pay equal part of split amount by 1st user<p>
	 * 3. Pay what's left amount by 2nd user<p>
	 * <b>Test assertions:</b> Verified transaction details of both the users<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate data should be displayed on transaction details pages<p>
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
		public void successfullyPaySplitAmountby1stUserAndWhatsLeftAmountBy2ndPerson(String env, String browserName,
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
			
			driver= new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
			closeApp();
			driver=setUp(paymentUrl);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new InFlowActions().selectSplitOption2ndUser(driver, "amountLeft");
			
			driver= new InFlowActions().selectTipAndProceed(driver, 2, "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
				
			driver=new Assertions().paidBillPageVerification(driver);
	}
	
	/**
	 * 
	 * <b>Title:</b> Testing Custom amount field by entering amount more than bill amount by 1st person<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Select custom amount option<p>
	 * 3. Enter amount more than bill amount<p>
	 * <b>Test assertions:</b> Verified the error displayed<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate error message should be displayed <p>
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
		public void enterCustomAmountMoreThanBillBy1stPerson(String env, String browserName,
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

			driver=new InFlowActions().selectSplitOption(driver, "custom");
			
			new EnterAmountPageWithoutAmount(driver).getAmountTextBox().sendKeys("41");
			
			driver=new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			sa.assertEquals(new EnterAmountPageWithoutAmount(driver).getInputErrorMessage().getText(),"Enter an amount lesser than your outstanding of £"+amount);
			sa.assertEquals(new EnterAmountPageWithoutAmount(driver).getProceedToPayCustomAmountButton().isEnabled(), false);
	}
	
	/**
	 * 
	 * <b>Title:</b> Testing Custom amount field by entering amount more than left over amount by 2nd person<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing all the valid values<p>
	 * 2. Select custom amount option<p>
	 * 3. Pay equal split part of amount by 1st person<p>
	 * 4. Enter custom amount more than bill by second person
	 * <b>Test assertions:</b> Verified the error displayed<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate error message should be displayed <p>
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
		public void enterCustomAmountMoreThanBillBy2ndPerson(String env, String browserName,
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
			
			driver= new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
			
			driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
			Thread.sleep(15000);
			driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
			
			closeApp();
			driver=setUp(paymentUrl);
			
			driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
			driver=new InFlowActions().selectSplitOption2ndUser(driver, "custom");
			
			new EnterAmountPageWithoutAmount(driver).getAmountTextBox().sendKeys("41");
			
			driver=new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
			
			sa.assertEquals(new EnterAmountPageWithoutAmount(driver).getInputErrorMessage().getText(),"Enter an amount lesser than your outstanding of £"+(Integer.parseInt(amount))/2);
			sa.assertEquals(new EnterAmountPageWithoutAmount(driver).getProceedToPayCustomAmountButton().isEnabled(), false);
	}
	

}
