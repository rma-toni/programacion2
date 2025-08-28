package Practica1_Maria_Isabel;

public class MascotaVirtual {
    // Constantes
    private static final int MAX_ENERGIA = 100;
    private static final int MIN_ENERGIA = 0;

    // Atributos
    private String nombre;
    private int energia;
    private boolean dormido;
    private int cantDesgaste;  // acciones de desgaste consecutivas
    private int cantComer;     // veces consecutivas de comer/beber
    private boolean vivo;

    // Constructor
    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.energia = 50;  // energia inicial intermedia
        this.dormido = false;
        this.cantDesgaste = 0;
        this.cantComer = 0;
        this.vivo = true;
    }

    // Metodo todas acciones
    public boolean comer() {
        if (!vivo || dormido) return false;
        cantDesgaste = 0;
        cantComer++;
        if (cantComer >= 5) { // muere por indigestion
            vivo = false;
            energia = 0;
            return false;
        }
        energia = Math.min(MAX_ENERGIA, energia + 30);
        return true;
    }

    public boolean beber() {
        if (!vivo || dormido) return false;
        cantDesgaste = 0;
        cantComer++;
        if (cantComer >= 5) {
            vivo = false;
            energia = 0;
            return false;
        }
        energia = Math.min(MAX_ENERGIA, energia + 15);
        return true;
    }

    public boolean dormir() {
        if (!vivo) return false;
        dormido = true;
        cantDesgaste = 0;
        cantComer = 0;
        energia = Math.min(MAX_ENERGIA, energia + (MAX_ENERGIA * 25 / 100));
        return true;
    }

    public boolean despertar() {
        if (!vivo) return false;
        dormido = false;
        return true;
    }

    public boolean caminar() {
        return desgaste(15);
    }

    public boolean correr() {
        return desgaste(50);
    }

    public boolean saltar() {
        return desgaste(5);
    }

    // Metodo interno para las acciones de desgaste
    private boolean desgaste(int puntos) {
        if (!vivo || dormido) return false;
        cantComer = 0;
        cantDesgaste++;
        if (cantDesgaste > 3) {
            return dormir(); // se duerme automaticamente
        }
        energia -= puntos;
        if (energia <= MIN_ENERGIA) {
            energia = 0;
            vivo = false;
        }
        return vivo;
    }

    // Getters
    public int obtenerEnergia() {
        return energia;
    }

    public boolean estaDormido() {
        return dormido;
    }

    public int obtenerCantComer() {
        return cantComer;
    }

    public int obtenerCantDesgaste() {
        return cantDesgaste;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int obtenerHumor() {
        if (energia >= 81) return 5;
        else if (energia >= 61) return 4;
        else if (energia >= 41) return 3;
        else if (energia >= 21) return 2;
        else return 1;
    }

    @Override
    public String toString() {
        return nombre + " | Energia: " + energia + " | Humor: " + obtenerHumor() +
                " | Dormido: " + dormido + " | Vivo: "+vivo;
    }
}