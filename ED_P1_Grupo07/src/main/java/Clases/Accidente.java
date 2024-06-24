/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author José Marin
 */
public class Accidente {
    
    private String fecha;
    private NivelAccidente nivelAccidente;
    private Vehiculo vehiculo;
    
    public Accidente(String fecha, Vehiculo vehiculo, NivelAccidente nivelAccidente) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.nivelAccidente = nivelAccidente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public NivelAccidente getNivelAccidente() {
        return nivelAccidente;
    }

    public void setNivelAccidente(NivelAccidente nivelAccidente) {
        this.nivelAccidente = nivelAccidente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
