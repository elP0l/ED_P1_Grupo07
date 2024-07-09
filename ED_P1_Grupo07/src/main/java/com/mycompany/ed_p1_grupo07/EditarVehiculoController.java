    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;


/**
 *
 * @author vecto
 */
import Clases.Vehiculo;
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
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

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
    private Button botonAtras;
    @FXML
    private TextField precio;
    @FXML
    private VBox imgContainer;

    private Vehiculo vehiculoActual;
  
    
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
            /*try {
                //handleButtonClick();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
*/
        });
        botonAtras.setOnAction(event -> {
            try {
                App.setRoot("inicio");
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
    
   public void editarVeh(Vehiculo vehiculo) {
    if (vehiculo != null) {
        cbmarca.setValue(vehiculo.getMarca());
        cbmodelo.setValue(vehiculo.getModelo());
        cbanio.setValue(String.valueOf(vehiculo.getAnio()));
        precio.setText(String.valueOf(vehiculo.getPrecio()));
        cbciudad.setValue(vehiculo.getCiud());
        tfkm.setText(String.valueOf(vehiculo.getKm()));
    } else {
        System.out.println("El vehículo proporcionado es nulo");
    }
   }

    public void mostrarDatosVehiculo(Vehiculo vehiculo){
        cbtipo.setValue(String.valueOf(vehiculo.getTipoVehi()));
        cbsubtipo.setValue(vehiculo.getSubtipo());
        cbubicacion.setValue(vehiculo.getUbiActual());
        cbmarca.setValue(vehiculo.getMarca());
        cbmodelo.setValue(vehiculo.getModelo());
        cbanio.setValue(String.valueOf(vehiculo.getAnio()));
        tfkm.setText(String.valueOf(vehiculo.getKm()));
        cbciudad.setValue(vehiculo.getCiud());
        precio.setText(String.valueOf(vehiculo.getPrecio()));
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
            // Actualizar vehículo con los datos ingresados
            actualizarVehiculo();
        }
    }
    public void setVehiculo(Vehiculo vehiculo) {
      
        this.vehiculoActual = vehiculo;
        if (vehiculo != null) {
            cbtipo.setValue(vehiculo.getTipoVehi().toString());
            cbmarca.setValue(vehiculo.getMarca());
            cbmodelo.setValue(vehiculo.getModelo());
            cbanio.setValue(String.valueOf(vehiculo.getAnio()));
            cbsubtipo.setValue(vehiculo.getSubtipo());
            cbubicacion.setValue(vehiculo.getUbiActual());
            cbciudad.setValue(vehiculo.getCiud());
            tfkm.setText(String.valueOf(vehiculo.getKm()));
            precio.setText(String.valueOf(vehiculo.getPrecio()));
            
        } else {
            System.out.println("El vehículo proporcionado es nulo");
        }
    }
   
    private void actualizarVehiculo() throws IOException {
        vehiculoActual.setMarca(cbmarca.getValue());
        vehiculoActual.setModelo(cbmodelo.getValue());
        vehiculoActual.setAnio(Integer.parseInt(cbanio.getValue()));
        vehiculoActual.setCiud(cbciudad.getValue());
        vehiculoActual.setKm(Integer.parseInt(tfkm.getText()));
        vehiculoActual.setPrecio(Double.parseDouble(precio.getText()));

        // Guardar cambios en archivo
        vehiculoActual.guardarEnArchivo(App.pathFiles + "vehiculos.txt");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText("Vehículo actualizado");
        alert.setContentText("Los cambios se han guardado exitosamente.");
        alert.showAndWait();
    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
         //handleButtonClick();
    }
   
}


    