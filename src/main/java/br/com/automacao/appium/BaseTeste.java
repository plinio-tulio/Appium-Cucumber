package br.com.automacao.appium;

import java.io.File;

import org.junit.AfterClass;

import com.cucumber.listener.Reporter;

import br.com.automacao.appium.core.DriverFactory;

public class BaseTeste {

	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
		Reporter.loadXMLConfig(new File("config/report.xml"));
	}

}