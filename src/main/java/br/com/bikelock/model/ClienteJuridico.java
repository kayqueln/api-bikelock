package br.com.bikelock.model;


import br.com.bikelock.util.exceptions.ExcecaoPersonalizada;

public class ClienteJuridico extends Cliente{
    private String cnpj;

    public ClienteJuridico() {
    }

    public ClienteJuridico(String email, String nome, Long telefone, String cnpj) {
        super(email, nome, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //Método que verifica se o CNPJ do cliente é válido
    public void verificaCNPJ() throws ExcecaoPersonalizada {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            throw new ExcecaoPersonalizada("CNPJ inválido!");
        }

        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        int resto = soma % 11;
        int primeiroDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
        if (primeiroDigitoVerificador != Character.getNumericValue(cnpj.charAt(12))) {
            throw new ExcecaoPersonalizada("CNPJ inválido!");
        }

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        resto = soma % 11;
        int segundoDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
        if (segundoDigitoVerificador != Character.getNumericValue(cnpj.charAt(13))) {
            throw new ExcecaoPersonalizada("CNPJ inválido!");
        }
    }


    @Override
    public String toString() {
        return "Cliente [CNPJ: " + cnpj + super.toString();
    }
}
