package Practica2.puerto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Barco {
    public final int VALOR = 20000;

    private String matricula;
    private int eslora;
    private int anioFabricacion;

    public Barco(String matricula, int eslora, int anioFabricacion){
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public float getAlquiler(LocalDate diaInicial, LocalDate diaFinal){
        int dias = (int) (ChronoUnit.DAYS.between(diaInicial,diaFinal)+1);
        return dias * this.getModulo() * VALOR;
    }

    public float getModulo(){
        return eslora*10;
    }

    @Override
    public String toString() {
        return ", matricula='" + matricula + '\'' +
                ", eslora=" + eslora +
                ", anioFabricacion=" + anioFabricacion;
    }
}
