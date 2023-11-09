package br.com.bikelock.model;


import br.com.bikelock.util.exceptions.ExcecaoPersonalizada;

public class ClienteFisico extends Cliente{
    private String cpf;
    private String rg;

    public ClienteFisico() {
    }

    public ClienteFisico(String email, String nome, Long telefone, String cpf, String rg) {
        super(email, nome, telefone);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    //Método que verifica se o CPF do cliente é válido
    public void verificaCPF() throws ExcecaoPersonalizada {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new ExcecaoPersonalizada("CPF inválido");
        }

        boolean digitosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            throw new ExcecaoPersonalizada("CPF inválido");
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
        if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
            throw new ExcecaoPersonalizada("CPF inválido");
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (11 - i);
        }
        resto = soma % 11;
        int segundoDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
        if (segundoDigitoVerificador != Character.getNumericValue(cpf.charAt(10))) {
            throw new ExcecaoPersonalizada("CPF inválido");
        }
    }


    @Override
    public String toString() {
        return "Cliente [CPF: " + cpf + ", RG: " + rg + super.toString();
    }
}
