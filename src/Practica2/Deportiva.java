package Practica2;

public class Deportiva extends Barco{

    private int potencia;

    public Deportiva(String matricula, int eslora, int anioFabricacion, int potencia) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
    }

    @Override
    public float getModulo() {
        return super.getModulo()+potencia;
    }
}
