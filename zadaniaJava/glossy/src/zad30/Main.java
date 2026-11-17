package zad30;

public class Main {
    public static void main(String[] args) {

        Kanal java = new Kanal("JavaPL");
        Kanal najlepsze = new Kanal("Najlepsze z Javy");

        Widz ania = new Widz("Ania");
        Widz bob = new Widz("Bob");

        WidzZFiltrem kasia = new WidzZFiltrem("Kasia", "programowanie");

        Statystyki statystyki = new Statystyki();

        java.subskrybuj(ania);
        java.subskrybuj(bob);
        java.subskrybuj(kasia);
        java.subskrybuj(statystyki);

        java.subskrybuj(ania);

        java.subskrybuj(najlepsze);

        java.opublikuj(new Film("Wątki w Javie", "programowanie"));
        java.opublikuj(new Film("Nowy komputer", "technologia"));
        java.opublikuj(new Film("Kolekcje w Javie", "programowanie"));

        java.anulujSubskrypcje(bob);

        java.opublikuj(new Film("Bazy danych", "programowanie"));
    }
}