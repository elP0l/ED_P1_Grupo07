/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.DoublyCircularNodeList;
import Clases.DoublyNodeList;
import Clases.Vehiculo;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class VehiculosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    DoublyNodeList<Vehiculo> nV = CatalogoController.vehis.getHeader();
    @FXML
    DoublyCircularNodeList<String> dI = nV.getContent().getlImagenes().getLast().getNext();
    @FXML
    ImageView imgVehis;
    @FXML
    Label nameModelo;
    @FXML
    Label anio;
    @FXML
    Label ciudad;
    @FXML
    Label recorrido;
    @FXML
    Label precio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Vehiculo v = nV.getContent();
        nameModelo.setText(v.getMarca().toUpperCase()+" "+v.getModelo().toUpperCase());
        try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+dI.getContent())){
            Image imgv = new Image(input);
            imgVehis.setImage(imgv);
            //previa.setPreserveRatio(true);
            imgVehis.setFitWidth(250);
            imgVehis.setFitHeight(175);
        }catch (IOException ex) {         
        }
        anio.setText(""+v.getAnio());
        ciudad.setText(v.getCiud());
        recorrido.setText(""+v.getKm());
        precio.setText(""+v.getPrecio());
    }    
    
    public void sgtVehi(){
        if(nV.getNext()!=null){
            this.nV = nV.getNext();
            this.dI = nV.getContent().getlImagenes().getLast().getNext();
            Vehiculo v = nV.getContent();
            nameModelo.setText(v.getMarca().toUpperCase()+" "+v.getModelo().toUpperCase());
            try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+dI.getContent())){
                Image imgv = new Image(input);
                imgVehis.setImage(imgv);
                //previa.setPreserveRatio(true);
                imgVehis.setFitWidth(250);
                imgVehis.setFitHeight(175);
            }catch (IOException ex) {         
            }
            anio.setText(""+v.getAnio());
            ciudad.setText(v.getCiud());
            recorrido.setText(""+v.getKm());
            precio.setText(""+v.getPrecio());
        }else{
            System.out.println("No es posible ejecutar esta opcion, es el limite");
        }
    }
    
    public void antVehi(){
        if(nV.getPrevious()!=null){
            this.nV = nV.getPrevious();
            this.dI = nV.getContent().getlImagenes().getLast().getNext();
            Vehiculo v = nV.getContent();
            nameModelo.setText(v.getMarca().toUpperCase()+" "+v.getModelo().toUpperCase());
            try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+dI.getContent())){
                Image imgv = new Image(input);
                imgVehis.setImage(imgv);
                //previa.setPreserveRatio(true);
                imgVehis.setFitWidth(250);
                imgVehis.setFitHeight(175);
            }catch (IOException ex) {         
            }
            anio.setText(""+v.getAnio());
            ciudad.setText(v.getCiud());
            recorrido.setText(""+v.getKm());
            precio.setText(""+v.getPrecio());
        }else{
            System.out.println("No es posible ejecutar esta opcion, es el limite");
        }
    }

    public void sgtImg(){
        this.dI = dI.getNext();
        try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+dI.getContent())){
            Image imgv = new Image(input);
            imgVehis.setImage(imgv);
            //previa.setPreserveRatio(true);
            imgVehis.setFitWidth(250);
            imgVehis.setFitHeight(175);
        }catch (IOException ex) {         
        }
    }
    
    public void antImg(){
        this.dI = dI.getPrevious();
        try(FileInputStream input = new FileInputStream(App.pathImagesXVehis+'/'+dI.getContent())){
            Image imgv = new Image(input);
            imgVehis.setImage(imgv);
            //previa.setPreserveRatio(true);
            imgVehis.setFitWidth(250);
            imgVehis.setFitHeight(175);
        }catch (IOException ex) {         
        }
    }
    
    public void volverIni() throws IOException{
        App.setRoot("inicio");
    }
    
    public void agregarVehi(){
        PrimaryController.u.getVehiPref().addLast(nV.getContent());
    }
    
   public void removerVehi() {
    if (nV != null && nV.getContent() != null) {
        Vehiculo vehiculoSeleccionado = nV.getContent();
        // Intentar remover el vehículo de CatalogoController.vehis
        if (CatalogoController.remove(vehiculoSeleccionado)) {
            // Mostrar alerta de éxito si se eliminó correctamente
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Vehículo eliminado");
            alert.setContentText("El vehículo ha sido eliminado correctamente.");
            alert.showAndWait();
        } else {
            // Mostrar alerta de error si no se pudo eliminar
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al eliminar vehículo");
            alert.setContentText("No se pudo eliminar el vehículo seleccionado.");
            alert.showAndWait();
        }
    } else {
        // Mostrar alerta de advertencia si no hay vehículo seleccionado
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Ningún vehículo seleccionado");
        alert.setContentText("Por favor, selecciona un vehículo antes de eliminarlo.");
        alert.showAndWait();
    }
}
    
    public void editarVehi() throws IOException{
       // Obtener el vehículo seleccionado actualmente
        Vehiculo vehiculoSeleccionado = nV.getContent();

        // Cargar la vista de edición de vehículo
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditarVehiculo.fxml"));
        Parent root = loader.load();
        EditarVehiculoController controller = loader.getController();

        // Pasar el vehículo seleccionado al controlador de edición
        controller.editarVeh(vehiculoSeleccionado);

        // Mostrar la escena de edición de vehículo
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

