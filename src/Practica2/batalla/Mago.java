package Practica2.batalla;

public class Mago extends Personaje {
    public Mago(int nivelAtaque, int nivelDefensa) {
        super(100, nivelAtaque, nivelDefensa);
    }

    @Override
    public void defender(int puntos) {
        this.vida -= (puntos - (int) (this.nivelDefensa * 0.8));
        if (this.vida < 0){
            this.vida = 0;
        }
    }
}
