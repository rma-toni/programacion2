package TrabajoFinal;

//todo Generar informes pdf
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import TrabajoFinal.Datos.Helper;
import TrabajoFinal.Datos.FileManager;
import TrabajoFinal.Usuarios.Administrativo;
import TrabajoFinal.Usuarios.Medico;
import TrabajoFinal.Usuarios.Paciente;
import TrabajoFinal.Usuarios.dateTurno;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.*; // este tambien importe
import java.time.format.DateTimeFormatter; //importe esto de nuevo toni
import java.util.ArrayList;


public class GestorTurnos implements Serializable {

    private String nombre;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Administrativo> administrativos;
    private ArrayList<Turno> turnos;
    private ArrayList<Turno> turnosCancelados;

    private static final long serialVersionUID = 1L;

    private final File archivo;

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
            this.turnosCancelados = carga.getTurnosCancelados();
        }else{
            this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del establecimiento: ");
            this.pacientes = new ArrayList<>();
            this.medicos = new ArrayList<>();
            this.administrativos = new ArrayList<>();
            this.turnos = new ArrayList<>();
            this.turnosCancelados = new ArrayList<>();
            FileManager.saveData(this, fileName);
        }

    };

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

    public void modificarPaciente(){
        Paciente modPaciente = buscarPaciente();

        String sb = """
                1 - nombre
                2 - apellido
                3 - obra social
                """;

        Integer opcion = Helper.getIntegerJInput(sb +"Ingrese la opcion que desea modificar: ");
        if (opcion!=null){
            switch (opcion){
                case 1:
                    String nom = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                    if (nom == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modPaciente.setNombre(nom);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 2:
                    String ap = JOptionPane.showInputDialog("Ingrese el nuevo apellido: ");
                    if (ap == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modPaciente.setApellido(ap);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 3:
                    String os = JOptionPane.showInputDialog("Ingrese la nueva obra social: ");
                    if (os == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modPaciente.setObraSocial(os);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cancelado.");
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

    public void modificarMedico(){
        Medico modMedico = buscarMedico();

        String sb = """
                1 - nombre
                2 - apellido
                3 - especialidad
                4 - matricula
                """;

        Integer opcion = Helper.getIntegerJInput(sb +"Ingrese la opcion que desea modificar: ");
        if (opcion!=null){
            switch (opcion){
                case 1:
                    String nom = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                    if (nom == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modMedico.setNombre(nom);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 2:
                    String ap = JOptionPane.showInputDialog("Ingrese el nuevo apellido: ");
                    if (ap == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modMedico.setApellido(ap);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 3:
                    String es = JOptionPane.showInputDialog("Ingrese la nueva especialidad: ");
                    if (es == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modMedico.setEspecialidad(es);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 4:
                    Integer mat = Helper.getIntegerJInput("Ingrese la nueva matricula");
                    if (mat == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modMedico.setMatricula(mat);
                        FileManager.saveData(this,archivo.getName());
                    }
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cancelado.");
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
        String sector = JOptionPane.showInputDialog("Ingrese el area del administrativo: ");
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

    public void modificarAdministrativo(){
        Administrativo modAdm = buscarAdministrativos();

        String sb = """
                1 - nombre
                2 - apellido
                3 - sector
                """;

        Integer opcion = Helper.getIntegerJInput(sb +"Ingrese la opcion que desea modificar: ");
        if (opcion!=null){
            switch (opcion){
                case 1:
                    String nom = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                    if (nom == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modAdm.setNombre(nom);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 2:
                    String ap = JOptionPane.showInputDialog("Ingrese el nuevo apellido: ");
                    if (ap == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modAdm.setApellido(ap);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                case 3:
                    String sec = JOptionPane.showInputDialog("Ingrese el nuevo sector: ");
                    if (sec == null){
                        JOptionPane.showMessageDialog(null, "Cancelado.");
                    }else{
                        modAdm.setSector(sec);
                        FileManager.saveData(this,archivo.getName());
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cancelado.");
        }
    }

    public void debugData(){
        if (JOptionPane.showConfirmDialog(null, "ADD DEBUG DATA?") == 0) {
            pacientes.add(new Paciente("Jorge", "Ramírez", 40123654, "jramirez", "Swiss Medical"));
            pacientes.add(new Paciente("María", "Gómez", 45891234, "mgomez", "OSDE"));
            pacientes.add(new Paciente("Lucía", "Fernández", 37984512, "lfernandez", "IOMA"));
            pacientes.add(new Paciente("Carlos", "Pérez", 42135789, "cperez", "Galeno"));
            pacientes.add(new Paciente("Ana", "López", 43876590, "alopez", "Medifé"));
            pacientes.add(new Paciente("Pedro", "Martínez", 39876123, "pmartinez", "PAMI"));
            pacientes.add(new Paciente("Sofía", "Rivas", 40987456, "srivas", "OSDE"));
            pacientes.add(new Paciente("Matías", "Suárez", 42785649, "msuarez", "Swiss Medical"));
            pacientes.add(new Paciente("Camila", "Ortiz", 45678123, "cortiz", "IOMA"));
            pacientes.add(new Paciente("Diego", "Herrera", 41234567, "dherrera", "Galeno"));

            medicos.add(new Medico("Laura", "Benítez", 32567890, "lbenitez", "Cardiología", 12345));
            medicos.get(0).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(0).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(0).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(0).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(0).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(0).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(0).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(0).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(0).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Martín", "Castro", 30123456, "mcastro", "Pediatría", 23456));
            medicos.get(1).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(1).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(1).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(1).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(1).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(1).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(1).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(1).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(1).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Luciano", "Díaz", 29876543, "ldiaz", "Clínica Médica", 34567));

            medicos.get(2).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(2).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(2).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(2).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(2).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(2).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(2).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(2).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(2).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Valeria", "Romero", 31234987, "vromero", "Dermatología", 45678));

            medicos.get(3).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(3).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(3).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(3).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(3).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(3).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(3).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(3).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(3).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Fernando", "Sánchez", 28765432, "fsanchez", "Traumatología", 56789));
            medicos.get(4).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(4).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(4).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(4).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(4).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(4).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(4).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(4).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(4).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Julieta", "Mendoza", 33456789, "jmendoza", "Ginecología", 67890));

            medicos.get(5).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(5).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(5).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(5).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(5).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(5).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(5).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(5).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(5).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Esteban", "López", 29543218, "elopez", "Oftalmología", 78901));

            medicos.get(6).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(6).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(6).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(6).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(6).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(6).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(6).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(6).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(6).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Carolina", "Ruiz", 31876543, "cruiz", "Neurología", 89012));

            medicos.get(7).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(7).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(7).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(7).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(7).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(7).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(7).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(7).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(7).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Diego", "Morales", 30567891, "dmorales", "Psiquiatría", 90123));

            medicos.get(8).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(8).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(8).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(8).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(8).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(8).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(8).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(8).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(8).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));
            medicos.add(new Medico("Paula", "Herrera", 32987654, "pherrera", "Endocrinología", 11223));

            medicos.get(9).addTurno(LocalDate.now(),LocalTime.of(9, 0));
            medicos.get(9).addTurno(LocalDate.now(),LocalTime.of(10, 0));
            medicos.get(9).addTurno(LocalDate.now(),LocalTime.of(11, 0));

            medicos.get(9).addTurno(LocalDate.now().plusDays(1),LocalTime.of(9, 0));
            medicos.get(9).addTurno(LocalDate.now().plusDays(1),LocalTime.of(10, 0));
            medicos.get(9).addTurno(LocalDate.now().plusDays(1),LocalTime.of(11, 0));

            medicos.get(9).addTurno(LocalDate.now().plusDays(2),LocalTime.of(9, 0));
            medicos.get(9).addTurno(LocalDate.now().plusDays(2),LocalTime.of(10, 0));
            medicos.get(9).addTurno(LocalDate.now().plusDays(2),LocalTime.of(11, 0));

            administrativos.add(new Administrativo("Gabriela", "Torres", 31567890, "gtorres", "Recepción"));
            administrativos.add(new Administrativo("Ricardo", "Luna", 29876543, "rluna", "Facturación"));
            administrativos.add(new Administrativo("Daniela", "Moreno", 32789456, "dmoreno", "Admisión"));
            administrativos.add(new Administrativo("Federico", "Paz", 31234567, "fpaz", "Recursos Humanos"));
            administrativos.add(new Administrativo("Patricia", "Vega", 30567891, "pvega", "Archivo Clínico"));
            administrativos.add(new Administrativo("Rodrigo", "Núñez", 32987654, "rnunez", "Sistemas"));
            administrativos.add(new Administrativo("Marcela", "Rojas", 30123987, "mrojas", "Contabilidad"));
            administrativos.add(new Administrativo("Lucía", "Cabrera", 33456789, "lcabrera", "Atención al Público"));
            administrativos.add(new Administrativo("Javier", "Ortiz", 28976543, "jortiz", "Compras"));
            administrativos.add(new Administrativo("Sabrina", "Flores", 32234567, "sflores", "Mesa de Entradas"));

            turnos.add(new Turno(new dateTurno(LocalTime.now(),LocalDate.now()),
                    pacientes.get(5),
                    medicos.get(4),
                    true));
            turnos.add(new Turno(new dateTurno(LocalTime.now(),LocalDate.now()),
                    pacientes.get(5),
                    medicos.get(2),
                    true));
            turnos.add(new Turno(new dateTurno(LocalTime.now(),LocalDate.now()),
                    pacientes.get(5),
                    medicos.get(8),
                    true));

            FileManager.saveData(this, archivo.getName());
        }
    }

    public void crearInforme(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre).append(" TURNOS").append("\n");
        sb.append("TURNOS ACTUALES: \n");
        for (Turno turno : turnos){
            sb.append(turno.toString()).append("\n");
        }
        sb.append("TURNOS CANCELADOS: \n");
        for (Turno turno : turnosCancelados){
            sb.append(turno.toString()).append("\n");
        }

        String rutaDestino = "infome.pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaDestino));
            document.open();
            document.add(new Paragraph(String.valueOf(sb)));
            document.close();
            JOptionPane.showMessageDialog(null, "Infome creado con exito");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void crearTurno(){
        Paciente paciente = buscarPaciente();
        if (paciente == null){
            JOptionPane.showMessageDialog(null,"Operación cancelada.");
            return;
        }
        Medico medico = buscarMedico();
        if (medico == null){
            JOptionPane.showMessageDialog(null,"Operación cancelada.");
            return;
        }

        Turno nuevoTurno = seleccionarFechaYHora(paciente, medico);

        if (nuevoTurno != null) {
            turnos.add(nuevoTurno);
            FileManager.saveData(this, archivo.getName());
            JOptionPane.showMessageDialog(null, "Turno creado exitosamente:\n" + nuevoTurno.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Creación de turno cancelada.");
        }
    }

    public void mostrarTurnos(){
        if (turnos.isEmpty()){
            JOptionPane.showMessageDialog(null ,"NO HAY TURNOS");
        }else{
            StringBuilder message = new StringBuilder();
            for (Turno turno : turnos){
                message.append(turno.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null ,message);
        }
    }

    public void cancelarTurno(){
        StringBuilder message = new StringBuilder();
        Paciente pac = buscarPaciente();
        int count = 1;
        ArrayList<Turno> turnosEncontrados = new ArrayList<>();
        if (!(pac == null)){
            for (Turno turno : turnos){
                if (turno.getPaciente().getUsuario().equals(pac.getUsuario())){
                    message.append(count).append(")").append(turno.toString()).append("\n");
                    turnosEncontrados.add(turno);
                    count++;
                }
            }
            String numString = JOptionPane.showInputDialog("Ingrese el turno a eliminar (numero): \n"+message);
            if (numString!=null && !numString.isEmpty()){
                int opcion = Integer.parseInt(numString);
                if (opcion <= turnosEncontrados.size() && opcion > 0){
                    Turno turnoEliminar = turnosEncontrados.get(opcion-1);
                    turnoEliminar.getDateTurno().setDisponible(true);
                    turnoEliminar.setEstado(false);
                    turnosCancelados.add(turnoEliminar);
                    turnos.remove(turnoEliminar);
                }else{
                    JOptionPane.showMessageDialog(null, "Valor invalido");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ingreso ningún valor");
            }
        }
        FileManager.saveData(this,archivo.getName());
    }

    //region GET AND SET
    public ArrayList<Turno> getTurnosCancelados() {
        return turnosCancelados;
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

    public boolean validateAdmUser(String user){
        boolean isValid = false;

        for (Administrativo adm : administrativos){
            if (adm.getUsuario().equals(user)){
                isValid = true;
            }
        }

        return isValid;
    }
    //endregion

    //region BUSCAR DATOS
    public Paciente buscarPaciente(){
        Paciente paciente = null;
        String usuario;

        while (paciente == null){
            usuario = JOptionPane.showInputDialog("No encontrado, ingrese un usuario valido: ");
            if (usuario == null) {
                return null;
            }
            for (Paciente pac : pacientes){
                if (pac.getUsuario().equals(usuario)){
                    paciente = pac;
                }
            }
        }
        return paciente;
    }

    public Medico buscarMedico(){
        Medico medico = null;
        String usuario;

        while (medico == null){
            usuario = JOptionPane.showInputDialog("No encontrado, ingrese un usuario valido: ");
            if (usuario == null) {
                return null;
            }
            for (Medico med : medicos){
                if (med.getUsuario().equals(usuario)){
                    medico = med;
                }
            }
        }
        return medico;
    }

    public Administrativo buscarAdministrativos(){
        Administrativo administrativo = null;
        String usuario;

        while (administrativo == null){
            usuario = JOptionPane.showInputDialog("No encontrado, ingrese un usuario valido: ");
            if (usuario == null) {
                return null;
            }
            for (Administrativo adm : administrativos){
                if (adm.getUsuario().equals(usuario)){
                    administrativo = adm;
                }
            }
        }
        return administrativo;
    }
    //endregion

    private Turno seleccionarFechaYHora(Paciente paciente, Medico medico) {
        final Turno[] turnoSeleccionado = new Turno[1];
        turnoSeleccionado[0] = null;

        JDialog dialog = new JDialog((Frame) null, "Seleccionar Fecha y Hora", true);
        dialog.setSize(500, 350);
        dialog.setLayout(new GridLayout(4, 1, 10, 10));
        dialog.setLocationRelativeTo(null);

        LocalDate hoy = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");




        JLabel titleLabel = new JLabel("Seleccione un horario para " + medico.getNombre() + ":", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dialog.add(titleLabel);

        JPanel panelDia1 = createDayPanel(paciente, medico, turnoSeleccionado, dialog, dtf, 0);
        dialog.add(panelDia1);
        JPanel panelDia2 = createDayPanel(paciente, medico, turnoSeleccionado, dialog, dtf, 1);
        dialog.add(panelDia2);
        JPanel panelDia3 = createDayPanel(paciente, medico, turnoSeleccionado, dialog, dtf, 2);
        dialog.add(panelDia3);


        dialog.setVisible(true);

        return turnoSeleccionado[0];
    }

    private JPanel createDayPanel(Paciente p, Medico m, Turno[] turnoHolder, JDialog dialog, DateTimeFormatter dtf, int days) {

        ArrayList<dateTurno>  disponiblesAll = m.getDisponibles();
        ArrayList<dateTurno>  today = new ArrayList<>();

        for (dateTurno fecha : disponiblesAll){
            if (fecha.getFecha().equals(LocalDate.now().plusDays(days))){
                today.add(fecha);
            }
        }

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBorder(BorderFactory.createTitledBorder(LocalDate.now().plusDays(days).format(dtf)));

        for (dateTurno hora : today){
            if (hora.isDisponible()){
                JButton btnH1 = new JButton(hora.getHora().toString());
                btnH1.addActionListener(e -> {
                    turnoHolder[0] = new Turno(hora, p, m, true);
                    hora.setDisponible(false);
                    dialog.dispose();
                });
                panel.add(btnH1);
            }
        }

        return panel;
    }
    //endregion


}
