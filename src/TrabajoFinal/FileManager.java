package TrabajoFinal;

import java.io.*; //Solo necesitamos ObjectInputStream y FileInputStream

public class FileManager {

    public static <T extends Serializable> void saveData(T object){
        //ObjectOutputStream convierte el objeto en una secuencia de bits
        //FileOutputStream permite escribir bytes en un archivo
        //Se crea el ObjectOutputStream para que al salir del try java cierre automaticamente lo que se instancio entre parentesis
        try (ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            fileStream.writeObject(object);
            System.out.println("Guardado correcto"); //TODO DEBUG
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static <T> T loadData(){

        return null;
    }

}
