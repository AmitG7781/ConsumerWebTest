package api.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModeloLoginPageD 
{
//
	@FindBy (xpath="(//input[@class='ozone-input'])[1]")
	private WebElement usn;
	
	@FindBy (xpath="(//input[@class='ozone-input'])[2]")
	private WebElement pass;
	
	@FindBy (id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(id="cancelButton")
	private WebElement cancelBtn;
	
	@FindBy (id="id-10000109010102")
	private WebElement account1;
	
	@FindBy (xpath="//select[@class='form-control form-control-sm']")
	private WebElement confirmAccDD;
	
	@FindBy (xpath="//option[text()='Octon Inc (700001 - 70000005)']")
	private WebElement confirmAcc;
	
	@FindBy (id="confirmButton")
	private WebElement confirmBtn;
	
	@FindBy (xpath=" //a[text()=' Cancel']")
	private WebElement cancelButton;
	
	@FindBy (xpath="//option[text()='Mr. Mitsuhirato (700001 - 70000010)']")
	private WebElement succesfulPaymentAcc;
	
//	
	public ModeloLoginPageD(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//
	public WebElement getUsn() {
		return usn;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getConfirmAccDD() {
		return confirmAccDD;
	}

	public WebElement getConfirmAcc() {
		return confirmAcc;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getSuccesfulPaymentAcc() {
		return succesfulPaymentAcc;
	}

	public WebElement getAccount1() {
		return account1;
	}
	


	

	
}
