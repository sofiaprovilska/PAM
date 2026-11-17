package zad29;

public class AlarmMrozu implements Obserwator {
    public void aktualizuj(Pomiar p) {
        if (p.getTemperatura() < 0) {
            System.out.println("ALARM! Temperatura poniżej zera!");
        }
    }
}