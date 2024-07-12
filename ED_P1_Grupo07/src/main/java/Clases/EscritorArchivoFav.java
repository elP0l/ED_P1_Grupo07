/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.ed_p1_grupo07.App;
import com.mycompany.ed_p1_grupo07.PrimaryController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author fabri
 */
public class EscritorArchivoFav {
        public static void guardarEnArchivo(Vehiculo v) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(App.pathFiles + "favoritos.txt", true));
        String linea = PrimaryController.u.getNombre()+ ";" + v.toString();
        writer.write(linea);
        writer.newLine();
        writer.close();
    }
}
