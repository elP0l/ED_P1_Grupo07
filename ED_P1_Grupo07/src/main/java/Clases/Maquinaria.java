/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author vecto
 */
public class Maquinaria extends Vehiculo {
    
    private String color;
    
    public Maquinaria(String placa, String marca, String modelo, int anio, String ubiActual,String color) {
        super(placa, marca, modelo, anio, ubiActual);
        this.color = color;
    }
    
}
