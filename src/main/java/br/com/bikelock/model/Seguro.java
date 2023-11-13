package br.com.bikelock.model;

import br.com.bikelock.util.Status;
import br.com.bikelock.util.TipoSeguro;

public class Seguro {

	private Long idSeguro;
	private double valor;
	private TipoSeguro tipoSeguro;
	private String numeroDeSerie;
	private String emailCliente;

	private Status status;

	public Seguro() {
		super();
		// TODO Auto-generated constructor stub
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

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seguro [ID do seguro: " + idSeguro + ", Valor: R$" + valor + ", Tipo do seguro: " + tipoSeguro + "]";
	}
}
