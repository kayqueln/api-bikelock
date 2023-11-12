package br.com.bikelock.model;

public class Endereco {

	private Long idEndereco;
	private String cep;
	private String rua;
	private String numero;
	private String estado;
	private String complemento;
	private String  emailCliente;

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

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
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

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"idEndereco=" + idEndereco +
				", cep='" + cep + '\'' +
				", rua='" + rua + '\'' +
				", numero='" + numero + '\'' +
				", estado='" + estado + '\'' +
				", complemento='" + complemento + '\'' +
				", emailCliente='" + emailCliente + '\'' +
				'}';
	}
}
