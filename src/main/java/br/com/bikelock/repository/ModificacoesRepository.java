package br.com.bikelock.repository;

import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Modificacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModificacoesRepository {
    public Connection minhaConexao;

    public ModificacoesRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public void inserir(Modificacoes modificacoes) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO MODIFICACOES(TIPO_MODIFICACAO, VALOR_MODIFICACAO, NUMERO_SERIE) " +
                "VALUES(?, ?, ?)");
        stmt.setString(1, modificacoes.getTipoModificacao());
        stmt.setDouble(2, modificacoes.getValorModificacao());
        stmt.setString(3, modificacoes.getNumeroDeSerie());
        stmt.execute();
        stmt.close();

        System.out.println("Modificação cadastrada com sucesso.");
    }

    public ArrayList<Modificacoes> selecionarTodas() throws SQLException {
        ArrayList<Modificacoes> listaModificacoes = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM modificacoes");
        ResultSet resultSet = stmt.executeQuery();

        while(resultSet.next()){
            Modificacoes modificacoes = new Modificacoes();
            modificacoes.setIdModificacao(resultSet.getLong(1));
            modificacoes.setTipoModificacao(resultSet.getString(2));
            modificacoes.setValorModificacao(resultSet.getDouble(3));
            modificacoes.setNumeroDeSerie(resultSet.getString(4));

            listaModificacoes.add(modificacoes);
        }

        resultSet.close();
        stmt.close();

        return listaModificacoes;
    }

    public Modificacoes selecionarPorID(Long idModificacao) throws SQLException {
        Modificacoes modificacoes = new Modificacoes();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM modificacoes WHERE id_modificacoes = ?");
        stmt.setLong(1, idModificacao);
        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            modificacoes.setIdModificacao(resultSet.getLong(1));
            modificacoes.setTipoModificacao(resultSet.getString(2));
            modificacoes.setValorModificacao(resultSet.getDouble(3));
            modificacoes.setNumeroDeSerie(resultSet.getString(4));
        }

        resultSet.close();
        stmt.close();

        return modificacoes;
    }

    public ArrayList<Modificacoes> selecionarPorNumeroDeSerie(String numeroDeSerie) throws SQLException {
        ArrayList<Modificacoes> listaModificacoes = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM modificacoes where NUMERO_SERIE = ?");
        stmt.setString(1, numeroDeSerie);
        ResultSet resultSet = stmt.executeQuery();

        while(resultSet.next()){
            Modificacoes modificacoes = new Modificacoes();
            modificacoes.setIdModificacao(resultSet.getLong(1));
            modificacoes.setTipoModificacao(resultSet.getString(2));
            modificacoes.setValorModificacao(resultSet.getDouble(3));
            modificacoes.setNumeroDeSerie(resultSet.getString(4));

            listaModificacoes.add(modificacoes);
        }

        resultSet.close();
        stmt.close();

        return listaModificacoes;
    }

    public void atualizar(Long idModificaco, Modificacoes modificacoes) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE MODIFICACOES " +
                "SET TIPO_MODIFICACAO = ?, VALOR_MODIFICACAO = ? " +
                "WHERE ID_MODIFICACOES = ?");
        stmt.setString(1, modificacoes.getTipoModificacao());
        stmt.setDouble(2, modificacoes.getValorModificacao());
        stmt.setDouble(3, idModificaco);
        stmt.execute();
        stmt.close();

        System.out.println("Modificação atualizadas com sucesso.");
    }

    public void deletar(Long idModificaco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM MODIFICACOES WHERE ID_MODIFICACOES = ?");
        stmt.setLong(1, idModificaco);
        stmt.execute();
        stmt.close();

        System.out.println("Modificação deletada com sucesso.");
    }
}
