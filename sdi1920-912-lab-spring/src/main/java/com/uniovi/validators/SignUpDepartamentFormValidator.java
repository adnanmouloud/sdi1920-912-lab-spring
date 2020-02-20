package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Departamento;
import com.uniovi.services.DepartamentService;

@Component
public class SignUpDepartamentFormValidator implements Validator {

	
	@Autowired
	private DepartamentService departamentService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Departamento.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Departamento departament = (Departamento) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "Error.empty");
		
		if (departament.getDescripcion().length() < 5 || departament.getDescripcion().length() > 24) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
	
	}
}
