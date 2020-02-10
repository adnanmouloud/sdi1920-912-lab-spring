package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeacherService {

	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void addTeacher(Teacher teacher) {
		if(teacher.getId() != null) {
			teachers.add(teacher);
		}
	}
	
	public void deleteTeacher(Long id) {
		for (Teacher teacher : teachers) {
			if(teacher.getId().equals(id)) {
				teachers.remove(teacher);
			}
		}
	}
	
	public Teacher getTeacher(Long id) {
		for (Teacher teacher : teachers) {
			if(teacher.getId().equals(id)) {
				return teacher;
			}
		}
		return null;
	}
}
