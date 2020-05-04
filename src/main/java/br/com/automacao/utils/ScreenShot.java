package br.com.automacao.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.automacao.appium.core.DriverFactory;

public class ScreenShot {

	public static void gerarScreenShot(String nome) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("target/screenshots/" + nome + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
