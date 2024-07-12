/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_p1_grupo07;
import Clases.LinkedList;
import Clases.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author José Marin
 */
public class VehiculosViewerApp extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        // Aquí podrías llamar al método para mostrar el contenido del archivo
        showFileContent(App.pathFiles+"vehiculos.txt");
    }

    public void showFileContent(String filePath) {
        Stage stage = new Stage();
        ListView<String> listView = new ListView<>();

        List<String> lines = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.addLast(line);
                listView.getItems().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 400);

        stage.setScene(scene);
        stage.setTitle("Lista Vehiculos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
}
