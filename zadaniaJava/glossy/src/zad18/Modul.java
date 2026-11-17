package zad18;

import java.util.Random;

public class Modul implements Runnable {

    String nazwa;
    Logger logger;

    public Modul(String nazwa, Logger logger) {
        this.nazwa = nazwa;
        this.logger = logger;
    }

    @Override
    public void run() {

        Random random = new Random();

        String[] poziomy = {"INFO", "WARN", "ERROR"};

        for (int i = 0; i < 250; i++) {

            int los = random.nextInt(3);

            String poziom = poziomy[los];

            logger.zapisz(nazwa, poziom, "Zdarzenie numer " + (i + 1));

            try {
                Thread.sleep(random.nextInt(6));
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}