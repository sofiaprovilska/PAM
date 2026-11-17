package zad16;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Runnable> lista = new ArrayList<>();

        lista.add(new Odliczanie("A", 5));
        lista.add(new Odliczanie("B", 3));
        lista.add(new Odliczanie("C", 8));
        lista.add(new Odliczanie("D", 6));
        lista.add(new Odliczanie("E", 4));

        ArrayList<Thread> watki = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {

            Thread watek = new Thread(lista.get(i));

            watki.add(watek);

            watek.start();
        }

        for (int i = 0; i < watki.size(); i++) {
            watki.get(i).join();
        }

        System.out.println("Wszystkie wątki zakończone");
    }
}
//wątki będą wykonywać się kolejno, a nie współbieżnie, ponieważ program czeka na zakończenie każdego wątku przed uruchomieniem następnego.