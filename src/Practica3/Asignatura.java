package Practica3;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private int anio;
    private int horas;
    private ArrayList<Alumno> alumnosInscriptos;

    public Asignatura(String nombre, int anio, int horas){
        this.nombre = nombre;
        this.anio = anio;
        this.horas = horas;
        alumnosInscriptos = new ArrayList<>();
    }

    public int alumnosInscriptos(){
        return alumnosInscriptos.size();
    }

    @Override
    public String toString() {

        return super.toString();
    }
}


