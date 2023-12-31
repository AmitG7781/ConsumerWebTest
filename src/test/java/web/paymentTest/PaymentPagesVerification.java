package web.paymentTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import web.genericLibraries.BaseClass;
import web.pomPages.ErrorPage;
import web.process.Assertions;
import web.process.FlowActions;
import web.process.PageMethods;

public class PaymentPagesVerification extends BaseClass{
	
	@Test 
	@Parameters({"env", "paymentMode", "merchant","tipOption","tip","amount",})
	public void paymentPagesVerification(String env,String paymentMode, String merchant,int tipOption, String tip, String amount) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		new Assertions().desktopQRPageVerification(driver, env, merchant);
		new PageMethods().clickContinueOnThisDeviceButton(driver);
		if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("physicalQR"))
		{
			new Assertions().enterAmountPageVerification(driver, env, merchant, amount);
			new FlowActions().enterAmountAndProceed(driver, amount);	
		}
		new Assertions().tipsPageVerification(driver, env, merchant, paymentMode, amount, "1", "2", "5");
		new PageMethods().selectTipAndProceed(driver, tipOption, tip);
		new Assertions().banksPageVerification(driver, env, merchant, paymentMode, amount, tip);	
	}
	
	@Test 
	public void suspendedBusinessVerification() throws IOException
	{
		ErrorPage ep=new ErrorPage(driver);
		sa.assertEquals(ep.getErrorTitle(), "Error Processing Payment");
		sa.assertEquals(ep.getErrorDescription(), "Sorry, this payment cannot be processed as this time due to an issue with the merchant’s account. Please try again later");		
	}
	
	@Test 
	public void blockedBusinessVerification() throws IOException
	{
		ErrorPage ep=new ErrorPage(driver);
		sa.assertEquals(ep.getErrorTitle(), "Error Processing Payment");
		sa.assertEquals(ep.getErrorDescription(), "Could not initiate payment as the business is not verified on Atoa");		
	}
	
	@Test 
	public void fraudulentBusinessVerification() throws IOException
	{
		ErrorPage ep=new ErrorPage(driver);
		sa.assertEquals(ep.getErrorTitle(), "Error Processing Payment");
		sa.assertEquals(ep.getErrorDescription(), "The business you're attempting to pay has been temporarily suspended due to unusual payment behavior.");		
	}
	

}
