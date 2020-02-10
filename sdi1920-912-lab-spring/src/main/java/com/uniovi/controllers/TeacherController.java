package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/teacher/list")
	public String getList(@PathVariable Long id) {
		
		return teacherService.getTeachers().toString();
	

	}
	

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(@PathVariable Long id) {
		
		return teacherService.getTeacher(id).toString();
	

	}
	
	@RequestMapping("/teacher/edit")
	public String setTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "Editing teacher";

	}

	@RequestMapping("/teacher/add")
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "Adding teacher";

	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "Deleting teacher "+id;
	}
}
