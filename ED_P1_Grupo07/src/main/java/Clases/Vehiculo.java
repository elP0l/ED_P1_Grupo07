/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author vecto
 */
public abstract class Vehiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private double peso;
    private String ubiActual;
    private double precio;
    private int km;
    LinkedList<Accidente> lAccidentes = new LinkedList<>();
    LinkedList<Servicio> lServicios = new LinkedList<>();
    DoublyCircularLinkedList<String> lImagenes = new DoublyCircularLinkedList<>();

    public Vehiculo(String placa, String marca, String modelo, int anio, String ubiActual) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.ubiActual = ubiActual;
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
    
    
    
}
