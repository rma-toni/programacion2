package TrabajoFinal;

//todo salto de linea en mostrar pacientes

import TrabajoFinal.Datos.Helper;
import TrabajoFinal.Datos.FileManager;
import TrabajoFinal.Usuarios.Administrativo;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorTurnos implements Serializable {

    private String nombre;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Administrativo> administrativos;
    private ArrayList<Turno> turnos;

    private static final long serialVersionUID = 1L;

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

    public void crearPaciente(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
        if (nombre == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
        if (apellido == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        Integer dni = Helper.getIntegerJInput("Ingrese el dni: ");
        if (dni == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario del paciente: ");
        if (usuario == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String obraSocial = JOptionPane.showInputDialog("Ingrese la obra social del paciente: ");
        if (obraSocial == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        pacientes.add(new Paciente(nombre, apellido, dni, usuario, obraSocial));
        FileManager.saveData(this, this.archivo.getName());
    }

    public void mostrarPacientes(){
        if (pacientes.size() == 0){
            JOptionPane.showMessageDialog(null ,"NO HAY PACIENTES");
        }else{
            JOptionPane.showMessageDialog(null ,pacientes.toString());
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
