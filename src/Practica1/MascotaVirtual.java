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
        if(estadoVivo() && !estaDormido()){ //TODO esto se puede simplicar, IDEM en beber()
            cantComer++;
            if(cantComer<5){
                if(energia > 70){
                    energia=100;
                }else{
                    energia+=30;
                }
                System.out.println("La mascota comió y recupero 30 puntos de energia");
            }else{
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        }else if(!estadoVivo()){
            System.out.println("La mascota esta muerta!");
            control = false;
        } else if(estaDormido()){
            System.out.println("La mascota esta dormida!");
            control = false;
        }
        return  control;
    }

    public boolean beber(){
        boolean control = true;
        if(estadoVivo() && !estaDormido()){
            cantComer++;
            if(cantComer<5){
                if(energia > 85){
                    energia=100;
                }else{
                    energia+=15;
                }
                System.out.println("La mascota bebió y recupero 15 puntos de energia");
            }else{
                System.out.println("La mascota murió de indigestion!");
                estaVivo = false;
            }
        }else if(!estadoVivo()){
            System.out.println("La mascota esta muerta!");
            control = false;
        } else if(estaDormido()){
            System.out.println("La mascota esta dormida!");
            control = false;
        }
        return  control;
    }

    public boolean dormir(){
        boolean control = true;
        if(!estaDormido()){
            System.out.println("La mascota ya esta dormida!");
            control = false;
        }else if(!estadoVivo()){
            System.out.println("La mascota esta muerta!");
            control = false;
        }else{
            System.out.println("La mascota se fue a dormir y recuro un cuarto de su energia!");
            dormido = true;
            energia += (int) (MAX_ENERGIA * 0.25f);
        }
        return control;
    }

    public boolean despertar(){
        boolean control = true;
        if(!estaDormido()){
            System.out.println("La mascota no esta dormida!");
            control = false;
        }else if(!estadoVivo()){
            System.out.println("La mascota esta muerta!");
        }else{
            dormido = false;
            System.out.println("La mascota desperto!");
        }
        return control;
    }

    //TODO caminar():boolean

    //TODO correr():boolean

    //TODO saltar():boolean

    public int obtenerEnergia(){
        return energia;
    }

    public boolean estaDormido(){
        return dormido;
    }

    public int obtenerCantDesgaste(){
        return cantDesgaste;
    }

    public int obtenerCantCamer(){
        return cantComer;
    }

    //TODO obtenerHumor():entero

    public boolean estadoVivo(){
        return estaVivo;
    }
}
