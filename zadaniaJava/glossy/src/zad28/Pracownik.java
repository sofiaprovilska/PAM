package zad28;

public class Pracownik implements JednostkaOrganizacyjna {

    private String imie;
    private String stanowisko;
    private double pensja;

    public Pracownik(String imie, String stanowisko, double pensja) {
        this.imie = imie;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
    }

    public String nazwa() {
        return imie;
    }

    public double kosztPensji() {
        return pensja;
    }

    public int liczbaOsob() {
        return 1;
    }

    public void podwyzka(double procent) {
        pensja += pensja * procent / 100;
    }

    public void wypiszStrukture(int poziom) {

        for (int i = 0; i < poziom; i++) {
            System.out.print("  ");
        }

        System.out.printf("%s – %s – %.0f zł%n",
                imie, stanowisko, pensja);
    }

    public double getPensja() {
        return pensja;
    }
}