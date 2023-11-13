package br.com.bikelock.business;

import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.model.Modificacoes;
import br.com.bikelock.model.Seguro;
import br.com.bikelock.repository.BicicletaRepository;
import br.com.bikelock.repository.ModificacoesRepository;
import br.com.bikelock.repository.SeguroRepository;
import br.com.bikelock.util.Status;
import br.com.bikelock.util.TipoSeguro;

import java.sql.SQLException;
import java.util.ArrayList;

public class
SeguroBusiness {

    private SeguroRepository repository;
    private BicicletaRepository bicicletaRepository;
    private ModificacoesRepository modificacoesRepository;

    public void simularSeguro(String numeroSerie, TipoSeguro tipoSeguro) throws SQLException, ClassNotFoundException {
        repository = new SeguroRepository();
        bicicletaRepository = new BicicletaRepository();
        modificacoesRepository = new ModificacoesRepository();

        Bicicleta bicicleta = bicicletaRepository.selecionarPorNumeroDeSerie(numeroSerie);
        ArrayList<Modificacoes> listaModificacoes = modificacoesRepository.selecionarPorNumeroDeSerie(numeroSerie);

        Double valorTotalModificacoes = 0.0;

        for (Modificacoes modificacao : listaModificacoes) {
            valorTotalModificacoes += modificacao.getValorModificacao();
        }

        Double valorTotalBicicleta = bicicleta.getValor() + valorTotalModificacoes;
        Double valorSeguro;

        if (tipoSeguro == TipoSeguro.ESSENCIAL) {
            valorSeguro = valorTotalBicicleta * 0.015;
        } else if (tipoSeguro == TipoSeguro.LEVE) {
            valorSeguro = valorTotalBicicleta * 0.03;
        } else {
            valorSeguro = bicicleta.getValor() * 0.06;
        }

        Seguro seguro = new Seguro();
        seguro.setTipoSeguro(tipoSeguro);
        seguro.setValor(valorSeguro);
        seguro.setNumeroDeSerie(bicicleta.getNumeroSerie());
        seguro.setEmailCliente(bicicleta.getEmailCliente());
        seguro.setStatus(Status.AGUARDANDO_CONFIRMACAO);

        repository.simular(seguro);
    }

    public void confirmarSeguro(Long idSeguro) throws Exception {
        repository = new SeguroRepository();
        Seguro seguro = repository.selecionarPorID(idSeguro);

        if(seguro.getIdSeguro() == null){
            throw new Exception("O id do seguro não foi encontrado");
        } else {
            repository.confirmar(idSeguro);
        }
    }

    public void recusarSeguro(Long idSeguro) throws Exception {
        repository = new SeguroRepository();
        Seguro seguro = repository.selecionarPorID(idSeguro);

        if(seguro.getIdSeguro() == null){
            throw new Exception("O id do seguro não foi encontrado");
        } else {
            repository.recusar(idSeguro);
        }
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
