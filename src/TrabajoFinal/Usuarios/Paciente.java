package TrabajoFinal.Usuarios;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable  {

    private String obraSocial;

    // constructor
    public Paciente(String nombre, String apellido, String dni, String usario, String obraSocial) {
        super(nombre, apellido, dni, usario);
        this.obraSocial = obraSocial;
    }
    // getter y setter
    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    @Override
    public String toString() {
        return "Paciente [obraSocial=" + obraSocial + ", getObraSocial()=" + getObraSocial() + ", getNombre()="
                + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni() + ", toString()="
                + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }

}


