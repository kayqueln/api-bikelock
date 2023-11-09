package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaRepository {
    public Connection minhaConexao;

    public BicicletaRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public String inserir(Bicicleta bicicleta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO BICICLETA VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, bicicleta.getNumeroSerie());
        stmt.setDate(2, new Date(bicicleta.getDataCompra().getTime()));
        stmt.setDouble(3, bicicleta.getValor());
        stmt.setString(4, bicicleta.getMarca());
        stmt.setString(5, bicicleta.getModelo());
        stmt.setString(6, bicicleta.getEmailCliente());
        stmt.execute();
        stmt.close();

        return "Bicicleta cadastrada com sucesso.";
    }

    public String atualizar(String numeroDeSerie, Bicicleta bicicleta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE BICICLETA " +
                "SET DT_COMPRA = ?, VALOR = ?, MARCA = ?, MODELO = ?, EMAIL = ?" +
                "WHERE NUMERO_SERIE = ?");

        stmt.setDate(1, new Date(bicicleta.getDataCompra().getTime()));
        stmt.setDouble(2, bicicleta.getValor());
        stmt.setString(3, bicicleta.getMarca());
        stmt.setString(4, bicicleta.getModelo());
        stmt.setString(5, bicicleta.getEmailCliente());
        stmt.setString(6, numeroDeSerie);
        stmt.execute();
        stmt.close();

        return "Bicicleta atualizada com sucesso.";
    }

    public String deletar(String numeroDeSerie) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM BICICLETA WHERE NUMERO_SERIE = ?");

        stmt.setString(1, numeroDeSerie);
        stmt.execute();
        stmt.close();

        return "Bicicleta deletada com sucesso.";
    }

    public List<Bicicleta> selecionar() throws SQLException {
        List<Bicicleta> listaBicicleta = new ArrayList<Bicicleta>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM BICICLETA");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            Bicicleta bicicleta = new Bicicleta();

            bicicleta.setNumeroSerie(resultSet.getString(1));
            bicicleta.setDataCompra(resultSet.getDate(2));
            bicicleta.setValor(resultSet.getDouble(3));
            bicicleta.setMarca(resultSet.getString(4));
            bicicleta.setModelo(resultSet.getString(5));
            bicicleta.setEmailCliente(resultSet.getString(6));
            listaBicicleta.add(bicicleta);
        }

        stmt.close();
        resultSet.close();

        return listaBicicleta;
    }

    public Bicicleta selecionarPorNumeroDeSerie(String numeroDeSerie) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM BICICLETA WHERE NUMERO_SERIE = ?");
        stmt.setString(1, numeroDeSerie);

        ResultSet resultSet = stmt.executeQuery();

        Bicicleta bicicleta = new Bicicleta();

        if(resultSet.next()){
            bicicleta.setNumeroSerie(resultSet.getString(1));
            bicicleta.setDataCompra(resultSet.getDate(2));
            bicicleta.setValor(resultSet.getDouble(3));
            bicicleta.setMarca(resultSet.getString(4));
            bicicleta.setModelo(resultSet.getString(5));
            bicicleta.setEmailCliente(resultSet.getString(6));
        }

        stmt.close();
        resultSet.close();

        return bicicleta;
    }
}
