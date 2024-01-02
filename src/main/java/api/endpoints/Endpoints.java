package api.endpoints;
import api.payload.Login;
import api.payload.ProcessPayment;
import api.payload.SendOtp;
import api.payload.VerifyOtp;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * The class contains methods to arrange the api payload and call the api
 */
public class Endpoints {
	
	public static Response generatePayment(ProcessPayment payload, String bearerToken)
	{
		Response response=RestAssured.given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		    .post(Routes.processPaymentUrl);
		
		return response;
	}
	
	public static Response getStores(String bearerToken, String pageNumber)
	{
		Response response=RestAssured.given()
			.header("Authorization","Bearer "+bearerToken)
		.when()
			.param("page", pageNumber)
		    .get(Routes.getStoresUrl);
		
		return response;
	}
	
	public static Response cancelPayment(String bearerToken,String paymentRequestId)
	{
		Response response=RestAssured.given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
		    .post(Routes.cancelPaymentUrl.concat(paymentRequestId));
		return response;
	}
	
	public static Response getPaymentStatus(String bearerToken,String paymentRequestId)
	{
		Response response=RestAssured.given()
				.header("Authorization","Bearer "+bearerToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				//.param("env", "sandbox")
		.when()
		    .get(Routes.getPaymentStatusUrl.concat(paymentRequestId)+"?env=sandbox");
		
		return response;
	}
	
	public static Response sendOtp(SendOtp sendOtpPayload)
	{
		Response response=RestAssured.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(sendOtpPayload)
		.when()
		    .post(Routes.sendOtpUrl);
		
		return response;
	}
	
	public static Response verifyOtp(VerifyOtp payload)
	{
		Response response=RestAssured.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		    .post(Routes.verifyOtpUrl);
		
		return response;
	}
	
	public static Response login(Login payload, String bearerToken)
	{
		Response response=RestAssured.given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		    .post(Routes.loginUrl);
		
		return response;
	}
	
	
}
