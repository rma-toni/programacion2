package Practica2.batalla;

public class Guerrero extends Personaje{

    public Guerrero(int nivelAtaque, int nivelDefensa) {
        super(120, nivelAtaque, nivelDefensa);
    }

    public void defender(int puntos) {
        this.vida -= (puntos - this.nivelDefensa);

        if (this.vida < 0){
            this.vida = 0;
        }
    }
}
