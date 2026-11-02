package zad15;

class Zadanie {
    private final String tytul;
    private final int priorytet;
    private boolean zrobione;

    public Zadanie(String tytul, int priorytet) {
        this.tytul = tytul;
        if (priorytet >= 1 && priorytet <= 3) {
            this.priorytet = priorytet;
        } else {
            this.priorytet = 3;
        }
        this.zrobione = false;
    }

    public String getTytul() { return tytul; }
    public int getPriorytet() { return priorytet; }
    public boolean isZrobione() { return zrobione; }

    public void oznaczJakoZrobione() {
        this.zrobione = true;
    }

    @Override
    public String toString() {
        String znacznik = zrobione ? "[x]" : "[ ]";
        return znacznik + " (" + priorytet + ") " + tytul;
    }
}
