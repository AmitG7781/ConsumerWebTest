package api.processPaymentApiTest;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.SplitEquallyPage;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;
import api.pomPages.TransactionDetailsPage;
import api.reusables.Assertions;
import api.reusables.InFlowActions;

public class SplitBillParameterValidations extends Call{
	
	/**
	 * 
	 * <b>Title:</b> Complete a split payment<p>
	 * <b>Test steps:</b><p>
	 * 1. Call processPayment api by passing splitBill as true<p>
	 * 2. Split the amount in 2
	 * 3. Make success payment by both users<p>
	 * <b>Test assertions:</b>Verify all the pages details for both the users<p>
	 * <b>Expected result:</b><p>
	 * 1. Appropriate details should be visible on all the pages during both the payments<p>
	 * 2. User 1 should only be allowed to set the split amount and pay his part<p>
	 * 3. User 2 is allowed to pay his part<p>
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
	public void payEqualSplitAmoutBy2PeopleWhenTipsAreEnabled(String env, String browserName,
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
		
		driver=new Assertions().scanQRPageVerification(env, merchantMobile1, amount, driver);
		
		driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
		
		driver=new Assertions().totalBillPageVerification(env, merchantMobile1, amount, driver);

		driver=new InFlowActions().selectSplitOption(driver, "Equally");
		
		driver=new Assertions().splitPageVerification(driver, amount,1,2,Integer.parseInt(amount)/2);
		
		driver= new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
		
		driver=new Assertions().tipsPageVerification(env, merchantMobile1, amount, "10", "20", "50", "Proceed without Tip", driver);
		
		driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
		
		driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
		Thread.sleep(15000);
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
		
		driver=setUp(paymentUrl);

		driver=new Assertions().scanQRPageVerification(env, merchantMobile1, amount, driver);
		
		driver=new InFlowActions().clickContinueOnThisDeviceButton(driver);
			
		driver=new Assertions().totalBillPageVerification(env, merchantMobile1, amount, "20", "20", driver);
		
		driver= new InFlowActions().selectSplitOption2ndUser(driver, "Equally");
		
		driver= new Assertions().splitPageVerification(driver, amount, 1, Integer.parseInt(amount)/2);
		
		driver= new InFlowActions().clickProceedButtonOnSplitEquallyPage(driver);
		
		driver=new Assertions().tipsPageVerification(env, merchantMobile1, amount, "10", "20", "50", "Proceed without Tip", driver);
		
		driver=new InFlowActions().selectTipAndProceed(driver, 2 , "100");
		
		driver=new InFlowActions().selectBankAndProceed(driver, "Aib");
		Thread.sleep(15000);
		driver=new Assertions().assertTransactionDetailPageVerification(env, merchantMobile1, "40","20","Paid", driver);
			
		}

}
