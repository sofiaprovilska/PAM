package zad30;

public class Film {
    private String tytul;
    private String kategoria;

    public Film(String tytul, String kategoria) {
        this.tytul = tytul;
        this.kategoria = kategoria;
    }

    public String getTytul() {
        return tytul;
    }

    public String getKategoria() {
        return kategoria;
    }
}