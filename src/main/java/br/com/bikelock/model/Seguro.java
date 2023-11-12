package br.com.bikelock.model;

public class Seguro {

	private Long idSeguro;
	private double valor;
	private String tipoSeguro;
	private String numeroDeSerie;
	private String emailCliente;

	public Seguro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seguro(String tipoSeguro, double valor) {
		this.valor = valor;
		this.tipoSeguro = tipoSeguro;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Long getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(Long idSeguro) {
		this.idSeguro = idSeguro;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public double valorSeguro(Double valorBicicleta, String tipoSeguro) {
		double valorSeguro;

		if(tipoSeguro.equals("Essencial")){
			valorSeguro = valorBicicleta * 0.015;
		} else if (tipoSeguro.equals("Leve")){
			valorSeguro = valorBicicleta * 0.03;
		} else {
			valorSeguro = valorBicicleta * 0.06;
		}

		return valorSeguro;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	@Override
	public String toString() {
		return "Seguro [ID do seguro: " + idSeguro + ", Valor: R$" + valor + ", Tipo do seguro: " + tipoSeguro + "]";
	}
}
