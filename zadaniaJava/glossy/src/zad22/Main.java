package zad22;


public class Main {

    public static void main(String[] args) {

        Komputer komputer1 = Dyrektor.zestawBiurowy();
        Komputer komputer2 = Dyrektor.zestawGamingowy();
        Komputer komputer3 = Dyrektor.zestawSerwerowy();

        Komputer mojKomputer = new Komputer.Builder(Komputer.TypDysku.SSD)
                .procesor("Ryzen 7")
                .ram(32)
                .dysk(1000)
                .kartaGraficzna("RTX 4070")
                .obudowa("Czarna")
                .build();

        System.out.println("Moj komputer:");
        System.out.println("Procesor: " + mojKomputer.getProcesor());
        System.out.println("RAM: " + mojKomputer.getRam() + " GB");
        System.out.println("Dysk: " + mojKomputer.getDysk() + " GB");
        System.out.println("Typ dysku: " + mojKomputer.getTypDysku());
        System.out.println("Karta graficzna: " + mojKomputer.getKartaGraficzna());
        System.out.println("Zasilacz: " + mojKomputer.getZasilacz() + " W");
        System.out.println("Obudowa: " + mojKomputer.getObudowa());
    }
}
