package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RBSBankPageD 
{
	@FindBy (xpath="(//button[@type='button'])[10]")
	private WebElement rbsCancel;
	
	@FindBy (id="customer-number")
	private WebElement loginID;
	
	@FindBy (id="customer-number-login")
	private WebElement continueBtn;
	
	@FindBy (id="login-button")
	private WebElement loginBtn;
	
	@FindBy (xpath="(//li[@class='row-element']/descendant::dd[@class='name col-size-1'])[2]")
	private WebElement selectAccount;
	
	@FindBy (id="approveButton")
	private WebElement approve;
	
	@FindBy (id="pin-1")
	private WebElement pin1;
	
	@FindBy (id="pin-2")
	private WebElement pin2;
	
	@FindBy (id="pin-3")
	private WebElement pin3;
	
	@FindBy (id="password-1")
	private WebElement pass1;
	
	@FindBy (id="password-2")
	private WebElement pass2;
	
	@FindBy (id="password-3")
	private WebElement pass3;
	
	public RBSBankPageD(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRbsCancel() {
		return rbsCancel;
	}

	public WebElement getLoginID() {
		return loginID;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSelectAccount() {
		return selectAccount;
	}

	public WebElement getApprove() {
		return approve;
	}

	public WebElement getPin1() {
		return pin1;
	}

	public WebElement getPin2() {
		return pin2;
	}

	public WebElement getPin3() {
		return pin3;
	}

	public WebElement getPass1() {
		return pass1;
	}

	public WebElement getPass2() {
		return pass2;
	}

	public WebElement getPass3() {
		return pass3;
	}
	
	
}
