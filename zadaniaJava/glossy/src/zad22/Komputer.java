package zad22;


public class Komputer {

    enum TypDysku {
        SSD, HDD
    }

    private final String procesor;
    private final int ram;
    private final int dysk;
    private final TypDysku typDysku;
    private final String kartaGraficzna;
    private final int zasilacz;
    private final String obudowa;

    public Komputer(Builder builder) {
        this.procesor = builder.procesor;
        this.ram = builder.ram;
        this.dysk = builder.dysk;
        this.typDysku = builder.typDysku;
        this.kartaGraficzna = builder.kartaGraficzna;
        this.zasilacz = builder.zasilacz;
        this.obudowa = builder.obudowa;
    }

    public String getProcesor() {
        return procesor;
    }

    public int getRam() {
        return ram;
    }

    public int getDysk() {
        return dysk;
    }

    public TypDysku getTypDysku() {
        return typDysku;
    }

    public String getKartaGraficzna() {
        return kartaGraficzna;
    }

    public int getZasilacz() {
        return zasilacz;
    }

    public String getObudowa() {
        return obudowa;
    }

    public static class Builder {

        private String procesor;
        private int ram;
        private int dysk;
        private TypDysku typDysku;
        private String kartaGraficzna;
        private int zasilacz;
        private String obudowa;

        public Builder(TypDysku typDysku) {
            this.typDysku = typDysku;
        }

        public Builder dysk(int dysk) {
            this.dysk = dysk;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder procesor(String procesor) {
            this.procesor = procesor;
            return this;
        }

        public Builder kartaGraficzna(String kartaGraficzna) {
            this.kartaGraficzna = kartaGraficzna;
            return this;
        }

        public Builder zasilacz(int zasilacz) {
            this.zasilacz = zasilacz;
            return this;
        }

        public Builder obudowa(String obudowa) {
            this.obudowa = obudowa;
            return this;
        }

        public Komputer build() {

            if (procesor == null || procesor.isBlank() || ram <= 0) {
                throw new IllegalArgumentException("Procesor i RAM musza byc!");
            }

            if ((ram & (ram - 1)) != 0) {
                throw new IllegalArgumentException("RAM musi byc potega dwojki!");
            }

            if (zasilacz == 0) {
                if (kartaGraficzna != null) {
                    zasilacz = 650;
                } else {
                    zasilacz = 400;
                }
            }

            if (kartaGraficzna != null && zasilacz < 650) {
                throw new IllegalArgumentException("Zasilacz musi miec minimum 650 W!");
            }

            if (zasilacz < 0) {
                throw new IllegalArgumentException("Nieprawidlowy zasilacz!");
            }

            return new Komputer(this);
        }
    }
}
