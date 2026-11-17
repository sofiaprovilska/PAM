package zad25;

public class Main {

    public static void main(String[] args) {

        Sklep sklep1 = new Sklep(
                new ForeignPayAdapter(new ForeignPayGateway())
        );

        sklep1.zamow("Słuchawki", 249.99);

        System.out.println("");

        Sklep sklep2 = new Sklep(
                new StaryTerminalAdapter(new StaryTerminal())
        );

        sklep2.zamow("Klawiatura", 150.00);
    }
}