package TrabajoFinal;

import java.io.*; //Solo necesitamos ObjectInputStream y FileInputStream

public class FileManager {

    public static <T extends Serializable> void saveData(T object, String fileName){
        //ObjectOutputStream convierte el objeto en una secuencia de bits
        //FileOutputStream permite escribir bytes en un archivo
        //Se crea el ObjectOutputStream para que al salir del try java cierre automaticamente lo que se instancio entre parentesis
        try (ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fileStream.writeObject(object);
            System.out.println("Guardado correcto"); //TODO DEBUG
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static <T> T loadData(String fileName){
        T data = null;
        try (ObjectInputStream fileStream = new ObjectInputStream(new FileInputStream(fileName))){
            data = (T) fileStream.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return data;
    }

}
