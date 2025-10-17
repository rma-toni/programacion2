package TrabajoFinal.Datos;

import javax.swing.*;
import java.util.Scanner;

public class Helper {


    //region Static Objects
    static Scanner scanner = new Scanner(System.in);
    //endregion


    //region Integer Helpers
    public static Integer getInteger(String inputMessage) {
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (Exception exception) {
                System.out.println("No es entero.");
            }
        }
    }

    public static Integer getIntegerJInput(String inputMessage) {
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                String intString = JOptionPane.showInputDialog(inputMessage);
                if (intString == null) {
                    return null; // Termina la función aquí
                }
                integerValue = Integer.parseInt(intString);
                return integerValue;
            } catch (Exception exception) {
                System.out.println("No es entero.");
            }
        }
    }
    //endregion

    //region String Helpers
    public static String getString(String inputMessage){
        System.out.print(inputMessage);
        String stringValue = scanner.nextLine();
        return stringValue;
    }
    //endregion

}