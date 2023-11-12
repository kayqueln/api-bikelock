package br.com.bikelock.business;

import br.com.bikelock.model.Cliente;
import br.com.bikelock.repository.ClienteRepository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ClienteBusiness {
    private ClienteRepository repository;

    public void inserirCliente(Cliente cliente) throws Exception {
        try {
            repository = new ClienteRepository();
            repository.inserir(cliente);
        } catch (SQLIntegrityConstraintViolationException s) {
            throw new Exception("Esse cliente já foi cadastrado na nossa base de dados");
        }
    }


    public ArrayList<Cliente> listarClientes() throws SQLException, ClassNotFoundException {
        repository = new ClienteRepository();
        return (ArrayList<Cliente>) repository.selecionarTodos();
    }

    public Cliente selecionarPorEmail(String email) throws Exception {
        repository = new ClienteRepository();
        Cliente cliente = repository.selecionarPorEmail(email);

        if(cliente.getEmail() == null){
            throw new Exception("O e-mail não foi encontrado");
        } else {
            return cliente;
        }
    }

    public void atualizarCliente(String email, Cliente cliente) throws SQLException, ClassNotFoundException {
        repository = new ClienteRepository();
        repository.atualizar(email, cliente);
    }

    public void deletarCliente(String email) throws SQLException, ClassNotFoundException {
        repository = new ClienteRepository();
        repository.deletar(email);
    }
}
