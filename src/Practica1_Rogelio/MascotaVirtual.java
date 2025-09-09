package Practica1_Rogelio;

public class MascotaVirtual {

    public static final short MAX_ENERGIA = 100;
    public static final short MIN_ENERGIA = 0;

    private String nombre;
    private int energia;
    private boolean dormido;
    private int cantDesgaste;
    private int cantComer;

    private boolean estaVivo;

    public MascotaVirtual(String nombre){
        this.nombre = nombre;
        this.energia = MAX_ENERGIA;
        this.dormido = false;
        this.cantDesgaste = 0;
        this.cantComer = 0;
        this.estaVivo = true;
    }

    public boolean comer(){
        boolean control = true;
        if(!estaDormido()){ //TODO esto se puede simplicar, IDEM en beber()
            cantComer++;
            if(energia > 70){
                energia=100;
            }else{
                energia+=30;
            }
            System.out.println("La mascota comió y recupero 30 puntos de energia");
            cantDesgaste = 0;
            if(cantComer == 5){
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        } else {
            System.out.println("La mascota esta dormida!");
            control = false;
        }
        return  control;
    }

    public boolean beber(){
        boolean control = true;
        if(!estaDormido()){
            cantComer++;
            if(cantComer<5){
                if(energia > 85){
                    energia=100;
                }else{
                    energia+=15;
                }
                System.out.println("La mascota bebió y recupero 15 puntos de energia");
                cantDesgaste = 0;
            }else{
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        } else {
            System.out.println("La mascota esta dormida!");
            control = false;
        }
        return  control;
    }

    public boolean dormir(){
        boolean control = true;
        if(estaDormido()){
            System.out.println("La mascota ya esta dormida!");
            control = false;
        }else{
            System.out.println("La mascota se fue a dormir y recupero un cuarto de su energia!");
            dormido = true;
            cantDesgaste = 0;
            cantComer = 0;
            if(energia < 75){
                energia += (int) (MAX_ENERGIA * 0.25f);
            }else{
                energia = 100;
            }
        }
        return control;
    }

    public boolean despertar(){
        boolean control = true;
        if(!estaDormido()){
            System.out.println("La mascota no esta dormida!");
            control = false;
        }else{
            dormido = false;
            System.out.println("La mascota desperto!");
        }
        return control;
    }

    public boolean caminar(){
        boolean control = true;
        if(estaDormido() || energia < 15){
            System.out.println("No se puede completar.");
            control = false;
        }else{
            cantDesgaste++;
            if(cantDesgaste == 4){
                System.out.println("La mascota ignoro la orden.");
                dormir();
            }else{
                cantComer = 0;
                energia-= 15;
                if (energia == MIN_ENERGIA){
                    System.out.println("La mascota se quedo sin energia y murio.");
                    estaVivo = false;
                }
            }
        }
        return control;
    }

    public boolean correr(){
        boolean control = true;
        if(estaDormido() || energia < (MAX_ENERGIA*0.5)){
            System.out.println("No se puede completar.");
            control = false;
        }else{
            cantDesgaste++;
            if(cantDesgaste == 4){
                System.out.println("La mascota ignoro la orden.");
                dormir();
            }else{
                cantComer = 0;
                energia-= (int)(MAX_ENERGIA*0.5);
                if (energia == MIN_ENERGIA){
                    System.out.println("La mascota se quedo sin energia y murio.");
                    estaVivo = false;
                }
            }
        }
        return control;
    }

    public boolean saltar(){
        boolean control = true;
        if(estaDormido() || energia < 5){
            System.out.println("No se puede completar.");
            control = false;
        }else{
            cantDesgaste++;
            if(cantDesgaste == 4){
                System.out.println("La mascota ignoro la orden.");
                dormir();
            }else{
                energia-=5;
                cantComer = 0;
                if (energia == MIN_ENERGIA){
                    System.out.println("La mascota se quedo sin energia y murio.");
                    estaVivo = false;
                }
            }
        }
        return control;
    }

    public int obtenerEnergia(){
        return energia;
    }

    public boolean estaDormido(){
        return dormido;
    }

    public int obtenerCantDesgaste(){
        return cantDesgaste;
    }

    public int obtenerCantComer(){
        return cantComer;
    }

    public int obtenerHumor(){
        int humor = -1;
        if(energia > 0 && energia <= 20){
            humor = 1;
        }else if(energia > 21 && energia <= 40){
            humor = 2;
        }
        else if(energia > 41 && energia <= 60){
            humor = 3;
        }
        else if(energia > 61 && energia <= 80){
            humor = 4;
        }else{
            humor = 5;
        }
        return humor;
    }

    public boolean estadoVivo(){
        return estaVivo;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return  "Energia = " + energia +
                ", Dormido = " + dormido +
                ", CantDesgaste = " + cantDesgaste +
                ", CantComer = " + cantComer;
    }
}
