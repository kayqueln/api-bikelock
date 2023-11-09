package br.com.bikelock.business;

import br.com.bikelock.model.Bicicleta;
import br.com.bikelock.repository.BicicletaRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class BicicletaBusiness {

    private BicicletaRepository repository;

    public void inserirBicicleta(Bicicleta bicicleta) throws SQLException, ClassNotFoundException {
        repository = new BicicletaRepository();
        repository.inserir(bicicleta);
    }

    public ArrayList<Bicicleta> listarBicicletas() throws SQLException, ClassNotFoundException {
        repository = new BicicletaRepository();
        return (ArrayList<Bicicleta>) repository.selecionar();
    }

    public Bicicleta buscarPorNumeroDeSerie(String numeroDeSerie) throws Exception {
        repository = new BicicletaRepository();
        Bicicleta bicicleta = repository.selecionarPorNumeroDeSerie(numeroDeSerie);

        if(bicicleta.getNumeroSerie() == null){
            throw new Exception();
        } else {
            return bicicleta;
        }
    }

    public void atualizarBicicleta(String numeroDeSerie, Bicicleta bicicleta) throws SQLException, ClassNotFoundException {
        repository = new BicicletaRepository();
        repository.atualizar(numeroDeSerie, bicicleta);
    }

    public void deletarBicicleta(String numeroDeSerie) throws SQLException, ClassNotFoundException {
        repository = new BicicletaRepository();
        repository.deletar(numeroDeSerie);
    }

}
