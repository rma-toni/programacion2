package TrabajoFinal.Usuarios;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class Medico extends Usuario implements Serializable {

    private String especialidad;
    private int matricula;
    private ArrayList<dateTurno> disponibles;

    // contructor
    public Medico(String nombre, String apellido, int dni, String usuario, String especialidad, int matricula) {
        super(nombre, apellido, dni, usuario);
        this.especialidad = especialidad;
        this.matricula = matricula;
        this.disponibles = new ArrayList<>();
    }
    // getter y setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public ArrayList<dateTurno> getDisponibles() {
        return disponibles;
    }

    //toString
    @Override
    public String toString() {
        return "[Nombre:"+getNombre()+", Apellido: "+getApellido()+", DNI: "+ getDni()+", usuario: " +getUsuario()+", Especialidad: "+getEspecialidad()+", Matricula: "+getMatricula()+ "]";
    }

    public void addTurno(LocalDate fecha, LocalTime hora){
        disponibles.add(new dateTurno(hora, fecha));
    }

}