package zad29;

public class WyswietlaczBiezacy implements Obserwator {
    public void aktualizuj(Pomiar p) {
        System.out.println("\nAktualna pogoda:");
        p.wypisz();
    }
}