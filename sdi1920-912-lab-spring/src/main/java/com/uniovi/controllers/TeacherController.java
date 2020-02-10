package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("markList", teacherService.getTeachers());
		return "teacher/list";
	

	}
	

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher/details";

	}
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setMark(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "redirect:/teacher/list";

	}

	@RequestMapping("/teacher/add")
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "Adding teacher";

	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "redirect:/teacher/list";
	}
}
