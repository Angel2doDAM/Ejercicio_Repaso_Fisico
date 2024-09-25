package com.example.ejerciciorepasofx.Model;

public class Usuario extends Cliente {

    private boolean premium;

    public Usuario() {
    }

    public Usuario(String correo, String contrasenia, double descuentos, boolean premium) {
        super(correo, contrasenia, descuentos);
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return getCorreo().equals(usuario.getCorreo()); // Compara por correo
    }

    @Override
    public int hashCode() {
        return getCorreo().hashCode();
    }
}