package zad24;

public class Main {

    public static void main(String[] args) {

        ZrodloTekstu t = new NumerowanieLinii(
                new WielkieLitery(
                        new ZwyklyTekst("ala ma kota\nkot ma ale")
                )
        );

        System.out.println("--- Przyklad z zadania ---");
        System.out.println(t.pobierz());


        ZrodloTekstu t2 = new SzyfrCezara(3,
                new ZwyklyTekst("Ala ma kota")
        );

        System.out.println("\n--- Szyfr Cezara ---");
        System.out.println(t2.pobierz());


        ZrodloTekstu t3 = new UsunPolskieZnaki(
                new ZwyklyTekst("Zażółć gęślą jaźń")
        );

        System.out.println("\n--- Usuwanie polskich znakow ---");
        System.out.println(t3.pobierz());


        ZrodloTekstu t4 = new Odwroc(
                new ZwyklyTekst("Ala ma kota")
        );

        System.out.println("\n--- Odwracanie tekstu ---");
        System.out.println(t4.pobierz());


        ZrodloTekstu t5 = new NumerowanieLinii(
                new Odwroc(
                        new ZwyklyTekst("ala ma kota\nkot ma ale")
                )
        );

        ZrodloTekstu t6 = new Odwroc(
                new NumerowanieLinii(
                        new ZwyklyTekst("ala ma kota\nkot ma ale")
                )
        );

        System.out.println("\n--- Numerowanie, potem odwrocenie ---");
        System.out.println(t5.pobierz());

        System.out.println("\n--- Odwrocenie, potem numerowanie ---");
        System.out.println(t6.pobierz());
    }
}
//Czy kolejność dekoratorów ma znaczenie?
//tak. Dekoratory wykonują operacje w kolejności od wewnętrznego do zewnętrznego.
//- NumerowanieLinii(Odwroc(tekst)) najpierw odwraca tekst, potem numeruje linie.
//- Odwroc(NumerowanieLinii(tekst)) najpierw numeruje linie, potem odwraca cały tekst.
//Przykłady klas z pakietu java.io:
// BufferedReader - buforowanie odczytu tekstu.
// BufferedInputStream - buforowanie danych.
//DataInputStream - odczytywanie typów danych.