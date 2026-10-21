package zad1;

import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {
        KontoBankowe konto = new KontoBankowe(5000);

        Runnable wplac = () ->{
            for(int i =0;i<1000;i++){
                konto.wplac(10);
            }
        };
        Runnable wyplac = () ->{
            for(int i =0;i<1000;i++){
                konto.wyplac(10);
            }
        };
        Thread watek1 = new Thread(wplac);
        Thread watek2 = new Thread(wplac);
        Thread watek3 = new Thread(wyplac);
        Thread watek4 = new Thread(wyplac);

        watek1.start();
        watek2.start();
        watek3.start();
        watek4.start();

        watek1.join();
        watek2.join();
        watek3.join();
        watek4.join();

        System.out.println(konto.getSaldo());
        //6110
        //5010
        //3710

        //po synchronizacji
        //5000synchronized
        //poniważ wątki nadpisują nawzajem swoje wyniki
    }

}
