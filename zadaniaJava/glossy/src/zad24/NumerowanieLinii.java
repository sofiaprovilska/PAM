package zad24;

public class NumerowanieLinii extends DekoratorTekstu {

    public NumerowanieLinii(ZrodloTekstu tekst) {
        super(tekst);
    }

    public String pobierz() {

        String napis = tekst.pobierz();
        String[] linie = napis.split("\n", -1);

        String wynik = "";

        for (int i = 0; i < linie.length; i++) {
            wynik += (i + 1) + ": " + linie[i];

            if (i < linie.length - 1) {
                wynik += "\n";
            }
        }

        return wynik;
    }
}