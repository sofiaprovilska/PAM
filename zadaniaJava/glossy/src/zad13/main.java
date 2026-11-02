package zad13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    private static final HashMap<String, Integer> stanMagazynowy = new HashMap<>();
    private static final HashMap<String, Double> cennik = new HashMap<>();

    public static void main(String[] args) {
        cennik.put("Chleb", 4.50);
        cennik.put("Mleko", 3.20);
        cennik.put("Masło", 7.00);
        cennik.put("Cukier", 5.00);

        System.out.println("dostawa");
        przyjmijDostawe("Chleb", 10);
        przyjmijDostawe("Mleko", 3);
        przyjmijDostawe("Masło", 6);
        przyjmijDostawe("Cukier", 2);

        System.out.println("\nsprzedaz");
        sprzedaj("Chleb", 3);
        sprzedaj("Masło", 10);

        System.out.println("\nkontrola");
        ArrayList<String> maloSztuk = produktyZMalymStanem();
        System.out.println("Produkty z małym stanem: " + maloSztuk);

        sprzedaj("Cukier", 2);
        usunPusteProdukty();

        policzWartoscMagazynu();
    }

    public static void przyjmijDostawe(String produkt, int ilosc) {
        if (ilosc <= 0) return;
        int obecnyStan = stanMagazynowy.getOrDefault(produkt, 0);
        stanMagazynowy.put(produkt, obecnyStan + ilosc);
        System.out.println("Przyjęto " + ilosc + " szt. produktu: " + produkt + " (Razem: " + stanMagazynowy.get(produkt) + ")");
    }

    public static void sprzedaj(String produkt, int ilosc) {
        if (!stanMagazynowy.containsKey(produkt)) {
            System.out.println("Błąd: Produkt '" + produkt + "' nie istnieje w magazynie");
            return;
        }

        int dostepnaIlosc = stanMagazynowy.get(produkt);
        if (ilosc > dostepnaIlosc) {
            System.out.println("Błąd: Nie można sprzedać " + ilosc + " szt. '" + produkt + "'. Na stanie jest tylko: " + dostepnaIlosc);
        } else {
            stanMagazynowy.put(produkt, dostepnaIlosc - ilosc);
            System.out.println("Sprzedano " + ilosc + " szt. produktu: " + produkt + " (Zostało: " + (dostepnaIlosc - ilosc) + ")");
        }
    }

    public static ArrayList<String> produktyZMalymStanem() {
        ArrayList<String> alertLista = new ArrayList<>();
        for (Map.Entry<String, Integer> wpis : stanMagazynowy.entrySet()) {
            if (wpis.getValue() < 5) {
                alertLista.add(wpis.getKey());
            }
        }
        return alertLista;
    }

    public static void usunPusteProdukty() {
        stanMagazynowy.entrySet().removeIf(wpis -> wpis.getValue() == 0);
        System.out.println("Usunięto,  magazyn: " + stanMagazynowy);
    }

    public static void policzWartoscMagazynu() {
        double calkowitaWartosc = 0.0;

        System.out.println("\nwycena");
        for (Map.Entry<String, Integer> wpis : stanMagazynowy.entrySet()) {
            String produkt = wpis.getKey();
            int ilosc = wpis.getValue();

            Double cena = cennik.get(produkt);

            if (cena != null) {
                double wartoscProduktu = ilosc * cena;
                System.out.printf("- %s: %d szt. x %.2f zł = %.2f zł\n", produkt, ilosc, cena, wartoscProduktu);
                calkowitaWartosc += wartoscProduktu;
            } else {
                System.out.println("- " + produkt + ": " + ilosc + " szt. (Brak ceny)");
            }
        }
        System.out.printf("ŁĄCZNA WARTOŚĆ TOWARU %.2f zł\n", calkowitaWartosc);
    }
}
