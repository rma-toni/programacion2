package TrabajoFinal.Usuarios;

import java.io.Serializable;

public class Administrativo extends Usuario  implements Serializable {
    private String sector;

    //Contructor
    public Administrativo(String nombre, String apellido, int dni, String usario, String sector) {
        super(nombre, apellido, dni, usario);
        this.sector = sector;
    }

    //Getters y Setter
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


    //to String
    @Override
    public String toString() {
        return "[Nombre:"+getNombre()+", Apellido: "+getApellido()+", DNI: "+ getDni()+", usuario: " +getUsuario()+", Sector: "+getSector()+ "]";
    }


}