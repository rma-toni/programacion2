package TrabajoFinal;

import TrabajoFinal.Datos.FileManager;
import TrabajoFinal.Datos.Helper;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String fileName = "datos.dat";
        File archivo = new File(fileName);
        GestorTurnos centroSalud;
        int option;

        if (archivo.exists()){
            centroSalud = FileManager.loadData(fileName);
        }else {
            centroSalud = new GestorTurnos(Helper.getString("Ingrese el nombre del sistema de gestion de turnos: "));
            FileManager.saveData(centroSalud,fileName);
        }

        while (true){

            System.out.println("----- "+centroSalud.getNombre()+" -----");
            System.out.println("9 - Borrar datos y salir del sistema");
            System.out.println("0 - Salir del sistema");
            option = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (option){
                case 9:
                    boolean result = archivo.delete();
                    if (result){
                        System.out.println("Datos eliminados con exito! ");
                        return;
                    } else {
                        System.out.println("No se pudo eliminar los datos.");
                        break;
                    }
                case 0:
                    return;
            }
        }
    }
}
