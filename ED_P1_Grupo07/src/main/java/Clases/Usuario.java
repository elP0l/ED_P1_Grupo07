/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vecto
 */
public class Usuario {
    
    private String correo;
    private String contra;
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario(String correo, String contra, String nombre, String apellido, int edad) {
        this.correo = correo;
        this.contra = contra;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Usuario(String correo, String contra) {
        this.correo = correo;
        this.contra = contra;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean validarCorreo(String correo, String contra) {
        return this.correo.equals(correo) && this.contra.equals(contra);
    }
    public static Usuario Texto(String linea) {
        String[] partes = linea.split(";"); 
        if (partes.length >= 5) { 
            String correo = partes[0].trim();
            String contra = partes[1].trim();
            String nombre = partes[2].trim();
            String apellido = partes[3].trim();
            int edad = Integer.parseInt(partes[4].trim());
            return new Usuario(correo, contra, nombre, apellido, edad);
        } else {
            throw new IllegalArgumentException("Formato de línea incorrecto para crear Usuario");
        }
    }
     public void guardarEnArchivo(String rutaArchivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
        writer.write(toString());
        writer.newLine();
        writer.close();
    }

    @Override
    public String toString() {
        return  correo + "," + contra + "," + nombre + "," + apellido + "," + edad;
    }

    
    
}
