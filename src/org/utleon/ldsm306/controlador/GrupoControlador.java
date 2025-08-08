package org.utleon.ldsm306.controlador;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.utleon.ldsm306.modelo.Alumno;

public class GrupoControlador {
    private Alumno[][] grupo;
    private int filas;
    private int columnas;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el número de filas del grupo: ");
            filas = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el número de columnas del grupo: ");
            columnas = scanner.nextInt();
            scanner.nextLine();

            grupo = new Alumno[filas][columnas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.println("\nAlumno en fila " + (i + 1) + ", columna " + (j + 1));

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();

                    System.out.print("Cuatrimestre: ");
                    int cuatrimestre = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = scanner.nextDouble();
                    scanner.nextLine();

                    grupo[i][j] = new Alumno(nombre, edad, carrera, cuatrimestre, promedio);
                }
            }

            mostrarPromediosPorFila();
            mostrarPromedioGrupalEdad();
            mostrarFilaMasDestacada();
            mostrarAlumnoMasDestacado();
    }

    private void mostrarPromediosPorFila() {
        for (int i = 0; i < filas; i++) {
            double suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += grupo[i][j].getPromedio();
            }
            System.out.println("Promedio de la fila " + (i + 1) + ": " + (suma / columnas));
        }
    }

    private void mostrarPromedioGrupalEdad() {
        int sumaEdades = 0;
        int total = filas * columnas;
        for (Alumno[] fila : grupo) {
            for (Alumno a : fila) {
                sumaEdades += a.getEdad();
            }
        }
        System.out.println("Promedio de edad del grupo: " + (sumaEdades / (double) total));
    }

    private void mostrarFilaMasDestacada() {
        int filaDestacada = 0;
        double mejorPromedio = -1;

        for (int i = 0; i < filas; i++) {
            double suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += grupo[i][j].getPromedio();
            }
            double promedio = suma / columnas;
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                filaDestacada = i;
            }
        }

        System.out.println("La fila más destacada es la " + (filaDestacada + 1) + " con promedio " + mejorPromedio);
    }

    private void mostrarAlumnoMasDestacado() {
        Alumno mejor = grupo[0][0];

        for (Alumno[] fila : grupo) {
            for (Alumno a : fila) {
                if (a.getPromedio() > mejor.getPromedio()) {
                    mejor = a;
                }
            }
        }

        System.out.println("El alumno más destacado es: " + mejor.getNombre() +
                           " con promedio de " + mejor.getPromedio());
    }
}
