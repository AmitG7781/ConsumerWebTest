package web.process;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import web.genericLibraries.BaseClass;
import web.pomPages.AtoaBankPage;
import web.pomPages.BanksPage;
import web.pomPages.CustomerDetailsPage;
import web.pomPages.DesktopQRPage;
import web.pomPages.EnterAmountPage;
import web.pomPages.TipsPage;

public class PageMethods extends BaseClass{

	public void clickContinueOnThisDeviceButton(WebDriver driver)
	{
		new DesktopQRPage(driver).clickContinueButton();
		
	}
	
	public void enterAmountAndProceed(WebDriver driver,String amount)
	{
		EnterAmountPage eap=new EnterAmountPage(driver);
		eap.enterAmount(amount);
		eap.clickProceedButton();
	}
	
	public void selectTipAndProceed(WebDriver driver,int tipOption,String tip)
	{
		TipsPage tp=new TipsPage(driver);
		
		if(tipOption==1) {
			tp.clickTipOption1();
		}
		else if(tipOption==2) {
			tp.clickTipOption2();
		}
		else if(tipOption==3) {
			tp.clickTipOption3();
		}
		else if(tipOption==4) {
			tp.clickCustomTipOption();
			tp.enterTip(tip);	
		}
		
		tp.clickProceedButton();
	}
	
	public void clickViewAllBanksButton ()
	{
		BanksPage bp = new BanksPage(driver);
		bp.clickViewAllBanksButton();
	}
	
	public void selectBankAndProceed(WebDriver driver,String paymentMode)
	{
		BanksPage bp = new BanksPage(driver);
		
		bp.clickViewAllBanksButton();
		bp.searchBank("ATOA test bank");
		bp.clickAtoaBank();
		
		if (paymentMode.equalsIgnoreCase("link")||paymentMode.equalsIgnoreCase("staticQR"))
		{
			bp.clickTermsCheckbox();
		}
		bp.clickProceedButton();
		
	}
	
	public void enterCustomerDetails(WebDriver driver, String mobile, String name, String address) throws InterruptedException
	{
		CustomerDetailsPage cdp=new CustomerDetailsPage(driver);
		//Thread.sleep(2000);
		cdp.getMobileNumber().click();
		cdp.enterMobileNumber(mobile);
		//Thread.sleep(2000);
		cdp.getFullName().click();
		cdp.enterFullName(name);
		//Thread.sleep(2000);
		cdp.getAddress().click();
		cdp.enterAddress(address);
		//Thread.sleep(2000);
		cdp.getBirthDate().click();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
		//Thread.sleep(2000);
		cdp.clickCountry();
		cdp.clickOption1();
		//Thread.sleep(2000);
		cdp.clickOccupation();
		cdp.clickOption1();
		//Thread.sleep(2000);
		cdp.clickSourceOfIncome();
		cdp.clickOption1();
		
	}
	
	public void successPaymentAtoaBank(WebDriver driver,String status) throws InterruptedException
	{
		utilities.switchingtabs(driver);
		AtoaBankPage abp=new AtoaBankPage(driver);
		utilities.dropDown(abp.getStatusDropdown(), status);
		abp.clickSubmitButton();
		Thread.sleep(5000);
		utilities.switchingtabs(driver);
	}
	
	
}
