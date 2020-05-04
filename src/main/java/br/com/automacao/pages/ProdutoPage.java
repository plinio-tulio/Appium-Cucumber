package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.entity.Produto;

public class ProdutoPage extends BasePage {

	public void preencherTodosCampos(Produto produto) {
		escrever(By.id("br.com.pztec.estoque:id/txt_codigo"), produto.getCodigo());
		escrever(By.id("br.com.pztec.estoque:id/txt_descricao"), produto.getDescricao());
		escrever(By.id("br.com.pztec.estoque:id/txt_unidade"), produto.getUnidade());
		esconderTeclado();
		escrever(By.id("br.com.pztec.estoque:id/txt_quantidade"), produto.getQuantidade().toString());
		escrever(By.id("br.com.pztec.estoque:id/txt_valunit"), produto.getValorUnitario().toString());
		escrever(By.id("br.com.pztec.estoque:id/txt_lote"), produto.getLote().toString());
	}

	public void salvar() {
		clique(By.id("br.com.pztec.estoque:id/btn_gravar_assunto"));

	}

}