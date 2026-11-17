package zad29;

import java.util.ArrayList;

public class WyswietlaczStatystyk implements Obserwator {
    private ArrayList<Double> temperatury = new ArrayList<>();

    public void aktualizuj(Pomiar p) {
        temperatury.add(p.getTemperatura());

        double min = temperatury.get(0);
        double max = temperatury.get(0);
        double suma = 0;

        for (double t : temperatury) {
            if (t < min) {
                min = t;
            }
            if (t > max) {
                max = t;
            }
            suma += t;
        }

        double srednia = suma / temperatury.size();

        System.out.println("\nStatystyki temperatury:");
        System.out.println("Minimum: " + min + "°C");
        System.out.println("Maksimum: " + max + "°C");
        System.out.println("Średnia: " + srednia + "°C");
    }
}