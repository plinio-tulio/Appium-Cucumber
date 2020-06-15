package br.com.automacao.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;

import br.com.automacao.appium.BasePage;
import br.com.automacao.entity.Produto;
import br.com.automacao.utils.FakerUtils;

public class RegistrosProdutoPage extends BasePage {
	
	By botaoNew = By.xpath("//android.widget.Button[@text='NEW']");
	By campoCodigo = By.id("br.com.pztec.estoque:id/txt_codigo");
	By campoDescricao = By.id("br.com.pztec.estoque:id/txt_descricao");
	By campoUnidade = By.id("br.com.pztec.estoque:id/txt_unidade");
	By campoQuantidade = By.id("br.com.pztec.estoque:id/txt_quantidade");
	By campoValorUnitario = By.id("br.com.pztec.estoque:id/txt_valunit");
	By campoLote = By.id("br.com.pztec.estoque:id/txt_lote");
	By campoDataExpiracao = By.id("br.com.pztec.estoque:id/txt_validade");
	By tituloTela = By.xpath("//android.widget.TextView[@text='Product Registration']");
	By botaoEntrada = By.id("br.com.pztec.estoque:id/entrada");
	By botaoSaida = By.id("br.com.pztec.estoque:id/saida");
	By botaoRemover = By.id("br.com.pztec.estoque:id/deletar");
	By botaoConfirmarRemover = By.xpath("//android.widget.Button[@text='YES']");
	
	public void acessarTelaCadastroProduto() {
		clique(botaoNew);
	}

	public Produto obterProdutoCadastrado() {
		
		Produto produto = Produto.builder()
				.descricao(obterTexto(campoDescricao))
				.codigo(obterTexto(campoCodigo))
				.unidade(obterTexto(campoUnidade))
				.quantidade(new BigDecimal(obterTexto(campoQuantidade)))
				.valorUnitario(new BigDecimal(obterTexto(campoValorUnitario).replace(",", ".")))
				.lote(Integer.parseInt(obterTexto(campoLote)))
				.dataExpiracao(obterTexto(campoDataExpiracao))
				.build();		
		return produto;
	}

	public String obterTituloTela() {
		return obterTexto(tituloTela);
	}

	public void cliqueBotaoIncluirEstoque() {
		clique(botaoEntrada);
	}

	public void cliqueBotaoRetirarEstoque() {
		clique(botaoSaida);
	}

	public void excluirProduto() {
		clique(botaoRemover);
		clique(botaoConfirmarRemover);
	}

}