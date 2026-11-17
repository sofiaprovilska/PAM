package zad30;

public class WidzZFiltrem implements Subskrybent {
    private String imie;
    private String kategoria;

    public WidzZFiltrem(String imie, String kategoria) {
        this.imie = imie;
        this.kategoria = kategoria;
    }

    public void powiadomienie(Kanal k, Film f) {
        if (f.getKategoria().equals(kategoria)) {
            System.out.println(imie + ": nowy film z kategorii "
                    + kategoria + " na kanale " + k.getNazwa()
                    + ": " + f.getTytul());
        }
    }
}
