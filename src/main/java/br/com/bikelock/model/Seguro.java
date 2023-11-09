package br.com.bikelock.model;

public class Seguro {

	private int idSeguro;
	private double valor;
	private String tipoSeguro;
	private Bicicleta bicicleta;
	private Cliente cliente;

	public Seguro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seguro(String tipoSeguro, double valor) {
		this.valor = valor;
		this.tipoSeguro = tipoSeguro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
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

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
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

	@Override
	public String toString() {
		return "Seguro [ID do seguro: " + idSeguro + ", Valor: R$" + valor + ", Tipo do seguro: " + tipoSeguro + "]";
	}
}
