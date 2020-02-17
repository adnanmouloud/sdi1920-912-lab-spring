package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Departamento;
import com.uniovi.services.DepartamentService;
import com.uniovi.services.SecurityService;
import com.uniovi.validators.signUpDepartamentFormValidator;

@Controller
public class DepartamentController {

	
	@Autowired
	private DepartamentService departamentsService;

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private signUpDepartamentFormValidator signUpDepartamentFormValidator;

	@RequestMapping("/departament/list")
	public String getListado(Model model) {
		model.addAttribute("departamentsList", departamentsService.getDepartaments());
		return "departament/list";
	}

	@RequestMapping(value = "/departament/add")
	public String getDepartament(Model model) {
		model.addAttribute("departamentsList", departamentsService.getDepartaments());
		return "departament/add";
	}

	@RequestMapping(value = "/departament/add", method = RequestMethod.POST)
	public String setDepartament(@ModelAttribute Departamento departament, BindingResult result) {
		
		signUpDepartamentFormValidator.validate(departament, result);
		if(result.hasErrors()) {
			return "departament/add";
		}
		departamentsService.addDepartamento(departament);
		return "redirect:/departament/list";
	}

	@RequestMapping("/departament/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("departament", departamentsService.getDepartamentoById(id));
		return "departament/details";
	}

	@RequestMapping("/departament/delete/{id}")
	public String delete(@PathVariable Long id) {
		departamentsService.deleteDepartamento(id);
		return "redirect:/departament/list";
	}

	@RequestMapping(value = "/departament/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		Departamento departament = departamentsService.getDepartamentoById(id);
		model.addAttribute("departament", departament);
		return "departament/edit";
	}

	@RequestMapping(value = "/departament/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Departamento departament) {
		departament.setId(id);
		departamentsService.addDepartamento(departament);
		return "redirect:/departament/details/" + id;
	}




}
