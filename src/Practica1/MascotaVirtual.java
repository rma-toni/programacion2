package Practica1;

public class MascotaVirtual {

    public static final short MAX_ENERGIA = 100;
    public static final short MIN_ENERGIA = 0;

    private int energia;
    private boolean dormido;
    private int cantDesgaste;
    private int cantComer;

    public MascotaVirtual(){
        this.energia = MAX_ENERGIA;
        this.dormido = false;
        this.cantDesgaste = 0;
        this.cantComer = 0;
    }

    //TODO comer():boolean

    public boolean comer(){
        boolean control = true;
        if(estaVivo()){
            cantComer++;
            if(cantComer<5){
                energia+=30;
            }else{
                //TODO morir?
            }
        }else{
            control = false;
        }
        return  control;
    }

    //TODO beber():boolean

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
    boolean estaVivo(){
        return true;
    }
}
