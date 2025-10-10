package TrabajoFinal;

import TrabajoFinal.Usuarios.Administrativo;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;

import java.io.Serializable;
import java.util.ArrayList;

public class GestorTurnos implements Serializable {

    private String nombre;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Administrativo> administrativos;
    private ArrayList<Turno> turnos;

    public GestorTurnos(String nombre){
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.administrativos = new ArrayList<>();
        this.turnos = new ArrayList<>();
    };


    //region GET AND SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    //endregion
}
