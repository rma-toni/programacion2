package CajaAhorro;

public class Persona {
    private int DNI;
    private String nombre;

    // Constructor for objects of class Persona
    public Persona(String nom, int dni)
    {
        DNI = dni;
        nombre= nom;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDNI(){
        return DNI;
    }

}