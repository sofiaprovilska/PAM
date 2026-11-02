package zad12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    private static final HashMap<String, ArrayList<Integer>> dziennik = new HashMap<>();

    public static void main(String[] args) {
        dodajUcznia("Kowalski");
        dodajUcznia("Nowak");
        dodajUcznia("Modrowski");

        dodajOcene("Kowalski", 5);
        dodajOcene("Kowalski", 4);
        dodajOcene("Kowalski", 6);

        dodajOcene("Nowak", 2);
        dodajOcene("Nowak", 1);
        dodajOcene("Nowak", 2);

        dodajOcene("Modrowski", 4);
        dodajOcene("Modrowski", 3);
        dodajOcene("Modrowski", 4);

        dodajOcene("Provilski", 5);

        wypiszRaport();
        znajdzNajlepszegoUcznia();
        wypiszZagrozonych();
    }

    public static void dodajUcsnia(String uczen) {
        dodajUcznia(uczen);
    }

    public static void dodajUcznia(String uczen) {
        if (!dziennik.containsKey(uczen)) {
            dziennik.put(uczen, new ArrayList<>());
            System.out.println("Dodano ucznia: " + uczen);
        } else {
            System.out.println("Uczeń " + uczen + " już istnieje w dzienniku!");
        }
    }

    public static void dodajOcene(String uczen, int ocena) {
        if (ocena < 1 || ocena > 6) {
            System.out.println("Błąd: Niepoprawna ocena " + ocena);
            return;
        }

        ArrayList<Integer> ocenyUcznia = dziennik.get(uczen);
        if (ocenyUcznia != null) {
            ocenyUcznia.add(ocena);
            System.out.println("Dodano ocenę " + ocena + " dla ucznia " + uczen);
        } else {
            System.out.println("Błąd: Nie można dodać oceny. Uczeń '" + uczen + "' nie istnieje!");
        }
    }

    private static double obliczSrednia(ArrayList<Integer> oceny) {
        if (oceny == null || oceny.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return (double) suma / oceny.size();
    }

    public static void wypiszRaport() {
        System.out.println("\nRAPORT DZIENNIKA");
        for (Map.Entry<String, ArrayList<Integer>> wpis : dziennik.entrySet()) {
            String uczen = wpis.getKey();
            ArrayList<Integer> oceny = wpis.getValue();
            double srednia = obliczSrednia(oceny);

            String status = (srednia < 2.0 && !oceny.isEmpty()) ? " ZAGROŻONY" : "";
            System.out.printf("%s: %s śr. %.2f%s\n", uczen, oceny.toString(), srednia, status);
        }
    }

    public static void znajdzNajlepszegoUcznia() {
        String najlepszyUczen = "Brak";
        double najwyzszaSrednia = -1.0;

        for (Map.Entry<String, ArrayList<Integer>> wpis : dziennik.entrySet()) {
            double aktualnaSrednia = obliczSrednia(wpis.getValue());
            if (aktualnaSrednia > najwyzszaSrednia) {
                najwyzszaSrednia = aktualnaSrednia;
                najlepszyUczen = wpis.getKey();
            }
        }

        System.out.println("\nnajlepszy uczen");
        if (najwyzszaSrednia >= 0) {
            System.out.printf("Uczeń z najwyższą średnią to: %s (śr. %.2f)\n", najlepszyUczen, najwyzszaSrednia);
        } else {
            System.out.println("Brak uczniów z ocenami.");
        }
    }

    public static void wypiszZagrozonych() {
        System.out.println("\nZAGROŻENI");
        boolean znaleziono = false;

        for (Map.Entry<String, ArrayList<Integer>> wpis : dziennik.entrySet()) {
            ArrayList<Integer> oceny = wpis.getValue();
            double srednia = obliczSrednia(oceny);

            if (srednia < 2.0 && !oceny.isEmpty()) {
                System.out.printf("- %s (śr. %.2f)\n", wpis.getKey(), srednia);
                znaleziono = true;
            }
        }

        if (!znaleziono) {
            System.out.println("Brak zagrożonych uczniów");
        }
    }
}
