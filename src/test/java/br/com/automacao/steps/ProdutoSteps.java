package br.com.automacao.steps;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Assert;

import br.com.automacao.appium.BaseTeste;
import br.com.automacao.appium.core.DriverFactory;
import br.com.automacao.entity.Produto;
import br.com.automacao.factory.ProdutoFactory;
import br.com.automacao.pages.EstoquePage;
import br.com.automacao.pages.ProdutoPage;
import br.com.automacao.pages.RegistrosProdutoPage;
import br.com.automacao.utils.ScreenShot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProdutoSteps extends BaseTeste {
	
	private ProdutoPage produtoPage = new ProdutoPage();
	private RegistrosProdutoPage registrosProdutoPage = new RegistrosProdutoPage();
	private EstoquePage estoquePage = new EstoquePage();
	Produto produto = ProdutoFactory.getProduto();
	private final String estoqueManipular = "10";
	private Scenario scenario;
	
	@Before(order = 1, value = { "@appium" })
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After(order = 1, value = { "@appium" })
	public void tearDown() {
		scenario.getName();
		DriverFactory.getDriver().resetApp();
	}

	@Given("^que acesso o aplicativo$")
	public void que_acesso_o_aplicativo() throws Throwable {

	}
	
	@Given("^possuo um produto cadastrado$")
	public void possuo_um_produto_cadastrado() throws Throwable {
		registrosProdutoPage.acessarTelaCadastroProduto();
		produtoPage.preencherTodosCampos(produto);
		produtoPage.salvar();
	}

	@When("^realizo o cadastro de um produto$")
	public void realizo_o_cadastro_de_um_produto() throws Throwable {
		registrosProdutoPage.acessarTelaCadastroProduto();
		produtoPage.preencherTodosCampos(produto);
		produtoPage.salvar();
	}

	@When("^realizo uma adicao na quantidade de estoque do produto$")
	public void realizo_uma_adicao_na_quantidade_de_estoque_do_produto() throws Throwable {
		registrosProdutoPage.cliqueBotaoIncluirEstoque();
		Assert.assertEquals(produto.getQuantidade().toString(), estoquePage.obterEstoqueAtual());
		String quantidadeEntrada = "10";
		estoquePage.preencherCampoEntrada(quantidadeEntrada);
		estoquePage.preencherCampoMotivo();
		estoquePage.preencherCampoReferencia();
		estoquePage.salvar();
	}

	@When("^realizo uma retirada na quantidade de estoque do produto$")
	public void realizo_uma_retirada_na_quantidade_de_estoque_do_produto() throws Throwable {
		registrosProdutoPage.cliqueBotaoRetirarEstoque();
		Assert.assertEquals(produto.getQuantidade().toString(), estoquePage.obterEstoqueAtual());
		String quantidadeRetirada = "10";
		estoquePage.preencherCampoRetirada(quantidadeRetirada);
		estoquePage.preencherCampoMotivo();
		estoquePage.preencherCampoReferencia();
		estoquePage.salvar();
	}
	
	@Then("^visualizo todos os dados do produto cadastrado na tela de detalhes do produto$")
	public void visualizo_todos_os_dados_do_produto_cadastrado_na_tela_de_detalhes_do_produto() throws Throwable {
		String tituloTela = registrosProdutoPage.obterTituloTela();
		Assert.assertEquals("Product Registration", tituloTela);
		Produto produtoCadastrado = registrosProdutoPage.obterProdutoCadastrado();
		Assert.assertEquals(produtoCadastrado.getCodigo(), produto.getCodigo());
		Assert.assertEquals(produtoCadastrado.getDescricao(), produto.getDescricao());
		Assert.assertEquals(produtoCadastrado.getUnidade(), produto.getUnidade());
		Assert.assertEquals(produtoCadastrado.getQuantidade(), produto.getQuantidade());
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.00");
		Assert.assertEquals(df.format(produtoCadastrado.getValorUnitario()), df.format(produto.getValorUnitario()));
		Assert.assertEquals(produtoCadastrado.getLote(), produto.getLote());
		Assert.assertNotNull(produtoCadastrado.getDataExpiracao());
		
		ScreenShot.gerarScreenShot(scenario.getName().toString());
		registrosProdutoPage.excluirProduto();
	}

	@Then("^visualizo corretamente os dados do produto e estoque atualizado com a inclusao$")
	public void visualizo_corretamente_os_dados_do_produto_e_estoque_atualizado_com_a_inclusao() throws Throwable {
		Produto produtoCadastrado = registrosProdutoPage.obterProdutoCadastrado();
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0");
		String valorSomadoFormatado = df.format(produto.getQuantidade().add(new BigDecimal(estoqueManipular)))
				.replace(",", ".");
		Assert.assertEquals(valorSomadoFormatado, produtoCadastrado.getQuantidade().toString());

		ScreenShot.gerarScreenShot(scenario.getName().toString());
		registrosProdutoPage.excluirProduto();
	}

	@Then("^visualizo corretamente os dados do produto e estoque atualizado com a retirada$")
	public void visualizo_corretamente_os_dados_do_produto_e_estoque_atualizado_com_a_retirada() throws Throwable {
		Produto produtoCadastrado = registrosProdutoPage.obterProdutoCadastrado();
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0");
		String valorSomadoFormatado = df.format(produto.getQuantidade().subtract(new BigDecimal(estoqueManipular)))
				.replace(",", ".");
		Assert.assertEquals(valorSomadoFormatado, produtoCadastrado.getQuantidade().toString());

		ScreenShot.gerarScreenShot(scenario.getName().toString());
		registrosProdutoPage.excluirProduto();
	}
}
