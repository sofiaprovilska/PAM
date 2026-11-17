package zad22;


public class Dyrektor {

    public static Komputer zestawBiurowy() {

        return new Komputer.Builder(Komputer.TypDysku.SSD)
                .procesor("Intel i3")
                .ram(8)
                .dysk(500)
                .obudowa("Biurowa")
                .build();
    }

    public static Komputer zestawGamingowy() {

        return new Komputer.Builder(Komputer.TypDysku.SSD)
                .procesor("Ryzen 7")
                .ram(32)
                .dysk(1000)
                .kartaGraficzna("RTX 4070")
                .zasilacz(750)
                .obudowa("Gamingowa")
                .build();
    }

    public static Komputer zestawSerwerowy() {

        return new Komputer.Builder(Komputer.TypDysku.SSD)
                .procesor("Intel Xeon")
                .ram(64)
                .dysk(2000)
                .zasilacz(750)
                .obudowa("Serwerowa")
                .build();
    }
}
