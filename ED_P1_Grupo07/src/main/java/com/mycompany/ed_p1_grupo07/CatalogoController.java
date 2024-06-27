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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
        CbxVehiculo.getItems().addAll("auto","moto","camion","maquinaria");
        CbxOrder.getItems().addAll("precio","año");
        
    }    
    
    @FXML
    private LinkedList<Vehiculo> soloUnTipo(){
        LinkedList<Vehiculo> lFiltrada = new LinkedList<>();
        NodeList<Vehiculo> node;
        TipoVehi tpV = TipoVehi.valueOf(CbxVehiculo.getSelectionModel().getSelectedItem());
        for (node = App.listaVehiculos.getHeader() ; node!=null ;node = node.getNext()){
           if(node.getContent().getTipoVehi()==tpV){
               lFiltrada.addLast(node.getContent());
           }            
        }
        return lFiltrada;
    }
            
    @FXML
    public void llenarContenedores(LinkedList<Vehiculo> lV){
        Iterator<Vehiculo> it = lV.iterator();
        int ctrl = 0;
        HBox cont = new HBox();
        while (it.hasNext()){
            cont.setSpacing(15);
            cont.setAlignment(Pos.CENTER);
            Vehiculo vehi = it.next();
            VBox cont2 = new VBox();
            cont2.setSpacing(15);
            cont2.setAlignment(Pos.TOP_LEFT);
            ImageView imgVehi = new ImageView();
            try(FileInputStream input = new FileInputStream(App.pathImages+vehi.getlImagenes().get(0))){
                Image imgv = new Image(input);            
                imgVehi.setImage(imgv);
            }catch (IOException ex) {            
            }
            cont2.getChildren().add(imgVehi);
            Label lb = new Label(vehi.getModelo());
            cont2.getChildren().add(lb);
            HBox cont3 = new HBox();
            cont3.setSpacing(15);
            cont3.setAlignment(Pos.CENTER);
            lb = new Label(String.valueOf(vehi.getPrecio()));
            cont3.getChildren().add(lb);
            lb = new Label(String.valueOf(vehi.getAnio()));
            cont3.getChildren().add(lb);
            lb = new Label(String.valueOf(vehi.getKm()));
            cont3.getChildren().add(lb);
            cont2.getChildren().add(cont3);
            lb = new Label(vehi.getUbiActual());
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
    private void filterVehiculo(ActionEvent event) {

        LinkedList<Vehiculo> lFiltrada = this.soloUnTipo();
        
        this.llenarContenedores(lFiltrada);
        
    }

    @FXML
    private void filterOrder(ActionEvent event) {
        Comparator<Vehiculo> porAnio = (Vehiculo b1, Vehiculo b2)->{
            return Integer.compare(b1.getAnio(), b2.getAnio());
         };
        Comparator<Vehiculo> porPrecio = (Vehiculo b1, Vehiculo b2)->{
            return Double.compare(b1.getPrecio(),b2.getPrecio());
         };
        LinkedList<Vehiculo> lFiltrada = App.listaVehiculos;        
        if (CbxVehiculo.getSelectionModel().getSelectedItem()!=null){
            lFiltrada = this.soloUnTipo();
        }
        String atrib = CbxVehiculo.getSelectionModel().getSelectedItem();
        if(atrib.equals("precio")){
            ordenarLista(lFiltrada,porPrecio);
        }else{
            ordenarLista(lFiltrada,porAnio);
        }
        this.llenarContenedores(lFiltrada);
    }

    @FXML
    public static void ordenarLista(LinkedList<Vehiculo> lista, Comparator<Vehiculo> comparador) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparador.compare(lista.get(j), lista.get(j + 1)) > 0) {
                    // Intercambiar elementos
                    Vehiculo temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
    
    
}
