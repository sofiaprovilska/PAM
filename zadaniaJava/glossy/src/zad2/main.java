package zad2;

public class main {
    public static void main(String[] args) throws InterruptedException {
        final int N = 10;
        final int POWTORZENIA = 100_000;
        final int OCZEKIWANY_WYNIK = N * POWTORZENIA;

        Licznik licznik = new Licznik();

        Thread[] watki = new Thread[N];

        for (int i = 0; i < N; i++) {
            watki[i] = new Thread(() -> {
                for (int j = 0; j < POWTORZENIA; j++) {
                    licznik.zwieksz();
                }
            });
        }
        long startLicznik = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            watki[i].start();
        }

        for (int i = 0; i < N; i++) {
            watki[i].join();
        }

        long koniecLicznik = System.currentTimeMillis();
        long czas = koniecLicznik - startLicznik;
        int wynikKoncowy = licznik.getWynik();
        System.out.println("Wynik końcowy licznika: " + wynikKoncowy);
        System.out.println("Oczekiwany wynik:       " + OCZEKIWANY_WYNIK);
        System.out.println(czas);


        if (wynikKoncowy == OCZEKIWANY_WYNIK) {
            System.out.println("Wyniki są zgodne.");
        } else {
            System.out.println("nie.");
        }


//        Wersja          | Wynik     | Oczekiwany | Czas [ms]
//        bez synchr.     | 130398    | 1000000    | 5
//        synchr.     | 1000000    | 1000000    | 23
//        this z blokiem syncs     | 1000000    | 1000000    | 29
    }
}
