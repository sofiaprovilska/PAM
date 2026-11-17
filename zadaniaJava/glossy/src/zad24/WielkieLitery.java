package zad24;

public class WielkieLitery extends DekoratorTekstu {

    public WielkieLitery(ZrodloTekstu tekst) {
        super(tekst);
    }

    public String pobierz() {
        return tekst.pobierz().toUpperCase();
    }
}