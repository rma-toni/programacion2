package TrabajoFinal;

import javax.swing.*;
import java.awt.*;

public class Main {

    // Obtener el tamaño de la pantalla
    static Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    static int widthScreen = pantalla.width;
    static int heigthScreen = pantalla.height;
    // Calcular el tamaño deseado (por ejemplo, 70% del ancho y 70% del alto)
    static int width = (int) (widthScreen * 0.7);
    static int height = (int) (heigthScreen * 0.7);

    static void main(String[] args) {
        GestorTurnos gestorTurnos = new GestorTurnos();
        gestorTurnos.debugData();

        if (!pedirUsuario(gestorTurnos)) return;

        mainUI(gestorTurnos);
    }

    public static void mainUI(GestorTurnos gestorTurnos){

        //region CREAR VENTANA
        JFrame window = new JFrame("Gestor de Turnos"); // título de la ventana
        window.setSize(width, height); // ancho y alto
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al salir
        window.setLayout(new BorderLayout());
        //endregion

        //region Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 10, 10));
        //endregion

        //region Panel Pacientes
        mainPanel.add(patientPanel(gestorTurnos));
        //endregion

        //region Panel Medicos
        mainPanel.add(doctorPanel(gestorTurnos));
        //endregion

        //region Panel Administrativos
        mainPanel.add(adminPanel(gestorTurnos));
        //endregion

        // Agregar los paneles al frame
        window.add(titlePanel(gestorTurnos), BorderLayout.NORTH);
        window.add(mainPanel, BorderLayout.CENTER);

        window.setVisible(true); // mostrar la ventana
    }

    public static JPanel adminPanel(GestorTurnos gestorTurnos){
        JPanel panel = new JPanel();
        JPanel admTitlePanel = new JPanel();
        admTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        admTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel


        JLabel titleAdm = new JLabel("ADMINISTRATIVOS", JLabel.CENTER);
        titleAdm.setFont(new Font("Arial", Font.BOLD, 24));
        titleAdm.setForeground(Color.BLACK); // color del texto
        admTitlePanel.setLayout(new BorderLayout());
        admTitlePanel.add(titleAdm, BorderLayout.CENTER);

        panel.add(admTitlePanel);

        JPanel doctorButtons = new JPanel();
        doctorButtons.setLayout(new BoxLayout(doctorButtons, BoxLayout.Y_AXIS)); // apilado vertical
        Dimension d = new Dimension(200, 40);


        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical
        JButton verAdmBtn = new JButton("VER ADMINISTRATIVOS");
        verAdmBtn.setPreferredSize(d);
        verAdmBtn.setMinimumSize(d);
        verAdmBtn.setMaximumSize(d);
        verAdmBtn.addActionListener(event -> gestorTurnos.mostrarAdministrativos());
        doctorButtons.add(verAdmBtn);
        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearAdmBtn = new JButton("CREAR ADMINISTRATIVO");
        crearAdmBtn.setPreferredSize(d);
        crearAdmBtn.setMinimumSize(d);
        crearAdmBtn.setMaximumSize(d);
        crearAdmBtn.addActionListener(event -> gestorTurnos.crearAdministrativo());
        doctorButtons.add(crearAdmBtn);
        doctorButtons.add(Box.createVerticalStrut(10));


        JButton eliminarAdmBtn = new JButton("BORRAR ADMINISTRATIVO");
        eliminarAdmBtn.setPreferredSize(d);
        eliminarAdmBtn.setMinimumSize(d);
        eliminarAdmBtn.setMaximumSize(d);
        eliminarAdmBtn.addActionListener(event -> gestorTurnos.eliminarAdministrativo());
        doctorButtons.add(eliminarAdmBtn);
        doctorButtons.add(Box.createVerticalStrut(10));

        panel.add(doctorButtons);

        return panel;
    }

    public static JPanel patientPanel(GestorTurnos gestorTurnos){
        JPanel panel = new JPanel();

        JPanel patientTitlePanel = new JPanel();
        patientTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        patientTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel

        JLabel titlePatient = new JLabel("PACIENTES", JLabel.CENTER);
        titlePatient.setFont(new Font("Arial", Font.BOLD, 24));
        titlePatient.setForeground(Color.BLACK); // color del texto
        patientTitlePanel.setLayout(new BorderLayout());
        patientTitlePanel.add(titlePatient, BorderLayout.CENTER);
        panel.add(patientTitlePanel);

        JPanel patientButtons = new JPanel();
        patientButtons.setLayout(new BoxLayout(patientButtons, BoxLayout.Y_AXIS)); // apilado vertical
        Dimension d = new Dimension(200, 40);

        patientButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical
        JButton verPacientesBtn = new JButton("VER PACIENTES");
        verPacientesBtn.setPreferredSize(d);
        verPacientesBtn.setMinimumSize(d);
        verPacientesBtn.setMaximumSize(d);
        verPacientesBtn.addActionListener(event -> gestorTurnos.mostrarPacientes());
        patientButtons.add(verPacientesBtn);
        patientButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearPacienteBtn = new JButton("CREAR PACIENTE");
        crearPacienteBtn.setPreferredSize(d);
        crearPacienteBtn.setMinimumSize(d);
        crearPacienteBtn.setMaximumSize(d);
        crearPacienteBtn.addActionListener(event -> gestorTurnos.crearPaciente());//TODO
        patientButtons.add(crearPacienteBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton eliminarPacienteBtn = new JButton("BORRAR PACIENTE");
        eliminarPacienteBtn.setPreferredSize(d);
        eliminarPacienteBtn.setMinimumSize(d);
        eliminarPacienteBtn.setMaximumSize(d);
        eliminarPacienteBtn.addActionListener(event -> gestorTurnos.eliminarPaciente());
        patientButtons.add(eliminarPacienteBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton crearTurnoBtn = new JButton("ASIGNAR TURNO");
        crearTurnoBtn.setPreferredSize(d);
        crearTurnoBtn.setMinimumSize(d);
        crearTurnoBtn.setMaximumSize(d);
        crearTurnoBtn.addActionListener(event -> gestorTurnos.crearTurno());
        patientButtons.add(crearTurnoBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton borrarTurnoBtn = new JButton("CANCELAR TURNO");
        borrarTurnoBtn.setPreferredSize(d);
        borrarTurnoBtn.setMinimumSize(d);
        borrarTurnoBtn.setMaximumSize(d);
        borrarTurnoBtn.addActionListener(event -> gestorTurnos.cancelarTurno());
        patientButtons.add(borrarTurnoBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton verTurnosBtn = new JButton("VER TURNOS");
        verTurnosBtn.setPreferredSize(d);
        verTurnosBtn.setMinimumSize(d);
        verTurnosBtn.setMaximumSize(d);
        verTurnosBtn.addActionListener(event -> gestorTurnos.mostrarTurnos());
        patientButtons.add(verTurnosBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        panel.add(patientButtons);

        return panel;
    }

    public static JPanel doctorPanel(GestorTurnos gestorTurnos){
        JPanel panel = new JPanel();

        JPanel doctorTitlePanel = new JPanel();
        doctorTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        doctorTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel


        JLabel titleDoc = new JLabel("MEDICOS", JLabel.CENTER);
        titleDoc.setFont(new Font("Arial", Font.BOLD, 24));
        titleDoc.setForeground(Color.BLACK); // color del texto
        doctorTitlePanel.setLayout(new BorderLayout());
        doctorTitlePanel.add(titleDoc, BorderLayout.CENTER);

        panel.add(doctorTitlePanel);

        JPanel doctorButtons = new JPanel();
        doctorButtons.setLayout(new BoxLayout(doctorButtons, BoxLayout.Y_AXIS)); // apilado vertical
        Dimension d = new Dimension(200, 40);

        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical
        JButton verMedicosBtn = new JButton("VER MEDICOS");
        verMedicosBtn.setPreferredSize(d);
        verMedicosBtn.setMinimumSize(d);
        verMedicosBtn.setMaximumSize(d);
        verMedicosBtn.addActionListener(event -> gestorTurnos.mostrarMedicos());
        doctorButtons.add(verMedicosBtn);
        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearMedicoBtn = new JButton("CREAR MEDICO");
        crearMedicoBtn.setPreferredSize(d);
        crearMedicoBtn.setMinimumSize(d);
        crearMedicoBtn.setMaximumSize(d);
        crearMedicoBtn.addActionListener(event -> gestorTurnos.crearMedico());
        doctorButtons.add(crearMedicoBtn);
        doctorButtons.add(Box.createVerticalStrut(10));


        JButton eliminarMedicoBtn = new JButton("BORRAR MEDICO");
        eliminarMedicoBtn.setPreferredSize(d);
        eliminarMedicoBtn.setMinimumSize(d);
        eliminarMedicoBtn.setMaximumSize(d);
        eliminarMedicoBtn.addActionListener(event -> gestorTurnos.eliminarMedico());
        doctorButtons.add(eliminarMedicoBtn);
        doctorButtons.add(Box.createVerticalStrut(10));

        panel.add(doctorButtons);

        return panel;
    }

    public static JPanel titlePanel(GestorTurnos gestor){
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(69, 172, 139)); // color azul (RGB)
        titlePanel.setPreferredSize(new Dimension(width, 80)); // altura del panel
        // Etiqueta del título
        JLabel title = new JLabel(gestor.getNombre(), JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE); // color del texto
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.CENTER);
        return titlePanel;
    }

    public static boolean pedirUsuario(GestorTurnos gestorTurnos) {
        boolean isValid = false;
        while (!isValid){
            String user = JOptionPane.showInputDialog(
                    null,
                    "Ingrese usuario ADMINISTRATIVO:",
                    "Inicio de sesión",
                    JOptionPane.QUESTION_MESSAGE
            );
            if(user == null) return false;
            isValid = gestorTurnos.validateAdmUser(user);
        }
        return isValid;
    }
}
