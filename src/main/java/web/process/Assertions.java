package web.process;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import web.genericLibraries.BaseClass;
import web.pomPages.BanksPage;
import web.pomPages.DesktopQRPage;
import web.pomPages.EnterAmountPage;
import web.pomPages.TipsPage;


public class Assertions extends BaseClass{
	
	public WebDriver desktopQRPageVerification(WebDriver driver,String env, String merchant) throws IOException
	{
		DesktopQRPage dqrp = new DesktopQRPage(driver);

		sa.assertEquals(dqrp.getHeaderLogo().isDisplayed(), true, "Header logo");
		sa.assertEquals(dqrp.getStoreImage().isDisplayed(), true, "Merchant icon");
		sa.assertEquals(dqrp.getPayingTitleText(), "You're paying", "Paying text");
		sa.assertEquals(dqrp.getBusinessNameText(),pdata.getPropertydata(env+"BusinessName"+merchant),"Business name");
		sa.assertEquals(dqrp.getStoreNameText(),pdata.getPropertydata(env+"StoreName"+merchant),"Store location");
		sa.assertEquals(dqrp.getQrCode().isDisplayed(), true, "QR code");
		sa.assertEquals(dqrp.getAtoaLogoInQr().isDisplayed(), true, "Logo in QR");
		sa.assertEquals(dqrp.getContinueButton().isEnabled(), true, "Continue on this device button");
		sa.assertEquals(dqrp.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		dqrp.clickHowToPayWithAtoaButton();
		sa.assertEquals(dqrp.getHowItWorksImage().isDisplayed(), true, "How it works image");
		sa.assertEquals(dqrp.getTermsLink().isDisplayed(), true, "Terms link");
		sa.assertEquals(dqrp.getPrivacyPolicyLink().isDisplayed(), true, "Privacy policy");
		sa.assertEquals(dqrp.getHelpLink().isDisplayed(), true, "Help");
		sa.assertEquals(dqrp.getPoweredByText(), " Atoa is powered by Yapily Connect Ltd, a company regulated and authorised by the UK Financial Conduct Authority", "Powered by information");
		
		return driver;
	}
	
	public WebDriver desktopQRPageVerification(WebDriver driver,String env, String merchant, String amount) throws IOException
	{
		
		DesktopQRPage dqrp = new DesktopQRPage(driver);

		sa.assertEquals(dqrp.getHeaderLogo().isDisplayed(), true, "Header logo");
		sa.assertEquals(dqrp.getStoreImage().isDisplayed(), true, "Merchant icon");
		sa.assertEquals(dqrp.getPayingTitleText(), "You're paying", "Paying text");
		sa.assertEquals(dqrp.getBusinessNameText(),pdata.getPropertydata(env+"BusinessName"+merchant),"Business name");
		sa.assertEquals(dqrp.getStoreNameText(),pdata.getPropertydata(env+"StoreName"+merchant),"Store location");
		sa.assertEquals(dqrp.getTotalAmountText(), "£1"+amount, "Amount");
		sa.assertEquals(dqrp.getQrCode().isDisplayed(), true, "QR code");
		sa.assertEquals(dqrp.getAtoaLogoInQr().isDisplayed(), true, "Logo in QR");
		sa.assertEquals(dqrp.getContinueButton().isEnabled(), true, "Continue on this device button");
		sa.assertEquals(dqrp.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		dqrp.clickHowToPayWithAtoaButton();
		sa.assertEquals(dqrp.getHowItWorksImage().isDisplayed(), true, "How it works image");
		sa.assertEquals(dqrp.getTermsLink().isDisplayed(), true, "Terms link");
		sa.assertEquals(dqrp.getPrivacyPolicyLink().isDisplayed(), true, "Privacy policy");
		sa.assertEquals(dqrp.getHelpLink().isDisplayed(), true, "Help");
		sa.assertEquals(dqrp.getPoweredByText(), " Atoa is powered by Yapily Connect Ltd, a company regulated and authorised by the UK Financial Conduct Authority", "Powered by information");
		
		return driver;
		
	}
	
	public WebDriver enterAmountPageVerification(WebDriver driver,String env, String merchant,String amount) throws IOException
	{
		EnterAmountPage eap = new EnterAmountPage(driver);

		sa.assertEquals(eap.getHeaderLogo().isDisplayed(), true, "Header logo");
		sa.assertEquals(eap.getStoreImage().isDisplayed(), true, "Merchant icon");
		sa.assertEquals(eap.getPayingTitleText(), "You're paying", "Paying text");
		sa.assertEquals(eap.getBusinessNameText(),pdata.getPropertydata(env+"BusinessName"+merchant),"Business name");
		sa.assertEquals(eap.getStoreNameText(),pdata.getPropertydata(env+"StoreName"+merchant),"Store location");	
		sa.assertEquals(eap.getAmountPrefixSymbolText(), "£", "Pound symbol");
		sa.assertEquals(eap.getAmountTextBox().isDisplayed(), true, "Amount text box");
		sa.assertEquals(eap.getAmountTextBoxValue("value"), amount, "Amount text box");
		sa.assertEquals(eap.getProceedButton().isEnabled(), false, "Proceed button");
		return driver;
	}
	
	public WebDriver tipsPageVerification(WebDriver driver,String env, String merchant,String paymentMode,String amount,String tip1,String tip2,String tip3) throws IOException
	{
		TipsPage tp = new TipsPage(driver);

		sa.assertEquals(tp.getHeaderLogo().isDisplayed(), true, "Header logo");
		sa.assertEquals(tp.getStoreImage().isDisplayed(), true, "Merchant icon");
		sa.assertEquals(tp.getPayingTitleText(), "You're paying", "Paying text");
		sa.assertEquals(tp.getBusinessNameText(),pdata.getPropertydata(env+"BusinessName"+merchant),"Business name");
		sa.assertEquals(tp.getStoreNameText(),pdata.getPropertydata(env+"StoreName"+merchant),"Store location");
		
		if(paymentMode.equalsIgnoreCase("physicalQR")||paymentMode.equalsIgnoreCase("staticQR"))
		{
			sa.assertEquals(tp.getAmountPrefixSymbolText(),"£" , "Amount pound symbol");
			sa.assertEquals(tp.getAmountTextBox().getAttribute("value"), amount, "Amount");
			sa.assertEquals(tp.getAmountEditButton().isEnabled(), true, "Amount edit button");
		}
		else if (paymentMode.equalsIgnoreCase("dynamicQR")||paymentMode.equalsIgnoreCase("link"))
		{
			sa.assertEquals(tp.getAmountText(), "£"+amount+".00", "Amount");
		}
		else
		{
			sa.assertEquals(tp.getAmountText(), "£"+amount+".00", "Amount");
		}
		sa.assertEquals(tp.getTipBoxTitleText(), "Would you like to add a Tip??", "Tip title");		
		sa.assertEquals(tp.getTipOption1Text(), "£"+tip1, "Tip Suggestion 1");		
		sa.assertEquals(tp.getTipOption2Text(), "£"+tip2, "Tip Suggestion 2");	
		sa.assertEquals(tp.getTipOption3Text(), "£"+tip3, "Tip Suggestion 3");	
		sa.assertEquals(tp.getCustomTipOption().isDisplayed(), true, "Custom tip button");
		sa.assertEquals(tp.getProceedButton().isDisplayed(), true, "Proceed button");
		sa.assertEquals(tp.getProceedButton().isEnabled(), true, "Proceed button");
		sa.assertEquals(tp.getProceedButton().getText(), "Proceed without Tip", "Proceed button");
		return driver;
	}
	
	public WebDriver banksPageVerification(WebDriver driver, String env,String merchant,String paymentMode,String amount,String tip) throws IOException
	{
		BanksPage bp = new BanksPage(driver);

		sa.assertEquals(bp.getHeaderLogo().isDisplayed(), true, "Header logo");
		sa.assertEquals(bp.getStoreImage().isDisplayed(), true, "Merchant icon");
		sa.assertEquals(bp.getPayingTitleText(), "You're paying", "Paying text");
		sa.assertEquals(bp.getBusinessNameText(),pdata.getPropertydata(env+"BusinessName"+merchant),"Business name");
		sa.assertEquals(bp.getStoreNameText(),pdata.getPropertydata(env+"StoreName"+merchant),"Store location");
		if(tip!=null)
		{
			sa.assertEquals(bp.getTotalAmountText(), "£"+(Integer.parseInt(amount.replace(",",""))+Integer.parseInt(tip.replace(",","")))+".00", "Total Amount");
			sa.assertEquals(bp.getIncludesTipText(), "Includes tip of £"+tip+".00", "Includes tip message");
		}
		else
		{
			sa.assertEquals(bp.getTotalAmountText(), "£"+amount+".00", "Total Amount");
		}
		
		if(paymentMode.equalsIgnoreCase("physicalQR")||paymentMode.equalsIgnoreCase("staticQR"))
		{
		sa.assertEquals(bp.getAmountEditButton().isEnabled(), true, "Edit amount button");
		}
		sa.assertEquals(bp.getViewAllBanksButton().isEnabled(), true, "View all banks link");
		
		Reporter.log("Bank Tiles displayed", true);
		for (int i = 0; i <= (bp.getBankTabsContainer().size()) - 1; i++) {
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='banklist-container']/descendant::label"));
			sa.assertEquals(list.get(i).isEnabled(), true);
			Reporter.log(i+1+". " + list.get(i).getText(), true);
		}
		sa.assertEquals(bp.getHowToPayWithAtoaButton().isDisplayed(), true, "How to pay with atoa");
		bp.getHowToPayWithAtoaButton().click();
		sa.assertEquals(bp.getHowItWorksImage().isDisplayed(), true, "How it works image");

		sa.assertEquals(bp.getPoweredByText(), "Atoa is powered by Yapily Connect Ltd, a company regulated and authorised by the UK Financial Conduct Authority", "Powered by information");
		return driver;
	}
	
	public WebDriver amountLimitError(WebDriver driver, String amount)
	{
		EnterAmountPage eap=new EnterAmountPage(driver);
		
		if(Float.parseFloat(amount)>15000 && Float.parseFloat(amount)<25000)
		{
			sa.assertEquals(eap.getInputErrorMessageText(), "Please enter an amount smaller than £15,000");
		}
		else if(Float.parseFloat(amount)<1)
		{
			sa.assertEquals(eap.getInputErrorMessageText(), "Please enter amount greater than £1");
		}
		else if(Float.parseFloat(amount)>25000)
		{
			sa.assertEquals(eap.getInputErrorMessageText(), "Please enter an amount smaller than £25,000");
		}
		return driver;
		
	}
	
	public WebDriver amountLimitErrorToast(WebDriver driver, String amount)
	{
		TipsPage tp=new TipsPage(driver);
		
		if(Float.parseFloat(amount)<=15000)
		{
			sa.assertEquals(tp.getToastText(), "Total amount can't be more than £15000");
		}
		else if(Float.parseFloat(amount)<=25000)
		{
			sa.assertEquals(tp.getToastText(), "Total amount can't be more than £25000");
		}
		return driver;
		
	}
	
	
	
	

}
