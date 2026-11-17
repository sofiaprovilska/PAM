package zad18;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Logger logger = new Logger();

        String[] nazwy = {
                "Siec", "Baza", "UI", "Platnosci"
        };

        ArrayList<Thread> watki = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            Modul modul = new Modul(nazwy[i], logger);

            Thread watek = new Thread(modul);

            watki.add(watek);

            watek.start();
        }

        for (int i = 0; i < watki.size(); i++) {
            watki.get(i).join();
        }

        ArrayList<String> logi = logger.pobierzLogi();

        System.out.println("Liczba wszystkich logow: " + logi.size());

        HashMap<String, Integer> poziomy = new HashMap<>();

        poziomy.put("INFO", 0);
        poziomy.put("WARN", 0);
        poziomy.put("ERROR", 0);

        HashMap<String, Integer> bledy = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            bledy.put(nazwy[i], 0);
        }

        ArrayList<String> ostatnieBledy = new ArrayList<>();

        for (int i = 0; i < logi.size(); i++) {

            String wpis = logi.get(i);

            int koniec = wpis.indexOf("]");
            String poziom = wpis.substring(1, koniec);

            poziomy.put(poziom, poziomy.get(poziom) + 1);

            if (poziom.equals("ERROR")) {

                int dwukropek = wpis.indexOf(":");

                String modul = wpis.substring(koniec + 2, dwukropek);

                bledy.put(modul, bledy.get(modul) + 1);

                ostatnieBledy.add(wpis);

                if (ostatnieBledy.size() > 5) {
                    ostatnieBledy.remove(0);
                }
            }
        }

        System.out.println("\nLiczba wpisow wedlug poziomu:");

        System.out.println("INFO: " + poziomy.get("INFO"));
        System.out.println("WARN: " + poziomy.get("WARN"));
        System.out.println("ERROR: " + poziomy.get("ERROR"));

        String najwiecej = "";
        int max = 0;

        for (int i = 0; i < 4; i++) {

            String modul = nazwy[i];

            if (bledy.get(modul) > max) {
                max = bledy.get(modul);
                najwiecej = modul;
            }
        }

        System.out.println("\nNajwiecej bledow: "
                + najwiecej + " (" + max + ")");

        System.out.println("\nOstatnie 5 wpisow ERROR:");

        for (int i = 0; i < ostatnieBledy.size(); i++) {
            System.out.println(ostatnieBledy.get(i));
        }
    }
}