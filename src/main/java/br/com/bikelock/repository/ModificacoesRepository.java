package br.com.bikelock.repository;

import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Modificacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificacoesRepository {
    public Connection minhaConexao;

    public ModificacoesRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(Modificacoes modificacoes) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO MODIFICACOES VALUES(?, ?, ?, ?)");
        stmt.setString(1, null);
        stmt.setString(2, modificacoes.getTipoModificacao());
        stmt.setDouble(3, modificacoes.getValorModificacao());
        stmt.setString(4, modificacoes.getBicicleta().getNumeroSerie());
        stmt.execute();
        stmt.close();

        return "Modificação cadastrada com sucesso.";
    }
}
