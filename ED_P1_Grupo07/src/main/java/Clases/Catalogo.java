/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author vecto
 */
public class Catalogo {
    
    Scanner sc = new Scanner(System.in);
    private static LinkedList<Vehiculo> lVehiculos = new LinkedList<>();

    public Catalogo() {
    }

    public static LinkedList<Vehiculo> getlVehiculos() {
        return lVehiculos;
    }

    public static void setlVehiculos(LinkedList<Vehiculo> lVehiculos) {
        Catalogo.lVehiculos = lVehiculos;
    }
    
    
    
    
}
