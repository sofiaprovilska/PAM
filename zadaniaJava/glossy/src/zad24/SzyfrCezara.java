package zad24;

public class SzyfrCezara extends DekoratorTekstu {

    private int przesuniecie;

    public SzyfrCezara(int przesuniecie, ZrodloTekstu tekst) {
        super(tekst);
        this.przesuniecie = przesuniecie;
    }

    public String pobierz() {

        String wynik = "";
        String napis = tekst.pobierz();

        for (int i = 0; i < napis.length(); i++) {

            char znak = napis.charAt(i);

            if (znak >= 'a' && znak <= 'z') {
                znak = (char) ('a' + (znak - 'a' + przesuniecie) % 26);
            } else if (znak >= 'A' && znak <= 'Z') {
                znak = (char) ('A' + (znak - 'A' + przesuniecie) % 26);
            }

            wynik += znak;
        }

        return wynik;
    }
}