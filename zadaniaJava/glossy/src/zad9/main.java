package zad9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> liczby = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            liczby.add(random.nextInt(100) + 1);
        }
        System.out.println("Wylosowane liczby (50 sztuk): " + liczby);

        ArrayList<Integer> parzyste = new ArrayList<>();
        ArrayList<Integer> nieparzyste = new ArrayList<>();
        for (int liczba : liczby) {
            if (liczba % 2 == 0) {
                parzyste.add(liczba);
            } else {
                nieparzyste.add(liczba);
            }
        }
        System.out.println("\nLiczby parzyste: " + parzyste);
        System.out.println("Liczby nieparzyste: " + nieparzyste);

        int suma = 0;
        for (int liczba : liczby) {
            suma += liczba;
        }
        double srednia = (double) suma / liczby.size();

        ArrayList<Integer> kopiaDoMediany = new ArrayList<>(liczby);
        Collections.sort(kopiaDoMediany);

        double mediana;
        int srodek = kopiaDoMediany.size() / 2;
        if (kopiaDoMediany.size() % 2 == 0) {
            mediana = (kopiaDoMediany.get(srodek - 1) + kopiaDoMediany.get(srodek)) / 2.0;
        } else {
            mediana = kopiaDoMediany.get(srodek);
        }

        System.out.printf("\nStatystyki:\n- Suma: %d\n- Średnia: %.2f\n- Mediana: %.1f\n", suma, srednia, mediana);

        ArrayList<Integer> wiekszeOdSredniej = new ArrayList<>();
        for (int liczba : liczby) {
            if (liczba > srednia) {
                wiekszeOdSredniej.add(liczba);
            }
        }
        System.out.println("\nLiczby większe od średniej: " + wiekszeOdSredniej);

        ArrayList<Integer> bezPowtorzen = new ArrayList<>(new LinkedHashSet<>(liczby));
        System.out.println("Liczby bez powtórzeń (unikalne): " + bezPowtorzen);

        System.out.println("\nporownanie z tablica int");

        int[] tablica = new int[liczby.size()];
        for (int i = 0; i < liczby.size(); i++) {
            tablica[i] = liczby.get(i);
        }
        System.out.println("Pomyślnie przepisano do tablicy int[]. Rozmiar: " + tablica.length);

        ArrayList<Integer> nowaLista = new ArrayList<>();
        for (int liczba : tablica) {
            nowaLista.add(liczba);
        }
        System.out.println("Pomyślnie przepisano z powrotem do ArrayList. Rozmiar: " + nowaLista.size());

        /*
          wygodniejsza w codziennej pracy jest lista ArrayList.
         *
         * 1. może rosnąć w nieskończoność
         * 2.ArrayList współpracuje z klasą Collections
         */
    }
}