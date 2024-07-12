/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;

import Clases.DoublyCircularNodeList;
import Clases.DoublyNodeList;
import Clases.Vehiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
        Vehiculo vehiculoSeleccionado = nV.getContent();
        boolean removed = CatalogoController.remove(vehiculoSeleccionado);
        if (removed) {
            actualizarArchivoVehiculos(vehiculoSeleccionado);
            eliminarCarpetaImagenes(vehiculoSeleccionado);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Eliminación Exitosa");
            alert.setHeaderText(null);
            alert.setContentText("Vehículo eliminado correctamente.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se encontró el vehículo a eliminar.");
            alert.showAndWait();
        }
    }

    private void actualizarArchivoVehiculos(Vehiculo vehiculoAEliminar) {
        File inputFile = new File(App.pathFiles + "vehiculos.txt");
        File tempFile = new File(App.pathFiles + "vehiculos_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                Vehiculo vehi = Vehiculo.Texto(linea);
                if (!vehi.equals(vehiculoAEliminar)) {
                    writer.write(linea);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de vehículos.");
            e.printStackTrace();
        }
        if (!inputFile.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }

    private void eliminarCarpetaImagenes(Vehiculo vehiculo) {
        String carpetaImagenes = App.pathImagesXVehis+ vehiculo.getCarpetaImagenes();
        File carpeta = new File(carpetaImagenes);

        if (carpeta.exists()) {
            for (File file : carpeta.listFiles()) {
                if (!file.delete()) {
                    System.out.println("No se pudo eliminar la imagen: " + file.getName());
                }
            }
            if (!carpeta.delete()) {
                System.out.println("No se pudo eliminar la carpeta de imágenes.");
            }
        } else {
            System.out.println("La carpeta de imágenes no existe.");
        }
    }

    public void editarVehi() throws IOException{
        Vehiculo vehiculoSeleccionado = nV.getContent();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditarVehiculo.fxml"));
        Parent root = loader.load();
        EditarVehiculoController controller = loader.getController();
        controller.mostrarVeh(vehiculoSeleccionado);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }
}

