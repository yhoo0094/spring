package co.company.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.company.spring.dao.Emp;

public class EmpValidator implements Validator {

	public final static String emailRegExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public EmpValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp = (Emp)target;
		if(emp.getLastName() == null || emp.getLastName().trim().isEmpty()) {
			errors.rejectValue("lastName", "required" , new Object[] {"성은"}, "");
		}
		
//		if(emp.getFirstName() == null || emp.getFirstName().trim().isEmpty()) {
//			errors.rejectValue("firstName", "required");
//		}
		
		//이메일형식(@.)
		if(emp.getEmail() == null || emp.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required", new Object[] {"이메일은"}, "");
			
		} else {
			Matcher matcher = pattern.matcher(emp.getEmail());
			if(! matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobId", "required", new Object[] {"직무는"}, "");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required", new Object[] {"이름은"}, "");
	}
	
	
	
}
