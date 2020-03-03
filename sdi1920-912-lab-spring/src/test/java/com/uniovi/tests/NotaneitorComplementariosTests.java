package com.uniovi.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_View;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NotaneitorComplementariosTests {
	
	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
		// automáticas)):
		static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		static String Geckdriver024 = "C:\\Users\\Adnan\\Downloads\\3º Segundo Semestre\\SDI\\Practica\\Material\\P5\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
		// En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens
		// automáticas):
//		 static String PathFirefox65 ="/Applications/Firefox.app/Contents/MacOS/firefox-bin";
//		 static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
		// Común a Windows y a MACOSX
		static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
		static String URL = "http://localhost:8090";

		public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
			System.setProperty("webdriver.firefox.bin", PathFirefox);
			System.setProperty("webdriver.gecko.driver", Geckdriver);
			WebDriver driver = new FirefoxDriver();
			return driver;
		}

		// Antes de cada prueba se navega al URL home de la aplicaciónn
		@Before
		public void setUp() {
			driver.navigate().to(URL);
		}

		// Después de cada prueba se borran las cookies del navegador
		@After
		public void tearDown() {
			driver.manage().deleteAllCookies();
		}

		// Antes de la primera prueba
		@BeforeClass
		static public void begin() {
		}

		// Al finalizar la última prueba
		@AfterClass
		static public void end() {
			// Cerramos el navegador al finalizar las pruebas
			driver.quit();
		}
		
		@Test
		public void PR1() {
			// Vamos al formulario de logueo.
			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
			// Rellenamos el formulario
			PO_LoginView.fillForm(driver, "99999988F", "123456");
			// COmprobamos que entramos en la pagina privada del Profesor
			//PO_PrivateView.checkPrivatePageTeacher(driver, "99999988F");
			// Pinchamos en la opción de menu de Profesores: //li[contains(@id, 'marks-menu')]/a
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'teachers-menu')]/a");
			elementos.get(0).click();
			// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
			// 'mark/add')]
			elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'teacher/add')]");
			// Pinchamos en agregar Nota.
			elementos.get(0).click();
			// Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
			PO_PrivateView.fillFormAddTeacher(driver, "99962988G", "dddd", "ffff", "ggggg", 0);
			// Comprobamos que aparece la nota en la pagina
			elementos = PO_View.checkElement(driver, "text", "99966988G");
			// Ahora nos desconectamos
			PO_PrivateView.logout(driver);
		}
		
		//Pruebas Modificar registro de un profesor
		
		@Test
		public void PR2() {
			// Vamos al formulario de logueo.
			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
			// Rellenamos el formulario
			PO_LoginView.fillForm(driver, "99999988F", "123456");
			// COmprobamos que entramos en la pagina privada del Profesor
			//PO_PrivateView.checkPrivatePageTeacher(driver, "99999988F");
			// Pinchamos en la opción de menu de Profesores: //li[contains(@id, 'marks-menu')]/a
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'teachers-menu')]/a");
			elementos.get(0).click();
			
			elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'teacher/list')]");
			// Pinchamos en agregar Nota.
			elementos.get(0).click();
			// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
			PO_HomeView.clickOption(driver, "teacher/edit", "class", "btn btn-primary");
		
			// Comprobamos que aparece la nota en la pagina
			elementos = PO_View.checkElement(driver, "text", "Editar Profesor");

		}

}
