package br.com.bikelock.model;

public class Modificacoes {

	private Long idModificacao;
	private String tipoModificacao;
	private double valorModificacao;
	private String numeroDeSerie;

	public Modificacoes() {
	}

	public Modificacoes(String tipoModificacao, double valorModificacao) {
		this.tipoModificacao = tipoModificacao;
		this.valorModificacao = valorModificacao;
	}

	public void setIdModificacao(Long idModificacao) {
		this.idModificacao = idModificacao;
	}

	public Long getIdModificacao() {
		return idModificacao;
	}

	public String getTipoModificacao() {
		return tipoModificacao;
	}

	public void setTipoModificacao(String tipoModificacao) {
		this.tipoModificacao = tipoModificacao;
	}

	public double getValorModificacao() {
		return valorModificacao;
	}

	public void setValorModificacao(double valorModificacao) {
		this.valorModificacao = valorModificacao;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	@Override
	public String toString() {
		return "Modificação [ID da modificação: " + idModificacao + ", Valor: R$" + valorModificacao + ", Tipo de modificação: " + tipoModificacao + "]";
	}

}
