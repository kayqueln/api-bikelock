package br.com.bikelock.util.exceptions;

import java.sql.SQLException;

public class ExcecaoEmailExistente extends SQLException {
    public ExcecaoEmailExistente(Exception e){
        if(e.getClass().toString().equals("class java.sql.SQLIntegrityConstraintViolationException")){
            System.err.println("Esse e-mail já está cadastrado no nosso banco de dados...");
        } else {
            System.err.println("Falha desconhecida");
            e.printStackTrace();
        }
    }
}
