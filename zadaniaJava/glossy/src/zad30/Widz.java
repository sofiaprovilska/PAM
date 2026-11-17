package zad30;

public class Widz implements Subskrybent {
    private String imie;

    public Widz(String imie) {
        this.imie = imie;
    }

    public void powiadomienie(Kanal k, Film f) {
        System.out.println(imie + ": nowy film na kanale "
                + k.getNazwa() + ": " + f.getTytul());
    }
}