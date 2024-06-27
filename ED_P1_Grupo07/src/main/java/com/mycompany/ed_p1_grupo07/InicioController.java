/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button verCat;
    @FXML
    Button venderVehi;
    @FXML
    ImageView imgPortada;
    @FXML
    ImageView imgBand;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream input = new FileInputStream(App.pathImages+"portada.jpg")){
            Image imgv = new Image(input);            
            imgPortada.setImage(imgv);
            //imgBienvenida.setPreserveRatio(true);
            imgPortada.setFitWidth(320);
            imgPortada.setFitHeight(550);
        }catch (IOException ex) {            
        }
        try(FileInputStream input = new FileInputStream(App.pathImages+"banderaEc.png")){
            Image imgv = new Image(input);            
            imgBand.setImage(imgv);
            //imgBienvenida.setPreserveRatio(true);
        }catch (IOException ex) {            
        }
    }    
    
    @FXML
    private void verCatalogo()throws IOException {
        App.setRoot("catalogo");    
    }
    
    @FXML
    private void venderVehiculo() throws IOException {
        App.setRoot("VentaVehiculo");
    }
    
}
