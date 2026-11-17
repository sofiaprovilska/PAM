package zad28;

public class Main {

    public static void main(String[] args) {

        Pracownik kierownikIT =
                new Pracownik("Anna Nowak", "Kierownik IT", 15000);

        Dzial it = new Dzial("IT", kierownikIT);

        Dzial backend = new Dzial(
                "Backend",
                new Pracownik("Jan Kowalski", "Senior Dev", 12000)
        );

        backend.dodaj(new Pracownik("Adam Nowak", "Programista", 9000));
        backend.dodaj(new Pracownik("Piotr Lis", "Junior Dev", 8000));

        Dzial frontend = new Dzial(
                "Frontend",
                new Pracownik("Maria Kot", "Team Leader", 11000)
        );

        frontend.dodaj(new Pracownik("Ola Wiśniewska", "Frontend Dev", 9000));
        frontend.dodaj(new Pracownik("Tomek Nowak", "Junior Dev", 7000));

        it.dodaj(backend);
        it.dodaj(frontend);

        Dzial sprzedaz = new Dzial(
                "Sprzedaż",
                new Pracownik("Kasia Lis", "Kierownik sprzedaży", 10000)
        );

        sprzedaz.dodaj(new Pracownik("Marek Nowak", "Handlowiec", 7000));

        Dzial hr = new Dzial(
                "HR",
                new Pracownik("Ewa Kowalska", "Kierownik HR", 9000)
        );

        hr.dodaj(new Pracownik("Ala Nowak", "Rekruter", 7000));

        Dzial firma = new Dzial(
                "Firma XYZ",
                new Pracownik("Jan Nowak", "Prezes", 18000)
        );

        firma.dodaj(it);
        firma.dodaj(sprzedaz);
        firma.dodaj(hr);

        System.out.println("--- STRUKTURA FIRMY ---");
        firma.wypiszStrukture(0);

        System.out.println("\nKoszt pensji IT: "
                + it.kosztPensji() + " zł");

        System.out.println("Koszt pensji całej firmy: "
                + firma.kosztPensji() + " zł");

        System.out.println("\nLiczba osób w firmie: "
                + firma.liczbaOsob());

        Pracownik najlepszy = firma.najlepiejOplacany();

        System.out.println("\nNajlepiej opłacany pracownik:");
        System.out.println(najlepszy.nazwa() + " – "
                + najlepszy.getPensja() + " zł");

        System.out.println("\n--- PODWYŻKA 10% W DZIALE IT ---");

        it.podwyzka(10);

        it.wypiszStrukture(0);
    }
}