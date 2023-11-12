package br.com.bikelock.business;

import br.com.bikelock.model.Seguro;
import br.com.bikelock.repository.ModificacoesRepository;
import br.com.bikelock.repository.SeguroRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class SeguroBusiness {
    private SeguroRepository repository;

    public void inserirSeguro(Seguro seguro) throws SQLException, ClassNotFoundException {
        repository = new SeguroRepository();
        repository.inserir(seguro);
    }

    public ArrayList<Seguro> listarSeguros() throws SQLException, ClassNotFoundException {
        repository = new SeguroRepository();
        return (ArrayList<Seguro>) repository.selecionarTodos();
    }

    public Seguro selecionarPorID(Long idSeguro) throws Exception {
        repository = new SeguroRepository();
        Seguro seguro = repository.selecionarPorID(idSeguro);

        if(seguro.getIdSeguro() == null){
            throw new Exception("O seguro não foi encontrado");
        } else {
            return seguro;
        }
    }

    public Seguro selecionarPorEmail(String email) throws Exception {
        repository = new SeguroRepository();
        Seguro seguro = repository.selecionarPorEmail(email);

        if(seguro.getIdSeguro() == null){
            throw new Exception("O seguro não foi encontrado");
        } else {
            return seguro;
        }
    }

    public Seguro selecionarPorNumeroDeSerie(String numeroDeSerie) throws Exception {
        repository = new SeguroRepository();
        Seguro seguro = repository.selecionarPorNumeroDeSerie(numeroDeSerie);

        if(seguro.getIdSeguro() == null){
            throw new Exception("O seguro não foi encontrado");
        } else {
            return seguro;
        }
    }

    public void atualizarSeguro(Long idSeguro, Seguro seguro) throws SQLException, ClassNotFoundException {
        repository = new SeguroRepository();
        repository.atualizar(idSeguro, seguro);
    }

    public void deletarSeguro(Long idSeguro) throws SQLException, ClassNotFoundException {
        repository = new SeguroRepository();
        repository.deletar(idSeguro);
    }
}
