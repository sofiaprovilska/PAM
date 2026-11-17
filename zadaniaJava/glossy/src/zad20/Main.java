package zad20;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static class Zadanie implements Runnable {

        int numer;

        public Zadanie(int numer) {
            this.numer = numer;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }

            System.out.println("Zakończono zadanie " + numer);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Runnable> kolejka = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            kolejka.add(new Zadanie(i));
        }

        ArrayList<Thread> watki = new ArrayList<>();

        HashMap<String, Integer> wyniki = new HashMap<>();

        for (int i = 1; i <= 3; i++) {

            Robotnik robotnik = new Robotnik(
                    "Robotnik-" + i, kolejka, wyniki
            );

            Thread watek = new Thread(robotnik);

            watki.add(watek);

            watek.start();
        }

        for (int i = 0; i < watki.size(); i++) {
            watki.get(i).join();
        }

        System.out.println("\nPodsumowanie:");

        for (int i = 1; i <= 3; i++) {

            String nazwa = "Robotnik-" + i;

            System.out.println(
                    nazwa + ": " + wyniki.get(nazwa)
            );
        }
    }
}