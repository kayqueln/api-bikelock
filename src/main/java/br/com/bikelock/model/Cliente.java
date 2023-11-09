package br.com.bikelock.model;

import br.com.bikelock.util.exceptions.ExcecaoPersonalizada;

public class Cliente {
    private String email;
    private String nome;
    private Long telefone;

    public Cliente() {
    }

    public Cliente(String email, String nome, Long telefone) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void verificaEmail() throws ExcecaoPersonalizada {
        if(!email.contains("@") || !email.contains(".")){
            throw new ExcecaoPersonalizada("Digite um e-mail válido!");
        }
    }

    @Override
    public String toString() {
        return ", E-mail: " + email + ", Nome: " + nome + ", Telefone: " + telefone + ']';
    }
}