package br.com.automacao.factory;

import java.math.BigDecimal;

import br.com.automacao.entity.Produto;
import br.com.automacao.utils.FakerUtils;

public class ProdutoFactory {

	public static Produto getProduto() {
		Produto produto = Produto.builder()
				.descricao(FakerUtils.gerarNomeAleatorio())
				.codigo("1")
				.unidade("unidade")
				.quantidade(new BigDecimal(100))
				.valorUnitario(new BigDecimal(10))
				.lote(100)
				.build();
		return produto;
	}

}