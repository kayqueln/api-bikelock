package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepository {

    public Connection minhaConexao;

    public ClienteRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(Cliente cliente) throws SQLException {
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

        return "Cliente cadastrado com sucesso.";
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

        System.out.printf(cliente.getEmail());

        return cliente;
    }
}
