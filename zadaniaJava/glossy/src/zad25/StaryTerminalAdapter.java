package zad25;

public class StaryTerminalAdapter implements Platnosc {

    private StaryTerminal terminal;
    private String status;

    public StaryTerminalAdapter(StaryTerminal terminal) {
        this.terminal = terminal;
    }

    public boolean zaplac(double kwotaPLN) {

        long grosze = Math.round(kwotaPLN * 100);

        int wynik = terminal.wykonajTransakcje(grosze, "PLN");

        if (wynik == 0) {
            status = "OK";
            return true;
        } else if (wynik == 1) {
            status = "Odrzucono";
        } else {
            status = "Błąd połączenia";
        }

        return false;
    }

    public String status() {
        return status;
    }
}