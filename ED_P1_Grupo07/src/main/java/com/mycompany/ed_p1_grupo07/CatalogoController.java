/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.LinkedList;
import Clases.NodeList;
import Clases.TipoVehi;
import Clases.Vehiculo;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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
        
        int ctrl = 0;
        HBox cont = new HBox();
        for (node = lFiltrada.getHeader();node!=null;node = node.getNext()){
            VBox cont2 = new VBox();
            ImageView imgVehi = new ImageView();
            try(FileInputStream input = new FileInputStream(App.pathImages+node.getContent().getlImagenes().get(0))){
                Image imgv = new Image(input);            
                imgVehi.setImage(imgv);
            }catch (IOException ex) {            
            }
            cont2.getChildren().add(imgVehi);
            Label lb = new Label(node.getContent().getModelo());
            cont2.getChildren().add(lb);
            lb = new Label(String.valueOf(node.getContent().getPrecio()));
            cont2.getChildren().add(lb);
            lb = new Label(String.valueOf(node.getContent().getAnio()));
            cont2.getChildren().add(lb);
            lb = new Label(String.valueOf(node.getContent().getUbiActual()));
            cont2.getChildren().add(lb);
            cont.getChildren().add(cont2);
            contenedor.getChildren().add(cont);
            ctrl++;
            if (ctrl==3){
                cont = new HBox();
                ctrl=0;
            }
        }
    }

    @FXML
    private void filterOrder(ActionEvent event) {
        
    }

}
