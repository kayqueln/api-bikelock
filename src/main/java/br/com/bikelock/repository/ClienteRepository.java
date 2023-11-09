package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.ClienteFisico;
import br.com.bikelock.model.ClienteJuridico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteRepository {

    public Connection minhaConexao;

    public ClienteRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(ClienteFisico clienteFisico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO CLIENTE VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, clienteFisico.getEmail());
        stmt.setString(2, clienteFisico.getNome());
        stmt.setLong(3, clienteFisico.getTelefone());
        stmt.setString(4, clienteFisico.getCpf());
        stmt.setString(5, clienteFisico.getRg());
        stmt.setString(6, null);
        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return "Cliente cadastrado com sucesso.";
    }

    public String inserir(ClienteJuridico clienteJuridico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO CLIENTE VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, clienteJuridico.getEmail());
        stmt.setString(2, clienteJuridico.getNome());
        stmt.setLong(3, clienteJuridico.getTelefone());
        stmt.setString(4, null);
        stmt.setString(5, null);
        stmt.setString(6, clienteJuridico.getCnpj());
        stmt.execute();
        stmt.close();

        return "Cliente cadastrado com sucesso.";
    }
}
