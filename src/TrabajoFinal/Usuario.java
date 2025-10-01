package TrabajoFinal;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialversion1 = 1l;

    private String nombre;
    private String apellido;
    private String dni;


    public Usuario(String nombre, String apellido, String dni, String usario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
