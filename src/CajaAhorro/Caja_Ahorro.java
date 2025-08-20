package CajaAhorro;

public class Caja_Ahorro {
    private int saldo;
    private Persona titular;

    public Caja_Ahorro(Persona Tit, int Importe)
    {
        saldo = Importe;
        titular = Tit;
    }

    public  void Depositar (int monto)
    {
        saldo = saldo + monto;
    }

    public  void Extraer (int monto)
    {
        if(saldo >= monto){
            saldo = saldo - monto;
        }else{
            System.out.println("Saldo insuficiente.");
        }
    }

    public  int GetSaldo ()
    {
        return saldo;
    }

    public void mostrarTitular(){
        System.out.println("Titular: "+titular.getNombre()+", DNI: "+titular.getDNI());
    }

}
