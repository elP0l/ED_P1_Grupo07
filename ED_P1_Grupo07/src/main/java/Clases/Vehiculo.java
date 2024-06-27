/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author vecto
 */

    
public class Vehiculo implements Comparable<Vehiculo>{
    private String ciud;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private double peso;
    private String ubiActual;
    private double precio;
    private int km;
    private TipoVehi tipoVehi;
    private String color;
    private String Subtipo;
    private int numLlantas;
    LinkedList<Accidente> lAccidentes = new LinkedList<>();
    LinkedList<Servicio> lServicios = new LinkedList<>();
    DoublyCircularLinkedList<String> lImagenes = new DoublyCircularLinkedList<>();

    public Vehiculo( String ubiActual,String ciud, String marca, String modelo, int anio, TipoVehi tipoVehi, String Subtipo) {
        this.ciud = ciud;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubiActual = ubiActual;
        this.tipoVehi = tipoVehi;
        this.Subtipo = Subtipo;
    }

    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUbiActual() {
        return ubiActual;
    }

    public void setUbiActual(String ubiActual) {
        this.ubiActual = ubiActual;
    }

    public LinkedList<Accidente> getlAccidentes() {
        return lAccidentes;
    }

    public LinkedList<Servicio> getlServicios() {
        return lServicios;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumLlantas() {
        return numLlantas;
    }

    public void setNumLlantas(int numLlantas) {
        this.numLlantas = numLlantas;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.placa, other.placa);
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
        
        return tipoVehi+","+ marca + "," + modelo + "," +Subtipo+"," +anio + "," +km+ "," +ubiActual+ "," +ciud;  }
    
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

        return new Vehiculo(ubiAct, ciud, marca, modelo, anio,tpv, subtipo);       
        
    }
    
    
}

    
    
    

