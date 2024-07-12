    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;


/**
 *
 * @author vecto
 */
import Clases.TipoVehi;
import Clases.Vehiculo;
import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class EditarVehiculoController implements Initializable {

    
     @FXML
    private ComboBox<String> cbtipo;
    
    @FXML
    private ComboBox<String> cbmodelo;
    
    @FXML
    private ComboBox<String> cbanio;
    
    @FXML
    private ComboBox<String> cbubicacion;
    
    @FXML
    private ComboBox<String> cbmarca;
    
    @FXML
    private ComboBox<String> cbsubtipo;
    
    @FXML
    private TextField tfkm;
    
    @FXML
    private ComboBox<String> cbkm;
    
    @FXML
    private ComboBox<String> cbciudad;
    
    @FXML
    private Button boton;
    @FXML
    private TextField precio;
    @FXML
    private VBox imgContainer;
    private Vehiculo vehiculoActual;
    private Vehiculo vehi;
  
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Llenar ComboBox tipo
        List<String> tipos = Arrays.asList("Autos", "Motos", "Camionetas", "Maquinarias");
        cbtipo.setItems(FXCollections.observableArrayList(tipos));
        // Llenar ComboBox marca
        List<String> marcas = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "Nissan");
        cbmarca.setItems(FXCollections.observableArrayList(marcas));
        // Llenar ComboBox año
        List<String> anios = Arrays.asList("2020", "2019", "2018", "2017", "2016");
        cbanio.setItems(FXCollections.observableArrayList(anios));
        // Llenar ComboBox ubicación
        List<String> ubicaciones = Arrays.asList("Ecuador");
        cbubicacion.setItems(FXCollections.observableArrayList(ubicaciones));
        // Llenar ComboBox subtipo
        List<String> subtipos = Arrays.asList("Sedan", "SUV", "Pick-up", "Hatchback", "Convertible");
        cbsubtipo.setItems(FXCollections.observableArrayList(subtipos));
        // Llenar ComboBox kilometraje
        List<String> kms = Arrays.asList("Km", "Millas");
        cbkm.setItems(FXCollections.observableArrayList(kms));
        // Llenar ComboBox ciudad
        List<String> ciudades = Arrays.asList("Guayaquil", "Cuenca", "Quito", "Ambato", "Manta");
        cbciudad.setItems(FXCollections.observableArrayList(ciudades));
        // Agregar listener para cbmarca que llene cbmodelo basado en la marca seleccionada
        cbmarca.setOnAction(event -> {
            String selectedMarca = cbmarca.getSelectionModel().getSelectedItem();
            if (selectedMarca != null) {
                fillModelos(selectedMarca);
            }
        });
        boton.setOnAction(event -> {
            try {
                handleButtonClick();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }

    private void fillModelos(String marca) {
        // Ejemplo de modelos basado en la marca seleccionada
        List<String> modelos;
        switch (marca) {
            case "Toyota":
                modelos = Arrays.asList("Corolla", "Camry", "Prius", "RAV4");
                break;
            case "Honda":
                modelos = Arrays.asList("Civic", "Accord", "CR-V", "Fit");
                break;
            case "Ford":
                modelos = Arrays.asList("Fiesta", "Focus", "Mustang", "Explorer");
                break;
            case "Chevrolet":
                modelos = Arrays.asList("Spark", "Malibu", "Impala", "Equinox");
                break;
            case "Nissan":
                modelos = Arrays.asList("Versa", "Sentra", "Altima", "Murano");
                break;
            default:
                modelos = Arrays.asList();
                break;
        }
        cbmodelo.setItems(FXCollections.observableArrayList(modelos));
    }
    
   public void mostrarVeh(Vehiculo vehiculo) {
        if (vehiculo != null) {
            cbtipo.setValue(vehiculo.getTipoVehi().toString());
            cbmarca.setValue(vehiculo.getMarca());
            cbubicacion.setValue(vehiculo.getUbiActual());
            cbsubtipo.setValue(vehiculo.getSubtipo());
            cbmodelo.setValue(vehiculo.getModelo());
            cbanio.setValue(String.valueOf(vehiculo.getAnio()));
            precio.setText(String.valueOf(vehiculo.getPrecio()));
            cbciudad.setValue(vehiculo.getCiud());
            tfkm.setText(String.valueOf(vehiculo.getKm()));
            cbkm.setValue("km");
            this.vehi=vehiculo;
            mostrarImagenes(vehiculo); 
        } else {
            System.out.println("El vehículo proporcionado es nulo");
        }
   }
   private void mostrarImagenes(Vehiculo vehiculo) {
        String nombreCarpeta = construirNombreCarpeta(vehiculo);
        String pathBase = "src/main/resources/imagesXVehis/";
        File carpeta = new File(pathBase + nombreCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".png")) {
                        Image imagen = new Image(archivo.toURI().toString());
                        ImageView imageView = new ImageView(imagen);
                        imageView.setFitWidth(100);
                        imageView.setFitHeight(100);
                        imageView.setPreserveRatio(true);
                        imageView.setSmooth(true);
                        imageView.setCache(true);
                        imgContainer.getChildren().add(imageView);
                    }
                }
            }
        }
    }

    public void editarVehiculo() throws IOException{
        String tipo = cbtipo.getValue();
        
        String marca = cbmarca.getValue();
        
        String modelo = cbmodelo.getValue();
       
        String subtipo= cbsubtipo.getValue();
        
        int anio = Integer.parseInt(cbanio.getValue());
      
        int km = Integer.parseInt(tfkm.getText());
        String ubicacion = cbubicacion.getValue();
        
        String ciu = cbciudad.getValue();
        double prec=Double.parseDouble(precio.getText()); 
        TipoVehi tipoVehi = TipoVehi.valueOf(tipo.toUpperCase());
        vehiculoActual = new Vehiculo(ubicacion,ciu,marca,modelo,anio,tipoVehi,subtipo,prec);
        vehiculoActual.setKm(km);
        Clases.List<Vehiculo> vehi2= Vehiculo.leerDesdeArchivo(App.pathFiles + "vehiculos.txt");
        boolean encontrado = false;
        for (Vehiculo vehiculo : vehi2) {
            if (vehiculo.equals(vehi)) {
            vehiculo.setMarca(vehiculoActual.getMarca());
            vehiculo.setModelo(vehiculoActual.getModelo());
            vehiculo.setSubtipo(vehiculoActual.getSubtipo());
            vehiculo.setAnio(vehiculoActual.getAnio());
            vehiculo.setKm(vehiculoActual.getKm());
            vehiculo.setUbiActual(vehiculoActual.getUbiActual());
            vehiculo.setCiud(vehiculoActual.getCiud());
            vehiculo.setPrecio(vehiculoActual.getPrecio());
            encontrado = true;
            renombrarCarpetaImagenes(vehi, vehiculoActual);
            break;
            }
        }
        if (encontrado) {
            Vehiculo.guardarEnArchivo1(App.pathFiles + "vehiculos.txt",vehi2);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Vehículo modificado");
            alert.setContentText("Se ha modificado el vehículo exitosamente.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Vehículo no encontrado");
            alert.setContentText("No se encontró el vehículo que intentas modificar.");
            alert.showAndWait();
        }
    }
    
    private String construirNombreCarpeta(Vehiculo vehiculo) {
        return String.join(",",vehiculo.getTipoVehi().toString(),vehiculo.getMarca(),vehiculo.getModelo(),vehiculo.getSubtipo(),String.valueOf(vehiculo.getAnio()),String.valueOf(vehiculo.getKm()),vehiculo.getUbiActual(),vehiculo.getCiud(),String.valueOf(vehiculo.getPrecio()));
    }
    public void renombrarCarpetaImagenes(Vehiculo vehiculoAnterior, Vehiculo vehiculoNuevo) {
        String nombreCarpetaAnterior = construirNombreCarpeta(vehiculoAnterior);
        String nombreCarpetaNuevo = construirNombreCarpeta(vehiculoNuevo);
        String pathBase = "src/main/resources/imagesXVehis/";
        File carpetaAnterior = new File(pathBase + nombreCarpetaAnterior);
        File carpetaNueva = new File(pathBase + nombreCarpetaNuevo);
        if (carpetaAnterior.exists()) {
            boolean renombrado = carpetaAnterior.renameTo(carpetaNueva);
            if (!renombrado) {
                System.out.println("Error al renombrar la carpeta de imágenes");
            }
        }else {
            System.out.println("La carpeta anterior no existe");
        }
    }
    private void handleButtonClick() throws IOException {
       if (cbtipo.getValue() == null || cbmodelo.getValue() == null || cbanio.getValue() == null ||
            cbubicacion.getValue() == null || cbmarca.getValue() == null || cbsubtipo.getValue() == null ||
            cbkm.getValue() == null || cbciudad.getValue() == null || tfkm.getText().isEmpty() ||precio.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incompletos");
            alert.setContentText("Por favor, completa todos los campos antes de continuar.");
            alert.showAndWait();
        } else {
            editarVehiculo();
        }
    }
    @FXML
    private void registrar(ActionEvent event) throws IOException {
         handleButtonClick();
    }
    

}