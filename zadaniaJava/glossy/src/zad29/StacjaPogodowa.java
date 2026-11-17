package zad29;

import java.util.ArrayList;

public class StacjaPogodowa implements Obserwowany {
    private Pomiar pomiar;
    private ArrayList<Obserwator> obserwatorzy = new ArrayList<>();

    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    public void usunObserwatora(Obserwator o) {
        obserwatorzy.remove(o);
    }

    public void powiadom() {
        for (Obserwator o : obserwatorzy) {
            o.aktualizuj(pomiar);
        }
    }

    public void nowyPomiar(double temperatura, double wilgotnosc, double cisnienie) {
        pomiar = new Pomiar(temperatura, wilgotnosc, cisnienie);
        System.out.println("\nNowy pomiar");
        powiadom();
    }
}