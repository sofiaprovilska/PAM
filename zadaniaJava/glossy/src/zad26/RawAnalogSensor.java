package zad26;

public class RawAnalogSensor {

    public int readRaw() {
        return 300 + (int) (Math.random() * 200);
    }
}