package zad24;

public class ZwyklyTekst implements ZrodloTekstu {

    private String tekst;

    public ZwyklyTekst(String tekst) {
        this.tekst = tekst;
    }

    public String pobierz() {
        return tekst;
    }
}