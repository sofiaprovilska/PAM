package zad15;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class main {
    private static final ArrayList<Zadanie> listaZadan = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("todo list");
        dodajZadanie("Oddać projekt", 1);
        dodajZadanie("Kupić kabel USB-C", 2);
        dodajZadanie("Posprzątać biurko", 3);
        dodajZadanie("Zrobić zakupy", 2);

        wypiszZadania();

        System.out.println("\noznaczone jako zrobione");
        oznaczJakoZrobione("Kupić kabel USB-C");
        wypiszZadania();

        System.out.println("\n posortowany po priorytetcie");
        wypiszPosortowane();

        System.out.println("\nstatystyki prioritetow");
        pokazStatystykiPriorytetow();

        System.out.println("\nusuniecie zadan");
        usunZrobione();
        wypiszZadania();
    }

    public static void dodajZadanie(String tytul, int priorytet) {
        listaZadan.add(new Zadanie(tytul, priorytet));
        System.out.println("Dodano: " + tytul);
    }

    public static void oznaczJakoZrobione(String tytul) {
        for (Zadanie z : listaZadan) {
            if (z.getTytul().equalsIgnoreCase(tytul)) {
                z.oznaczJakoZrobione();
                System.out.println("Zadanie '" + tytul + "' zostało wykonane!");
                return;
            }
        }
        System.out.println("Nie znaleziono zadania o tytule: " + tytul);
    }

    public static void usunZrobione() {
        listaZadan.removeIf(Zadanie::isZrobione);
        System.out.println("Usunięto wszystkie ukończone zadania.");
    }

    public static void wypiszZadania() {
        System.out.println("\nAktualna lista TODO:");
        for (Zadanie z : listaZadan) {
            System.out.println(z);
        }
    }

    public static void wypiszPosortowane() {
        ArrayList<Zadanie> kopiaDoSortowania = new ArrayList<>(listaZadan);

        kopiaDoSortowania.sort(Comparator.comparingInt(Zadanie::getPriorytet));

        for (Zadanie z : kopiaDoSortowania) {
            System.out.println(z);
        }
    }

    public static void pokazStatystykiPriorytetow() {
        HashMap<Integer, Integer> statystyki = new HashMap<>();

        for (Zadanie z : listaZadan) {
            int priorytet = z.getPriorytet();
            statystyki.put(priorytet, statystyki.getOrDefault(priorytet, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> wpis : statystyki.entrySet()) {
            System.out.println("Priorytet (" + wpis.getKey() + ") -> " + wpis.getValue() + " zad.");
        }
    }
}