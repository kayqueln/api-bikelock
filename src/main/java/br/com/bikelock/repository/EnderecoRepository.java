package br.com.bikelock.repository;


import br.com.bikelock.config.ConnectionFactory;
import br.com.bikelock.model.Endereco;
import oracle.sql.NUMBER;
import org.apache.commons.logging.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {
    public Connection minhaConexao;

    public EnderecoRepository() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    public void inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO ENDERECO (cep, rua, numero, estado, complemento, email)" +
                " VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getRua());
        stmt.setString(3, endereco.getNumero());
        stmt.setString(4, endereco.getEstado());
        stmt.setString(5, endereco.getComplemento());
        stmt.setString(6, endereco.getEmailCliente());
        stmt.execute();
        stmt.close();

        System.out.println("Endereço cadastrado com sucesso.");
    }

    public ArrayList<Endereco> selecionarTodos() throws SQLException {
        ArrayList<Endereco> listaEnderecos = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ENDERECO");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            Endereco endereco = new Endereco();

            endereco.setIdEndereco(resultSet.getLong(1));
            endereco.setCep(resultSet.getString(2));
            endereco.setRua(resultSet.getString(3));
            endereco.setNumero(resultSet.getString(4));
            endereco.setEstado(resultSet.getString(5));
            endereco.setComplemento(resultSet.getString(6));
            endereco.setEmailCliente(resultSet.getString(7));

            listaEnderecos.add(endereco);
        }

        resultSet.close();
        stmt.close();

        return listaEnderecos;
    }

    public Endereco selecionarPorID(Long idEndereco) throws SQLException {
        Endereco endereco = new Endereco();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ENDERECO WHERE ID_ENDERECO = ?");
        stmt.setLong(1, idEndereco);

        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            endereco.setIdEndereco(resultSet.getLong(1));
            endereco.setCep(resultSet.getString(2));
            endereco.setRua(resultSet.getString(3));
            endereco.setNumero(resultSet.getString(4));
            endereco.setEstado(resultSet.getString(5));
            endereco.setComplemento(resultSet.getString(6));
            endereco.setEmailCliente(resultSet.getString(7));
        }

        resultSet.close();
        stmt.close();

        return endereco;
    }

    public ArrayList<Endereco> selecionarPorEmail(String email) throws SQLException {
        ArrayList<Endereco> listaEnderecos = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ENDERECO WHERE EMAIL = ?");
        stmt.setString(1, email);

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            Endereco endereco = new Endereco();

            endereco.setIdEndereco(resultSet.getLong(1));
            endereco.setCep(resultSet.getString(2));
            endereco.setRua(resultSet.getString(3));
            endereco.setNumero(resultSet.getString(4));
            endereco.setEstado(resultSet.getString(5));
            endereco.setComplemento(resultSet.getString(6));
            endereco.setEmailCliente(resultSet.getString(7));

            listaEnderecos.add(endereco);
        }

        resultSet.close();
        stmt.close();

        return listaEnderecos;
    }

    public void atualizar(Long idEndereco, Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE ENDERECO " +
                "SET CEP = ?, RUA = ?, NUMERO = ?, ESTADO = ?, COMPLEMENTO = ? " +
                "WHERE ID_ENDERECO = ?");
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getRua());
        stmt.setString(3, endereco.getNumero());
        stmt.setString(4, endereco.getEstado());
        stmt.setString(5, endereco.getComplemento());
        stmt.setLong(6, idEndereco);
        stmt.execute();
        stmt.close();

        System.out.println("Endereço atualizado com sucesso");
    }

    public void deletar(Long idEndereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM ENDERECO WHERE ID_ENDERECO = ?");
        stmt.setLong(1, idEndereco);
        stmt.execute();
        stmt.close();

        System.out.println("Endereço deletado com sucesso");
    }
}
