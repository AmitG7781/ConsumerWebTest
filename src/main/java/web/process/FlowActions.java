package web.process;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import web.pomPages.BanksPage;

public class FlowActions extends PageMethods{
	
	public void makeSuccessfulPayment(WebDriver driver, String env,String paymentMode,String amount,int tipOption,String tip) throws InterruptedException
	{
		clickContinueOnThisDeviceButton(driver);
		
		if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("dynamicQR"))
		{
			enterAmountAndProceed(driver, amount);
		}
		
		selectTipAndProceed(driver, tipOption, tip);
		selectBankAndProceed(driver, paymentMode);
		successPaymentAtoaBank(driver, "COMPLETED");
	}	
	
	public void goToAllBanksPage(WebDriver driver, String env,String merchant,String paymentMode, String amount,int tipOption, String tip ) throws IOException
	{
			if(paymentMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata(env+"StaticQR"+merchant));
			}
			else if(paymentMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata(env+"PhysicalQR"+merchant));
			}
			else if(paymentMode.equalsIgnoreCase("dynamicQR"))
			{
				driver.navigate().to(pdata.getPropertydata(env+"dynamicQR"+merchant));
			}
			else if(paymentMode.equalsIgnoreCase("link"))
			{
				driver.navigate().to(pdata.getPropertydata("link"));
			}
		
		
		clickContinueOnThisDeviceButton(driver);
		
		if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("physicalQR"));
		{
			enterAmountAndProceed(driver, amount);	
		}
		selectTipAndProceed(driver,tipOption, tip);
		
	}
	
	public void verifyBanksRedirection(WebDriver driver,String env,String merchant,String paymentMode,String amount,int tipOption,String tip) throws InterruptedException, IOException
	{
		BanksPage bp = new BanksPage(driver);
		bp.clickViewAllBanksButton();
		
		for(int i=0;i<=bp.getAllBankList().size()-1;i++)
		{
			BanksPage bp1 = new BanksPage(driver);
			Thread.sleep(2000);
			String bank=bp1.getAllBankList().get(i).getText();
			bp1.getAllBankList().get(i).click();
			
			if (bp1.getToast().size()!=0)
			{
				Reporter.log(i+1+" "+bank+" is Down");
			}
			else
			{
				if(paymentMode.equalsIgnoreCase("staticQR")||paymentMode.equalsIgnoreCase("link"))
				{
					
					bp1.clickTermsCheckbox();
				}
				
				bp1.clickProceedButton();
				
				utilities.switchingtabs(driver);
				sa.assertTrue(bankPageTitles.contains(driver.getTitle()));
				Reporter.log(i+1+" "+bank+" is redirecting to "+ driver.getTitle());
			}
			goToAllBanksPage(driver, env, merchant, paymentMode, amount, tipOption, tip);
			bp1.clickViewAllBanksButton();
		}

	}
}
