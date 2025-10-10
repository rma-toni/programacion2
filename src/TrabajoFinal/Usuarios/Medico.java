package TrabajoFinal.Usuarios;


import java.io.Serializable;

public class Medico extends Usuario implements Serializable {

    private String especialidad;
    private String matricula;

    // contructor
    public Medico(String nombre, String apellido, String dni, String usario, String especialidad, String matricula) {
        super(nombre, apellido, dni, usario);
        this.especialidad = especialidad;
        this.matricula = matricula;
    }
    // getter y setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //toString
    @Override
    public String toString() {
        return "Medico [especialidad=" + especialidad + ", matricula=" + matricula + ", getEspecialidad()="
                + getEspecialidad() + ", getMatricula()=" + getMatricula() + ", getNombre()=" + getNombre()
                + ", getApellido()=" + getApellido() + ", getDni()=" + getDni() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }





}