package com.example.ejerciciorepasofx.Model;

public class Anunciante extends Cliente {

    private int num_anuncios;

    public Anunciante() {
    }

    public Anunciante(String correo, String contrasenia, double descuentos, int num_anuncios) {
        super(correo, contrasenia, descuentos);
        this.num_anuncios = num_anuncios;
    }

    public int getNum_anuncios() {
        return num_anuncios;
    }

    public void setNum_anuncios(int num_anuncios) {
        this.num_anuncios = num_anuncios;
    }
}