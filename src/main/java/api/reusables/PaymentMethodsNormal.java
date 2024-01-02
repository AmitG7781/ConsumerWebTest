package api.reusables;

import org.openqa.selenium.WebDriver;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.LloydsPaymentPageD;
import api.pomPages.ModeloLoginPageD;
import api.pomPages.RBSBankPageD;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;

public class PaymentMethodsNormal extends Call{
	
		public WebDriver makeSuccessPaymentAib(long wait,WebDriver driver) throws InterruptedException
		{	
		    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

			sqrwa.getContinueOnThisDeviceButton().click();

			Thread.sleep(5000);
			
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

			tspwa.getTipSuggestion22().click();

			tspwa.getProceedButton().click();

			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

			bspwa.getViewAllBanksButton().click();

			bspwa.getBanksSearchBox().sendKeys("Aib");
			
			bspwa.getAib().click();
			
			Thread.sleep(wait);
			
			bspwa.getProceedButton().click();
			Thread.sleep(10000);
			
			return driver;
		}
		
		public WebDriver makeSuccessPaymentAib(long wait,boolean enableTips,WebDriver driver) throws InterruptedException
		{	
		    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

			sqrwa.getContinueOnThisDeviceButton().click();

			Thread.sleep(5000);
			if(enableTips)
			{	
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);
	
			tspwa.getTipSuggestion22().click();

			tspwa.getProceedButton().click();
			}
			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

			bspwa.getViewAllBanksButton().click();

			bspwa.getBanksSearchBox().sendKeys("Aib");
			
			bspwa.getAib().click();
			
			Thread.sleep(wait);
			
			bspwa.getProceedButton().click();
			Thread.sleep(10000);
			
			return driver;
		}
		
		public WebDriver makeSuccessPaymentLloyds( long wait, WebDriver driver) throws InterruptedException
		{
			
		    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

			sqrwa.getContinueOnThisDeviceButton().click();

			Thread.sleep(5000);
			
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

			tspwa.getTipSuggestion22().click();

			tspwa.getProceedButton().click();

			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

			bspwa.getViewAllBanksButton().click();

			bspwa.getBanksSearchBox().sendKeys("Lloyds");
			
			bspwa.getLloyds().click();
			Thread.sleep(5000);
			bspwa.getProceedButton().click();
			
			LloydsPaymentPageD lpp = new LloydsPaymentPageD(driver);
			lpp.getLloydsUsername().sendKeys("Llr001");
			lpp.getLloydsPass().sendKeys("Password123");
			lpp.getLloydsNext().click();
			Thread.sleep(wait);
			lpp.getLloydsSelectAcc().click();
			lpp.getLloydsProceed().click();
			lpp.getLloydsYes().click();
			Thread.sleep(10000);
			return driver;
		}
		

		public WebDriver makeFailedPayment(long wait, WebDriver driver) throws InterruptedException
		{   
			ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);
	
			sqrwa.getContinueOnThisDeviceButton().click();
	
			Thread.sleep(5000);
			
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);
	
			// Tip 2nd suggestion
			tspwa.getTipSuggestion22().click();
	
			tspwa.getProceedButton().click();
	
			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);
	
			bspwa.getViewAllBanksButton().click();
			
			bspwa.getBanksSearchBox().sendKeys("royal");
			
			bspwa.getRbs().click();
			Thread.sleep(10000);
			
			bspwa.getProceedButton().click();
			
			utilities.switchingtabs(driver);
			RBSBankPageD rbs= new RBSBankPageD(driver);
			rbs.getLoginID().sendKeys("123456789012");
			rbs.getContinueBtn().click();
			rbs.getPin1().sendKeys("5");
			rbs.getPin2().sendKeys("7");
			rbs.getPin3().sendKeys("2");
			rbs.getPass1().sendKeys("4");
			rbs.getPass2().sendKeys("3");
			rbs.getPass3().sendKeys("6");
			rbs.getLoginBtn().click();
			rbs.getSelectAccount().click();
			rbs.getApprove().click();
			utilities.switchingtabs(driver);
			
			Thread.sleep(10000);
			return driver;
		}

		public WebDriver makePendingPayment(WebDriver driver) throws InterruptedException
		{
			
		    ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

			sqrwa.getContinueOnThisDeviceButton().click();

			Thread.sleep(5000);
			
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

			tspwa.getTipSuggestion22().click();

			tspwa.getProceedButton().click();

			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

			bspwa.getViewAllBanksButton().click();

			bspwa.getBanksSearchBox().sendKeys("Modelo");
			
			bspwa.getModelo().click();
			
			Thread.sleep(5000);
			
			bspwa.getProceedButton().click();
			Thread.sleep(10000);
			
			utilities.switchingtabs(driver);
			ModeloLoginPageD mod = new ModeloLoginPageD(driver);
			
			mod.getUsn().sendKeys("mits");
			mod.getPass().sendKeys("mits");
			mod.getLoginBtn().click();
			mod.getAccount1().click();
			mod.getConfirmBtn().click();
			utilities.switchingtabs(driver);
			Thread.sleep(10000);
			return driver;
		}
		

		public WebDriver makeCancelledPayment(long wait,WebDriver driver) throws InterruptedException
		{
			ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

			sqrwa.getContinueOnThisDeviceButton().click();

			Thread.sleep(5000);
			
			TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

			// Tip 2nd suggestion
			tspwa.getTipSuggestion22().click();

			tspwa.getProceedButton().click();

			BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

			bspwa.getViewAllBanksButton().click();

			bspwa.getBanksSearchBox().sendKeys("royal");
			
			bspwa.getRbs().click();
			Thread.sleep(10000);
			bspwa.getProceedButton().click();
			
			utilities.switchingtabs(driver);
			RBSBankPageD rbp=new RBSBankPageD(driver);
			rbp.getRbsCancel().click();
			
			Thread.sleep(wait);
			utilities.switchingtabs(driver);
			
			return driver;
		}

}
