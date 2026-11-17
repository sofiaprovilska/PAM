package zad17;

import java.util.HashMap;

public class Sala {

    HashMap<Integer, String> rezerwacje = new HashMap<>();

//    public synchronized boolean rezerwuj(int miejsce, String klient) {
//
//        if (rezerwacje.containsKey(miejsce)) {
//            return false;
//        }
//
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            return false;
//        }
//
//        rezerwacje.put(miejsce, klient);
//
//        System.out.println(klient + " zarezerwował miejsce " + miejsce);
//
//        return true;
//    }
public boolean rezerwuj(int miejsce, String klient) {

    if (rezerwacje.containsKey(miejsce)) {
        return false;
    }

    try {
        Thread.sleep(50);
    } catch (InterruptedException e) {
        return false;
    }

    String poprzedni = rezerwacje.put(miejsce, klient);

    if (poprzedni != null) {
        System.out.println(
                klient + " nadpisal rezerwacje klienta " + poprzedni
        );
    } else {
        System.out.println(klient + " zarezerwowal miejsce " + miejsce);
    }

    return true;
}

    public void pokazSale() {

        for (int i = 1; i <= 30; i++) {

            if (rezerwacje.containsKey(i)) {
                System.out.print("[" + String.format("%02d", i)
                        + " " + rezerwacje.get(i) + "] ");
            } else {
                System.out.print("[" + String.format("%02d", i)
                        + " ----] ");
            }

            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}