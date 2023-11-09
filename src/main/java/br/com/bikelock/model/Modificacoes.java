package br.com.bikelock.model;

public class Modificacoes {

	private int idModificacao;
	private String tipoModificacao;
	private double valorModificacao;
	private Bicicleta bicicleta;

	public Modificacoes() {
	}

	public Modificacoes(String tipoModificacao, double valorModificacao) {
		this.tipoModificacao = tipoModificacao;
		this.valorModificacao = valorModificacao;
	}

	public int getIdModificacao() {
		return idModificacao;
	}

	public void setIdModificacao(int idModificacao) {
		this.idModificacao = idModificacao;
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

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	@Override
	public String toString() {
		return "Modificação [ID da modificação: " + idModificacao + ", Valor: R$" + valorModificacao + ", Tipo de modificação: " + tipoModificacao + "]";
	}

}
