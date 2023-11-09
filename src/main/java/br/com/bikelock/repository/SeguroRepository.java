package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Seguro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeguroRepository {
    public Connection minhaConexao;

    public SeguroRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(Seguro seguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO SEGURO VALUES(?, ?, ?, ?, ?)");
        stmt.setString(1, null);
        stmt.setDouble(2, seguro.getValor());
        stmt.setString(3, seguro.getTipoSeguro());
        stmt.setString(4, seguro.getBicicleta().getNumeroSerie());
        stmt.setString(5, seguro.getCliente().getEmail());
        stmt.execute();
        stmt.close();

        return "Seguro cadastrado com sucesso.";
    }

}
