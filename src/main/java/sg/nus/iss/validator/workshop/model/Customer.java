package sg.nus.iss.validator.workshop.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Customer {
	@Size(min=2, max=30, message="Name must be 2-30 characters long")
	private String name;
	
	@Email(message="Please provide a valid email")
	@NotBlank(message="Email is required")
	private String email;
	
	private String gender;
	private String creditCardNumber;
	private String creditCardExpiration;
	private String creditCardCVV;
	
	public Customer() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getCreditCardExpiration() {
		return creditCardExpiration;
	}
	public void setCreditCardExpiration(String creditCardExpiration) {
		this.creditCardExpiration = creditCardExpiration;
	}
	public String getCreditCardCVV() {
		return creditCardCVV;
	}
	public void setCreditCardCVV(String creditCardCVV) {
		this.creditCardCVV = creditCardCVV;
	}
	
	
	
}
