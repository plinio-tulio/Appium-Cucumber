package br.com.automacao.appium;

import static br.com.automacao.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clique(By by) {
		getDriver().findElement(by).click();
	}

	public void esconderTeclado() {
		if (getDriver().isKeyboardShown()) {
			getDriver().hideKeyboard();
		}
	}
}