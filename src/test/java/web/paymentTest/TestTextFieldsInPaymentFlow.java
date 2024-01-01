package web.paymentTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import web.genericLibraries.BaseClass;
import web.process.Assertions;
import web.process.FlowActions;
import web.process.PageMethods;

public class TestTextFieldsInPaymentFlow extends BaseClass{
	
	@Test 
	@Parameters({"env", "paymentMode", "merchant","tipOption","tip","amount",})
	public void enterAmountLimitTest(String env,String paymentMode, String merchant,int tipOption, String tip, String amount) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		new PageMethods().clickContinueOnThisDeviceButton(driver);
		new FlowActions().enterAmountAndProceed(driver, amount);	
		new Assertions().amountLimitError(driver, amount);
	}
	
	@Test 
	@Parameters({"env", "paymentMode", "merchant","tipOption","tip","amount",})
	public void enterTipToTestAmountLimit(String env,String paymentMode, String merchant,int tipOption, String tip, String amount) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		new PageMethods().clickContinueOnThisDeviceButton(driver);
		if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("physicalQR"))
		{
			new Assertions().enterAmountPageVerification(driver, env, merchant, amount);
			new FlowActions().enterAmountAndProceed(driver, amount);	
		}	
		new PageMethods().selectTipAndProceed(driver, tipOption, tip);
		new Assertions().amountLimitErrorToast(driver, amount);
	}

}
