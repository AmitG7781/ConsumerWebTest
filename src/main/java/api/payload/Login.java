package api.payload;

/**
 * The class contains payload variables and initialization methods for login api
 */
public class Login {
	
	String phoneCountryCode;
	String phoneNumber;
	boolean isEmployee;
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
	public boolean getIsEmployee() {
		return isEmployee;
	}
	public void setIsEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}
