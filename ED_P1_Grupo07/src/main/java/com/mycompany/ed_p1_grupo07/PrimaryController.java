/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void siguiente(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
}
