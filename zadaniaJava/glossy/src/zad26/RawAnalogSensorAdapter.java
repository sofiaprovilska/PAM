package zad26;

public class RawAnalogSensorAdapter implements CzujnikTemperatury {

    private RawAnalogSensor sensor;
    private String nazwa;

    public RawAnalogSensorAdapter(RawAnalogSensor sensor, String nazwa) {
        this.sensor = sensor;
        this.nazwa = nazwa;
    }

    public double odczytCelsjusz() {

        int raw = sensor.readRaw();

        return -40 + (raw * 125.0 / 1023);
    }

    public String nazwa() {
        return nazwa;
    }
}