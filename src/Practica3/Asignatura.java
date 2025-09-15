package Practica3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

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

    public void inscribirAlumno(Alumno alumno){
        alumnosInscriptos.add(alumno);
    }

    public void mostrarAlumnos(){
        for (Alumno alumno : alumnosInscriptos){
            System.out.println(alumno.toString());
        }
    }

    public void mostrarAlumnosCondicion(String condicion){
        for (Alumno alumno : alumnosInscriptos){
            if (Objects.equals(alumno.getCondicion(), condicion)){
                System.out.println(alumno.toString());
            }
        }
    }

    public void mostarAlumnosOrdenadosPorNota() {
        ArrayList<Alumno> ordenados = new ArrayList<>(alumnosInscriptos);
        //.reversed
        //.sort recibe un comparador de enteros
        //Alumno::getNotaFinal es solo una forma corda de escribir el lambda (Alumno a) -> a.getNotaFinal()
        ordenados.sort(Comparator.comparingInt(Alumno::getNotaFinal).reversed());
        for (Alumno alumno : ordenados){
            System.out.println(alumno.toString());
        }
    }

    public void mostrarAlumnosOrdenadosPorNombre() {
        ArrayList<Alumno> ordenados = new ArrayList<>(alumnosInscriptos);
        ordenados.sort(Comparator.comparing(Alumno::getNombre));
        for (Alumno alumno : ordenados){
            System.out.println(alumno.toString());
        }
    }

    public void mostrarAlumnosOrdenadosPorApellido() {
        ArrayList<Alumno> ordenados = new ArrayList<>(alumnosInscriptos);
        ordenados.sort(Comparator.comparing(Alumno::getApellido));
        for (Alumno alumno : ordenados){
            System.out.println(alumno.toString());
        }
    }

    //region GETTERS

    public String getNombre() {
        return nombre;
    }

    //endregion

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Año: "+anio+", Horas: "+horas;
    }
}


