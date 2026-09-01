package org.example.tiendaapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField editNombre;

    @FXML
    private Button saludar, limpiar;


    @FXML
    private Text textSaludo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        saludar.setOnAction(actionEvent -> {
            if (editNombre.getText().isEmpty()){
                textSaludo.setText("No hay nadie a quien saludar");
            }else{
                textSaludo.setText(String.format("Enhorabuena %s has completado el reto",editNombre.getText()));
            }
        });

        limpiar.setOnAction(actionEvent -> {
            editNombre.clear();
            textSaludo.setText("");
        });
    }
}

