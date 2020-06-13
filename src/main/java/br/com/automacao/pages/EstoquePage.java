package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;

public class EstoquePage extends BasePage {
	
	By campoMotivo = By.id("br.com.pztec.estoque:id/txt_motivo");
	By campoReferencia = By.id("br.com.pztec.estoque:id/txt_referencia");
	By campoQuantidadeEntrada = By.id("br.com.pztec.estoque:id/txt_qtdentrada") ;
	By campoQuantidadeSaida = By.id("br.com.pztec.estoque:id/txt_qtdsaida");
	By campoQuantidadeAtual = By.id("br.com.pztec.estoque:id/txt_qtdatual");
	By botaoSalvar = By.id("br.com.pztec.estoque:id/btn_salvar");

	public void preencherCampoMotivo() {
		escrever(campoMotivo, "motivo");
	}

	public void preencherCampoReferencia() {
		escrever(campoReferencia, "ref");
	}

	public void preencherCampoEntrada(String entrada) {
		escrever(campoQuantidadeEntrada, entrada);
	}

	public void preencherCampoRetirada(String retirada) {
		escrever(campoQuantidadeSaida, retirada);
	}

	public String obterEstoqueAtual() {
		return obterTexto(campoQuantidadeAtual);
	}

	public void salvar() {
		clique(botaoSalvar);
	}

}