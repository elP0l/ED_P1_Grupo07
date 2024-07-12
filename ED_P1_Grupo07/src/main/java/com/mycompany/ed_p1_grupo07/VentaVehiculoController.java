    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;


/**
 *
 * @author fabri
 */
import Clases.LinkedList;
import Clases.Vehiculo;
import Clases.TipoVehi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VentaVehiculoController implements Initializable {
    
    @FXML
    private Stage stage;

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
    private Button imagen;
    
    private File imagenElegida;
    @FXML
    private TextField precio;
    @FXML
    private VBox imgContainer;
    private LinkedList<String> lImagenes = new LinkedList<>();
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarVehiculos();
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
        botonAtras.setOnAction(event -> {
            try {
                stage.close();
                App.setRoot("inicio");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         });
        imagen.setOnAction(this::subirImagen);
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
    
    private void handleButtonClick() throws IOException {
        if (cbtipo.getValue() == null || cbmodelo.getValue() == null || cbanio.getValue() == null ||
            cbubicacion.getValue() == null || cbmarca.getValue() == null || cbsubtipo.getValue() == null ||
            cbkm.getValue() == null || cbciudad.getValue() == null || tfkm.getText().isEmpty() ||precio.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incompletos");
            alert.setContentText("Por favor, completa todos los campos antes de continuar.");
            alert.showAndWait();
        } else if (lImagenes.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Imágenes no subidas");
            alert.setContentText("Por favor, sube al menos una imagen antes de continuar.");
            alert.showAndWait();
        } else {
            // Crear objeto Vehiculo
            String tipo = cbtipo.getValue();
            String marca = cbmarca.getValue();
            String modelo = cbmodelo.getValue();
            String subtipo= cbsubtipo.getValue();
            int anio = Integer.parseInt(cbanio.getValue());
            int km = Integer.parseInt(tfkm.getText());
            String ubicacion = cbubicacion.getValue();
            TipoVehi tipoVehi = TipoVehi.valueOf(tipo.toUpperCase());
            String ciu = cbciudad.getValue();
            double prec=Double.parseDouble(precio.getText());
            Vehiculo vehiculo = new Vehiculo(ubicacion,ciu,marca,modelo,anio,tipoVehi,subtipo,prec);
            vehiculo.setKm(km);
            vehiculo.setUbiActual(ubicacion);
            String nombreCarpeta = tipo.toUpperCase() + "," + marca + "," + modelo + "," + subtipo + "," + anio + "," + km + "," + ubicacion + "," + ciu + "," + prec;
            Path carpetaVehiculo = Paths.get("src/main/resources/imagesXVehis/" + nombreCarpeta);
            Files.createDirectories(carpetaVehiculo);
            for (String imagenNombre : lImagenes) {
                Path origen = Paths.get("src/main/resources/imagesXVehis/" + imagenNombre);
                Path destino = Paths.get(carpetaVehiculo.toString() + "/" + imagenNombre);
                Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            }
            vehiculo.guardarEnArchivo(App.pathFiles + "vehiculos.txt");
            
            //
            stage.close();
            mostrarVehiculos();
      
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Vehículo creado");
            alert.setContentText("Se ha creado un nuevo vehículo exitosamente.");
            alert.showAndWait();
        }
    }
    @FXML
    private void registrar(ActionEvent event) throws IOException {
         handleButtonClick();
    }
    
    @FXML
     private void mostrarVehiculos() {
        stage = new Stage();
        ListView<String> listView = new ListView<>();

        Stack<String> lines = leerArchivo(App.pathFiles+"vehiculos.txt");
        listView.getItems().addAll(lines);

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 400);

        stage.setScene(scene);
        stage.setTitle("Lista de Vehículos");
        stage.show();
    }
    
    @FXML
    private Stack<String> leerArchivo(String filePath) {
        Stack<String> lineas = new Stack<>();
        FXCollections.observableArrayList(lineas);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineas.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineas;
    }
    

    @FXML
    private void subirImagen(ActionEvent event) {
        int imagre = 0;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imágenes", "*.png"));
        List<File> imagenesElegidas = fileChooser.showOpenMultipleDialog(boton.getScene().getWindow());
        if (imagenesElegidas != null && !imagenesElegidas.isEmpty()) {
            for (File imagenElegida : imagenesElegidas) {
                try {
                    File destino = new File(App.pathImagesXVehis + "/" + imagenElegida.getName());
                    Files.copy(imagenElegida.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    lImagenes.addLast(destino.getName());
                    Image imagen = new Image(imagenElegida.toURI().toString());
                    ImageView imageView = new ImageView(imagen);
                    imageView.setFitWidth(100); 
                    imageView.setFitHeight(100);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    imageView.setCache(true);
                    VBox.setMargin(imageView, new Insets(10));
                    imgContainer.getChildren().add(imageView); 
                    imagre++;
                }catch (IOException e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al subir imagen");
                    alert.setContentText("No se pudo subir la imagen: " + e.getMessage());
                    alert.showAndWait();
                }
                
           }
        }
    }
}



    