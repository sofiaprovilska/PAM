package zad24;

public abstract class DekoratorTekstu implements ZrodloTekstu {

    protected ZrodloTekstu tekst;

    public DekoratorTekstu(ZrodloTekstu tekst) {
        this.tekst = tekst;
    }
}
