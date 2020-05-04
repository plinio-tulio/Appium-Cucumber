package br.com.automacao.appium;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Assert;
import org.junit.Test;

import br.com.automacao.entity.Produto;
import br.com.automacao.factory.ProdutoFactory;
import br.com.automacao.pages.EstoquePage;
import br.com.automacao.pages.ProdutoPage;
import br.com.automacao.pages.RegistrosProdutoPage;

public class ProdutoFinalTest extends BaseTeste {

	private ProdutoPage produtoPage = new ProdutoPage();
	private RegistrosProdutoPage registrosProdutoPage = new RegistrosProdutoPage();
	private EstoquePage estoquePage = new EstoquePage();

	@Test
	public void cadastrarNovoProduto() throws Exception {
		// Acessar tela e fazer o cadastro
		Produto produto = ProdutoFactory.getProduto();
		registrosProdutoPage.acessarTelaCadastroProduto();
		produtoPage.preencherTodosCampos(produto);
		produtoPage.salvar();

		String tituloTela = registrosProdutoPage.obterTituloTela();
		System.out.println(tituloTela);
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

		registrosProdutoPage.excluirProduto();
	}

	@Test
	public void incluirEstoque() throws Exception {
		// Acessar tela e fazer o cadastro
		Produto produto = ProdutoFactory.getProduto();
		registrosProdutoPage.acessarTelaCadastroProduto();
		produtoPage.preencherTodosCampos(produto);
		produtoPage.salvar();

		// IncluirEstoque

		registrosProdutoPage.cliqueBotaoIncluirEstoque();
		Assert.assertEquals(produto.getQuantidade().toString(), estoquePage.obterEstoqueAtual());
		String quantidadeEntrada = "10";
		estoquePage.preencherCampoEntrada(quantidadeEntrada);
		estoquePage.preencherCampoMotivo();
		estoquePage.preencherCampoReferencia();
		estoquePage.salvar();

		Produto produtoCadastrado = registrosProdutoPage.obterProdutoCadastrado();
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0");
		String valorSomadoFormatado = df.format(produto.getQuantidade().add(new BigDecimal(quantidadeEntrada)))
				.replace(",", ".");
		Assert.assertEquals(valorSomadoFormatado, produtoCadastrado.getQuantidade().toString());

		registrosProdutoPage.excluirProduto();
	}

	@Test
	public void retirarEstoque() throws Exception {
		// Acessar tela e fazer o cadastro
		Produto produto = ProdutoFactory.getProduto();
		registrosProdutoPage.acessarTelaCadastroProduto();
		produtoPage.preencherTodosCampos(produto);
		produtoPage.salvar();

		// RetirarEstoque
		registrosProdutoPage.cliqueBotaoRetirarEstoque();
		Assert.assertEquals(produto.getQuantidade().toString(), estoquePage.obterEstoqueAtual());
		String quantidadeRetirada = "10";
		estoquePage.preencherCampoRetirada(quantidadeRetirada);
		estoquePage.preencherCampoMotivo();
		estoquePage.preencherCampoReferencia();
		estoquePage.salvar();

		Produto produtoCadastrado = registrosProdutoPage.obterProdutoCadastrado();
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0");
		String valorSomadoFormatado = df.format(produto.getQuantidade().subtract(new BigDecimal(quantidadeRetirada)))
				.replace(",", ".");
		Assert.assertEquals(valorSomadoFormatado, produtoCadastrado.getQuantidade().toString());

		registrosProdutoPage.excluirProduto();
	}

}