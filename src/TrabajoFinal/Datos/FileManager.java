package TrabajoFinal.Datos;

import java.io.*; //Solo necesitamos ObjectInputStream y FileInputStream

public class FileManager {

    public static <T extends Serializable> boolean saveData(T object, String fileName){
        //ObjectOutputStream convierte el objeto en una secuencia de bits
        //FileOutputStream permite escribir bytes en un archivo
        //Se crea el ObjectOutputStream para que al salir del try java cierre automaticamente lo que se instancio entre parentesis
        try (ObjectOutputStream fileStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fileStream.writeObject(object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> T loadData(String fileName){
        T data = null;
        try (ObjectInputStream fileStream = new ObjectInputStream(new FileInputStream(fileName))){
            data = (T) fileStream.readObject();
        } catch (Exception e) {
            data = null;
        }
        return data;
    }
}