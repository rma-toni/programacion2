package TrabajoFinal;

//ESTE ARCHIVO ES SOLO PARA PRUEBAS

public class Debug {
    public static void main(String[] args) {
        Usuario user = null;
        while (true){
            if(user == null){
                System.out.println("Sin datos para mostrar");
            }else{
                System.out.println(user.toString());
            }
            System.out.println("1 - Crear Usuario");
            System.out.println("2 - Guardar Usuario");
            System.out.println("3 - Leer Usuario");
            System.out.println("4 - Borrar cargado");
            System.out.println("0 - Salir");

            int option = Helper.getInteger("Ingrese la opcion elegida: ");

            switch (option){
                case 1:
                    user = crearUsuario();
                    break;
                case 2:
                    FileManager.saveData(user, "user.dat");
                    break;
                case 3:
                    user = FileManager.loadData("user.dat");
                    break;
                case 4:
                    user = null;
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }


    //(String nombre, String apellido, String dni, String usario)
    public static Usuario crearUsuario(){
        String nombre = Helper.getString("Nombre: ");
        String apellido = Helper.getString("Apellido: ");
        int dni = Helper.getInteger("Dni: ");
        String user = Helper.getString("Usuario: ");
        return new Usuario(nombre,apellido,dni,user);
    }

}
