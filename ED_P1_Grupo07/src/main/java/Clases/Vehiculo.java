/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.ed_p1_grupo07.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 *
 * @author vecto
 */

    
public class Vehiculo implements Comparable<Vehiculo>{
    private String ciud;
    private String marca;
    private String modelo;
    private int anio;
    private String ubiActual;
    private double precio;
    private int km;
    private TipoVehi tipoVehi;
    private String Subtipo;
    DoublyCircularLinkedList<String> lImagenes = new DoublyCircularLinkedList<>();

    public Vehiculo( String ubiActual,String ciud, String marca, String modelo, int anio, TipoVehi tipoVehi, String Subtipo, double precio) {
        this.ciud = ciud;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubiActual = ubiActual;
        this.tipoVehi = tipoVehi;
        this.Subtipo = Subtipo;
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getUbiActual() {
        return ubiActual;
    }

    public void setUbiActual(String ubiActual) {
        this.ubiActual = ubiActual;
    }
    public DoublyCircularLinkedList<String> getlImagenes() {
        return lImagenes;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public TipoVehi getTipoVehi() {
        return tipoVehi;
    }

    public void setTipoVehi(TipoVehi tipoVehi) {
        this.tipoVehi = tipoVehi;
        
    }
    public String getSubtipo() {
        return Subtipo;
    }

    public void setSubtipo(String Subtipo) {
        this.Subtipo = Subtipo;
    }

    public String getCiud() {
        return ciud;
    }

    public void setCiud(String ciud) {
        this.ciud = ciud;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo other = (Vehiculo) obj;
        return anio == other.anio &&
               Double.compare(other.precio, precio) == 0 &&
               km == other.km &&
               Objects.equals(marca, other.marca) &&
               Objects.equals(modelo, other.modelo) &&
               Objects.equals(Subtipo, other.Subtipo) &&
               Objects.equals(ubiActual, other.ubiActual) &&
               Objects.equals(ciud, other.ciud);
    }

    public void guardarEnArchivo(String rutaArchivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
        writer.write(toString());
        writer.newLine();
        writer.close();
    }
    

    @Override
    public int compareTo(Vehiculo o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        
        return tipoVehi+","+ marca + "," + modelo + "," +Subtipo+"," +anio + "," +km+ "," +ubiActual+ "," +ciud+","+precio;  }
    
    public static Vehiculo Texto(String linea) {
        String[] partes = linea.split(","); 
        TipoVehi tpv = TipoVehi.valueOf(partes[0]);
        String marca = partes[1];
        String modelo = partes[2];
        String subtipo = partes[3];
        Integer anio = Integer.valueOf(partes[4]);
        Integer km = Integer.valueOf(partes[5]);
        String ubiAct = partes[6];
        String ciud = partes[7];
        double pre=Double.parseDouble(partes[8]);
        Vehiculo v = new Vehiculo(ubiAct, ciud, marca, modelo, anio,tpv, subtipo,pre);
        v.setKm(km);
        v.cargarImagenes(linea);
        return v;       
        
    }
    public String getCarpetaImagenes() {
    return tipoVehi + "," + marca + "," + modelo + "," + Subtipo + "," + anio + "," + km + "," + ubiActual + "," + ciud + "," + precio;
}
    
    public void cargarImagenes(String lineVehi){
        
//        try {
//            Files.walkFileTree(Paths.get(App.pathImagesXVehis), new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    if (file.getFileName().toString().equals(lineVehi)) {
//                        System.out.println("Archivo encontrado: " + file.toAbsolutePath());
//                        try {
//                            LinkedList<String> lines = (LinkedList<String>) Files.readAllLines(file);
//                            for (String line : lines) {
//                                if (line.endsWith(".png")) {
//                                    lImagenes.addLast(lineVehi+"/"+line);
//                                }
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        return FileVisitResult.TERMINATE;
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }        

        try {
            lImagenes.readAllPngFiles(Paths.get(App.pathImagesXVehis+"/"+lineVehi),lineVehi);
            System.out.println("Nombres de archivos PNG en el directorio:");
            System.out.println(lImagenes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public static List<Vehiculo> leerDesdeArchivo(String rutaArchivo) throws IOException {
        List<Vehiculo> vehiculos = new LinkedList<>();
        File file = new File(rutaArchivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Vehiculo vehiculo = Texto(line); 
                vehiculos.addLast(vehiculo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehiculos;
    }
    public static void guardarEnArchivo1(String rutaArchivo, List<Vehiculo> vehiculos) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
        for (Vehiculo vehiculo : vehiculos) {
            String linea = vehiculo.toString(); 
            writer.write(linea);
            writer.newLine();
        }
        writer.close();
    }
    
    
    
    
}

    
    
    

