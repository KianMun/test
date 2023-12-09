package sg.nus.iss.validator.workshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.nus.iss.validator.workshop.model.Customer;

@Component
public class CustomerValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) 
	{
		return Customer.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) 
	{
		//Create customer object
		Customer customer = (Customer) obj;
		
		//Get customer attributes
		String gender = customer.getGender();
		String cardNumber = customer.getCreditCardNumber();
		String cardExpiration = customer.getCreditCardExpiration();
		String cardCVV = customer.getCreditCardCVV();
		
		//Check gender
		if(!gender.isBlank()) 
		{
			if(!gender.equalsIgnoreCase("Male") 
					&& !gender.equalsIgnoreCase("Female")
					&& !gender.equalsIgnoreCase("Other")) 
			{
				errors.rejectValue("gender", "error.gender", "Gender must be either Male, Female or Other");
			}
		}
		
		//Check cardNumber, cardExpiration, cardCVV
		//Check if either is not blank, then the rest is mandatory
		if(!cardNumber.isBlank() ||
				!cardExpiration.isBlank() ||
				!cardCVV.isBlank()) 
		{
			if(cardNumber.isBlank()) 
			{
				errors.rejectValue("creditCardNumber", "error.creditCardNumber", "Credit Card Number is Required");
			}
			
			if(cardExpiration.isBlank()) 
			{
				errors.rejectValue("creditCardExpiration", "error.creditCardExpiration", "Credit Card Expiration date is Required");
			}
			
			if(cardCVV.isBlank()) 
			{
				errors.rejectValue("creditCardCVV", "error.creditCardCVV", "Credit Card CVV is Required");
			}
		}
		
	}
}
