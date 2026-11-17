package zad17;

import java.util.ArrayList;

public class Klient implements Runnable {

    String imie;
    ArrayList<Integer> miejsca;
    Sala sala;
    ArrayList<String> rezygnacje;

    public Klient(String imie, ArrayList<Integer> miejsca,
                  Sala sala, ArrayList<String> rezygnacje) {

        this.imie = imie;
        this.miejsca = miejsca;
        this.sala = sala;
        this.rezygnacje = rezygnacje;
    }

    @Override
    public void run() {

        boolean udaloSie = false;

        for (int i = 0; i < miejsca.size(); i++) {

            int miejsce = miejsca.get(i);

            if (sala.rezerwuj(miejsce, imie)) {
                udaloSie = true;
                break;
            }
        }

        if (!udaloSie) {
            rezygnacje.add(imie);
            System.out.println(imie + " rezygnuje z rezerwacji.");
        }
    }
}