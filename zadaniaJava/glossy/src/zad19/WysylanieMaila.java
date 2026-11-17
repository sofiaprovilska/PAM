package zad19;

public class WysylanieMaila implements Runnable {

    String adres;

    public WysylanieMaila(String adres) {
        this.adres = adres;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }

        System.out.println("Wyslano maila do: " + adres);
    }
}