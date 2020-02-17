package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Departamento;
import com.uniovi.repositories.DepartamentRepository;

@Service
public class DepartamentService {
	
	@Autowired
	private DepartamentRepository departamentRepository;
	
	public List<Departamento> getDepartaments() {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		departamentRepository.findAll().forEach(departamentos::add);
		return departamentos;
	}
	
	

	public Departamento getDepartaments(Long id) {
		return departamentRepository.findById(id).get();
	}

	public void addDepartamento(Departamento departamento) {
		departamentRepository.save(departamento);
	}
	
	public Departamento getDepartamentoById(Long id) {
		return departamentRepository.findById(id).get();
		}

	public void deleteDepartamento(Long id) {
		departamentRepository.deleteById(id);
	}

}
