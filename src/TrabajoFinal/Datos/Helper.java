package TrabajoFinal.Datos;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public static LocalDate getLocalDate(){
        int day;
        int month;
        int year;
        LocalDate fecha;

        while (true){
            String dateString = JOptionPane.showInputDialog("Ingrese la fecha (DD/MM/AAA)");
            if (dateString == null){
                return null;
            }
            String[] splitDate = dateString.split("/");
            try {
                day = Integer.parseInt(splitDate[0]);
                month = Integer.parseInt(splitDate[1]);
                year = Integer.parseInt(splitDate[2]);
            } catch (Exception e) {
                continue;
            }
            boolean dayC = day <= 31 && day > 0;
            boolean monthC = month <= 12 && month > 0;
            boolean yearC = year < 2100 && year > 1950;
            fecha = LocalDate.of(year,month,day);
            if(dayC && monthC && yearC && fecha.isAfter(LocalDate.now())){
                break;
            }
        }
        return fecha;
    }

    public static LocalTime getLocalTime(){
        String timeString = JOptionPane.showInputDialog("Ingrese la hora (HH:MM) :");
        if (timeString == null){
            return null;
        }
        String[] splitHour = timeString.split(":");
        int hour;
        int minute;
        while (true) {
            try {
                hour = Integer.parseInt(splitHour[0]);
                minute = Integer.parseInt(splitHour[1]);
            } catch (Exception e) {
                continue;
            }
            if (!((hour <= 23 && hour >= 0) && (minute <= 59 && minute >= 0))){
                System.out.println("Ingrese un horario valido");

            }else{
                break;
            }
        }
        LocalTime time = LocalTime.of(hour,minute);
        System.out.println("retorna"); //DEBUG
        return time;
    }

}