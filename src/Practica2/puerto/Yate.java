package Practica2.puerto;

public class Yate extends Barco{

    int potencia;
    int numeroCamarotes;

    public Yate(String matricula, int eslora, int anioFabricacion, int potencia, int numeroCamarotes) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
        this.numeroCamarotes = numeroCamarotes;
    }

    @Override
    public float getModulo() {
        return super.getModulo()+potencia+numeroCamarotes;
    }
}
