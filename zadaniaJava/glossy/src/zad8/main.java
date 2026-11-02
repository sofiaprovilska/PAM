package zad8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ArrayList<String> imiona = new ArrayList<>(List.of(
                "Anna", "Jan", "Katarzyna", "Mateusz", "Anna",
                "Piotr", "Maja", "Krzysztof", "Jan", "Agnieszka",
                "Tomasz", "Magdalena", "Ewa", "Karol", "Weronika"
        ));

        System.out.println("Lista początkowa: " + imiona);

        ArrayList<String> posortowane = new ArrayList<>(imiona);
        Collections.sort(posortowane);
        System.out.println("\nAlfabetycznie: " + posortowane);

        Collections.reverse(posortowane);
        System.out.println("Odwrotnie alfabetycznie: " + posortowane);

        ArrayList<String> dlugieImiona = new ArrayList<>();
        for (String imie : imiona) {
            if (imie.length() > 5) {
                dlugieImiona.add(imie);
            }
        }
        System.out.println("\nImiona dłuższe niż 5 liter: " + dlugieImiona);

        char SzukanaLitera = 'M';
        ArrayList<String> naLitere = new ArrayList<>();
        for (String imie : imiona) {
            if (imie.toUpperCase().startsWith(String.valueOf(SzukanaLitera).toUpperCase())) {
                naLitere.add(imie);
            }
        }
        System.out.println("Imiona zaczynające się na '" + SzukanaLitera + "': " + naLitere);

        String najdluzsze = "";
        for (String imie : imiona) {
            if (imie.length() > najdluzsze.length()) {
                najdluzsze = imie;
            }
        }
        System.out.println("Najdłuższe imię z listy: " + najdluzsze);

        ArrayList<String> bezDuplikatów = new ArrayList<>(new LinkedHashSet<>(imiona));
        System.out.println("Lista bez duplikatów: " + bezDuplikatów);

        System.out.println("\nusuwanie imia zenskich");

        /*
         ponieważ pętla for-each używa specjalnego
         * obiektu (Iteratora) do chodzenia po liście.Kiedy modyfikujemy listę bezpośrednio za pomocą
         * imiona.remove(), licznik modyfikacji się zmienia. W kolejnym kroku pętli Iterator widzi,
         * że struktura listy zmieniła się i natychmiast
         * awaryjnie przerywa program błędem, aby zapobiec uszkodzeniu danych.
         */

        imiona.removeIf(imie -> imie.toLowerCase().endsWith("a"));

        System.out.println("Lista po usunięciu imion żeńskich: " + imiona);
    }
}