package Practica1_Nazareno;


public class MascotaVirtual {

    private String nombre;
    private int energia;
    private boolean viva;
    private boolean durmiendo;

    private int contadorDesgasteConsecutivo;
    private int contadorComerBeberConsecutivo;


    public MascotaVirtual() {}

    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.energia = 100;
        this.viva = true;
        this.durmiendo = false;
        this.contadorDesgasteConsecutivo = 0;
        this.contadorComerBeberConsecutivo = 0;
    }

    private void VerificarVida() {
        if (this.energia <= 0) {
            this.energia = 0;
            this.viva = false;
            System.out.println(this.nombre + " ha muerto");
        }
    }

    private void cambiarEnergia(int cantidad) {
        if (!this.viva) {
            return;
        }
        this.energia = this.energia + cantidad;
        if (this.energia > 100) {
            this.energia = 100;
        }
        if (this.energia < 0) {
            this.energia = 0;
        }
        VerificarVida();
    }

    public boolean comer() {
        if (!this.viva) {
            return false;
        }
        if (this.durmiendo) {
            System.out.println(this.nombre + " está durmiendo y no puede comer (∪.∪ )...zzz.");
            return false;
        }

        this.contadorComerBeberConsecutivo++;
        this.contadorDesgasteConsecutivo = 0;

        if (this.contadorComerBeberConsecutivo >= 5) {
            this.viva = false;
            System.out.println(this.nombre + " murió por indigestión (⓿_⓿)");
            return false;
        }

        cambiarEnergia(10);
        return true;
    }

    public boolean beber() {
        if (!this.viva) {
            return false;
        }
        if (this.durmiendo) {
            System.out.println(this.nombre + " está durmiendo y no puede beber(∪.∪ )...zzz.");
            return false;
        }

        this.contadorComerBeberConsecutivo++;
        this.contadorDesgasteConsecutivo = 0;

        if (this.contadorComerBeberConsecutivo >= 5) {
            this.viva = false;
            System.out.println(this.nombre + " murió por indigestión (⓿_⓿) ");
            return false;
        }

        cambiarEnergia(5);
        return true;
    }

    public boolean dormir() {
        if (!this.viva) {
            return false;
        }
        if (this.durmiendo) {
            System.out.println(this.nombre + " ya está durmiendo.");
            return false;
        }

        this.durmiendo = true;
        this.contadorComerBeberConsecutivo = 0;
        this.contadorDesgasteConsecutivo = 0;

        int recuperacion = (int) (this.energia * 0.25);
        cambiarEnergia(recuperacion);

        return true;
    }

    public boolean Despertar() {
        if (!this.viva) {
            return false;
        }
        if (!this.durmiendo) {
            System.out.println(this.nombre + " no está durmiendo.");
            return false;
        }
        this.durmiendo = false;
        System.out.println(this.nombre + " se despertó");
        return true;
    }

    public boolean Caminar() {
        return HacerAccionDesgaste(5, "caminar");
    }

    public boolean Correr() {
        return HacerAccionDesgaste(15, "correr");
    }

    public boolean Saltar() {
        return HacerAccionDesgaste(10, "saltar");
    }

    private boolean HacerAccionDesgaste(int costo, String accion) {
        if (!this.viva) {
            return false;
        }
        if (this.durmiendo) {
            System.out.println(this.nombre + " está durmiendo y no puede " + accion);
            return false;
        }

        this.contadorDesgasteConsecutivo++;
        this.contadorComerBeberConsecutivo = 0;

        if (this.contadorDesgasteConsecutivo > 3) {
            System.out.println(this.nombre + " está agotado y se duerme automáticamente 😴");
            dormir();
            return false;
        }

        cambiarEnergia(-costo);
        System.out.println(this.nombre + " realizó " + accion + " y ahora tiene " + this.energia + " de energía.");
        return true;
    }

    public int getHumor() {
        if (!this.viva) {
            return 0;
        }
        if (this.energia >= 81 && this.energia <= 100) {
            return 5;
        } else if (this.energia >= 61) {
            return 4;
        } else if (this.energia >= 41) {
            return 3;
        } else if (this.energia >= 21) {
            return 2;
        } else {
            return 1;
        }
    }
    public boolean estaViva() {
        return this.viva;
    }
    public String getNombre() {
        return this.nombre;
    }

    public int getEnergia() {
        return this.energia;
    }

    public boolean estaDurmiendo() {
        return this.durmiendo;
    }

}