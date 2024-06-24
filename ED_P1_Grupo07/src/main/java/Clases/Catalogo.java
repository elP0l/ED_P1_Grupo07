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
    LinkedList<Vehiculo> lVehiculos = new LinkedList<>();
    
    public void verCatalogo(){
        
    }
    
    public Vehiculo crearVehiculo(){
        Vehiculo vehi = null;
        System.out.print("Ingrese los siguientes datos de su vehículo: ");
        
        System.out.print("Ingrese la placa: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la ubicación actual: ");
        String ubiAct = sc.nextLine();
        
        
        //vehi = new (placa,);
        return vehi;     
    }
    
}
