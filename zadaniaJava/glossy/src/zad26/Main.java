package zad26;

public class Main {

    public static void main(String[] args) {

        StacjaMeteo stacja = new StacjaMeteo();

        stacja.dodajCzujnik(
                new AmericanSensorAdapter(
                        new AmericanSensor(), "ogród (US)"
                )
        );

        stacja.dodajCzujnik(
                new KelvinProbeAdapter(
                        new KelvinProbe(), "piwnica (K)"
                )
        );

        stacja.dodajCzujnik(
                new RawAnalogSensorAdapter(
                        new RawAnalogSensor(), "dach (RAW)"
                )
        );

        stacja.pokazOdczyty();
    }
}
//Adapter obiektowy (kompozycja) - adapter przechowuje obiekt innej klasy i korzysta z jego metod.
//
//Adapter klasowy (dziedziczenie) - adapter dziedziczy po klasie, którą chce dostosować.