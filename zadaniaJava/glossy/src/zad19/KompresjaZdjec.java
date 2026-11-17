package zad19;

public class KompresjaZdjec implements Runnable {

    int liczbaZdjec;

    public KompresjaZdjec(int liczbaZdjec) {
        this.liczbaZdjec = liczbaZdjec;
    }

    @Override
    public void run() {

        for (int i = 1; i <= liczbaZdjec; i++) {

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                return;
            }

            System.out.println("Skompresowano zdjecie " + i);
        }
    }
}