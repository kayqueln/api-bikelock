package br.com.bikelock.business;

import br.com.bikelock.model.Endereco;
import br.com.bikelock.repository.EnderecoRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoBusiness {

    private EnderecoRepository repository;

    public void inserirEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        repository = new EnderecoRepository();
        repository.inserir(endereco);
    }

    public ArrayList<Endereco> listarEndereco() throws SQLException, ClassNotFoundException {
        repository = new EnderecoRepository();
        return (ArrayList<Endereco>) repository.selecionarTodos();
    }

    public Endereco selecionarPorID(Long idEndereco) throws Exception {
        repository = new EnderecoRepository();
        Endereco endereco = repository.selecionarPorID(idEndereco);

        if(endereco.getIdEndereco() == null){
            throw new Exception("O endereço não foi encontrado");
        } else {
            return endereco;
        }
    }

    public ArrayList<Endereco> listarPorEmail(String email) throws SQLException, ClassNotFoundException {
        repository = new EnderecoRepository();
        return (ArrayList<Endereco>) repository.selecionarPorEmail(email);
    }

    public void atualizarEndereco(Long idEndereco, Endereco endereco) throws SQLException, ClassNotFoundException {
        repository = new EnderecoRepository();
        repository.atualizar(idEndereco, endereco);
    }

    public void deletarEndereco(Long idEndereco) throws SQLException, ClassNotFoundException {
        repository = new EnderecoRepository();
        repository.deletar(idEndereco);
    }
}
