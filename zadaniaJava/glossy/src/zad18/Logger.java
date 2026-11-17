package zad18;

import java.util.ArrayList;

public class Logger {

    ArrayList<String> logi = new ArrayList<>();

//    public synchronized void zapisz(String modul, String poziom, String tresc)
         public void zapisz(String modul, String poziom, String tresc){

        String wpis = "[" + poziom + "] " + modul + ": " + tresc;

        logi.add(wpis);
    }

    public ArrayList<String> pobierzLogi() {
        return logi;
    }
}