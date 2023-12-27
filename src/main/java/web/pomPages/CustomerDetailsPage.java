package web.pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {

	@FindBy(xpath="(//input[@class='input'])[1]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="(//input[@class='input'])[2]")
	private WebElement fullname;
	
	@FindBy(xpath="(//input[@class='input'])[3]")
	private WebElement address;
	
	@FindBy(id="birthdate")
	private WebElement birthDate;
	
	@FindBy(xpath="(//input[@class='input'])[4]")
	private WebElement country;
	
	@FindBy(xpath="(//input[@class='input'])[5]")
	private WebElement occupation;
	
	@FindBy(xpath="(//input[@class='input'])[6]")
	private WebElement sourceeOfIncome;
	
	@FindBy(xpath="//input[@class='search-input']")
	private WebElement searchBox;
	
	@FindBy(xpath="(//p[@class='option-txt'])[1]")
	private WebElement option1;
	
	@FindBy(xpath="//button[@class='btn go-to-bank']")
	private WebElement proceedButton;
	
	@FindBy(xpath="//label[@class='input-label-error']")
	private WebElement errorMessage;
	
	@FindBys({@FindBy(how=How.XPATH, using="//p[@class='option-txt']")})
	public List<WebElement> options;
	
	public CustomerDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getMobileNumber() {
		return mobileNumber;
	}
	
	public void enterMobileNumber(String key) {
		 mobileNumber.sendKeys(key);
	}

	public WebElement getFullName() {
		return fullname;
	}

	public void enterFullName(String key) {
		fullname.sendKeys(key);
	}
	
	public WebElement getAddress() {
		return address;
	}
	
	public void enterAddress(String key) {
		address.sendKeys(key);
	}


	public WebElement getBirthDate() {
		return birthDate;
	}
	
	public WebElement getCountry() {
		return country;
	}

	public void clickCountry() {
		country.click();
	}
	
	public WebElement getOccupation() {
		return occupation;
	}
	
	public void clickOccupation() {
		occupation.click();
	}

	public WebElement getSourceOfIncome() {
		return sourceeOfIncome;
	}
	
	public void clickSourceOfIncome() {
		sourceeOfIncome.click();
	}
	
	public void sendKeysSearchBox(String key) {
		 searchBox.sendKeys(key);
	}
	
	public WebElement getSearchBox()
	{
		return searchBox;
	}
	
	public void clickOption1()
	{
		option1.click();
	}

	public void clickProceedButton() {
		proceedButton.click();
	}
	
	public WebElement getProceedButton() {
		return proceedButton;
	}

	public String getErrorMessage() {
		
		return errorMessage.getText();
	}
	
	public List<WebElement> getOptions()
	{
		return options;
	}
}
