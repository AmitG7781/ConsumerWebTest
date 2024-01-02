package api.reusables;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import api.call.Call;
import api.pomPages.BankSelectionPageWithAmount;
import api.pomPages.ScanQRPageWithAmount;
import api.pomPages.SplitEquallyPage;
import api.pomPages.TipSelectionPageWithAmount;
import api.pomPages.TotalBillAmountPage;
import api.pomPages.TransactionDetailsPage;

public class Assertions extends Call{

	public WebDriver assertTransactionDetailPageVerification(String env, String merchantMobile,String paidAmount, String tip,String transactionStatus, WebDriver driver) throws IOException
	{
		TransactionDetailsPage tdp = new TransactionDetailsPage(driver);

		sa.assertEquals(tdp.getAtoaLogoHeader().isDisplayed(), true, "Header logo");
		sa.assertEquals(tdp.getBusinessHeader().getText(), pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile), "Business name header");		
		sa.assertEquals(tdp.getStoreIcon().isDisplayed(), true, "Store icon");		
		sa.assertEquals(tdp.getStoreLocation().getText(), pdata.getSdkPropertydata(env+"StoreName"), "Store location");		
		sa.assertEquals(tdp.getPaymentSuccessStatus().getText(), transactionStatus, "Payment success status");		
		sa.assertEquals(tdp.getAmountText().getText(),"£ "+paidAmount+".00", "Amount");
		if(Float.parseFloat(tip)!=0)
		{
		sa.assertEquals(tdp.getTipText().getText(), "Includes a tip of £"+tip+".00", "Includes tip message");
		}
		//Assert.assertEquals(tdp.getBusinessName().getText(), pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile), "Business name");
	
		if(transactionStatus.equalsIgnoreCase("Payment Failed")|| transactionStatus.equalsIgnoreCase("Cancelled"))
		{
			try {sa.assertEquals(tdp.getRetryBtn().isDisplayed(), true, "Retry button");}
			catch (Exception e){}{Reporter.log("Retry button is not displayed");}
		}
		return driver;
	}
	
	public WebDriver scanQRPageVerification(String env, String merchantMobile,String amount, String tip, WebDriver driver) throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

		sa.assertEquals(sqrwa.getMerchantIcon().isDisplayed(), true, "Merchant icon");
		
		sa.assertEquals(sqrwa.getPayingText().getText(), "You're paying", "Paying text");
		
		sa.assertEquals(sqrwa.getBusinessName().getText(),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile),"Business name");

		sa.assertEquals(sqrwa.getStoreLocation().getText(),pdata.getSdkPropertydata(env+"StoreName"),"Store location");
		
		sa.assertEquals(sqrwa.getTotalAmount().getText(), "£"+amount+".00", "Amount");
		
		sa.assertEquals(sqrwa.getQrCode().isDisplayed(), true, "QR code");
		sa.assertEquals(sqrwa.getAtoaLogoInQr().isDisplayed(), true, "Logo in QR");

		sa.assertEquals(sqrwa.getContinueOnThisDeviceButton().isEnabled(), true, "Continue on this device button");

		sa.assertEquals(sqrwa.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		sqrwa.getHowToPayWithAtoaButton().click();
		Thread.sleep(2000);
		sa.assertEquals(sqrwa.getHowItWorksImage().isDisplayed(), true, "How it works image");

		sa.assertEquals(sqrwa.getTerms().isDisplayed(), true, "Terms link");
		sa.assertEquals(sqrwa.getPrivacyPolicy().isDisplayed(), true, "Privacy policy");
		sa.assertEquals(sqrwa.getHelp().isDisplayed(), true, "Help");

		sa.assertEquals(sqrwa.getPoweredBy().isDisplayed(), true, "Powered by information");
		
		return driver;
	}
	
	public WebDriver scanQRPageVerification(String env, String merchantMobile,String amount, WebDriver driver) throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		ScanQRPageWithAmount sqrwa = new ScanQRPageWithAmount(driver);

		sa.assertEquals(sqrwa.getMerchantIcon().isDisplayed(), true, "Merchant icon");
		
		sa.assertEquals(sqrwa.getPayingText().getText(), "You're paying", "Paying text");
		
		sa.assertEquals(sqrwa.getBusinessName().getText(),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile),"Business name");

		sa.assertEquals(sqrwa.getStoreLocation().getText(),pdata.getSdkPropertydata(env+"StoreName"),"Store location");
		
		sa.assertEquals(sqrwa.getTotalAmount().getText(), "£"+amount+".00", "Amount");
		
		sa.assertEquals(sqrwa.getQrCode().isDisplayed(), true, "QR code");
		sa.assertEquals(sqrwa.getAtoaLogoInQr().isDisplayed(), true, "Logo in QR");

		sa.assertEquals(sqrwa.getContinueOnThisDeviceButton().isEnabled(), true, "Continue on this device button");

		sa.assertEquals(sqrwa.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		sqrwa.getHowToPayWithAtoaButton().click();
		Thread.sleep(2000);
		sa.assertEquals(sqrwa.getHowItWorksImage().isDisplayed(), true, "How it works image");

		sa.assertEquals(sqrwa.getTerms().isDisplayed(), true, "Terms link");
		sa.assertEquals(sqrwa.getPrivacyPolicy().isDisplayed(), true, "Privacy policy");
		sa.assertEquals(sqrwa.getHelp().isDisplayed(), true, "Help");

		sa.assertEquals(sqrwa.getPoweredBy().isDisplayed(), true, "Powered by information");
		
		return driver;
	}
	
	public WebDriver tipsPageVerification(String env,String merchantMobile,String amount,String tip1, String tip2, String tip3,String proceedButtonText,WebDriver driver) throws IOException
	{
			
		TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

		sa.assertEquals(tspwa.getMerchantIcon().isDisplayed(), true, "Merchant icon");
		
		sa.assertEquals(tspwa.getBusinessName().getText(),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile),"Business name");

		sa.assertEquals(tspwa.getStoreLocation().getText(),pdata.getSdkPropertydata(env+"StoreName"),"Store location");
		
		sa.assertEquals(tspwa.getTipBoxTitle().getText(), "Would you like to add a Tip?", "Tip title");

		sa.assertEquals(tspwa.getTipSuggestion11().getText(), "£"+tip1, "Tip Suggestion 1");
		
		sa.assertEquals(tspwa.getTipSuggestion22().getText(), "£"+tip2, "Tip Suggestion 2");

		sa.assertEquals(tspwa.getTipSuggestion33().getText(), "£"+tip3, "Tip Suggestion 3");

		sa.assertEquals(tspwa.getTipSuggestion4().isDisplayed(), true, "Custom tip button");

		sa.assertEquals(tspwa.getProceedButton().isEnabled(), true, "Proceed button");
		sa.assertEquals(tspwa.getProceedButton().getText(), proceedButtonText, "Proceed button");
		
		return driver;
		
	}
	
	public WebDriver tipsPageVerification(String env,String merchantMobile,String amount,boolean enableTips,String tip1, String tip2, String tip3,String proceedButtonText,WebDriver driver) throws IOException
	{
			
		TipSelectionPageWithAmount tspwa = new TipSelectionPageWithAmount(driver);

		sa.assertEquals(tspwa.getMerchantIcon().isDisplayed(), true, "Merchant icon");
		
		sa.assertEquals(tspwa.getBusinessName().getText(),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile),"Business name");

		sa.assertEquals(tspwa.getStoreLocation().getText(),pdata.getSdkPropertydata(env+"StoreName"),"Store location");
		
		sa.assertEquals(tspwa.getTipBoxTitle().getText(), "Would you like to add a Tip?", "Tip title");

		sa.assertEquals(tspwa.getTipSuggestion11().getText(), "£"+tip1, "Tip Suggestion 1");
		
		sa.assertEquals(tspwa.getTipSuggestion22().getText(), "£"+tip2, "Tip Suggestion 2");

		sa.assertEquals(tspwa.getTipSuggestion33().getText(), "£"+tip3, "Tip Suggestion 3");

		sa.assertEquals(tspwa.getTipSuggestion4().isDisplayed(), true, "Custom tip button");

		sa.assertEquals(tspwa.getProceedButton().isEnabled(), true, "Proceed button");
		sa.assertEquals(tspwa.getProceedButton().getText(), proceedButtonText, "Proceed button");
		
		return driver;
		
	}
	
	public WebDriver totalBillPageVerification(String env,String merchantMobile,String amount,WebDriver driver) throws IOException
	{
			
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		
		sa.assertEquals(tbap.getBusinessName().getText(), pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile), "Business Name");
		
		sa.assertEquals(tbap.getBusinessLocation().getText(), "at "+pdata.getSdkPropertydata(env+"StoreName"), "Business Location");
		
		sa.assertEquals(tbap.getTotalBillText().isDisplayed(),true, "Total bill text");
		
		sa.assertEquals(tbap.getTotalBillAmount().isDisplayed(),true, "Total bill amount");
		sa.assertEquals(tbap.getTotalBillAmount().getText(), "£"+amount+".00", "Total amount value");
		
		sa.assertEquals(tbap.getProceedButton().isDisplayed(), true,"Proceed Button");
		sa.assertEquals(tbap.getProceedButton().getText(), "Proceed to Pay £"+amount+".00", "Proceed button text");
		
		sa.assertEquals(tbap.getSplitBillButton().isDisplayed(), true, "Split bill button");
		return driver;
		
	}
	
	public WebDriver totalBillPageVerification(String env,String merchantMobile,String amount,String tip,String paidAmount,WebDriver driver) throws IOException
	{
			
		TotalBillAmountPage tbap1=new TotalBillAmountPage(driver);
		
		sa.assertEquals(tbap1.getBusinessName().getText(), pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile), "Business Name");
		
		sa.assertEquals(tbap1.getBusinessLocation().getText(), "at "+pdata.getSdkPropertydata(env+"StoreName"), "Business Location");
		
		sa.assertEquals(tbap1.getTotalBillAmountTextSecondUser().getText(),"£"+amount+".00", "Total bill amount");
		sa.assertEquals(tbap1.getAmountLeftToPayForSecondUser().getText(),"£"+tip+".00", "Total bill amount");
		sa.assertEquals(tbap1.getAmountPaid().getText(),"£"+paidAmount+".00", "Total bill amount");
		
		sa.assertEquals(tbap1.getProceedButton().getText(),"Split the Bill", "Split bill button");
		
		sa.assertEquals(tbap1.getSplitBillButton().getText(),"Pay What's Left £"+(Integer.parseInt(amount)-Integer.parseInt(paidAmount))+".00", "Pay total bill button");
		return driver;
		
	}
	
	public WebDriver splitPageVerification(WebDriver driver,String amount, int payForCount, int outOfPeople, int proceedButtonAmount)
	{
		SplitEquallyPage sep = new SplitEquallyPage(driver);
		sa.assertEquals(sep.getToShareAmount().getText(),"£ "+amount+".00", "To split amount");
		
		sa.assertEquals(sep.getNegativePayForButton().isDisplayed(),true, "Negative pay for button");
		sa.assertEquals(Integer.parseInt(sep.getPayForCount().getText()),payForCount, "Pay for count");
		sa.assertEquals(sep.getPositivePayForButton().isDisplayed(),true, "Positive pay for button");
		
		sa.assertEquals(sep.getNegativeOutOfButton().isDisplayed(),true, "Negative out of button");
		sa.assertEquals(Integer.parseInt(sep.getOutOfCount().getText()),outOfPeople, "Out of count");
		sa.assertEquals(sep.getPositiveOutOfButton().isDisplayed(),true, "Positive out of button");
		
		sa.assertEquals(sep.getProceedButton().getText(), "Proceed to Pay £"+proceedButtonAmount+".00", "Proceed button");
		
		return driver;	
	}
	
	public WebDriver splitPageVerification(WebDriver driver,String amount, int payForCount, int proceedButtonAmount)
	{
SplitEquallyPage sep1 = new SplitEquallyPage(driver);
		
		sa.assertEquals(sep1.getToShareAmount().getText(),"£ "+amount+".00", "To share amount");
		sa.assertEquals(sep1.getPayForCount().getText(), payForCount, "Pay for count");
		
		sa.assertEquals(sep1.getProceedButton().getText(), "Proceed to Pay £"+proceedButtonAmount+".00", "Proceed button");
		
		sa.assertEquals(sep1.getSplitDifferentlyButton().isDisplayed(), true, "Split differently button");
		sa.assertEquals(sep1.getSplitDifferentlyButton().getText(), "Split Differently", "Split differently button");
		
		return driver;	
	}
	
	public WebDriver bankSelectionPageVerification(String env,String merchantMobile, String paidAmount, String tip ) throws IOException, InterruptedException
	{
		BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

		sa.assertEquals(bspwa.getMerchantIcon().isDisplayed(), true, "Merchant icon");
		
		sa.assertEquals(bspwa.getPayingText().getText(), "You're paying", "Paying text");
		
		sa.assertEquals(bspwa.getBusinessName().getText(),pdata.getSdkPropertydata(env+"BusinessName"+merchantMobile),"Business name");

		sa.assertEquals(bspwa.getStoreLocation().getText(),pdata.getSdkPropertydata(env+"StoreName"),"Store location");
		
		sa.assertEquals(bspwa.getTotalAmount().getText(), "£"+paidAmount+".00", "Total Amount");

		sa.assertEquals(bspwa.getIncludesTipText().getText(), "Includes tip of £"+tip+".00", "Includes tip message");

		sa.assertEquals(bspwa.getViewAllBanksButton().isDisplayed(), true, "View all banks link");

		Reporter.log("Bank Tiles displayed", true);
		for (int i = 0; i <= (bspwa.getBankTabsContainer().size()) - 1; i++) {
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='banklist-container']/descendant::label"));
			sa.assertEquals(list.get(i).isEnabled(), true);
			Reporter.log(i+1+". " + list.get(i).getText(), true);
		}

		sa.assertEquals(bspwa.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		bspwa.getHowToPayWithAtoaButton().click();
		Thread.sleep(2000);
		sa.assertEquals(bspwa.getHowItWorksImage().isDisplayed(), true, "How it works image");

		sa.assertEquals(bspwa.getPoweredBy().isDisplayed(), true, "Powered by information");
		return driver;
	}
	
	public WebDriver allBanksPageVerification()
	{

		BankSelectionPageWithAmount bspwa = new BankSelectionPageWithAmount(driver);

		bspwa.getViewAllBanksButton().click();

		sa.assertEquals(bspwa.getAllBanksPageHeader().isDisplayed(), true, "All banks page header");
		sa.assertEquals(bspwa.getAllBanksPageHeader().getText(), "All Banks", "All banks page header");

		sa.assertEquals(bspwa.getBanksSearchBox().isDisplayed(), true, "Banks search box");

		Reporter.log("Banks available on Atoa", true);
		for (int i = 0; i <= (bspwa.getAllBankList().size()) - 1; i++) {
			List<WebElement> list = driver.findElements(
					By.xpath("//div[@class='card']/descendant::ul[@class='all-bank-list']/descendant::li"));
			Reporter.log(i+1+". " + list.get(i).getText(), true);
			sa.assertEquals(list.get(i).isEnabled(), true, "Bank list items");
		}
		
		return driver;

	}
	
	public WebDriver paidBillPageVerification(WebDriver driver)
	{
		TotalBillAmountPage tbap=new TotalBillAmountPage(driver);
		sa.assertEquals(tbap.getBillPaidChip().isDisplayed(), true,"Bill paid chip");
		return driver;
	}
}
