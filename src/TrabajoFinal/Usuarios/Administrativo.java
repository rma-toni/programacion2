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
        return "Administrativo [sector=" + sector + ", getSector()=" + getSector() + ", getNombre()=" + getNombre()
                + ", getApellido()=" + getApellido() + ", getDni()=" + getDni() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }


}