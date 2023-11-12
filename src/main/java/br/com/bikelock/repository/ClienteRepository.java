package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public Connection minhaConexao;

    public ClienteRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public void inserir(Cliente cliente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO CLIENTE VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, cliente.getEmail());
        stmt.setString(2, cliente.getNome());
        stmt.setLong(3, cliente.getTelefone());
        stmt.setString(4, cliente.getCpf());
        stmt.setString(5, cliente.getRg());
        stmt.setString(6, cliente.getSenha());
        stmt.execute();
        stmt.close();
        minhaConexao.close();

        System.out.println("Cliente cadastrado com sucesso.");
    }

    public ArrayList<Cliente> selecionarTodos() throws SQLException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM CLIENTE");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            Cliente cliente = new Cliente();
            cliente.setEmail(resultSet.getString(1));
            cliente.setNome(resultSet.getString(2));
            cliente.setTelefone(resultSet.getLong(3));
            cliente.setCpf(resultSet.getString(4));
            cliente.setRg(resultSet.getString(5));
            cliente.setSenha(resultSet.getString(6));
            listaClientes.add(cliente);
        }

        resultSet.close();
        stmt.close();

        return listaClientes;
    }


    public Cliente selecionarPorEmail(String email) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM CLIENTE WHERE EMAIL = ?");
        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();

        Cliente cliente = new Cliente();

        if(resultSet.next()){
            cliente.setEmail(resultSet.getString(1));
            cliente.setNome(resultSet.getString(2));
            cliente.setTelefone(resultSet.getLong(3));
            cliente.setCpf(resultSet.getString(4));
            cliente.setRg(resultSet.getString(5));
            cliente.setSenha(resultSet.getString(6));
        }

        resultSet.close();
        stmt.close();

        return cliente;
    }

    public void atualizar(String email, Cliente cliente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE CLIENTE " +
                "SET NOME = ?, TELEFONE = ?, CPF = ?, RG = ?, SENHA = ?" +
                "WHERE EMAIL = ?");

        stmt.setString(1, cliente.getNome());
        stmt.setLong(2, cliente.getTelefone());
        stmt.setString(3, cliente.getCpf());
        stmt.setString(4, cliente.getRg());
        stmt.setString(5, cliente.getSenha());
        stmt.setString(6, email);
        stmt.execute();
        stmt.close();

        System.out.println("Cliente atualizado com sucesso.");
    }

    public void deletar(String email) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM CLIENTE WHERE EMAIL = ?");
        stmt.setString(1, email);
        stmt.execute();
        stmt.close();

        System.out.println("Cliente deletado com sucesso.");
    }
}
