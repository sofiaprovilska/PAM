package zad24;

public class Odwroc extends DekoratorTekstu {

    public Odwroc(ZrodloTekstu tekst) {
        super(tekst);
    }

    public String pobierz() {

        String napis = tekst.pobierz();
        String wynik = "";

        for (int i = napis.length() - 1; i >= 0; i--) {
            wynik += napis.charAt(i);
        }

        return wynik;
    }
}