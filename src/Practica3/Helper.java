package Practica3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Helper {


    //region Static Objects
    static Random random = new Random();
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

    //region String Helpers - Toni:)
    public static String getString(String inputMessage){
        System.out.print(inputMessage);
        String stringValue = scanner.nextLine();
        return stringValue;
    }
    //endregion

    //region LocalDate Helpers - Toni:)
    public static LocalDate getLocalDate(String inputMessage, String separator){
        int day;
        int month;
        int year;

        while (true){
            try {
                System.out.print(inputMessage);
                String[] splitDate = scanner.nextLine().split(separator);
                day = Integer.parseInt(splitDate[0]);
                month = Integer.parseInt(splitDate[1]);
                year = Integer.parseInt(splitDate[2]);
                //TODO Si el año es bisiesto
                //TODO Meses
                boolean dayC = day <= 31 && day > 0;
                boolean monthC = month <= 12 && month > 0;
                boolean yearC = year < 2100 && year > 1950;
                if(dayC && monthC && yearC){
                    return LocalDate.of(year,month,day);
                }
            } catch (Exception e){
                System.out.println("Ingrese una fecha valida.");
            }
        }
    }
    //endregion
}