package zad5;

public class main {
    public static void main(String[] args) {

        System.out.println("START: JEDNA DRUKARKA");
        Drukarka drukarkaGlowna = new Drukarka("Drukarka_A");

        Uzytkownik u1 = new Uzytkownik("Uzytkownik1", drukarkaGlowna, "Raport.pdf", 4);
        Uzytkownik u2 = new Uzytkownik("Uzytkownik2", drukarkaGlowna, "Zdjecie.png", 4);
        Uzytkownik u3 = new Uzytkownik("Uzytkownik3", drukarkaGlowna, "Dyplom.docx", 4);

        u1.start();
        u2.start();
        u3.start();

        try {
            u1.join(); u2.join(); u3.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\nSTART: DWIE OSOBNE DRUKARKI");
        Drukarka drukarkaPieterko1 = new Drukarka("Drukarka_X");
        Drukarka drukarkaPieterko2 = new Drukarka("Drukarka_Y");

        Uzytkownik u4 = new Uzytkownik("Uzytkownik1", drukarkaPieterko1, "Umowa.pdf", 3);
        Uzytkownik u5 = new Uzytkownik("Uzytkownik2", drukarkaPieterko1, "Faktura.pdf", 3);

        Uzytkownik u6 = new Uzytkownik("Uzytkownik3", drukarkaPieterko2, "Plakat.png", 3);

        u4.start();
        u5.start();
        u6.start();
    }
}
