package zad27;

public class Main {

    public static void main(String[] args) {

        Folder dokumenty = new Folder("Dokumenty");

        Folder szkola = new Folder("szkola");
        Folder zdjecia = new Folder("zdjecia");

        Plik plan = new Plik("plan.pdf", 120);
        Plik zadania = new Plik("zadania.docx", 700);
        Plik wakacje = new Plik("wakacje.jpg", 700);

        szkola.dodaj(plan);
        szkola.dodaj(zadania);

        zdjecia.dodaj(wakacje);

        dokumenty.dodaj(szkola);
        dokumenty.dodaj(zdjecia);

        System.out.println("STRUKTURA PLIKÓW");
        dokumenty.wypisz(0);

        System.out.println("\nLiczba plików: " + dokumenty.policzPliki());

        System.out.println("\nWYSZUKIWANIE");

        ElementSystemuPlikow znaleziony = dokumenty.znajdz("plan.pdf");

        if (znaleziony != null) {
            System.out.println("Znaleziono: " + znaleziony.getNazwa());
        } else {
            System.out.println("Nie znaleziono pliku.");
        }

        System.out.println("\nPLIKI WIĘKSZE NIŻ 500 KB");

        for (Plik plik : dokumenty.znajdzWiekszeNiz(500)) {
            System.out.println(plik.getNazwa() + " - " + plik.rozmiar() + " KB");
        }
    }
}