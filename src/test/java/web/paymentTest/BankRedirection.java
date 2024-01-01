package web.paymentTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import web.genericLibraries.BaseClass;
import web.process.FlowActions;

public class BankRedirection extends BaseClass{
	
	@Test
	@Parameters({"env", "paymentMode", "merchant","tipOption","tip","amount",})
	public void banksRedirectionTest(String env,String paymentMode, String merchant,int tipOption, String tip, String amount) throws InterruptedException, IOException
	{
		new FlowActions().clickContinueOnThisDeviceButton(driver);
		
		if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("physicalQR"))
		{
			new FlowActions().enterAmountAndProceed(driver, amount);	
		}
		new FlowActions().selectTipAndProceed(driver,tipOption, tip);
		
		new FlowActions().verifyBanksRedirection(driver, env, merchant, paymentMode, amount, tipOption, tip);
	}
	
}
