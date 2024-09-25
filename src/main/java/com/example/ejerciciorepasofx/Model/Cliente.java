package com.example.ejerciciorepasofx.Model;

public abstract class Cliente {

    private String correo;
    private String contrasenia;
    private double descuentos;

    public Cliente() {
    }

    public Cliente(String correo, String contrasenia, double importe) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.descuentos = importe;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getdescuentos() {
        return descuentos;
    }

    public void setdescuentos(double importe) {
        this.descuentos = importe;
    }
}