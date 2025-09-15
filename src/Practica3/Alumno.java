package Practica3;

public class Alumno {
    private String nombre;
    private String apellido;
    private String lu;
    private String sexo;
    private String condicion;
    private int notaFinal;

    public Alumno (String nombre, String apellido, String lu, String sexo, String condicion, int notaFinal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lu = lu;
        this.sexo = sexo;
        this.condicion = condicion;
        this.notaFinal = notaFinal;
    }

    //region GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLu() {
        return lu;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCondicion() {
        return condicion;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    //endregion


    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", lu='" + lu + '\'' +
                ", sexo='" + sexo + '\'' +
                ", condicion='" + condicion + '\'' +
                ", notaFinal=" + notaFinal +
                '}';
    }
}
