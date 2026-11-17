package zad30;

import java.util.ArrayList;

public class Kanal implements Subskrybent {
    private String nazwa;
    private ArrayList<Subskrybent> subskrybenci = new ArrayList<>();
    private ArrayList<Film> filmy = new ArrayList<>();

    public Kanal(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void subskrybuj(Subskrybent s) {
        if (!subskrybenci.contains(s)) {
            subskrybenci.add(s);
        }
    }

    public void anulujSubskrypcje(Subskrybent s) {
        subskrybenci.remove(s);
    }

    public void opublikuj(Film f) {
        filmy.add(f);

        System.out.println("\nKanał " + nazwa + " opublikował: " + f.getTytul());

        ArrayList<Subskrybent> kopia = new ArrayList<>(subskrybenci);

        for (Subskrybent s : kopia) {
            s.powiadomienie(this, f);
        }
    }

    public void powiadomienie(Kanal k, Film f) {
        if (f.getKategoria().equals("programowanie")
                && !filmy.contains(f)) {
            opublikuj(f);
        }
    }
}