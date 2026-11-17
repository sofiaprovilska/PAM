package zad29;

public class Prognoza implements Obserwator {
    private double poprzednieCisnienie = 0;

    public void aktualizuj(Pomiar p) {
        double cisnienie = p.getCisnienie();

        if (poprzednieCisnienie == 0) {
            System.out.println("Prognoza: brak danych");
        } else if (cisnienie > poprzednieCisnienie) {
            System.out.println("Prognoza: poprawa");
        } else if (cisnienie < poprzednieCisnienie) {
            System.out.println("Prognoza: pogorszenie");
        } else {
            System.out.println("Prognoza: bez zmian");
        }

        poprzednieCisnienie = cisnienie;
    }
}