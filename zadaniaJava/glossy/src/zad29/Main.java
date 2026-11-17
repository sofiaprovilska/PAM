package zad29;

public class Main {
    public static void main(String[] args) {
        StacjaPogodowa stacja = new StacjaPogodowa();

        WyswietlaczBiezacy wyswietlacz = new WyswietlaczBiezacy();
        WyswietlaczStatystyk statystyki = new WyswietlaczStatystyk();
        AlarmMrozu alarm = new AlarmMrozu();
        Prognoza prognoza = new Prognoza();

        stacja.dodajObserwatora(wyswietlacz);
        stacja.dodajObserwatora(statystyki);
        stacja.dodajObserwatora(alarm);
        stacja.dodajObserwatora(prognoza);

        double[] temperatury = {5, 3, 0, -2, -4, 1, 4, 6, 5, 8};
        double[] wilgotnosci = {60, 65, 70, 75, 80, 68, 55, 50, 52, 45};
        double[] cisnienia = {1010, 1005, 1000, 995, 990, 1000, 1010, 1015, 1015, 1020};

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("\n Odłączamy wyświetlacz bieżący");
                stacja.usunObserwatora(wyswietlacz);
            }

            stacja.nowyPomiar(temperatury[i], wilgotnosci[i], cisnienia[i]);
        }
    }
}
