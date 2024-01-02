package api.reusables;

import org.openqa.selenium.WebDriver;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.SplitEquallyPage;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;

public class InFlowActions extends Call{

	
	public WebDriver clickContinueOnThisDeviceButton(WebDriver driver)
	{
		ScanQRPageWithAmount sqrwa= new ScanQRPageWithAmount(driver);
		sqrwa.getContinueOnThisDeviceButton().click();
		return driver;
	}
	
	public WebDriver selectSplitOption(WebDriver driver, String paymentType) throws InterruptedException
	{
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
			
		if(paymentType.equalsIgnoreCase("equally"))
		{	
			Thread.sleep(3000);
			tbap.getSplitBillButton().click();
			tbap.getSplitEquallyButton().click();
		}
		else if(paymentType.equalsIgnoreCase("custom"))
		{
			Thread.sleep(3000);
			tbap.getSplitBillButton().click();
			tbap.getEnterCustomAmountButton().click();
		}
		else if(paymentType.equalsIgnoreCase("full"))
		{
			Thread.sleep(3000);
			tbap.getProceedButton().click();
		}
		return driver;
	}
	
	
	public WebDriver selectSplitOption2ndUser(WebDriver driver, String splitType) throws InterruptedException
	{
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		
		if(splitType.equalsIgnoreCase("equally"))
		{	
			Thread.sleep(3000);
			tbap.getProceedButton().click();
			tbap.getSplitEquallyButton().click();
		}
		else if(splitType.equalsIgnoreCase("custom"))
		{
			Thread.sleep(3000);
			tbap.getProceedButton().click();
			tbap.getEnterCustomAmountButton().click();
		}
		else if(splitType.equalsIgnoreCase("amountLeft"))
		{
			Thread.sleep(3000);
			tbap.getSplitBillButton().click();
		}
		return driver;
	}
	
	public WebDriver clickProceedButtonOnSplitEquallyPage(WebDriver driver)
	{
		SplitEquallyPage sep= new SplitEquallyPage(driver);
		
		sep.getProceedButton().click();
		return driver;
	}
	
	public WebDriver selectTipAndProceed(WebDriver driver, int tipSuggestion,String tip)
	{
		
		TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);
		
		if (tipSuggestion==1)
		{
			tspwa.getTipSuggestion11().click();
		}
		else if(tipSuggestion==2)
		{
			tspwa.getTipSuggestion22().click();
		}
		else if(tipSuggestion==3)
		{
			tspwa.getTipSuggestion33().click();
		}
		else
		{
			tspwa.getTipSuggestion4().click();
			tspwa.getTipTextBox().sendKeys(tip);
		}
		
		tspwa.getProceedButton().click();
		return driver;
	}
	
	public WebDriver selectBankAndProceed(WebDriver driver, String bankName) throws InterruptedException
	{
		BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

		bspwa.getViewAllBanksButton().click();

		if(bankName.equalsIgnoreCase("Aib"))
		{	
		bspwa.getBanksSearchBox().sendKeys(bankName);
		
		bspwa.getAib().click();
		}
		else if (bankName.equalsIgnoreCase("Lloyds"))
		{
			bspwa.getBanksSearchBox().sendKeys(bankName);
			
			bspwa.getLloyds().click();
		}
		else if(bankName.equalsIgnoreCase("Royal bank of Scotland"))
		{
			bspwa.getBanksSearchBox().sendKeys(bankName);
			
			bspwa.getRbs().click();
		}
		Thread.sleep(10000);
		
		bspwa.getProceedButton().click();
		
		return driver;
	}
	
	public WebDriver setOutOfPeopleValues(WebDriver driver, int outOf)
	{
		SplitEquallyPage sep=new SplitEquallyPage(driver);
		if(outOf>Integer.parseInt(sep.getOutOfCount().getText()))
		{
			for(int i=Integer.parseInt(sep.getOutOfCount().getText());i<outOf;i++)
			{
				sep.getPositiveOutOfButton().click();
			}
		}
		else if(outOf<Integer.parseInt(sep.getOutOfCount().getText()))
		{
			for(int i=Integer.parseInt(sep.getOutOfCount().getText());i>outOf;i--)
			{
				sep.getNegativeOutOfButton().click();
			}
		}
		return driver;
	}
	
	public WebDriver setPayForPeopleValues(WebDriver driver, int payFor)
	{
		
		
		SplitEquallyPage sep=new SplitEquallyPage(driver);
		if(payFor>Integer.parseInt(sep.getPayForCount().getText()))
		{
			for(int i=Integer.parseInt(sep.getPayForCount().getText());i<payFor;i++)
			{
				sep.getPositivePayForButton().click();
			}
		}
		else if(payFor<Integer.parseInt(sep.getPayForCount().getText()))
		{
			for(int i=Integer.parseInt(sep.getPayForCount().getText());i>payFor;i--)
			{
				sep.getNegativePayForButton().click();
			}
		}
		return driver;
	}
}
