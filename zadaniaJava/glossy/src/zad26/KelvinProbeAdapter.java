package zad26;

public class KelvinProbeAdapter implements CzujnikTemperatury {

    private KelvinProbe sensor;
    private String nazwa;

    public KelvinProbeAdapter(KelvinProbe sensor, String nazwa) {
        this.sensor = sensor;
        this.nazwa = nazwa;
    }

    public double odczytCelsjusz() {
        return sensor.readKelvin() - 273.15;
    }

    public String nazwa() {
        return nazwa;
    }
}