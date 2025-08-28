package Practica1_Gabriel;

public class MascotaVirtual {
    String nombre;
    int energia;
    boolean viva;
    boolean dormido;
    int contDegaste;
    int contComer;

    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.energia = 50;
        this.viva = true;
        this.dormido = false;
        this.contDegaste = 0;
        this.contComer = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEnergia() {
        return this.energia;
    }

    public boolean getViva() {
        return this.viva;
    }

    public boolean getDormido() {
        return this.dormido;
    }

    public int getHumor() {
        if (energia >= 81 && energia <= 100) {return 5;}
        else if (energia >= 61 && energia <= 80) {return 4;}
        else if (energia >= 41 && energia <= 60) {return 3;}
        else if (energia >= 40 && energia <= 21) {return 2;}
        else if (energia >= 0 && energia <= 20) {return 1;}
        else return 0;
    }

    private void setEnergia(int cambio) {
        energia += cambio;
        if (energia > 100) energia = 100;
        else if (energia < 0) energia = 0;
        else if (energia == 0) {
            viva = false;
            System.out.println(nombre + "muelto por falta de energia");
        }
    }

    private boolean puedeActuar() {
        if (!viva) {
            System.out.println("esta muerto");
            return false;
        }
        if (dormido) {
            System.out.println("esta mimido");
            return false;
        }
        return true;
    }

    public boolean comer() {
        if (!puedeActuar()) return false;
        contComer++;
        contDegaste = 0;
        if (contComer >= 5) {
            viva = false;
            System.out.println(nombre + "muelto por indigestion");
            return false;
        }
        setEnergia(+30);
        return true;
    }

    public boolean bebida() {
        if (!puedeActuar()) return false;
        contComer++;
        contDegaste = 0;
        if (contComer >= 5) {
            viva = false;
            System.out.println(nombre + "muelto por indigestion");
            return false;
        }
        setEnergia(+15);
        return true;
    }

    public boolean dormir() {
        if (!viva) return false;
        if (dormido) {
            System.out.println(nombre + "ya esta mimido");
            return false;
        }
        dormido = true;
        contComer = 0;
        contDegaste = 0;
        int recuperacion = (int) (energia * 0.25);
        setEnergia(recuperacion);
        System.out.println(nombre + "se durmio y recupero algo de energia");
        return true;
    }

    public boolean despertar() {
        if (!viva) return false;
        if (!dormido) {
            System.out.println(nombre + "ta despierto");
            return false;
        }
        dormido = false;
        System.out.println(nombre + "esta despiuerto");
        return true;
    }

    public boolean caminar() {
        if (!viva) return false;
        if (dormido) {
            System.out.println(nombre + "esta dormido");
            return false;
        }
        System.out.println(nombre + "esta caminando");
        setEnergia(-10);
        return true;
    }
    public boolean correr() {
        if (!viva) return false;
        if (dormido) {
            System.out.println(nombre + "esta dormido");
            return false;
        }
        System.out.println(nombre + "esta corrinedo");
        setEnergia(-20);
        return true;
    }
    public boolean saltar() {
        if (!viva) return false;
        if (dormido) {
            System.out.println(nombre + "esta dormido");
            return false;
        }
        System.out.println(nombre + "esta caminando");
        setEnergia(-5);
        return true;
    }
    private boolean  gastarEnergia(int gasto){
        if (!puedeActuar()) return false;
        contDegaste++;
        if (contDegaste > 3){
            System.out.println("se canso y se durmio");
            return dormir();
        }
        setEnergia(gasto);
        return true;
    }
    public String toString(){
        return "mascota" + nombre +"\n"+
                "energia" + energia+ "\n"+
                "humor" + getHumor()+ "\n"+
                "vivo" + viva + "\n" +
                "dormido" + dormido;

    }
}