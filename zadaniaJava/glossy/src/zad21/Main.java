package zad21;

public class Main {
    public static void main(String[] args) {
    Pizza p1 = new Pizza.Builder(Pizza.Rozmiar.DUZA)
            .ciasto(Pizza.Ciasto.CIENKIE)
            .sos("pomidorowy")
            .dodatek("pieczarki")
            .dodatek("kukurydza")
            .podwojnySer(true)
            .build();

        Pizza p2 = new Pizza.Builder(Pizza.Rozmiar.SREDNIA)
                .ciasto(Pizza.Ciasto.GRUBE)
                .sos("czosnkowy")
                .dodatek("szynka")
                .build();

        Pizza p3 = new Pizza.Builder(Pizza.Rozmiar.MALA)
                .ciasto(Pizza.Ciasto.CIENKIE)
                .sos("pomidorowy")
                .dodatek("oliwki")
                .build();

        System.out.println("PARAGON");

        System.out.println("Pizza 1: " + p1.getRozmiar());
        System.out.println("Sos: " + p1.getSos());
        System.out.println("Dodatki: " + p1.getDodatki());
        System.out.println("Cena: " + p1.cena() + " zł");

        System.out.println("Pizza 2: " + p2.getRozmiar());
        System.out.println("Sos: " + p2.getSos());
        System.out.println("Dodatki: " + p2.getDodatki());
        System.out.println("Cena: " + p2.cena() + " zł");

        System.out.println("Pizza 3: " + p3.getRozmiar());
        System.out.println("Sos: " + p3.getSos());
        System.out.println("Dodatki: " + p3.getDodatki());
        System.out.println("Cena: " + p3.cena() + " zł");
    }
}
