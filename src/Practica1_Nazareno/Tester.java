package Practica1_Nazareno;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {


        Scanner scaner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de su mascota: ");
        String nombre = scaner.nextLine();
        MascotaVirtual mascota = new MascotaVirtual(nombre);


        int opcion = 0;

        while (mascota.estaViva() && opcion != 9) {
            System.out.println("--- Menú ---");
            System.out.println("1. Comer");
            System.out.println("2. Beber");
            System.out.println("3. Dormir");
            System.out.println("4. Despertar");
            System.out.println("5. Caminar");
            System.out.println("6. Correr");
            System.out.println("7. Saltar");
            System.out.println("8. Estado");
            System.out.println("9. Salir");
            System.out.print("Elija una opción: ");

            opcion = scaner.nextInt();

            if (opcion == 1) {
                mascota.comer();
            } else if (opcion == 2) {
                mascota.beber();
            } else if (opcion == 3) {
                mascota.dormir();
            } else if (opcion == 4) {
                mascota.Despertar();
            } else if (opcion == 5) {
                mascota.Caminar();
            } else if (opcion == 6) {
                mascota.Correr();
            } else if (opcion == 7) {
                mascota.Saltar();
            } else if (opcion == 8) {
                System.out.println("Mascota: " + mascota.getNombre());
                System.out.println("Energía: " + mascota.getEnergia());
                System.out.println("Humor: " + mascota.getHumor());
                System.out.println("Durmiendo: " + mascota.estaDurmiendo());
                System.out.println("Viva: " + mascota.estaViva());
            } else if (opcion == 9) {
                System.out.println("Saliendo del juego...");
            } else {
                System.out.println("Opción incorrecta.");
            }
        }


    }

}