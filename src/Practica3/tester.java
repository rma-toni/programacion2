package Practica3;

//TODO Constructores

import java.util.ArrayList;

public class tester {
    public static void main(String[] args) {

        while (true){
            int opcion = -1;

            ArrayList<Asignatura> asignaturas = new ArrayList<>();

            System.out.println("---------- MENU ----------");
            System.out.println("1 - Crear materia");
            System.out.println("2 - Mostrar materias");

            switch (opcion){

                case 1:
                    asignaturas.add(crearAsignatura());
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Opcion invalida, ingrese una opcion valida");

            }
        }

    }

    public static Asignatura crearAsignatura(){
        String nombre = Helper.getString("Ingrese el nombre de la meteria: ");
        int anio = Helper.getInteger("Ingrese el año al que corresponde la materia: ");
        int horas = Helper.getInteger("Ingrese la cantidad de horas que tiene la materia: ");
        return new Asignatura(nombre, anio, horas);
    }
}
