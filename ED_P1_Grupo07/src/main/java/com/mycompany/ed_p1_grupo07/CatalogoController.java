/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.Catalogo;
import Clases.LinkedList;
import Clases.NodeList;
import Clases.TipoVehi;
import Clases.Usuario;
import Clases.Vehiculo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class CatalogoController implements Initializable {
    
    @FXML
    private VBox contenedorcito = new VBox();
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
        CbxVehiculo.getItems().addAll("AUTOS","MOTOS","CAMIONES","MAQUINARIAS");
        CbxOrder.getItems().addAll("AÑO");
        cargarVehiculos();
        //contenedor.getChildren().add(contenedorcito);
        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.TOP_CENTER);
    }    
    
    @FXML
    private LinkedList<Vehiculo> soloUnTipo(LinkedList<Vehiculo> listita){
        LinkedList<Vehiculo> lFiltrada = new LinkedList<>();
        NodeList<Vehiculo> node;
        TipoVehi tpV = TipoVehi.valueOf(CbxVehiculo.getSelectionModel().getSelectedItem());
        for (node = listita.getHeader() ; node!=null ;node = node.getNext()){
           if(node.getContent().getTipoVehi()==tpV){
               lFiltrada.addLast(node.getContent());
           }            
        }
        return lFiltrada;
    }
    
    @FXML
    public void llenarContenedores(LinkedList<Vehiculo> lV) {

        Iterator<Vehiculo> it = lV.iterator();
        
        int ctrl = 0;
        HBox cont = new HBox();
        cont.setSpacing(15);
        cont.setAlignment(Pos.CENTER);
        
        while (it.hasNext()) {
            Vehiculo vehi = it.next();
            String img = vehi.getlImagenes().getLast().getNext().getContent();
            System.out.println(img);
            ImageView previa = new ImageView();
            try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+img)){
                Image imgv = new Image(input);            
                previa.setImage(imgv);
                //previa.setPreserveRatio(true);
                previa.setFitWidth(150);
                previa.setFitHeight(75);
            }catch (IOException ex) {         
            }
            
            VBox cont2 = new VBox();
            cont2.setSpacing(25);
            cont2.setAlignment(Pos.TOP_CENTER);
            cont2.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-padding: 10;");
            cont2.setMinWidth(175);
            cont2.setMaxHeight(200);
            
            cont2.getChildren().add(previa);

            Label lb1 = new Label("Modelo: "+vehi.getModelo());
            cont2.getChildren().add(lb1);

            HBox cont3 = new HBox();
            cont3.setSpacing(25);
            cont3.setAlignment(Pos.TOP_CENTER);

            Label lb2 = new Label(String.valueOf("Año: "+vehi.getAnio()));
            cont3.getChildren().add(lb2);

            Label lb3 = new Label(String.valueOf("Km: "+vehi.getKm()));
            cont3.getChildren().add(lb3);

            cont2.getChildren().add(cont3);

            Label lb4 = new Label("Ciudad: "+vehi.getCiud());
            cont2.getChildren().add(lb4);

            cont.getChildren().add(cont2);
            ctrl++;

            if (ctrl == 3) {
                contenedorcito.getChildren().add(cont);

                cont = new HBox(); // Crear un nuevo HBox para el siguiente conjunto de elementos
                cont.setSpacing(15);
                cont.setAlignment(Pos.CENTER);
                ctrl = 0;
            }
        }
        if (ctrl > 0) {
            contenedorcito.getChildren().add(cont);
        }
        
        ScrollPane scrll = new ScrollPane(contenedorcito);
        scrll.setFitToWidth(true);
        contenedor.getChildren().add(scrll);
        //VBox.setVgrow(scrll, Priority.ALWAYS);
        
    }
    
    @FXML
    private void filterVehiculo(ActionEvent event) {

        contenedorcito.getChildren().clear();
        contenedorcito.setSpacing(25);
        
        LinkedList<Vehiculo> lFiltrada = this.soloUnTipo(App.listaVehiculos);
        
        this.llenarContenedores(lFiltrada);
        
    }

    @FXML
    private void filterOrder(ActionEvent event) {
        
        contenedorcito.getChildren().clear();
        contenedorcito.setSpacing(25);
        
        Comparator<Vehiculo> porAnio = (Vehiculo b1, Vehiculo b2)->{
            return Integer.compare(b1.getAnio(), b2.getAnio());
         };
        /*
        Comparator<Vehiculo> porPrecio = (Vehiculo b1, Vehiculo b2)->{
            return Double.compare(b1.getPrecio(),b2.getPrecio());
         };
        */
        
        contenedorcito.getChildren().clear();
        contenedorcito.setSpacing(25);
        
        LinkedList<Vehiculo> lFiltrada = new LinkedList<>();
        lFiltrada.setAll(App.listaVehiculos);        
        if (CbxVehiculo.getSelectionModel().getSelectedItem()!=null){
            lFiltrada = this.soloUnTipo(lFiltrada);
        }
        String atrib = CbxVehiculo.getSelectionModel().getSelectedItem();
        
        ordenarLista(lFiltrada,porAnio);
        
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
    
    private void cargarVehiculos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(App.pathFiles+"vehiculos.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                Vehiculo vehi = Vehiculo.Texto(linea);
                App.listaVehiculos.addLast(vehi);
            }
            System.out.println(Catalogo.getlVehiculos());
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de vehiculos");
            e.printStackTrace();
        }
    }    
    
}
