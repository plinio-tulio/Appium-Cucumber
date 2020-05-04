package br.com.automacao.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.entity.Produto;

public class RegistrosProdutoPage extends BasePage {

	public void acessarTelaCadastroProduto() {
		clique(By.xpath("//android.widget.Button[@text='NEW']"));
	}

	public Produto obterProdutoCadastrado() {
		Produto produto = new Produto();
		produto.setCodigo(obterTexto(By.id("br.com.pztec.estoque:id/txt_codigo")));
		produto.setDescricao(obterTexto(By.id("br.com.pztec.estoque:id/txt_descricao")));
		produto.setUnidade(obterTexto(By.id("br.com.pztec.estoque:id/txt_unidade")));
		produto.setQuantidade(new BigDecimal(obterTexto(By.id("br.com.pztec.estoque:id/txt_quantidade"))));
		produto.setValorUnitario(new BigDecimal(obterTexto(By.id("br.com.pztec.estoque:id/txt_valunit")).replace(",", ".")));
		produto.setLote(Integer.parseInt(obterTexto(By.id("br.com.pztec.estoque:id/txt_lote"))));
		produto.setDataExpiracao(obterTexto(By.id("br.com.pztec.estoque:id/txt_validade")));

		return produto;
	}

	public String obterTituloTela() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Product Registration']"));
	}

	public void cliqueBotaoIncluirEstoque() {
		clique(By.id("br.com.pztec.estoque:id/entrada"));
	}

	public void cliqueBotaoRetirarEstoque() {
		clique(By.id("br.com.pztec.estoque:id/saida"));
	}

	public void excluirProduto() {
		clique(By.id("br.com.pztec.estoque:id/deletar"));
		clique(By.xpath("//android.widget.Button[@text='YES']"));
	}

}