package zad2;

public class Licznik {
    private int wartosc = 0;
//    public void zwieksz(){
//        wartosc ++;
//    }
//    public synchronized void zwieksz(){
//        wartosc ++;
//    }
    public void zwieksz(){
        synchronized (this) {
            wartosc++;
        }
}

    public int getWynik(){
        return wartosc;
    }
}
