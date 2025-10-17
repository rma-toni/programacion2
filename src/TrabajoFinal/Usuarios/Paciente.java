package TrabajoFinal.Usuarios;

import java.io.Serializable;

public class Paciente extends Usuario implements Serializable  {

    private String obraSocial;

    // constructor
    public Paciente(String nombre, String apellido, int dni, String usuario, String obraSocial) {
        super(nombre, apellido, dni, usuario);
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
        return "[Nombre:"+getNombre()+", Apellido: "+getApellido()+", DNI: "+ getDni()+", usuario: " +getUsuario()+", Obra Social: "+getObraSocial()+ "]";
    }

}


