package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoRepository {
    public Connection minhaConexao;

    public EnderecoRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO ENDERECO VALUES(?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, null);
        stmt.setString(2, endereco.getCep());
        stmt.setString(3, endereco.getRua());
        stmt.setString(4, endereco.getNumero());
        stmt.setString(5, endereco.getEstado());
        stmt.setString(6, endereco.getComplemento());
        stmt.setString(7, endereco.getCliente().getEmail());
        stmt.execute();
        stmt.close();

        return "Endereço cadastrado com sucesso.";
    }
}
