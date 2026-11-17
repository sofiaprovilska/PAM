package zad17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Sala sala = new Sala();

        ArrayList<Thread> watki = new ArrayList<>();

        ArrayList<String> rezygnacje =
                new ArrayList<>();

        rezygnacje = new ArrayList<>(
                Collections.synchronizedList(rezygnacje)
        );

        String[] imiona = {
                "Ania", "Kuba", "Ola", "Marek", "Zosia",
                "Adam", "Ewa", "Tomek", "Julia", "Piotr",
                "Maja", "Kamil", "Basia", "Jan", "Lena",
                "Pawel", "Kasia", "Filip", "Ala", "Michal"
        };

        Random random = new Random();

        for (int i = 0; i < 20; i++) {

            ArrayList<Integer> miejsca = new ArrayList<>();

            while (miejsca.size() < 3) {

                int miejsce = random.nextInt(30) + 1;

                if (!miejsca.contains(miejsce)) {
                    miejsca.add(miejsce);
                }
            }

            Klient klient = new Klient(
                    imiona[i], miejsca, sala, rezygnacje
            );

            Thread watek = new Thread(klient);

            watki.add(watek);

            watek.start();
        }

        for (int i = 0; i < watki.size(); i++) {
            watki.get(i).join();
        }

        System.out.println("\nPLAN SALI:");

        sala.pokazSale();

        System.out.println("\nZrezygnowali:");

        for (int i = 0; i < rezygnacje.size(); i++) {
            System.out.print(rezygnacje.get(i) + " ");
        }
    }
}