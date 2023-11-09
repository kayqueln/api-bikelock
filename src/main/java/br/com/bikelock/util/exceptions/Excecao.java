package br.com.bikelock.util.exceptions;

public class Excecao extends Exception{
    public Excecao(Exception e){
        if(e.getClass().toString().equals("class java.lang.NumberFormatException")){
            System.out.println("Esse campo aceita somente números!");
        } else {
            System.out.println("Falha desconhecida");
            e.printStackTrace();
        }
    }
}
