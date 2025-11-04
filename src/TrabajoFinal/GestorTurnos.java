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
        if (pacientes.isEmpty()){
            JOptionPane.showMessageDialog(null ,"NO HAY PACIENTES");
        }else{
            StringBuilder message = new StringBuilder();
            for (Paciente paciente : pacientes){
                message.append(paciente.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null ,message);
        }
    }

    public void eliminarPaciente(){
        if (pacientes.isEmpty()){
            JOptionPane.showMessageDialog(null,"NO HAY PACIENTES!");
        }else{
            String usuarioPaciente = JOptionPane.showInputDialog("Ingrese el usuario del paciente que desea eliminar: ");
            Paciente pacienteEliminar = null;
            for (Paciente paciente : pacientes){
                if (paciente.getUsuario().equals(usuarioPaciente)){
                    pacienteEliminar = paciente;
                }
            }
            if (pacienteEliminar == null){
                JOptionPane.showMessageDialog(null, "PACIENTE NO ENCONTRADO!");
            }else{
                if (JOptionPane.showConfirmDialog(null, pacienteEliminar.toString()+". ELIMINAR?") == 0){
                    pacientes.remove(pacienteEliminar);
                    JOptionPane.showMessageDialog(null,"Paciente eliminado!");
                    FileManager.saveData(this, archivo.getName());
                }else{
                    JOptionPane.showMessageDialog(null,"Operacion cancelada.");
                }
            }
        }
    }

    public void crearMedico(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico: ");
        if (nombre == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico: ");
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
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario del medico: ");
        if (usuario == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del medico: ");
        if (especialidad == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        Integer matricula = Helper.getIntegerJInput("Ingrese el numero de matricula: ");
        if (matricula == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        medicos.add(new Medico(nombre, apellido, dni, usuario, especialidad, matricula));
        FileManager.saveData(this, this.archivo.getName());
    }

    public void mostrarMedicos(){
        if (medicos.isEmpty()){
            JOptionPane.showMessageDialog(null ,"NO HAY MEDICOS");
        }else{
            StringBuilder message = new StringBuilder();
            for (Medico medico : medicos){
                message.append(medico.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null ,message);
        }
    }

    public void eliminarMedico(){
        if (medicos.isEmpty()){
            JOptionPane.showMessageDialog(null,"NO HAY MEDICOS!");
        }else{
            String usuarioMedico = JOptionPane.showInputDialog("Ingrese el usuario del paciente que desea eliminar: ");
            Medico  medicoEliminar = null;
            for (Medico medico : medicos){
                if (medico.getUsuario().equals(usuarioMedico)){
                    medicoEliminar = medico;
                }
            }
            if (medicoEliminar == null){
                JOptionPane.showMessageDialog(null, "MEDICO NO ENCONTRADO!");
            }else{
                if (JOptionPane.showConfirmDialog(null, medicoEliminar.toString()+". ELIMINAR?") == 0){
                    medicos.remove(medicoEliminar);
                    JOptionPane.showMessageDialog(null,"Medico eliminado!");
                    FileManager.saveData(this, archivo.getName());
                }else{
                    JOptionPane.showMessageDialog(null,"Operacion cancelada.");
                }
            }
        }
    }

    public void crearAdministrativo(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del administrativo: ");
        if (nombre == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del administrativo: ");
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
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario del administrativo: ");
        if (usuario == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        String sector = JOptionPane.showInputDialog("Ingrese la especialidad del administrativo: ");
        if (sector == null) {
            // El usuario presionó "Cancelar"
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return; // Termina la función aquí
        }
        administrativos.add(new Administrativo(nombre, apellido, dni, usuario, sector));
        FileManager.saveData(this, this.archivo.getName());
    }

    public void mostrarAdministrativos(){
        if (administrativos.isEmpty()){
            JOptionPane.showMessageDialog(null ,"NO HAY ADMINISTRATIVOS");
        }else{
            StringBuilder message = new StringBuilder();
            for (Administrativo administrativo : administrativos){
                message.append(administrativo.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null ,message);
        }
    }

    public void eliminarAdministrativo(){
        if (administrativos.isEmpty()){
            JOptionPane.showMessageDialog(null,"NO HAY ADMINISTRATIVOS!");
        }else{
            String usuarioAdm = JOptionPane.showInputDialog("Ingrese el usuario del administrativo que desea eliminar: ");
            Administrativo administrativoEliminar = null;
            for (Administrativo administrativo : administrativos){
                if (administrativo.getUsuario().equals(usuarioAdm)){
                    administrativoEliminar = administrativo;
                }
            }
            if (administrativoEliminar == null){
                JOptionPane.showMessageDialog(null, "ADMINISTRATIVO NO ENCONTRADO!");
            }else{
                if (JOptionPane.showConfirmDialog(null, administrativoEliminar.toString()+". ELIMINAR?") == 0){
                    administrativos.remove(administrativoEliminar);
                    JOptionPane.showMessageDialog(null,"administrativo eliminado!");
                    FileManager.saveData(this, archivo.getName());
                }else{
                    JOptionPane.showMessageDialog(null,"Operacion cancelada.");
                }
            }
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
