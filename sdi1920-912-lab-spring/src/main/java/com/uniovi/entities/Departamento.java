package com.uniovi.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue
	private Long id;
	private String descripcion;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private Set<Teacher> profesores;

	public Departamento(Long id, String descripcion, Set<Teacher> profesores) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.profesores = profesores;
	}

	public Departamento() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Teacher> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Teacher> profesores) {
		this.profesores = profesores;
	}

}
