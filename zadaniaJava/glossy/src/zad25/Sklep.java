package zad25;

public class Sklep {

    private Platnosc platnosc;

    public Sklep(Platnosc platnosc) {
        this.platnosc = platnosc;
    }

    public void zamow(String produkt, double cena) {

        System.out.println("Zamówienie: " + produkt);
        System.out.println("Cena: " + cena + " PLN");

        boolean wynik = platnosc.zaplac(cena);

        if (wynik) {
            System.out.println("Płatność zakończona sukcesem!");
        } else {
            System.out.println("Płatność nieudana!");
        }

        System.out.println("Status: " + platnosc.status());
    }
}
