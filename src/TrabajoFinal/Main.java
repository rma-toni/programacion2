package TrabajoFinal;

import TrabajoFinal.Datos.Helper;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        GestorTurnos centroSalud = new GestorTurnos();


        // Obtener el tamaño de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int widthScreen = pantalla.width;
        int heigthScreen = pantalla.height;

        // Calcular el tamaño deseado (por ejemplo, 70% del ancho y 60% del alto)
        int width = (int) (widthScreen * 0.7);
        int height = (int) (heigthScreen * 0.7);

        JFrame window = new JFrame("Gestor de Turnos"); // título de la ventana
        window.setSize(width, height); // ancho y alto
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar al salir
        window.setVisible(true); // mostrar la ventana


        // 🟦 Panel superior (encabezado)
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(69, 172, 139)); // color azul (RGB)
        titlePanel.setPreferredSize(new Dimension(width, 80)); // altura del panel

        window.add(titlePanel, BorderLayout.NORTH);
        // 🏷️ Etiqueta del título
        JLabel title = new JLabel(centroSalud.getNombre(), JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE); // color del texto
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.CENTER);

        /*int option;

        while (true){

            System.out.println("----- "+centroSalud.getNombre()+" -----");
            System.out.println("9 - Eliminar Datos y salir");
            System.out.println("0 - Salir del sistema");
            option = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (option){
                case 9:
                    centroSalud.deleteData();
                    return;
                case 0:
                    return;
            }
        }*/
    }
}
