package zad4;

import java.util.Random;

public class PulaBiletow {
    private int dostepneBilety = 100;

    public synchronized int kupBilety(int liczba, String nazwaKasy) {
        if (dostepneBilety == 0) {
            return -1;
        }

        if (liczba > dostepneBilety) {
            System.out.println(nazwaKasy + ": odrzucono " + liczba + " (zostało " + dostepneBilety + ")");
            return 0;
        }

        dostepneBilety -= liczba;
        System.out.println(nazwaKasy + ": sprzedano " + liczba + " (zostało " + dostepneBilety + ")");
        return liczba;
    }

    public synchronized int getDostepneBilety() {
        return dostepneBilety;
    }
}

class Kasa extends Thread {
    private final PulaBiletow pula;
    private final String nazwaKasy;
    private int sprzedanePrzezTęKasę = 0;
    private final Random random = new Random();

    public Kasa(String nazwaKasy, PulaBiletow pula) {
        this.nazwaKasy = nazwaKasy;
        this.pula = pula;
    }

    @Override
    public void run() {
        while (pula.getDostepneBilety() > 0) {
            int doKupienia = random.nextInt(4) + 1;

            int wynik = pula.kupBilety(doKupienia, nazwaKasy);

            if (wynik == -1) {
                break;
            } else if (wynik > 0) {
                sprzedanePrzezTęKasę += wynik;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getSprzedanePrzezTęKasę() {
        return sprzedanePrzezTęKasę;
    }
}