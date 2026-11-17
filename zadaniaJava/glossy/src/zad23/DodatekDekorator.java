package zad23;

public abstract class DodatekDekorator implements Napoj {

    protected Napoj napoj;

    public DodatekDekorator(Napoj napoj) {
        this.napoj = napoj;
    }
}