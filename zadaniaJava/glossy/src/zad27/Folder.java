package zad27;

import java.util.ArrayList;

public class Folder extends ElementSystemuPlikow {

    private ArrayList<ElementSystemuPlikow> zawartosc = new ArrayList<>();

    public Folder(String nazwa) {
        super(nazwa);
    }

    public void dodaj(ElementSystemuPlikow element) {
        zawartosc.add(element);
    }

    public void usun(ElementSystemuPlikow element) {
        zawartosc.remove(element);
    }

    public int rozmiar() {

        int suma = 0;

        for (ElementSystemuPlikow element : zawartosc) {
            suma += element.rozmiar();
        }

        return suma;
    }

    public void wypisz(int wciecie) {

        for (int i = 0; i < wciecie; i++) {
            System.out.print("  ");
        }

        System.out.println(nazwa + "/ (" + rozmiar() + " KB)");

        for (ElementSystemuPlikow element : zawartosc) {
            element.wypisz(wciecie + 1);
        }
    }

    public ElementSystemuPlikow znajdz(String szukanaNazwa) {

        if (nazwa.equals(szukanaNazwa)) {
            return this;
        }

        for (ElementSystemuPlikow element : zawartosc) {

            if (element.getNazwa().equals(szukanaNazwa)) {
                return element;
            }

            if (element instanceof Folder) {

                ElementSystemuPlikow wynik =
                        ((Folder) element).znajdz(szukanaNazwa);

                if (wynik != null) {
                    return wynik;
                }
            }
        }

        return null;
    }

    public int policzPliki() {

        int liczba = 0;

        for (ElementSystemuPlikow element : zawartosc) {

            if (element instanceof Plik) {
                liczba++;
            }

            if (element instanceof Folder) {
                liczba += ((Folder) element).policzPliki();
            }
        }

        return liczba;
    }

    public ArrayList<Plik> znajdzWiekszeNiz(int kb) {

        ArrayList<Plik> wynik = new ArrayList<>();

        for (ElementSystemuPlikow element : zawartosc) {

            if (element instanceof Plik) {

                Plik plik = (Plik) element;

                if (plik.rozmiar() > kb) {
                    wynik.add(plik);
                }
            }

            if (element instanceof Folder) {
                wynik.addAll(((Folder) element).znajdzWiekszeNiz(kb));
            }
        }

        return wynik;
    }
}