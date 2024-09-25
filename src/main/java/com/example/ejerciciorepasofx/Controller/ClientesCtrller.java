package com.example.ejerciciorepasofx.Controller;

import com.example.ejerciciorepasofx.Model.CRUDCliente;
import com.example.ejerciciorepasofx.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.ArrayList;

public class ClientesCtrller {
    ArrayList<Usuario> lista = new ArrayList<>();
    Usuario usu;
    double comprobacion=1;

    @FXML
    private ToggleGroup clientePremium;
    @FXML
    private TextField contraseñaTxt;
    @FXML
    private TextField descuentoTxt;
    @FXML
    private TextField usuarioTxt;

    @FXML
    void onAñadirBtt(ActionEvent event) {
        // Comprobar si los campos están vacíos o si no hay selección en el ToggleGroup
        if (usuarioTxt.getText().isEmpty() || contraseñaTxt.getText().isEmpty() || clientePremium.getSelectedToggle() == null || descuentoTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fallo");
            alert.setContentText("Todos los campos deben estar rellenos");
            alert.showAndWait();
        }

        String descuentoText = descuentoTxt.getText();
        double descuento=0;

        //Validar que el descuento sea un número
        try {
            descuento = Double.parseDouble(descuentoText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fallo");
            alert.setContentText("El descuento debe ser un numero");
            alert.showAndWait();
        }

        //Obtener la opción seleccionada y convertirla en boolean
        boolean isPremium;
        RadioButton selectedToggle = (RadioButton) clientePremium.getSelectedToggle();
        if (selectedToggle != null) {
            //Asignar isPremium como true si la opción es "Si"
            isPremium = selectedToggle.getText().equals("Si");
        } else {
            isPremium = false;
        }

        if (selectedToggle.getText().equals("Si")){// reparado con un .getText.equals
            comprobacion = 35.5 - Double.parseDouble(descuentoTxt.getText());
        } else {
            comprobacion = 20.5 - Double.parseDouble(descuentoTxt.getText());
        }

        if (comprobacion <= 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fallo");
            alert.setContentText("El descuento no puede superar ni igualar la tasa de pago:\n" +
                    "35.5€ para usuarios premium\n" +
                    "20.5€ para usuarios NO premium");
            alert.showAndWait();
        } else {
            Usuario usu = new Usuario(usuarioTxt.getText(), contraseñaTxt.getText(), descuento, isPremium);
            if (CRUDCliente.insertarCliente(lista, usu)) {
                usuarioTxt.setText("");
                contraseñaTxt.setText("");
                descuentoTxt.setText("");
                clientePremium.selectToggle(null);
            }
        }
    }


    @FXML
    void onBuscarBtt(ActionEvent event) {
        CRUDCliente.buscarUsuarios(lista, usuarioTxt.getText());
        usuarioTxt.setText("");
        contraseñaTxt.setText("");
        descuentoTxt.setText("");
        clientePremium.selectToggle(null);
    } // METODO PARA BUSCAR UN USUARIO POR MAIL

    @FXML
    void onIngresoBtt(ActionEvent event) {

        CRUDCliente.totalIngresos(lista);
    } // METODO PARA CALCULAR EL TOTAL DE INGRESOS DE LOS USUARIOS


    @FXML
    void onLimpiarBtt(ActionEvent event) {
        usuarioTxt.setText("");
        contraseñaTxt.setText("");
        descuentoTxt.setText("");
        clientePremium.selectToggle(null);
    }

    @FXML
    void onSalirBtt(ActionEvent event) {
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0); // CERRAR APLICACIÓN
        }
    } // SALIR DE LA APLICACIÓN
}