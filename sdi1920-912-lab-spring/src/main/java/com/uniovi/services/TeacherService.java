package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	
	@Autowired
	private TeacherRepository teacherRepository; 


	

	public List<Teacher> getTeachers(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
		}
		public Teacher getTeacher(Long id){
		return teacherRepository.findById(id).get();
		}
		public void addTeacher(Teacher teacher){
		// Si en Id es null le asignamos el ultimo + 1 de la lista
			teacherRepository.save(teacher);
		}
		public void deleteTeacher(Long id){
			teacherRepository.deleteById(id);
		}
		
		
		public Teacher getTeacherByDni(String dni) {
			return teacherRepository.findByDni(dni);
		}
		

	
	
	
	
//	public List<Teacher> getTeachers() {
//		return teachers;
//	}
//
//	public void setTeachers(List<Teacher> teachers) {
//		this.teachers = teachers;
//	}
//
//	public void addTeacher(Teacher teacher) {
//		if(teacher.getId() != null) {
//			teachers.add(teacher);
//		}
//	}
//	
//	public void deleteTeacher(Long id) {
//		for (Teacher teacher : teachers) {
//			if(teacher.getId().equals(id)) {
//				teachers.remove(teacher);
//			}
//		}
//	}
//	
//	public Teacher getTeacher(Long id) {
//		for (Teacher teacher : teachers) {
//			if(teacher.getId().equals(id)) {
//				return teacher;
//			}
//		}
//		return null;
//	}
}
