package zad26;

public class AmericanSensorAdapter implements CzujnikTemperatury {

    private AmericanSensor sensor;
    private String nazwa;

    public AmericanSensorAdapter(AmericanSensor sensor, String nazwa) {
        this.sensor = sensor;
        this.nazwa = nazwa;
    }

    public double odczytCelsjusz() {
        return (sensor.getFahrenheit() - 32) * 5 / 9;
    }

    public String nazwa() {
        return nazwa;
    }
}