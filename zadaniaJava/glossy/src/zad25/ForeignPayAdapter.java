package zad25;

public class ForeignPayAdapter implements Platnosc {

    private ForeignPayGateway gateway;
    private String status;

    public ForeignPayAdapter(ForeignPayGateway gateway) {
        this.gateway = gateway;
    }

    public boolean zaplac(double kwotaPLN) {

        double kwotaEUR = kwotaPLN / 4.30;

        boolean wynik = gateway.pay(kwotaEUR);

        if (wynik) {
            status = "OK";
            return true;
        } else {
            status = "Odrzucono";
            return false;
        }
    }

    public String status() {
        return status;
    }
}