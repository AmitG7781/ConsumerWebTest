package api.reusables;

import org.openqa.selenium.WebDriver;

import api.call.Call;
import api.pomPages.LloydsPaymentPageD;
import api.pomPages.ModeloLoginPageD;

public class BankProcesses extends Call{
	
	
	public WebDriver successfullPaymentLloyds(WebDriver driver)
	{
		
		LloydsPaymentPageD lpp = new LloydsPaymentPageD(driver);
		lpp.getLloydsUsername().sendKeys("Llr001");
		lpp.getLloydsPass().sendKeys("Password123");
		lpp.getLloydsNext().click();
		lpp.getLloydsSelectAcc().click();
		lpp.getLloydsProceed().click();
		lpp.getLloydsYes().click();
		
		return driver;
	}
	
	public WebDriver processingPaymentModelo(WebDriver driver)
	{
		utilities.switchingtabs(driver);
		ModeloLoginPageD mod = new ModeloLoginPageD(driver);
		
		mod.getUsn().sendKeys("mits");
		mod.getPass().sendKeys("mits");
		mod.getLoginBtn().click();
		mod.getAccount1().click();
		mod.getConfirmBtn().click();
		utilities.switchingtabs(driver);
		return driver;
	}

}
