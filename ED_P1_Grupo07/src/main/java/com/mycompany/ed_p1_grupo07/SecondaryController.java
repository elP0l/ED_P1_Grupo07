package com.mycompany.ed_p1_grupo07;

import Clases.Usuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SecondaryController {

    @FXML
    private Label nom1;
    @FXML
    private Label ap1;
    @FXML
    private Label ed1;
    @FXML
    private Label co1;
    @FXML
    private Label con1;
    @FXML
    private TextField nom2;
    @FXML
    private TextField ap2;
    @FXML
    private TextField ed2;
    @FXML
    private TextField co2;
    @FXML
    private PasswordField con2;
    @FXML
    private Button reg3;
    @FXML
    private Button at2;
    @FXML
    private BorderPane pane1;
    @FXML
    private ImageView img2;
    @FXML
    private VBox vBox;
    @FXML
    private VBox vBox2;
    @FXML
    private VBox vBox1;

    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    public void initialize() {
        try {
            BackgroundFill backgroundFill = new BackgroundFill(Color.BEIGE, null, null);     
            pane1.setBackground(new Background(backgroundFill));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void registrar() {
        String nombre = nom2.getText();
        String apellido = ap2.getText();
        String correo = co2.getText();
        String contra = con2.getText();
        String edad = ed2.getText();
        Usuario nuevoUsuario = new Usuario(correo, contra, nombre, apellido, edad);
        try {
            nuevoUsuario.guardarEnArchivo(App.pathFiles+"usuarios.txt");
            System.out.println("Usuario registrado correctamente");
              switchToPrimary();
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario en el archivo");
            e.printStackTrace();
        }
    }

    @FXML
    private void atras(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}