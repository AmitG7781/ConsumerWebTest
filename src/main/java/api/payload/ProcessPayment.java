package api.payload;

import java.util.HashMap;
import java.util.Map;

/**
 * The class contains payload variables and initialization methods for processPayment api
 */
public class ProcessPayment 
{

	String customerId;
    Map consumerDetails;
	String phoneCountryCode;
	String phoneNumber;
    String email;
	String firstName;
	String lastName;
    String orderId;
    String amount;
    String currency;
    String institutionId;
    String paymentType;
    boolean autoRedirect;
    Map  callbackParams;
    String callBackParameter;
    String expiresIn;
    boolean enableTips;
    String storeId;
    boolean strictExpiry;
    boolean allowRetry;
    String redirectUrl;
    boolean splitBill;
    String template;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Map getConsumerDetails() {
		return consumerDetails;
	}
	public void setConsumerDetails() {
		consumerDetails = new HashMap();
		consumerDetails.put(this.phoneCountryCode,phoneCountryCode);
		consumerDetails.put(this.phoneNumber,phoneNumber);
		consumerDetails.put(this.email,email);
		consumerDetails.put(this.firstName,firstName);
		consumerDetails.put(this.lastName,lastName);
		
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isAutoRedirect() {
		return autoRedirect;
	}
	public void setAutoRedirect(boolean autoRedirect) {
		this.autoRedirect = autoRedirect;
	}
	public Map getCallbackParams() {
		return callbackParams;
	}
	public void setCallbackParams() {
		callbackParams = new HashMap();
		callbackParams.put(this.callBackParameter,callBackParameter);
	}
	public String getCallBackParameter() {
		return callBackParameter;
	}
	public void setCallBackParameter(String callBackParameter) {
		this.callBackParameter = callBackParameter;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public boolean isEnableTips() {
		return enableTips;
	}
	public void setEnableTips(boolean enableTips) {
		this.enableTips = enableTips;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public boolean isStrictExpiry() {
		return strictExpiry;
	}
	public void setStrictExpiry(boolean strictExpiry) {
		this.strictExpiry = strictExpiry;
	}
	public boolean isAllowRetry() {
		return allowRetry;
	}
	public void setAllowRetry(boolean allowRetry) {
		this.allowRetry = allowRetry;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public boolean isSplitBill() {
		return splitBill;
	}
	public void setSplitBill(boolean splitBill) {
		this.splitBill = splitBill;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
    
    
    
    
}
