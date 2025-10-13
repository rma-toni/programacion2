package TrabajoFinal;

import TrabajoFinal.Datos.Helper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        GestorTurnos centroSalud = new GestorTurnos();

        mainUI(centroSalud);

    }

    public static void mainUI(GestorTurnos centroSalud){

        //region CREAR VENTANA
        // Obtener el tamaño de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int widthScreen = pantalla.width;
        int heigthScreen = pantalla.height;
        // Calcular el tamaño deseado (por ejemplo, 70% del ancho y 70% del alto)
        int width = (int) (widthScreen * 0.7);
        int height = (int) (heigthScreen * 0.7);
        JFrame window = new JFrame("Gestor de Turnos"); // título de la ventana
        window.setSize(width, height); // ancho y alto
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al salir
        window.setLayout(new BorderLayout());
        //endregion

        //region PANEL SUPERIOR
        // Panel superior (encabezado)
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(69, 172, 139)); // color azul (RGB)
        titlePanel.setPreferredSize(new Dimension(width, 80)); // altura del panel
        // Etiqueta del título
        JLabel title = new JLabel(centroSalud.getNombre(), JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE); // color del texto
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.CENTER);
        //endregion

        //region Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(236, 240, 241)); // gris claro
        mainPanel.setLayout(new GridLayout(1, 3, 10, 10));
        //endregion

        //region Panel Pacientes
        JPanel patientPanel = new JPanel();
        patientPanel.setBackground(new Color(171, 171, 171));
        JPanel patientTitlePanel = new JPanel();
        patientTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        patientTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel

        JLabel titlePatient = new JLabel("PACIENTES", JLabel.CENTER);
        titlePatient.setFont(new Font("Arial", Font.BOLD, 24));
        titlePatient.setForeground(Color.BLACK); // color del texto
        patientTitlePanel.setLayout(new BorderLayout());
        patientTitlePanel.add(titlePatient, BorderLayout.CENTER);

        patientPanel.add(patientTitlePanel);
        patientPanel.add(new JButton("Botón 1"));
        patientPanel.add(new JButton("Botón 2"));
        patientPanel.add(new JButton("Botón 3"));
        mainPanel.add(patientPanel);
        //endregion
        //region Panel Medicos
        JPanel doctorPanel = new JPanel();
        doctorPanel.setBackground(new Color(171, 171, 171));
        JPanel doctorTitlePanel = new JPanel();
        doctorTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        doctorTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel


        JLabel titleDoc = new JLabel("MEDICOS", JLabel.CENTER);
        titleDoc.setFont(new Font("Arial", Font.BOLD, 24));
        titleDoc.setForeground(Color.BLACK); // color del texto
        doctorTitlePanel.setLayout(new BorderLayout());
        doctorTitlePanel.add(titleDoc, BorderLayout.CENTER);

        doctorPanel.add(doctorTitlePanel);
        doctorPanel.add(new JButton("Botón 1"));
        doctorPanel.add(new JButton("Botón 2"));
        doctorPanel.add(new JButton("Botón 3"));
        mainPanel.add(doctorPanel);
        //endregion
        //region Panel Administrativos
        JPanel admPanel = new JPanel();
        admPanel.setBackground(new Color(171, 171, 171));
        JPanel admTitlePanel = new JPanel();
        admTitlePanel.setBackground(new Color(255, 198, 135)); // color NARANJA (RGB)
        admTitlePanel.setPreferredSize(new Dimension(width, 60)); // altura del panel


        JLabel titleAdm = new JLabel("MEDICOS", JLabel.CENTER);
        titleAdm.setFont(new Font("Arial", Font.BOLD, 24));
        titleAdm.setForeground(Color.BLACK); // color del texto
        admTitlePanel.setLayout(new BorderLayout());
        admTitlePanel.add(titleAdm, BorderLayout.CENTER);

        admPanel.add(admTitlePanel);
        admPanel.add(new JButton("Botón 1"));
        admPanel.add(new JButton("Botón 2"));
        admPanel.add(new JButton("Botón 3"));
        mainPanel.add(admPanel);
        //endregion

        // Agregar los paneles al frame
        window.add(titlePanel, BorderLayout.NORTH);
        window.add(mainPanel, BorderLayout.CENTER);

        window.setVisible(true); // mostrar la ventana
    }
}
