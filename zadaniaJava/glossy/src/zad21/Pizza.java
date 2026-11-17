package zad21;

import java.util.ArrayList;

public class Pizza {
    enum Rozmiar {
        MALA, DUZA, SREDNIA
    }
    enum Ciasto{
        CIENKIE, GRUBE
    }
    private final Rozmiar rozmiar;
    private final Ciasto ciasto;
    private final String sos;
    private final ArrayList<String> dodatki;
    private final boolean czyPodwojnySer;

    public Pizza(Builder builder){

        this.rozmiar = builder.rozmiar;
        this.ciasto = builder.ciasto;
        this.sos = builder.sos;
        this.dodatki =new ArrayList<>(builder.dodatki);
        this.czyPodwojnySer = builder.czyPodwojnySer;
    }
    public Rozmiar getRozmiar(){
        return rozmiar;
    }
    public Ciasto getCiasto(){
        return ciasto;
    }
    public String getSos(){
        return sos;
    }
    public ArrayList<String> getDodatki(){
        return new ArrayList<>(dodatki);
    }
    public boolean getCzyPodwojnySer(){
        return czyPodwojnySer;
    }
    public static class Builder{
        private Rozmiar rozmiar;
        private Ciasto ciasto;
        private String sos;
        private ArrayList<String> dodatki = new ArrayList<>();
        private boolean czyPodwojnySer;

        public Builder (Rozmiar rozmiar){
            this.rozmiar = rozmiar;
        }
        public Builder ciasto(Ciasto ciasto){
            this.ciasto = ciasto;
            return this;
        }
        public Builder sos(String sos){
            this.sos = sos;
            return this;
        }
        public Builder dodatek(String dodatek){
            dodatki.add(dodatek);
            return this;
        }
        public Builder podwojnySer(boolean czySer){
            this.czyPodwojnySer = czySer;
            return this;
        }
        public Pizza build(){
            if (dodatki.size() > 6) {
                throw new IllegalArgumentException("Maksymalnie 6 dodatków!");
            }

            return new Pizza(this);
        }

    }
    public int cena(){
        int cena = 0;
        switch (rozmiar){
            case DUZA -> cena+=50;
            case MALA -> cena+=20;
            case SREDNIA -> cena+=30;
        }
        for (int i = 0; i < dodatki.size(); i++) {
            cena += 5;
        }
        if(czyPodwojnySer){
            cena+=5;
        }
        return cena;
    }
}
