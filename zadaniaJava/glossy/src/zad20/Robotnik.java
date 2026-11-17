package zad20;

import java.util.ArrayList;
import java.util.HashMap;

public class Robotnik implements Runnable {

    String nazwa;
    ArrayList<Runnable> kolejka;
    HashMap<String, Integer> wyniki;

    public Robotnik(String nazwa, ArrayList<Runnable> kolejka,
                    HashMap<String, Integer> wyniki) {

        this.nazwa = nazwa;
        this.kolejka = kolejka;
        this.wyniki = wyniki;
    }

    @Override
    public void run() {

        int licznik = 0;

        while (true) {

            Runnable zadanie;

            synchronized (kolejka) {

                if (kolejka.isEmpty()) {
                    break;
                }

                zadanie = kolejka.remove(0);
            }

            licznik++;

            System.out.println(nazwa + " wykonuje zadanie " + licznik);

            zadanie.run();
        }

        synchronized (wyniki) {
            wyniki.put(nazwa, licznik);
        }
    }
}