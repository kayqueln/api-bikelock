package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Seguro;
import br.com.bikelock.util.Status;
import br.com.bikelock.util.TipoSeguro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeguroRepository {
    public Connection minhaConexao;

    public SeguroRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public void simular(Seguro seguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO SEGURO(VALOR_SEGURO, TIPO_SEGURO, NUMERO_SERIE, EMAIL, STATUS)" +
                " VALUES(?, ?, ?, ?, ?)");
        stmt.setDouble(1, seguro.getValor());
        stmt.setString(2, String.valueOf(seguro.getTipoSeguro()));
        stmt.setString(3, seguro.getNumeroDeSerie());
        stmt.setString(4, seguro.getEmailCliente());
        stmt.setString(5, String.valueOf(seguro.getStatus()));
        stmt.execute();
        stmt.close();

        System.out.println("Seguro simulado com sucesso.");
    }

    public void confirmar(Long idSeguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE SEGURO SET STATUS = ? " +
                "WHERE ID_SEGURO = ?");
        stmt.setString(1, String.valueOf(Status.CONFIRMADO));
        stmt.setLong(2, idSeguro);
        stmt.execute();
        stmt.close();

        System.out.println("Seguro confirmado com sucesso.");
    }

    public void recusar(Long idSeguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE SEGURO SET STATUS = ? " +
                "WHERE ID_SEGURO = ?");
        stmt.setString(1, String.valueOf(Status.RECUSADO));
        stmt.setLong(2, idSeguro);
        stmt.execute();
        stmt.close();

        System.out.println("Seguro confirmado com sucesso.");
    }


    public ArrayList<Seguro> selecionarTodos() throws SQLException {
        ArrayList<Seguro> listaSeguros = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SEGURO");
        ResultSet resultSet = stmt.executeQuery();

        while(resultSet.next()){
            Seguro seguro = new Seguro();
            seguro.setIdSeguro(resultSet.getLong(1));
            seguro.setValor(resultSet.getDouble(2));
            seguro.setTipoSeguro(TipoSeguro.valueOf(resultSet.getString(3)));
            seguro.setNumeroDeSerie(resultSet.getString(4));
            seguro.setEmailCliente(resultSet.getString(5));
            seguro.setStatus(Status.valueOf(resultSet.getString(6)));

            listaSeguros.add(seguro);
        }

        resultSet.close();
        stmt.close();

        return listaSeguros;
    }

    public Seguro selecionarPorID(Long idSeguro) throws SQLException {
        Seguro seguro = new Seguro();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM seguro where id_seguro = ?");
        stmt.setLong(1, idSeguro);
        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            seguro.setIdSeguro(resultSet.getLong(1));
            seguro.setValor(resultSet.getDouble(2));
            seguro.setTipoSeguro(TipoSeguro.valueOf(resultSet.getString(3)));
            seguro.setNumeroDeSerie(resultSet.getString(4));
            seguro.setEmailCliente(resultSet.getString(5));
            seguro.setStatus(Status.valueOf(resultSet.getString(6)));
        }

        resultSet.close();
        stmt.close();

        return seguro;
    }

    public Seguro selecionarPorEmail(String emailCliente) throws SQLException {
        Seguro seguro = new Seguro();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM seguro where email = ?");
        stmt.setString(1, emailCliente);
        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            seguro.setIdSeguro(resultSet.getLong(1));
            seguro.setValor(resultSet.getDouble(2));
            seguro.setTipoSeguro(TipoSeguro.valueOf(resultSet.getString(3)));
            seguro.setNumeroDeSerie(resultSet.getString(4));
            seguro.setEmailCliente(resultSet.getString(5));
            seguro.setStatus(Status.valueOf(resultSet.getString(6)));
        }

        resultSet.close();
        stmt.close();

        return seguro;
    }

    public Seguro selecionarPorNumeroDeSerie(String numeroDeSerie) throws SQLException {
        Seguro seguro = new Seguro();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM seguro where NUMERO_SERIE = ?");
        stmt.setString(1, numeroDeSerie);
        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            seguro.setIdSeguro(resultSet.getLong(1));
            seguro.setValor(resultSet.getDouble(2));
            seguro.setTipoSeguro(TipoSeguro.valueOf(resultSet.getString(3)));
            seguro.setNumeroDeSerie(resultSet.getString(4));
            seguro.setEmailCliente(resultSet.getString(5));
            seguro.setStatus(Status.valueOf(resultSet.getString(6)));
        }

        resultSet.close();
        stmt.close();

        return seguro;
    }

    public void atualizar(Long idSeguro, Seguro seguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE SEGURO " +
                "SET VALOR_SEGURO = ?, TIPO_SEGURO = ? " +
                "WHERE ID_SEGURO = ?");
        stmt.setDouble(1, seguro.getValor());
        stmt.setString(2, String.valueOf(seguro.getTipoSeguro()));
        stmt.setLong(3, idSeguro);
        stmt.execute();
        stmt.close();

        System.out.println("Seguro atualizado com sucesso.");
    }

    public void deletar(Long idSeguro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM SEGURO WHERE ID_SEGURO = ?");
        stmt.setLong(1, idSeguro);
        stmt.execute();
        stmt.close();

        System.out.println("Seguro deletado com sucesso.");
    }

}
