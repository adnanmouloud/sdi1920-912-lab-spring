package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;
@Component
public class SignUpTeacherFormValidator implements Validator {
	
	@Autowired
	private TeacherService teacherService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Teacher.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Teacher teacher = (Teacher) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");

		
		if(teacherService.getTeacherByDni((teacher.getDni())) != null) {
			errors.rejectValue("dni", "Error.signup.dni.duplicate");
		}
		
		if(teacher.getDni().length()!=9) {
			errors.rejectValue("dni", "Error.signup.dni.nine.characters");
		}
		
		if(!Character.isLetter(teacher.getDni().charAt(teacher.getDni().length()-1))) {
			errors.rejectValue("dni", "Error.signup.dni.last.character");
		}

	}

}
