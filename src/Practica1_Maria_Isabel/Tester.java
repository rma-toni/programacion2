package Practica1_Maria_Isabel;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre de su mascota: ");
        String nombre = sc.nextLine();
        MascotaVirtual m = new MascotaVirtual(nombre);

        int opcion;
        do {
            System.out.println("\nEstado: " + m);
            System.out.println("1. Comer");
            System.out.println("2. Beber");
            System.out.println("3. Dormir");
            System.out.println("4. Despertar");
            System.out.println("5. Caminar");
            System.out.println("6. Correr");
            System.out.println("7. Saltar");
            System.out.println("0. Salir");
            System.out.print("Elija una accion: ");
            opcion = sc.nextInt();

            boolean resultado = false;
            switch (opcion) {
                case 1: resultado = m.comer(); break;
                case 2: resultado = m.beber(); break;
                case 3: resultado = m.dormir(); break;
                case 4: resultado = m.despertar(); break;
                case 5: resultado = m.caminar(); break;
                case 6: resultado = m.correr(); break;
                case 7: resultado = m.saltar(); break;
                case 0: System.out.println("Fin del juego."); break;
                default: System.out.println("Opcion invalida."); break;
            }

            if (!resultado && opcion != 0) {
                System.out.println(" Accion no valida (mascota muerta, dormida o limite alcanzado).");
            }

            if (!m.estaVivo()) {
                System.out.println(" Tu mascota ha muerto. Fin del juego.");
                break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
