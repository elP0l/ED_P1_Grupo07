/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.LinkedList;
import Clases.NodeList;
import Clases.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class VentanaRangoController implements Initializable {

    @FXML
    TextField tMin;
    @FXML
    TextField tMax;
    @FXML
    public static String aspect;
    @FXML
    public static LinkedList<Vehiculo> lXFilt = new LinkedList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void filtrar(ActionEvent event) throws IOException{
        
        if((!tMin.getText().isEmpty() && !tMax.getText().isEmpty())){
            App.listaVehiculos.clear();
            int min = Integer.parseInt(tMin.getText());
            int max = Integer.parseInt(tMax.getText());
            LinkedList<Vehiculo> lXRangos = new LinkedList<>();
            NodeList<Vehiculo> nodo=null;
            for (nodo = lXFilt.getHeader(); nodo!=null; nodo=nodo.getNext()){
                Vehiculo vF = nodo.getContent();
                if(aspect.equals("ANIO")){
                    if(vF.getAnio()>=min && vF.getAnio()<=max){
                            lXRangos.addLast(vF);
                    }
                }else if(aspect.equals("PRECIO")){
                    if(vF.getPrecio()>=min && vF.getPrecio()<=max){
                            lXRangos.addLast(vF);
                    }
                }else if(aspect.equals("KILOMETRAJE")){
                    if(vF.getKm()>=min && vF.getKm()<=max){
                            lXRangos.addLast(vF);
                    }
                }
            }
            lXFilt.clear();
            App.listaVehiculos.setAll(lXRangos);
            
        }else{
            Comparator<Vehiculo> porAnio = (Vehiculo b1, Vehiculo b2)->{
                return Integer.compare(b1.getAnio(), b2.getAnio());
            };
        
            Comparator<Vehiculo> porPrecio = (Vehiculo b1, Vehiculo b2)->{
                return Double.compare(b1.getPrecio(),b2.getPrecio());
            };
        
            Comparator<Vehiculo> porKm = (Vehiculo b1, Vehiculo b2)->{
                return Integer.compare(b1.getKm(), b2.getKm());
            };
            
            System.out.println(App.listaVehiculos);
            if(aspect.equals("ANIO")){
                CatalogoController.ordenarLista(App.listaVehiculos, porAnio);
            }else if(aspect.equals("PRECIO")){
                CatalogoController.ordenarLista(App.listaVehiculos, porPrecio);
            }else if(aspect.equals("KILOMETRAJE")){
                CatalogoController.ordenarLista(App.listaVehiculos, porKm);
            }
        }

        App.setRoot("catalogo");
        
    }
    
}
