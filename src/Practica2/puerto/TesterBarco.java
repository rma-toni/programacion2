package Practica2.puerto;

import java.time.LocalDate;

public class TesterBarco {
    public static void main(String[] args) {
        System.out.println("---------- ALQUILER PUERTO ----------");

        Barco barco = crearBarco();

        LocalDate inicioAlquiler = Helper.getLocalDate("Ingrese la fecha inicial de alquiler (DD/MM/AAAA): ", "/");  // Fecha inicial
        LocalDate finAlquiler = Helper.getLocalDate("Ingrese la fecha final de alquiler (DD/MM/AAAA): ", "/");

        if (inicioAlquiler.isBefore(finAlquiler)) {
            System.out.println("El valor de el alquiler es de $"+barco.getAlquiler(inicioAlquiler,finAlquiler));
        } else {
            System.out.println("Las fechas ingresadas son invalidas.");
        }



    }

    public static Barco crearBarco(){
        String matricula = Helper.getString("Ingrese la matricula: ");
        int eslora = Helper.getInteger("Ingrese los metros de eslora: ");
        int anioFabricacion = Helper.getInteger("Ingrese el año de fabricacion: ");

        System.out.println("1 - Barco comun");
        System.out.println("2 - Velero");
        System.out.println("3 - Deportivo");
        System.out.println("4 - Yate");

        int option = Helper.getInteger("Ingrese la opcion elegida: ");

        Barco barco;

        switch (option){
            case 1:
                barco = new Barco(matricula,eslora,anioFabricacion);
                break;
            case 2:
                int velas = Helper.getInteger("Ingrese la cantidad de velas: ");
                barco = new Velero(matricula,eslora,anioFabricacion, velas);
                break;
            case 3:
                int potencia = Helper.getInteger("Ingrese la potencia del motor: ");
                barco = new Deportiva(matricula,eslora,anioFabricacion, potencia);
                break;
            case 4:
                potencia = Helper.getInteger("Ingrese la potencia del motor: ");
                int camarotes = Helper.getInteger("Ingrese el numero de camarotes: ");
                barco = new Yate(matricula,eslora,anioFabricacion, potencia, camarotes);
                break;
            default:
                System.out.println("Opcion invalida");
                barco = null;
        }

        return barco;
    }
}
