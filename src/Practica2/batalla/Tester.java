package Practica2.batalla;

import java.util.Random;

//TODO Solucionar problemas de encapsulamiento
//TODO Mostrar mensaje con el ganador

public class Tester {
    public static void main(String[] args) {

        Random rand = new Random();
        int turno;

        for (int combate = 1; combate <= 3; combate++){
            System.out.println("----------- BATALLA "+combate+" ----------");

            Mago mago = new Mago(40, 20);
            Guerrero guerrero = new Guerrero(35, 20);

            boolean turnoMago = rand.nextInt(2) == 0;
            while (mago.getVida() > 0 && guerrero.getVida() > 0) {
                if (turnoMago){
                    System.out.println("El mago ataca!");
                    guerrero.defender(mago.atacar());

                    System.out.println(guerrero.toString());
                    System.out.println(mago.toString());
                }else{
                    System.out.println("El guerrero ataca!");
                    mago.defender(guerrero.atacar());

                    System.out.println(guerrero.toString());
                    System.out.println(mago.toString());
                }
                // Cambiar turno
                turnoMago = !turnoMago;
            }

            if(mago.getVida() == 0){
                System.out.println("El guerrero gano!\n\n");
            }else{
                System.out.println("El mago gano!\n\n");
            }
        }
    }
}
