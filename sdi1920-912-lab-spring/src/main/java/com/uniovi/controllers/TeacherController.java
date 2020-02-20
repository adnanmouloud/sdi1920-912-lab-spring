package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.services.DepartamentService;
import com.uniovi.services.TeacherService;
import com.uniovi.validators.SignUpTeacherFormValidator;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private DepartamentService departamentsService;
	
	@Autowired
	private SignUpTeacherFormValidator signUpTeacherFormValidator;
	
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", teacherService.getTeachers());
		return "teacher/list";
	

	}
	

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher/details";

	}
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setTeacher(Model model,@ModelAttribute Teacher teacher,BindingResult result) {
		signUpTeacherFormValidator.validate(teacher, result);
		if(result.hasErrors()) {
			return "teacher/add";
		}
		teacherService.addTeacher(teacher);
		model.addAttribute("departamentsList", departamentsService.getDepartaments());
		return "redirect:/teacher/list";

	}

	@RequestMapping("/teacher/add")
	public String addTeacher(Model model, @ModelAttribute Teacher teacher) {
		model.addAttribute("departamentsList", departamentsService.getDepartaments());
		model.addAttribute("teacher", new Teacher());
		return "teacher/add";

	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "redirect:/teacher/list";
	}

	@RequestMapping(value = "/teacher/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher/edit";
	}

	@RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Teacher teacher) {
		teacher.setId(id);
		teacherService.addTeacher(teacher);
		return "redirect:/teacher/list";
		//"redirect:/teacher/details/" + id;
	}
}
