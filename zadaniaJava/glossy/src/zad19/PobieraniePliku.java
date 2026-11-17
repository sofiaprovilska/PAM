package zad19;

public class PobieraniePliku implements Runnable {

    String nazwa;

    public PobieraniePliku(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void run() {

        for (int i = 25; i <= 100; i += 25) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }

            System.out.println(nazwa + ": " + i + "%");
        }

        System.out.println("Pobrano plik: " + nazwa);
    }
}