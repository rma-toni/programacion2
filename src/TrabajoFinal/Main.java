package TrabajoFinal;

//TODO Renombrar botones en admPanel, doctorPanel y patientPanel

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

    public static void main(String[] args) {
        GestorTurnos centroSalud = new GestorTurnos();
        mainUI(centroSalud);
    }

    public static void mainUI(GestorTurnos centroSalud){

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
        mainPanel.add(patientPanel());
        //endregion

        //region Panel Medicos
        mainPanel.add(doctorPanel());
        //endregion

        //region Panel Administrativos
        mainPanel.add(adminPanel());
        //endregion

        // Agregar los paneles al frame
        window.add(titlePanel(centroSalud), BorderLayout.NORTH);
        window.add(mainPanel, BorderLayout.CENTER);

        window.setVisible(true); // mostrar la ventana
    }

    public static JPanel adminPanel(){
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


        JButton verPacientesBtn = new JButton("VER ADMINISTRATIVOS");
        verPacientesBtn.setPreferredSize(d);
        verPacientesBtn.setMinimumSize(d);
        verPacientesBtn.setMaximumSize(d);
        doctorButtons.add(verPacientesBtn);
        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearPacienteBtn = new JButton("CREAR ADMINISTRATIVO");
        crearPacienteBtn.setPreferredSize(d);
        crearPacienteBtn.setMinimumSize(d);
        crearPacienteBtn.setMaximumSize(d);
        doctorButtons.add(crearPacienteBtn);
        doctorButtons.add(Box.createVerticalStrut(10));


        JButton eliminarPacienteBtn = new JButton("BORRAR ADMINISTRATIVO");
        eliminarPacienteBtn.setPreferredSize(d);
        eliminarPacienteBtn.setMinimumSize(d);
        eliminarPacienteBtn.setMaximumSize(d);
        doctorButtons.add(eliminarPacienteBtn);
        doctorButtons.add(Box.createVerticalStrut(10));

        panel.add(doctorButtons);

        return panel;
    }

    public static JPanel patientPanel(){
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


        JButton verPacientesBtn = new JButton("VER PACIENTES");
        verPacientesBtn.setPreferredSize(d);
        verPacientesBtn.setMinimumSize(d);
        verPacientesBtn.setMaximumSize(d);
        patientButtons.add(verPacientesBtn);
        patientButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearPacienteBtn = new JButton("CREAR PACIENTE");
        crearPacienteBtn.setPreferredSize(d);
        crearPacienteBtn.setMinimumSize(d);
        crearPacienteBtn.setMaximumSize(d);
        patientButtons.add(crearPacienteBtn);
        patientButtons.add(Box.createVerticalStrut(10));


        JButton eliminarPacienteBtn = new JButton("BORRAR PACIENTE");
        eliminarPacienteBtn.setPreferredSize(d);
        eliminarPacienteBtn.setMinimumSize(d);
        eliminarPacienteBtn.setMaximumSize(d);
        patientButtons.add(eliminarPacienteBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton crearTurnoBtn = new JButton("ASIGNAR TURNO");
        crearTurnoBtn.setPreferredSize(d);
        crearTurnoBtn.setMinimumSize(d);
        crearTurnoBtn.setMaximumSize(d);
        patientButtons.add(crearTurnoBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        JButton borrarTurnoBtn = new JButton("CANCELAR TURNO");
        borrarTurnoBtn.setPreferredSize(d);
        borrarTurnoBtn.setMinimumSize(d);
        borrarTurnoBtn.setMaximumSize(d);
        patientButtons.add(borrarTurnoBtn);
        patientButtons.add(Box.createVerticalStrut(10));

        panel.add(patientButtons);

        return panel;
    }

    public static JPanel doctorPanel(){
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


        JButton verPacientesBtn = new JButton("VER MEDICOS");
        verPacientesBtn.setPreferredSize(d);
        verPacientesBtn.setMinimumSize(d);
        verPacientesBtn.setMaximumSize(d);
        doctorButtons.add(verPacientesBtn);
        doctorButtons.add(Box.createVerticalStrut(10)); // 10px de espacio vertical


        JButton crearPacienteBtn = new JButton("CREAR MEDICO");
        crearPacienteBtn.setPreferredSize(d);
        crearPacienteBtn.setMinimumSize(d);
        crearPacienteBtn.setMaximumSize(d);
        doctorButtons.add(crearPacienteBtn);
        doctorButtons.add(Box.createVerticalStrut(10));


        JButton eliminarPacienteBtn = new JButton("BORRAR MEDICO");
        eliminarPacienteBtn.setPreferredSize(d);
        eliminarPacienteBtn.setMinimumSize(d);
        eliminarPacienteBtn.setMaximumSize(d);
        doctorButtons.add(eliminarPacienteBtn);
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
}
