package zad30;

import java.util.HashMap;

public class Statystyki implements Subskrybent {
    private HashMap<String, Integer> liczbaFilmow = new HashMap<>();

    public void powiadomienie(Kanal k, Film f) {
        String nazwa = k.getNazwa();

        if (liczbaFilmow.containsKey(nazwa)) {
            liczbaFilmow.put(nazwa, liczbaFilmow.get(nazwa) + 1);
        } else {
            liczbaFilmow.put(nazwa, 1);
        }

        System.out.println("\nStatystyki:");
        System.out.println(liczbaFilmow);
    }
}