package br.com.automacao.factory;

import java.math.BigDecimal;

import br.com.automacao.entity.Produto;
import br.com.automacao.utils.FakerUtils;

public class ProdutoFactory {

	public static Produto getProduto() {
		Produto produto = new Produto();
		produto.setDescricao(FakerUtils.gerarNomeAleatorio());
		produto.setCodigo("1");
		produto.setUnidade("unidade");
		produto.setQuantidade(new BigDecimal(100));
		produto.setValorUnitario(new BigDecimal(10));
		produto.setLote(100);
		return produto;
	}

}