package br.com.bikelock.business;

import br.com.bikelock.dto.DadosLoginCliente;
import br.com.bikelock.model.Cliente;
import br.com.bikelock.repository.BicicletaRepository;
import br.com.bikelock.repository.ClienteRepository;

import java.sql.SQLException;

public class LoginBusiness {

    private ClienteRepository repository;

    public boolean logar(DadosLoginCliente dados) throws Exception {
        repository = new ClienteRepository();
        Cliente cliente =  repository.selecionarPorEmail(dados.getEmail());

        if(cliente.getEmail().isEmpty()){
            throw new Exception();
        }

        if(!cliente.getSenha().equals(dados.getSenha())){
            throw new Exception();
        }

        return true;
    }
}
