package api.call;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import api.endpoints.Endpoints;
import api.payload.Login;
import api.payload.ProcessPayment;
import api.payload.SendOtp;
import api.payload.VerifyOtp;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import web.utilities.PropertyFile;
import web.utilities.WebDriverUtilities;


/**
 * The class contains methods to initiate the payload variables passed in the apis and getting the response from apis
 */
public class Call {
	public PropertyFile pdata=new PropertyFile();
	public Response response;
	public String storeId;
	public String paymentUrl;
	public ProcessPayment payload;	
	public SendOtp sendOtpPayload;
	public VerifyOtp verifyOtpPayload;
	public Login loginPayload;
	public WebDriver driver;
	public WebDriverUtilities utilities=new WebDriverUtilities();
	public SoftAssert sa=new SoftAssert();

//	@Parameters({"env", "browserName", "customerId", "orderId", "amount", "currency", 
//		"institutionId", "storeId", "paymentType", "autoRedirect", "phoneCountryCode", 
//		"phoneNumber", "email","firstName", "lastName","callBackParameter","expiresIn",
//		"enableTips","allowRetry", "strictExpiry", "redirectUrl", "splitBill", "template"})
	
	public void processPaymentPayload(String env, String browserName,String customerId,String orderId,String amount,String currency,
			String institutionId,String storeId,String paymentType,boolean autoRedirect,String phoneCountryCode,
			String phoneNumber,String email,String firstName,String lastName,String callBackParameter,String expiresIn,
			boolean enableTips,boolean allowRetry,boolean strictExpiry,String redirectUrl,boolean splitBill,
			String template) throws JSONException
	{
		payload = new ProcessPayment();
		payload.setCustomerId(customerId);
		payload.setOrderId(orderId);
		payload.setAmount(amount);
		payload.setCurrency(currency);
		payload.setInstitutionId(institutionId);
		payload.setStoreId(storeId);
		payload.setPaymentType(paymentType);
		payload.setAutoRedirect(autoRedirect);
		
		payload.setPhoneCountryCode(phoneCountryCode);
		payload.setPhoneNumber(phoneNumber);
		payload.setEmail(email);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		
		payload.setCallBackParameter(callBackParameter);
		payload.setExpiresIn(expiresIn);
		payload.setEnableTips(enableTips);
		payload.setAllowRetry(allowRetry);
		payload.setStrictExpiry(strictExpiry);
		payload.setRedirectUrl(redirectUrl);
		payload.setSplitBill(splitBill);
		payload.setTemplate(template);		
		
		payload.setConsumerDetails();
		payload.setCallbackParams();
			
	}
	
	public void sendOtpPayload(String phoneCountryCode,String phoneNumber)
	{
		sendOtpPayload = new SendOtp();
		sendOtpPayload.setPhoneCountryCode(phoneCountryCode);
		sendOtpPayload.setPhoneNumber(phoneNumber);
	}
	
	public void verifyOtpPayload (String phoneCountryCode,String phoneNumber, String otp)
	{
		verifyOtpPayload = new VerifyOtp();
		verifyOtpPayload.setPhoneCountryCode(phoneCountryCode);
		verifyOtpPayload.setPhoneNumber(phoneNumber);
		verifyOtpPayload.setOtp(otp);
	}
	
	public void loginPayload(String phoneCountryCode,String phoneNumber, boolean isEmployee)
	{
		loginPayload = new Login();
		loginPayload.setPhoneCountryCode(phoneCountryCode);
		loginPayload.setPhoneNumber(phoneNumber);
		loginPayload.setIsEmployee(isEmployee);
	}
	
	public WebDriver setUp(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		return driver;
	}
	
	@AfterMethod
	public void closeApp()
	{
		if(driver!=null)
		driver.quit();
	}
	
	@AfterTest
	public void assertAll()
	{
		sa.assertAll();
	}
	
	public String getProcessPaymentUrl(String bearerToken, String urlType)
	{
		Response response=Endpoints.generatePayment(payload,bearerToken);
		String jsonString = response.getBody().asString();
		return JsonPath.from(jsonString).get(urlType);
	}
	
	public Response getProcessPaymentResponse(String bearerToken)
	{
		return Endpoints.generatePayment(payload,bearerToken);
	}
	
	public String getStoreId(String bearerToken)
	{
		Response response = Endpoints.getStores(bearerToken,"0");
		JsonPath json=response.jsonPath();
		List<String>ids = json.getList("data.id");
		
		if(ids!=null)
		{	
			return ids.get(0).toString();
		}
		else 
		{
			return response.asString();
		}
	}
	
	public Response getStoreResponse(String bearerToken,String pageNumber)
	{
		return Endpoints.getStores(bearerToken,pageNumber);
		
	}
	
	public void sendOtp()
	{
		
		Endpoints.sendOtp(sendOtpPayload);
		
	}
	
	public String verifyOtp()
	{
		
		Response response = Endpoints.verifyOtp(verifyOtpPayload);
	
		return JsonPath.from(response.getBody().asString()).get("otpVerifiedToken");
		
	}
	
	public String login( String bearerToken)
	{
		
		Response response = Endpoints.login(loginPayload, bearerToken);
	
		return JsonPath.from(response.getBody().asString()).get("token");
		
	}
	
	public Response cancelPaymentApiCall( String bearerToken,String paymentRequestId)
	{		
		return  Endpoints.cancelPayment( bearerToken,paymentRequestId);		
	}
	
	public Response getPaymentStatusApiCall( String bearerToken,String paymentRequestId)
	{
		return Endpoints.getPaymentStatus( bearerToken,paymentRequestId);	
	}
}
