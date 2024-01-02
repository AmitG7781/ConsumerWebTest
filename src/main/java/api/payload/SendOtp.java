package api.payload;

/**
 * The class contains payload variables and initialization methods for sendOtp api
 */
public class SendOtp {
	
	String phoneCountryCode;
	String phoneNumber;
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
