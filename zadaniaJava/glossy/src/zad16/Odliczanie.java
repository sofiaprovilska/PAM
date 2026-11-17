package zad16;

public class Odliczanie implements Runnable {

    String nazwa;
    int odIlu;

    public Odliczanie(String nazwa, int odIlu) {
        this.nazwa = nazwa;
        this.odIlu = odIlu;
    }

    @Override
    public void run() {

        for (int i = odIlu; i >= 1; i--) {
            System.out.println(nazwa + ": " + i);
        }
    }
}