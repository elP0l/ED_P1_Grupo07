/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.NodeList;
import Clases.TipoVehi;
import Clases.Vehiculo;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class CatalogoController implements Initializable {
    
    @FXML
    private VBox contenedor;
    @FXML
    private ComboBox<String> CbxVehiculo;
    @FXML
    private ComboBox<String> CbxOrder;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void filterVehiculo(ActionEvent event) {
        LinkedList<Vehiculo> lFiltrada = new LinkedList<>();
        NodeList<Vehiculo> node;
        TipoVehi tpV = TipoVehi.valueOf(CbxVehiculo.getSelectionModel().getSelectedItem());
        for (node = App.listaVehiculos.getHeader() ; node!=null ;node = node.getNext()){
           if(node.getContent().getTipoVehi()==tpV){
               lFiltrada.addLast(node.getContent());
           }            
        }
        //contenedor.
    }

    @FXML
    private void filterOrder(ActionEvent event) {
        
    }

}
