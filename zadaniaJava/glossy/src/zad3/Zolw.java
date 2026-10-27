package zad3;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Zolw implements Runnable{
    String imie;
    List<String> wyniki;
    public Zolw(String imie, List<String> wyniki){
        this.imie = imie;
        this.wyniki = wyniki;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for(int i =0; i<=20; i++){
            try{
                Thread.sleep(rnd.nextInt(251)+50);
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(imie + "krok" + i + "/20");
        }
        synchronized (wyniki){
            wyniki.add(imie);
        }
        System.out.println(imie + "dotatł do mety");
    }
}
