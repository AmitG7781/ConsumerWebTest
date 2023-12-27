package web.process;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import web.genericLibraries.BaseClass;
import web.pomPages.BanksPage;
import web.pomPages.CustomerDetailsPage;

public class InFlowActions extends BaseClass{
	
	public WebDriver enterCustomerDetails(WebDriver driver, String mobile, String name, String address) throws InterruptedException
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
		
		return driver;
	}
	
	public void goToAllBanksPage(WebDriver driver, String env,String paymentMode ) throws IOException
	{
		if(env.equalsIgnoreCase("DEV"))
		{
			if(paymentMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("devStaticQR"));
			}
			else if(paymentMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("devPhysicalQR"));
			}
		}
		
		else if(env.equalsIgnoreCase("UAT"))
		{
			if(paymentMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("uatPhysicalQR"));
			}
			else if(paymentMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("uatStaticQR"));
			}
		}
		
		else if(env.equalsIgnoreCase("PROD"))
		{
			if(paymentMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("prodPhysicalQR"));
			}
			else if(paymentMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("prodStaticQR"));
			}
		}
		
		re.goToEnterAmountPageFromQRPage(driver);

		re.goToTipSelectionPageFromEnterAmountPage25K(driver);

		re.goToBankSelctionPageFromTipsPage(driver);

		BanksPage bp = new BanksPage(driver);

		bspwa.getViewAllBanksButton().click();
	}


}
