package zad23;

public class Main {

    public static void main(String[] args) {

        Napoj n = new BitaSmietana(
                new Syrop("karmel",
                        new Mleko(
                                new Espresso()
                        )
                )
        );

        System.out.println(n.opis() + " = " + n.cena() + " zł");

        System.out.println("\nMENU");

        Napoj kawa1 = new Espresso();

        Napoj kawa2 = new Mleko(
                new Americano()
        );

        Napoj kawa3 = new Syrop("wanili",
                new Mleko(
                        new Espresso()
                )
        );

        Napoj kawa4 = new BitaSmietana(
                new Syrop("czekolad",
                        new Americano()
                )
        );

        Napoj kawa5 = new Mleko(
                new Mleko(
                        new Espresso()
                )
        );

        Napoj kawa6 = new PodwojneEspresso(
                new Espresso()
        );

        System.out.println(kawa1.opis() + " = " + kawa1.cena() + " zł");
        System.out.println(kawa2.opis() + " = " + kawa2.cena() + " zł");
        System.out.println(kawa3.opis() + " = " + kawa3.cena() + " zł");
        System.out.println(kawa4.opis() + " = " + kawa4.cena() + " zł");
        System.out.println(kawa5.opis() + " = " + kawa5.cena() + " zł");
        System.out.println(kawa6.opis() + " = " + kawa6.cena() + " zł");
    }
}
//liczba kombinacji wynosi:
//3 * 2^4 = 3 * 16 = 48
//Czyli 48 klas.