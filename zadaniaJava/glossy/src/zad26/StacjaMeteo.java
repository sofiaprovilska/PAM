package zad26;

import java.util.ArrayList;

public class StacjaMeteo {

    private ArrayList<CzujnikTemperatury> czujniki = new ArrayList<>();

    public void dodajCzujnik(CzujnikTemperatury czujnik) {
        czujniki.add(czujnik);
    }

    public void pokazOdczyty() {

        double suma = 0;

        for (CzujnikTemperatury czujnik : czujniki) {

            double temperatura = czujnik.odczytCelsjusz();

            System.out.printf(
                    "Czujnik %s: %.1f °C%n",
                    czujnik.nazwa(),
                    temperatura
            );

            suma += temperatura;
        }

        if (czujniki.size() > 0) {
            double srednia = suma / czujniki.size();

            System.out.printf("Średnia: %.1f °C%n", srednia);
        }
    }
}
