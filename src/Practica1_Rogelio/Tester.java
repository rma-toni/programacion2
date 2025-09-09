package Practica1_Rogelio;

//TODO Logica de objeto
//TODO Logica de menu para interactuar con el objeto

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el nombre de su mascota virtual: ");
        String nombre = scan.nextLine();
        MascotaVirtual mascota1 = new MascotaVirtual(nombre);
        while (mascota1.estadoVivo()){
            System.out.println("----------------- MASCOTA VIRTUAL: " + mascota1.getNombre() + " -----------------");
            System.out.println("Humor: "+mascota1.obtenerHumor());
            System.out.println(mascota1.toString());
            System.out.println("1 - Comer");
            System.out.println("2 - Beber");
            System.out.println("3 - Caminar");
            System.out.println("4 - Correr");
            System.out.println("5 - Saltar");
            System.out.println("6 - Dormir");
            System.out.println("7 - Despertar");
            System.out.println("0 - Salir");
            int option = getInteger("Ingrese la opcion elegida: ", scan);
            switch (option){
                case 1:
                    mascota1.comer();
                    break;
                case 2:
                    mascota1.beber();
                    break;
                case 3:
                    mascota1.caminar();
                    break;
                case 4:
                    mascota1.correr();
                    break;
                case 5:
                    mascota1.saltar();
                    break;
                case 6:
                    mascota1.dormir();
                    break;
                case 7:
                    mascota1.despertar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("La opción elegida no es valida.");
                    break;
            }
        }
    }

    //region Inputs
    public static int getInteger(String inputMessage, Scanner scanner){
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (Exception exception) {
                System.out.println("El valor ingresado no es un numero entero.");
            }
        }
    }
    //enregion
}

