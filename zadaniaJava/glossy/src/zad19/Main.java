package zad19;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Runnable> zadania = new ArrayList<>();

        zadania.add(new PobieraniePliku("zdjecia.zip"));
        zadania.add(new WysylanieMaila("ania@gmail.com"));
        zadania.add(new KompresjaZdjec(3));
        zadania.add(new PobieraniePliku("film.mp4"));
        zadania.add(new WysylanieMaila("kuba@gmail.com"));
        zadania.add(new KompresjaZdjec(4));
        zadania.add(new PobieraniePliku("muzyka.mp3"));
        zadania.add(new WysylanieMaila("ola@gmail.com"));


        System.out.println("WERSJA A - PO KOLEI");

        long startA = System.currentTimeMillis();

        for (int i = 0; i < zadania.size(); i++) {
            zadania.get(i).run();
        }

        long koniecA = System.currentTimeMillis();

        long czasA = koniecA - startA;

        System.out.println("Czas wykonania A: " + czasA + " ms");


        System.out.println("\nWERSJA B - WATKI");

        ArrayList<Thread> watki = new ArrayList<>();

        long startB = System.currentTimeMillis();

        for (int i = 0; i < zadania.size(); i++) {

            Thread watek = new Thread(zadania.get(i));

            watki.add(watek);

            watek.start();
        }

        for (int i = 0; i < watki.size(); i++) {
            watki.get(i).join();
        }

        long koniecB = System.currentTimeMillis();

        long czasB = koniecB - startB;

        System.out.println("Czas wykonania B: " + czasB + " ms");


        System.out.println("\nPOROWNANIE CZASU:");

        System.out.println("Wersja A: " + czasA + " ms");
        System.out.println("Wersja B: " + czasB + " ms");

        if (czasA > czasB) {
            System.out.println("Wersja B byla szybsza.");
        } else {
            System.out.println("Wersja A byla szybsza.");
        }
    }
}
//run() - wykonuje zadanie w aktualnym wątku, czyli po kolei
//start() - uruchamia nowy wątek, dzięki czemu zadania mogą wykonywać się jednocześnie (współbieżnie).