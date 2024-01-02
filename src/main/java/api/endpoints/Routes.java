package api.endpoints;

/**
 * This class contains all the api url
 */
public class Routes {
	
	//Base url
	
	public static String baseUrl="https://api.atoa.me/api";
	
	
	//Api Endpoints
	
	public static String processPaymentUrl = baseUrl+"/payments/process-payment";
	public static String getStoresUrl = baseUrl+"/payments/stores";
	public static String cancelPaymentUrl = baseUrl+"/payment-request/cancel/";
	public static String getPaymentStatusUrl=baseUrl+"/payments/v1/payment-status/";
	public static String sendOtpUrl = baseUrl+"/otp/v1/send-otp";
	public static String verifyOtpUrl = baseUrl+"/otp/verify-otp";
	public static String loginUrl = baseUrl+"/auth/login-otp";

}
