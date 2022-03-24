package ar.com.intrale.messages;

import javax.validation.constraints.NotBlank;

import edu.umd.cs.findbugs.annotations.NonNull;

public class DeliveryLocationMessage {
	
	private String deliveryLocationId;

	@NonNull
    @NotBlank
	private String businessName;
	
	@NonNull
    @NotBlank
	private String email;
	
	@NonNull
    @NotBlank
	private String street;
	
	@NonNull
    @NotBlank
	private String number;
	
	private String details;

	@NonNull
    @NotBlank
	private String country;
	
	@NonNull
    @NotBlank
	private String region;
	
	@NonNull
    @NotBlank
	private String location;

	@NonNull
    @NotBlank
	private String postalCode;
	
	public String getDeliveryLocationId() {
		return deliveryLocationId;
	}

	public void setDeliveryLocationId(String deliveryLocationId) {
		this.deliveryLocationId = deliveryLocationId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
