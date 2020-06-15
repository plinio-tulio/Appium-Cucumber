package br.com.automacao.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Produto {

	private String codigo;
	private String descricao;
	private String unidade;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private Integer lote;
	private String dataExpiracao;

}