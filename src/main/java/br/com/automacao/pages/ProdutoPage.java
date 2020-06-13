package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.entity.Produto;

public class ProdutoPage extends BasePage {
	
	By campoCodigo = By.id("br.com.pztec.estoque:id/txt_codigo");
	By campoDescricao = By.id("br.com.pztec.estoque:id/txt_descricao");
	By campoUnidade = By.id("br.com.pztec.estoque:id/txt_unidade");
	By campoQuantidade = By.id("br.com.pztec.estoque:id/txt_quantidade");
	By campoValorUnitario = By.id("br.com.pztec.estoque:id/txt_valunit");
	By campoLote = By.id("br.com.pztec.estoque:id/txt_lote");
	By botaoGravar = By.id("br.com.pztec.estoque:id/btn_gravar_assunto");
			
	public void preencherTodosCampos(Produto produto) {
		escrever(campoCodigo, produto.getCodigo());
		escrever(campoDescricao, produto.getDescricao());
		escrever(campoUnidade, produto.getUnidade());
		esconderTeclado();
		escrever(campoQuantidade, produto.getQuantidade().toString());
		escrever(campoValorUnitario, produto.getValorUnitario().toString());
		escrever(campoLote, produto.getLote().toString());
	}

	public void salvar() {
		clique(botaoGravar);
	}

}