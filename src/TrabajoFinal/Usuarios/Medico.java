package TrabajoFinal.Usuarios;


import java.io.Serializable;

public class Medico extends Usuario implements Serializable {

    private String especialidad;
    private int matricula;

    // contructor
    public Medico(String nombre, String apellido, int dni, String usario, String especialidad, int matricula) {
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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