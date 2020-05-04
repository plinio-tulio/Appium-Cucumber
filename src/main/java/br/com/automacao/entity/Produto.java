package br.com.automacao.entity;

import java.math.BigDecimal;

public class Produto {

	private String codigo;
	private String descricao;
	private String unidade;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private Integer lote;
	private String dataExpiracao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public String getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}