/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author vecto
 */
public class Vehiculo implements Comparable<Vehiculo>{
    
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
    private int numLlantas;
    LinkedList<Accidente> lAccidentes = new LinkedList<>();
    LinkedList<Servicio> lServicios = new LinkedList<>();
    DoublyCircularLinkedList<String> lImagenes = new DoublyCircularLinkedList<>();

    public Vehiculo(String placa, String marca, String modelo, int anio, String ubiActual, TipoVehi tipoVehi) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubiActual = ubiActual;
        this.tipoVehi = tipoVehi;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.placa);
        hash = 29 * hash + Objects.hashCode(this.marca);
        hash = 29 * hash + Objects.hashCode(this.modelo);
        hash = 29 * hash + this.anio;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.ubiActual);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 29 * hash + this.km;
        hash = 29 * hash + Objects.hashCode(this.tipoVehi);
        hash = 29 * hash + Objects.hashCode(this.color);
        hash = 29 * hash + this.numLlantas;
        hash = 29 * hash + Objects.hashCode(this.lAccidentes);
        hash = 29 * hash + Objects.hashCode(this.lServicios);
        hash = 29 * hash + Objects.hashCode(this.lImagenes);
        return hash;
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

    @Override
    public int compareTo(Vehiculo o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
}
