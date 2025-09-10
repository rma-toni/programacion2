package Practica2.puerto;

public class Velero extends Barco{

    private int numeroMastiles;

    public Velero(String matricula, int eslora, int anioFabricacion, int numeroMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.numeroMastiles = numeroMastiles;
    }

    @Override
    public float getModulo() {
        return super.getModulo()+numeroMastiles;
    }
}
