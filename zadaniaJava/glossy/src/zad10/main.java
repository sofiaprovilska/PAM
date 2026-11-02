package zad10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main {
    private static final HashMap<String, String> ksiazkaTelefoniczna = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ksiazkaTelefoniczna.put("Sofia Provilska ", "123456789");
        ksiazkaTelefoniczna.put("Yurii Biba", "987654321");
        ksiazkaTelefoniczna.put("Lena Mastalerz", "500600700");

        int wybor = -1;
        while (wybor != 0) {
            System.out.println("\nKSIĄŻKA TELEFONICZNA");
            System.out.println("1. Dodaj lub edytuj kontakt");
            System.out.println("2. Usuń kontakt");
            System.out.println("3. Znajdź numer po nazwisku");
            System.out.println("4. Znajdź nazwisko po numerze");
            System.out.println("5. Wypisz wszystkie kontakty alfabetycznie");
            System.out.println("0. Koniec");
            System.out.print("Wybierz opcję: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Błąd: Podaj liczbę");
                scanner.next();
                continue;
            }
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1 -> dodajLubEdytujKontakt();
                case 2 -> usunKontakt();
                case 3 -> znajdzNumerPoNazwie();
                case 4 -> znajdzNazwePoNumerze();
                case 5 -> wypiszAlfabetycznie();
                case 0 -> System.out.println("koniec.");
                default -> System.out.println("Niepoprawna opcja");
            }
        }
    }

    private static boolean czyNumerJestPoprawny(String numer) {
        return numer.matches("\\d{9}");
    }

    private static void dodajLubEdytujKontakt() {
        System.out.print("Podaj imię i nazwisko: ");
        String nazwa = scanner.nextLine().trim();
        if (nazwa.isEmpty()) {
            System.out.println(" Nazwa nie może być pusta!");
            return;
        }

        if (ksiazkaTelefoniczna.containsKey(nazwa)) {
            System.out.print("Kontakt już istnieje. Czy chcesz edytować numer? (tak/nie): ");
            String odpowiedz = scanner.nextLine().trim().toLowerCase();
            if (!odpowiedz.equals("tak")) {
                System.out.println(".");
                return;
            }
        }

        System.out.print("Podaj 9-cyfrowy numer telefonu: ");
        String numer = scanner.nextLine().trim();

        if (czyNumerJestPoprawny(numer)) {
            ksiazkaTelefoniczna.put(nazwa, numer);
            System.out.println("Zapisano kontakt: " + nazwa + " -> " + numer);
        } else {
            System.out.println("numer musi składać się z 9 cyfr");
        }
    }

    private static void usunKontakt() {
        System.out.print("Podaj imię i nazwisko kontaktu do usunięcia: ");
        String nazwa = scanner.nextLine().trim();

        if (ksiazkaTelefoniczna.containsKey(nazwa)) {
            ksiazkaTelefoniczna.remove(nazwa);
            System.out.println("Usunięto kontakt: " + nazwa);
        } else {
            System.out.println("Błąd: Nie znaleziono takiego kontaktu.");
        }
    }

    private static void znajdzNumerPoNazwie() {
        System.out.print("Podaj imię i nazwisko: ");
        String nazwa = scanner.nextLine().trim();

        String numer = ksiazkaTelefoniczna.get(nazwa);
        if (numer != null) {
            System.out.println("Numer dla '" + nazwa + "' to: " + numer);
        } else {
            System.out.println("nie znaleziono kontaktu o tej nazwie.");
        }
    }

    private static void znajdzNazwePoNumerze() {
        System.out.print("Podaj numer telefonu do wyszukania: ");
        String szukanyNumer = scanner.nextLine().trim();

        boolean znaleziono = false;
        for (Map.Entry<String, String> wpis : ksiazkaTelefoniczna.entrySet()) {
            if (wpis.getValue().equals(szukanyNumer)) {
                System.out.println("Ten numer należy do: " + wpis.getKey());
                znaleziono = true;
                break;
            }
        }

        if (!znaleziono) {
            System.out.println("zaden kontakt nie posiada takiego numeru.");
        }
    }

    private static void wypiszAlfabetycznie() {
        if (ksiazkaTelefoniczna.isEmpty()) {
            System.out.println("Książka telefoniczna jest pusta.");
            return;
        }

        TreeMap<String, String> posortowanaMapa = new TreeMap<>(ksiazkaTelefoniczna);

        System.out.println("\nkista kontaktow alfabetycznie");
        for (Map.Entry<String, String> wpis : posortowanaMapa.entrySet()) {
            System.out.println(wpis.getKey() + " -> " + wpis.getValue());
        }
    }
}