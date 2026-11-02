package zad14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> slownik = new HashMap<>();

        slownik.put("pies", "dog");
        slownik.put("kot", "cat");
        slownik.put("drzewo", "tree");
        slownik.put("książka", "book");
        slownik.put("okno", "window");
        slownik.put("samochód", "car");
        slownik.put("jabłko", "apple");
        slownik.put("woda", "water");
        slownik.put("dom", "house");
        slownik.put("szkoła", "school");
        slownik.put("chleb", "bread");
        slownik.put("komputer", "computer");
        slownik.put("ptak", "bird");
        slownik.put("kwiat", "flower");
        slownik.put("słońce", "sun");

        ArrayList<String> slowaDoRundy = new ArrayList<>(slownik.keySet());

        ArrayList<String> doPowtorki = new ArrayList<>();

        int wszystkiePytania = 0;
        int poprawneOdpowiedzi = 0;
        int numerRundy = 1;


        while (!slowaDoRundy.isEmpty()) {
            System.out.println("runda " + numerRundy + " (Słów do sprawdzenia: " + slowaDoRundy.size() + ")");

            Collections.shuffle(slowaDoRundy);

            for (String pl : slowaDoRundy) {
                System.out.print("przetlumacz: '" + pl + "'? ");
                String odpowiedz = scanner.nextLine().trim().toLowerCase();
                String poprawneTlumaczenie = slownik.get(pl).toLowerCase();

                wszystkiePytania++;

                if (odpowiedz.equals(poprawneTlumaczenie)) {
                    System.out.println("dobrze");
                    poprawneOdpowiedzi++;
                } else {
                    System.out.println("Błąd! poprawna odpowiedź to: " + odpowiedz + " -> " + poprawneTlumaczenie);
                    doPowtorki.add(pl);
                }
            }

            if (!doPowtorki.isEmpty()) {
                System.out.println("\nKoniec rundy " + numerRundy + "słowa do powtórki");
                slowaDoRundy = new ArrayList<>(doPowtorki);
                doPowtorki.clear();
                numerRundy++;
                scanner.nextLine();
                System.out.println();
            } else {
                System.out.println("\nwszystkie słowa zaliczone");
                slowaDoRundy.clear();
            }
        }

        System.out.println("\ntwoja statystyka");
        double procentPoprawnych = ((double) poprawneOdpowiedzi / wszystkiePytania) * 100;

        System.out.println("Łączna liczba prób: " + wszystkiePytania);
        System.out.println("Dobre odpowiedzi: " + poprawneOdpowiedzi);
        System.out.println("Złe odpowiedzi: " + (wszystkiePytania - poprawneOdpowiedzi));
        System.out.printf("Skuteczność: %.2f%%\n", procentPoprawnych);

        scanner.close();
    }
}

