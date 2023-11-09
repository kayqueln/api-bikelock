package br.com.bikelock.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bicicleta {

	private String numeroSerie;
	private Date dataCompra;
	private double valor;
	private String marca;
	private String modelo;
	private String emailCliente;

	public Bicicleta(Date dataCompra, double valor, String marca, String modelo, String numeroSerie) {
		this.dataCompra = dataCompra;
		this.valor = valor;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroSerie = numeroSerie;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public Bicicleta() {
		super();
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public double valorTotal(Double valorModificacao){
		if(valorModificacao == null){
			return valor;
		} else {
			return valor + valorModificacao;
		}
	}

}
