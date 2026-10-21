package zad1;

public class KontoBankowe {
    private int saldo;

    public KontoBankowe(int saldo){
        this.saldo = saldo;
    }
//    public void wplac(int kwota){
//        this.saldo += kwota;
//    }
//    public boolean wyplac(int kwota){
//        if(this.saldo - kwota >= 0){
//            this.saldo -= kwota;
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
public synchronized void wplac(int kwota){
    this.saldo += kwota;
}
    public synchronized boolean wyplac(int kwota){
        if(this.saldo - kwota >= 0){
            this.saldo -= kwota;
            return true;
        }
        else{
            return false;
        }
    }
    public int getSaldo(){
        return this.saldo;
    }

}
