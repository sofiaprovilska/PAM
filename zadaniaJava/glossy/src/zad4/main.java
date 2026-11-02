package zad4;

public class main {
    public static void main(String[] args) {
        PulaBiletow pula = new PulaBiletow();

        Kasa k1 = new Kasa("Kasa 1", pula);
        Kasa k2 = new Kasa("Kasa 2", pula);
        Kasa k3 = new Kasa("Kasa 3", pula);
        Kasa k4 = new Kasa("Kasa 4", pula);

        k1.start();
        k2.start();
        k3.start();
        k4.start();

        try {
            k1.join();
            k2.join();
            k3.join();
            k4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int suma = k1.getSprzedanePrzezTęKasę() + k2.getSprzedanePrzezTęKasę() +
                k3.getSprzedanePrzezTęKasę() + k4.getSprzedanePrzezTęKasę();

        System.out.println("\nPodsumowanie:");
        System.out.print("Kasa 1: " + k1.getSprzedanePrzezTęKasę() + ", ");
        System.out.print("Kasa 2: " + k2.getSprzedanePrzezTęKasę() + ", ");
        System.out.print("Kasa 3: " + k3.getSprzedanePrzezTęKasę() + ", ");
        System.out.print("Kasa 4: " + k4.getSprzedanePrzezTęKasę() + ", ");
        System.out.println("RAZEM: " + suma);
    }
}
