package zad24;

public class UsunPolskieZnaki extends DekoratorTekstu {

    public UsunPolskieZnaki(ZrodloTekstu tekst) {
        super(tekst);
    }

    public String pobierz() {

        String napis = tekst.pobierz();

        napis = napis.replace("ą", "a");
        napis = napis.replace("ć", "c");
        napis = napis.replace("ę", "e");
        napis = napis.replace("ł", "l");
        napis = napis.replace("ń", "n");
        napis = napis.replace("ó", "o");
        napis = napis.replace("ś", "s");
        napis = napis.replace("ź", "z");
        napis = napis.replace("ż", "z");

        napis = napis.replace("Ą", "A");
        napis = napis.replace("Ć", "C");
        napis = napis.replace("Ę", "E");
        napis = napis.replace("Ł", "L");
        napis = napis.replace("Ń", "N");
        napis = napis.replace("Ó", "O");
        napis = napis.replace("Ś", "S");
        napis = napis.replace("Ź", "Z");
        napis = napis.replace("Ż", "Z");

        return napis;
    }
}