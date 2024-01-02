package api.reusables;

import org.openqa.selenium.WebDriver;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.EnterAmountPageWithoutAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;

public class PaymentMethodsSplitBill extends Call{
	
	public WebDriver makeSuccessPaymentCustomAmountLloyds(String customAmount,String user,long wait,WebDriver driver) throws InterruptedException
	{	
	    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

		sqrwa.getContinueOnThisDeviceButton().click();

		Thread.sleep(5000);
		
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		if(user.equalsIgnoreCase("User1"))
		{
			tbap.getSplitBillButton().click();
		}
		else
		{
			tbap.getProceedButton().click();
		}
		tbap.getEnterCustomAmountButton().click();
		
		EnterAmountPageWithoutAmount eapwa = new EnterAmountPageWithoutAmount(driver);
		eapwa.getAmountTextBox().sendKeys(customAmount);
		Thread.sleep(5000);
		eapwa.getProceedToPayCustomAmountButton().click();
		
		TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);
		tspwa.getTipSuggestion22().click();
		tspwa.getProceedButton().click();
		
		BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

		bspwa.getViewAllBanksButton().click();

		bspwa.getBanksSearchBox().sendKeys("Lloyds");
		
		bspwa.getLloyds().click();
		Thread.sleep(wait);
		
		bspwa.getProceedButton().click();
		Thread.sleep(10000);
		new BankProcesses().successfullPaymentLloyds(driver);
		
		return driver;
	}
	
	public WebDriver makeSuccessPaymentSplitAmountLloyds(String customAmount,String user,long wait,WebDriver driver) throws InterruptedException
	{	
	    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

		sqrwa.getContinueOnThisDeviceButton().click();

		Thread.sleep(5000);
		
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		if(user.equalsIgnoreCase("User1"))
		{
			tbap.getSplitBillButton().click();
		}
		else
		{
			tbap.getProceedButton().click();
		}
		tbap.getSplitEquallyButton().click();
		
		TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);
		tspwa.getTipSuggestion22().click();
		tspwa.getProceedButton().click();
		
		BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

		bspwa.getViewAllBanksButton().click();

		bspwa.getBanksSearchBox().sendKeys("Lloyds");
		
		bspwa.getLloyds().click();
		Thread.sleep(wait);
		
		bspwa.getProceedButton().click();
		Thread.sleep(10000);
		new BankProcesses().successfullPaymentLloyds(driver);
		
		return driver;
	}

}
