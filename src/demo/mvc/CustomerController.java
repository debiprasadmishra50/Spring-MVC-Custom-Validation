package demo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	// The form will be passed for whitespace in the required field which should not happen, to resolve this issue
	// add an @InitBinder to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/customerform")
	public String showform(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		
		System.out.println("Last Name : |"+theCustomer.getLastName()+"|");
		
		System.out.println("Binding Result : "+theBindingResult);
		System.out.println("\n\n\n\n");
		
		if(theBindingResult.hasErrors())
			return "customerform";
		else
			return "customerconfirmation";
	}
}
