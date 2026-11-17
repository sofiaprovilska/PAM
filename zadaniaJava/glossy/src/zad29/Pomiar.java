package zad29;

public class Pomiar {
    private double temperatura;
    private double wilgotnosc;
    private double cisnienie;

    public Pomiar(double temperatura, double wilgotnosc, double cisnienie) {
        this.temperatura = temperatura;
        this.wilgotnosc = wilgotnosc;
        this.cisnienie = cisnienie;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getWilgotnosc() {
        return wilgotnosc;
    }

    public double getCisnienie() {
        return cisnienie;
    }

    public void wypisz() {
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Wilgotność: " + wilgotnosc + "%");
        System.out.println("Ciśnienie: " + cisnienie + " hPa");
    }
}