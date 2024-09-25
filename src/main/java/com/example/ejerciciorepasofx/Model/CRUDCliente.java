package com.example.ejerciciorepasofx.Model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUDCliente {
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola

    public static boolean insertarCliente(ArrayList<Usuario> lista, Usuario usu){
        boolean aniadido = false;
        if(!lista.contains(usu)){
            lista.add(usu);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usuario añadido");
            alert.setContentText("Usuario " + usu.getCorreo() + " añadido exitosamente.");
            alert.showAndWait();
            aniadido = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fallo");
            alert.setContentText(usu.getCorreo() + " ya tiene una cuenta existente");
            alert.showAndWait();
        }
        return aniadido;
    }

    public static void buscarUsuarios(ArrayList<Usuario> lista, String correo){
        boolean encontrado = false;
        for (Usuario usuario : lista) {
            if (usuario.getCorreo().equals(correo)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Usuario añadido");
                alert.setContentText(" ¡Usuario encontrado!\n" +
                        "     Correo: " + usuario.getCorreo() +"\n" +
                        "     Contraseña: " + usuario.getContrasenia() +"\n" +
                        "     Descuento: " + usuario.getdescuentos() +"€\n" +
                        "     Premium: " + (usuario.isPremium() ? "Sí" : "No") + "\n");
                alert.showAndWait();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fallo");
            alert.setContentText("El usuario no ha sido encontrado");
            alert.showAndWait();
        }
    }

    public static void totalIngresos(ArrayList<Usuario> lista){
        double totalPago=0;
        for (Usuario usuario : lista) {
            if(usuario.isPremium()){
                totalPago = totalPago + (35.5 - usuario.getdescuentos());
            } else {
                totalPago = totalPago + (20.5 - usuario.getdescuentos());
            }
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Completado");
        alert.setContentText("El total de ingresos a recibir es de " +totalPago +"€");
        alert.showAndWait();
    }
}
