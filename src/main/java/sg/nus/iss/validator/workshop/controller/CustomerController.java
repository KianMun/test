package sg.nus.iss.validator.workshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sg.nus.iss.validator.workshop.model.Customer;
import sg.nus.iss.validator.workshop.validator.CustomerValidator;

@Controller
public class CustomerController {
	//Dependency injection customer validator
	@Autowired
	private CustomerValidator customerValidator;
	
	//Register customer validator using InitBinder
	@InitBinder
	private void initCustomerBinder(WebDataBinder binder) 
	{
		binder.addValidators(customerValidator);
	}
	
	@GetMapping("customer/create")
	public String createCustomer(Model model) 
	{
		model.addAttribute("customer", new Customer());
		return "create-customer";
	}
	
	@PostMapping("customer/create")
	public String saveCustomerAction(@Valid @ModelAttribute Customer customer,
			BindingResult bindingResult, Model model) 
	{
		//Need to explicitly @Valid and check BindingResult have errors
		if(bindingResult.hasErrors()) 
		{
			return "create-customer";
		}
		model.addAttribute("customer", customer);
		return "create-customer-success";
	}
}
