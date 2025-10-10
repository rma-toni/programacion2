package TrabajoFinal;

import Practica3.Helper;
import TrabajoFinal.Datos.FileManager;
import TrabajoFinal.Usuarios.Administrativo;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorTurnos implements Serializable {

    private String nombre;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Administrativo> administrativos;
    private ArrayList<Turno> turnos;

    private  File archivo;

    public GestorTurnos(){

        String fileName = "datos.dat";
        archivo = new File(fileName);

        if (archivo.exists()){
            GestorTurnos carga = FileManager.loadData(fileName);

            this.nombre = carga.getNombre();
            this.pacientes = carga.getPacientes();
            this.medicos = carga.getMedicos();
            this.administrativos = carga.getAdministrativos();
            this.turnos = carga.getTurnos();
        }else{
            this.nombre = Helper.getString("Ingrese el nombre del establecimiento: ");
            this.pacientes = new ArrayList<>();
            this.medicos = new ArrayList<>();
            this.administrativos = new ArrayList<>();
            this.turnos = new ArrayList<>();
            FileManager.saveData(this, fileName);
        }

    };

    public void deleteData(){
        if (archivo.delete()){
            System.out.println("Los datos fueron eliminados correctamente.");
        }else {
            System.out.println("No se pudo elimnar los datos.");
        }


    }

    //region GET AND SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    //endregion
}
