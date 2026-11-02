package zad11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz dowolny tekst:");
        String tekst = scanner.nextLine();

        String tekstWyczyszczony = tekst.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()?\\\"]", "");
        String[] slowa = tekstWyczyszczony.split("\\s+");

        HashMap<String, Integer> licznikSlow = new HashMap<>();

        for (String slowo : slowa) {
            if (slowo.isEmpty()) continue;

            /*
              getOrDefault(slowo, 0)
             sprawdza, czy dane słowo jest już w mapie.
             * jeśli tak, zwraca jego aktualną liczbę wystąpień
             * jesli nie, zwraca domyślną wartość - 0.
             */
            int aktualnyLicznik = licznikSlow.getOrDefault(slowo, 0);
            licznikSlow.put(slowo, aktualnyLicznik + 1);
        }

        System.out.println("\nWszystkie słowa z liczbą wystąpień:");
        System.out.println(licznikSlow);

        String najczęstszeSlowo = "";
        int maxWystapien = 0;

        StringBuilder slowaTylkoRaz = new StringBuilder();

        for (Map.Entry<String, Integer> wpis : licznikSlow.entrySet()) {
            String slowo = wpis.getKey();
            int liczbaWystapien = wpis.getValue();

            if (liczbaWystapien > maxWystapien) {
                maxWystapien = liczbaWystapien;
                najczęstszeSlowo = slowo;
            }

            if (liczbaWystapien == 1) {
                if (slowaTylkoRaz.length() > 0) {
                    slowaTylkoRaz.append(", ");
                }
                slowaTylkoRaz.append(slowo);
            }
        }

        System.out.println("\nNajczęstsze słowo:");
        if (maxWystapien > 0) {
            System.out.println("- '" + najczęstszeSlowo + "' (wystąpiło " + maxWystapien + " razy)");
        } else {
            System.out.println("- Brak słów.");
        }

        System.out.println("\nSłowa występujące tylko raz:");
        if (slowaTylkoRaz.length() > 0) {
            System.out.println("- " + slowaTylkoRaz);
        } else {
            System.out.println("- Brak takich słów (wszystkie się powtarzają).");
        }

        scanner.close();
    }
}
