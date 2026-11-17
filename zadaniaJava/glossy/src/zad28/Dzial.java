package zad28;

import java.util.ArrayList;

public class Dzial implements JednostkaOrganizacyjna {

    private String nazwa;
    private Pracownik kierownik;

    private ArrayList<JednostkaOrganizacyjna> podjednostki =
            new ArrayList<>();

    public Dzial(String nazwa, Pracownik kierownik) {
        this.nazwa = nazwa;
        this.kierownik = kierownik;
    }

    public void dodaj(JednostkaOrganizacyjna jednostka) {
        podjednostki.add(jednostka);
    }

    public String nazwa() {
        return nazwa;
    }

    public double kosztPensji() {

        double suma = kierownik.kosztPensji();

        for (JednostkaOrganizacyjna jednostka : podjednostki) {
            suma += jednostka.kosztPensji();
        }

        return suma;
    }

    public int liczbaOsob() {

        int liczba = kierownik.liczbaOsob();

        for (JednostkaOrganizacyjna jednostka : podjednostki) {
            liczba += jednostka.liczbaOsob();
        }

        return liczba;
    }

    public void podwyzka(double procent) {

        kierownik.podwyzka(procent);

        for (JednostkaOrganizacyjna jednostka : podjednostki) {
            jednostka.podwyzka(procent);
        }
    }

    public void wypiszStrukture(int poziom) {

        for (int i = 0; i < poziom; i++) {
            System.out.print("  ");
        }

        System.out.printf("%s (%d osób, %.0f zł)%n",
                nazwa, liczbaOsob(), kosztPensji());

        kierownik.wypiszStrukture(poziom + 1);

        for (JednostkaOrganizacyjna jednostka : podjednostki) {
            jednostka.wypiszStrukture(poziom + 1);
        }
    }

    public Pracownik najlepiejOplacany() {

        Pracownik najlepszy = kierownik;

        for (JednostkaOrganizacyjna jednostka : podjednostki) {

            if (jednostka instanceof Pracownik) {

                Pracownik pracownik = (Pracownik) jednostka;

                if (pracownik.getPensja() > najlepszy.getPensja()) {
                    najlepszy = pracownik;
                }
            }

            if (jednostka instanceof Dzial) {

                Pracownik pracownik =
                        ((Dzial) jednostka).najlepiejOplacany();

                if (pracownik.getPensja() > najlepszy.getPensja()) {
                    najlepszy = pracownik;
                }
            }
        }

        return najlepszy;
    }
}