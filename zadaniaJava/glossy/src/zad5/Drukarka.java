package zad5;

public class Drukarka {
    private final String nazwaDrukarki;

    public Drukarka(String nazwaDrukarki) {
        this.nazwaDrukarki = nazwaDrukarki;
    }

    public void drukuj(String nazwaDokumentu, int liczbaLinii) {
        for (int i = 1; i <= liczbaLinii; i++) {
            System.out.println("[" + nazwaDrukarki + "] " + nazwaDokumentu + " - linia " + i + "/" + liczbaLinii);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
class Uzytkownik extends Thread {
    private final Drukarka drukarka;
    private final String nazwaDokumentu;
    private final int liczbaLinii;

    public Uzytkownik(String imieWatku, Drukarka drukarka, String nazwaDokumentu, int liczbaLinii) {
        super(imieWatku);
        this.drukarka = drukarka;
        this.nazwaDokumentu = nazwaDokumentu;
        this.liczbaLinii = liczbaLinii;
    }

    @Override
    public void run() {
        drukarka.drukuj(nazwaDokumentu, liczbaLinii);
    }
}