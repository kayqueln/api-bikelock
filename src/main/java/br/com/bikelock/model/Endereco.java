package br.com.bikelock.model;

public class Endereco {

	private int idEndereco;
	private String cep;
	private String rua;
	private String numero;
	private String estado;
	private String complemento;
	private Cliente cliente;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(String cep, String rua, String numero, String estado, String complemento) {
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
		this.complemento = complemento;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Endereco [ID do endereço: " + idEndereco + ", Rua: " + rua + ", Número: " + numero + ", CEP: " + cep + ", Estado: " + estado + ", Complemento: " + complemento + "]" + cliente;
	}
}
