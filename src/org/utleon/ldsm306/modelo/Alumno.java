
package org.utleon.ldsm306.modelo;

public class Alumno {
    private String nombre;
    private int edad;
    private String carrera;
    private int cuatri;
    private double promedio;

    public Alumno(String nombre, int edad, String carrera, int cuatrimestre, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.cuatri = cuatrimestre;
        this.promedio = promedio;
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getCuatrimestre() {
        return cuatri;
    }

    public double getPromedio() {
        return promedio;
    }
}

   

    

