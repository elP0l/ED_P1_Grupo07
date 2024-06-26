/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author vecto
 */
public class PrimaryController implements Initializable {

    @FXML
    private Label nombre1;
    @FXML
    private VBox h1;
    @FXML
    private Label us1;
    @FXML
    private Label con1;
    @FXML
    private Button ini1;
    @FXML
    private Button regi1;
    @FXML
    private VBox h2;
    @FXML
    private TextField usu2;
    @FXML
    private PasswordField con2;
    private Usuario u;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
   private void iniciarSesion() {
       String correo = usu2.getText();
       String contra = con2.getText();
       Usuario usuario;
        try {
            usuario = buscarUsuario(correo);
            if (usuario!=null&& usuario.getContra().equals(contra)) {
                u = usuario;
                System.out.println("Inicio de sesión exitoso");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Inicio de sesión exitoso");
                alert.setHeaderText(null);
                alert.setContentText("¡Inicio de sesión exitoso! Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
                alert.showAndWait();
                siguiente(new ActionEvent());
            } else {
                System.out.println("Credenciales incorrectas o usuario no encontrado");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar el usuario");
            e.printStackTrace();
        }
}

    

    @FXML
    private void siguiente(ActionEvent event) throws IOException {
        App.setRoot("inicio");
    }
    private Usuario buscarUsuario(String correo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(App.pathFiles+"usuarios.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                Usuario usuario = Usuario.Texto(linea);
                if (usuario.getCorreo().equals(correo)) {
                    reader.close();
                    return usuario;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios");
            e.printStackTrace();
          
        }
        return null;
    }
}
    
