package zad3;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException{
        List<String> wyniki = new ArrayList<>();
        Thread[] watki = new Thread[5];
        String[] imiona = {
                "Leonardo",
                "Franklin",
                "Donatello",
                "Michelangelo",
                "Rafael"
        };
        for(int i = 0;i<5;i++){
            Zolw zolw = new Zolw(imiona[i],wyniki);
            watki[i] = new Thread(zolw);
            watki[i].start();
        }
        for(int i = 1;i<5;i++){
            watki[i].join();
        }
        System.out.println("Kolejność dotarcia do mety:");
        for(int i=0;i< wyniki.size();i++){
            System.out.println((i+1) + wyniki.get(i));
        }
    }


}
