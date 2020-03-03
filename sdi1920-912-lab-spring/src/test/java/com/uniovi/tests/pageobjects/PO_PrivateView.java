package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.utils.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {

	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);

		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);

		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

	static public void fillFormAddTeacher(WebDriver driver, String dnip, String nombrep, String apellidosp,
			String categoriap, int departamentId) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);

		// Rellenemos el campo de descripción
		WebElement dni = driver.findElement(By.name("dni"));
		dni.clear();
		dni.sendKeys(dnip);
		WebElement nombre = driver.findElement(By.name("nombre"));
		nombre.click();
		nombre.clear();
		nombre.sendKeys(nombrep);
		WebElement apellidos = driver.findElement(By.name("apellidos"));
		apellidos.click();
		apellidos.clear();
		apellidos.sendKeys(apellidosp);
		WebElement categoria = driver.findElement(By.name("categoria"));
		categoria.click();
		categoria.clear();
		categoria.sendKeys(categoriap);

		// Seleccionamos el departamento userOrder

			new Select(driver.findElement(By.id("departament"))).selectByIndex(departamentId);
		
		

		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

	static public void logout(WebDriver driver) {
		PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
	}

	static public void checkPrivatePageUser(WebDriver driver) {
		PO_View.checkElement(driver, "text", "Notas del usuario");
	}

	static public void checkPrivatePageTeacher(WebDriver driver, String dni) {
		PO_View.checkElement(driver, "text", dni);
	}

}