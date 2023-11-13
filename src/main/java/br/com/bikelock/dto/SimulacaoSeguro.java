package br.com.bikelock.dto;

import br.com.bikelock.util.TipoSeguro;

public class SimulacaoSeguro {
    private String numeroDeSerie;
    private TipoSeguro tipoSeguro;

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
}
