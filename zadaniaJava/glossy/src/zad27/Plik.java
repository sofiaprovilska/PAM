package zad27;

public class Plik extends ElementSystemuPlikow {

    private int rozmiar;

    public Plik(String nazwa, int rozmiar) {
        super(nazwa);
        this.rozmiar = rozmiar;
    }

    public int rozmiar() {
        return rozmiar;
    }

    public void wypisz(int wciecie) {

        for (int i = 0; i < wciecie; i++) {
            System.out.print("  ");
        }

        System.out.println(nazwa + " (" + rozmiar + " KB)");
    }
}