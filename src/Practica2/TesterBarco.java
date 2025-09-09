package Practica2;

import Practica3.Helper;

public class TesterBarco {

    public static void main(String[] args) {

        System.out.println("--------- ALQUILER PUERTO ----------");

        Barco barco = crearBarco();

        if (barco == null){
            System.out.println("No se ingrese una embarcacion.");
        }else{

        }

    }

    public static Barco crearBarco(){
        String matricula = Helper.getString("Ingrese la matricula: ");
        int anio = Helper.getInteger("Ingrese el año de fabricacion: ");
        int eslora = Helper.getInteger("Ingrese los metros de eslora: ");

        int option;
        System.out.println("¿Cual es el tipo de barco?");
        System.out.println("1 - BARCO NORMAL");
        System.out.println("2 - VELERO");
        System.out.println("3 - DEPORTIVO");
        System.out.println("4 - YATE");
        option = Helper.getInteger("Ingrese la opcion elegida: ");
        Barco barco;

        switch (option){
            case 1:
                barco = new Barco(matricula,anio,eslora);
                break;
            case 2:
                int numeroMastiles = Helper.getInteger("Ingrese el numero de mastiles: ");
                barco = new Velero(matricula,anio,eslora,numeroMastiles);
                break;
            case 3:
                int potencia = Helper.getInteger("Ingrese la potencia: ");
                barco = new Deportiva(matricula,anio,eslora,potencia);
                break;
            case 4:
                potencia = Helper.getInteger("Ingrese la potencia: ");
                int numeroCamarotes = Helper.getInteger("Ingrese el numero de camarotes: ");
                barco = new Yate(matricula,anio,eslora,potencia,numeroCamarotes);
                break;
            default:
                barco = null;
                System.out.println("Opcion invalida");
        }
        return barco;
    }
}
