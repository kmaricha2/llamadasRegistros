package com.example.peterson.llamar.Entidades;

import java.io.Serializable;

public class Llamar implements Serializable {

    private int id;
    private  String numero;
    private String fecha;

    public Llamar(int id, String numero, String fecha) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
    }

    public Llamar(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
