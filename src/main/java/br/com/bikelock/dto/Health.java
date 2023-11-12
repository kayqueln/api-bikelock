package br.com.bikelock.dto;

public class Health {

    private String status;

    public Health(String satus) {
        this.status = satus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
