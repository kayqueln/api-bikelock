package br.com.bikelock.business;

import br.com.bikelock.model.Cliente;
import br.com.bikelock.repository.BicicletaRepository;
import br.com.bikelock.repository.ClienteRepository;

import java.sql.SQLException;

public class LoginBusiness {

    private ClienteRepository repository;

    public boolean logar(String email, String senha) throws Exception {
        repository = new ClienteRepository();
        Cliente cliente =  repository.selecionarPorEmail(email);

        System.out.println(cliente.getEmail());

        if(cliente.getEmail() == null){
            throw new Exception();
        }

        if(cliente.getSenha().equals(senha)){
            return true;
        }

        return false;
    }
}
