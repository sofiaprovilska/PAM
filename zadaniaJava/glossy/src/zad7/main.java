package zad7;

import java.util.ArrayList;
import java.util.Collections;

class DziennikUcznia {
    private final ArrayList<Integer> oceny = new ArrayList<>();

    public void dodajOcene(int ocena) {
        if (ocena >= 1 && ocena <= 6) {
            oceny.add(ocena);
            System.out.println("Dodano ocenę: " + ocena);
        } else {
            System.out.println("Błąd: Ocena " + ocena + " jest spoza zakresu 1-6!");
        }
    }

    public double srednia() {
        if (oceny.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return suma / oceny.size();
    }

    public int najwyzsza() {
        if (oceny.isEmpty()) {
            return 0;
        }
        return Collections.max(oceny);
    }

    public int najnizsza() {
        if (oceny.isEmpty()) {
            return 0;
        }
        return Collections.min(oceny);
    }

    public int ileRazy(int szukanaOcena) {
        int licznik = 0;
        for (int ocena : oceny) {
            if (ocena == szukanaOcena) {
                licznik++;
            }
        }
        return licznik;
    }

    public void usunNajnizsza() {
        if (oceny.isEmpty()) {
            System.out.println("Błąd: Lista ocen jest pusta.");
            return;
        }

        int doUsuniecia = najnizsza();

         /* 1) remove(int index) -> usuwa element na podanym indeksie.
         *    oceny.remove(1) usunie drugi element z listy
         *
         * 2) remove(Object o) -> szuka obiektu na liście i go usuwa.
         *    oceny.remove(Integer.valueOf(doUsuniecia)), usunie pierwsze wystąpienie wartosci
         */

        oceny.remove(Integer.valueOf(doUsuniecia));
        System.out.println("Usunięto jedną najniższą ocenę (" + doUsuniecia + ").");
    }

    public void wyswietlOceny() {
        System.out.println("Aktualne oceny: " + oceny);
    }
}

public class main {
    public static void main(String[] args){
        DziennikUcznia dziennik = new DziennikUcznia();

        dziennik.dodajOcene(5);
        dziennik.dodajOcene(2);
        dziennik.dodajOcene(6);
        dziennik.dodajOcene(2);
        dziennik.dodajOcene(4);
        dziennik.dodajOcene(7); // To powinno zostać odrzucone

        dziennik.wyswietlOceny();

        System.out.printf("Średnia ocen: %.2f\n", dziennik.srednia());
        System.out.println("Najwyższa ocena: " + dziennik.najwyzsza());
        System.out.println("Najniższa ocena: " + dziennik.najnizsza());
        System.out.println("Ile razy wystąpiła dwójka? " + dziennik.ileRazy(2));

        dziennik.usunNajnizsza();
        dziennik.wyswietlOceny();

        System.out.println("Nowa najniższa ocena: " + dziennik.najnizsza());
        System.out.println("Ile razy teraz występuje dwójka? " + dziennik.ileRazy(2));
    }
}
