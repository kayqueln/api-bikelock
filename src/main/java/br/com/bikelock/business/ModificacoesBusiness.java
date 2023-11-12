package br.com.bikelock.business;

import br.com.bikelock.model.Modificacoes;
import br.com.bikelock.repository.ModificacoesRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModificacoesBusiness {
    private ModificacoesRepository repository;

    public void inserirModificacao(Modificacoes modificacoes) throws SQLException, ClassNotFoundException {
        repository = new ModificacoesRepository();
        repository.inserir(modificacoes);
    }

    public ArrayList<Modificacoes> listarModificacoes() throws SQLException, ClassNotFoundException {
        repository = new ModificacoesRepository();
        return (ArrayList<Modificacoes>) repository.selecionarTodas();
    }

    public Modificacoes selecionarPorID(Long idModificacao) throws Exception {
        repository = new ModificacoesRepository();
        Modificacoes modificacoes = repository.selecionarPorID(idModificacao);

        if(modificacoes.getIdModificacao() == null){
            throw new Exception("A modificação não foi encontrada");
        } else {
            return modificacoes;
        }
    }

    public ArrayList<Modificacoes> listarPorNumeroDeSerie(String numeroDeSerie) throws Exception {
        repository = new ModificacoesRepository();
        return repository.selecionarPorNumeroDeSerie(numeroDeSerie);
    }

    public void atualizarModificacao(Long idModificacao, Modificacoes modificacao) throws SQLException, ClassNotFoundException {
        repository = new ModificacoesRepository();
        repository.atualizar(idModificacao, modificacao);
    }

    public void deletarModificacao(Long idModificacao) throws SQLException, ClassNotFoundException {
        repository = new ModificacoesRepository();
        repository.deletar(idModificacao);
    }
}
