package Practica2.batalla;

public class Personaje {

    int vida;
    private int nivelAtaque;
    int nivelDefensa;

    public Personaje(int vida, int nivelAtaque, int nivelDefensa){
        this.vida = vida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
    }

    public int atacar(){
        return  nivelAtaque;
    }

    public void defender(int puntos){

    }

    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return " vida=" + vida +
                ", nivelAtaque=" + nivelAtaque +
                ", nivelDefensa=" + nivelDefensa;
    }
}
