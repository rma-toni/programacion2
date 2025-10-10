package TrabajoFinal.Datos;

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
    //endregion

    //region String Helpers
    public static String getString(String inputMessage){
        System.out.print(inputMessage);
        String stringValue = scanner.nextLine();
        return stringValue;
    }
    //endregion

}