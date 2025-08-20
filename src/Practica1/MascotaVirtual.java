package Practica1;

public class MascotaVirtual {

    public static final short MAX_ENERGIA = 100;
    public static final short MIN_ENERGIA = 0;

    private int energia;
    private boolean dormido;
    private int cantDesgaste;
    private int cantComer;

    private boolean estaVivo;

    public MascotaVirtual(){
        this.energia = MAX_ENERGIA;
        this.dormido = false;
        this.cantDesgaste = 0;
        this.cantComer = 0;
        this.estaVivo = true;
    }

    public boolean comer(){
        boolean control = true;
        if(estadoVivo()){
            cantComer++;
            if(cantComer<5){
                if(energia > 70){
                    energia=100;
                }else{
                    energia+=30;
                }
            }else{
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        }else{
            System.out.println("La mascota esta muerta!");
            control = false;
        }
        return  control;
    }

    public boolean beber(){
        boolean control = true;
        if(estadoVivo()){
            cantComer++;
            if(cantComer<5){
                if(energia > 85){
                    energia=100;
                }else{
                    energia+=15;
                }
            }else{
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        }else{
            System.out.println("La mascota esta muerta!");
            control = false;
        }
        return  control;
    }

    //TODO dormir():boolean

    //TODO despertar():boolean

    //TODO caminar():boolean

    //TODO correr():boolean

    //TODO saltar():boolean

    //TODO obtenerEnergia():entero

    //TODO estaDormido():boolean

    //TODO obtenerCantDesgaste():entero

    //TODO obtenerCantComer():entero

    //TODO obtenerHumor():entero

    //TODO estaVivo():boolean completar
    boolean estadoVivo(){
        return estaVivo;
    }
}
