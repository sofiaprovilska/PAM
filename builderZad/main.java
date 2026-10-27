package builderZad;

public class main {
    Osoba osoba1 = new Osoba.OsobaBuilder()
            .setImie("yoongi")
            .setWiek(33)
            .setNazwisko("min")
            .setRozmiarCzapki(7)
            .setNrButa(40)
            .build();

}
