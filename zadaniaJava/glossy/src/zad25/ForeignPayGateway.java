package zad25;

public class ForeignPayGateway {

    public boolean pay(double amountEUR) {
        if (amountEUR > 1000) return false;

        System.out.println("Gateway: paid " + amountEUR + " EUR");
        return true;
    }
}