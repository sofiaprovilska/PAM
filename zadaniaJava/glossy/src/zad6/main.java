package zad6;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ArrayList<String> listaZakupow = new ArrayList<>();
        listaZakupow.add("mleko");
        listaZakupow.add("chleb");
        listaZakupow.add("maslo");
        listaZakupow.add("cukier");
        listaZakupow.add("cynamon");
        listaZakupow.add("czipsy");

        Scanner scanner = new Scanner(System.in);
        int wybor = -1;

        while (wybor != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Usun produkt (po nazwie lub numerze)");
            System.out.println("3. Wypisz listę z numerami");
            System.out.println("4. Wyczyść listę");
            System.out.println("0. Koniec");
            System.out.print("Wybierz opcję: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Błąd: Podaj poprawny numer opcji!");
                scanner.next();
                continue;
            }
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    System.out.print("Podaj nazwę produktu do dodania: ");
                    String nowyProdukt = scanner.nextLine().trim();
                    if (nowyProdukt.isEmpty()) {
                        System.out.println("Błąd: Nazwa produktu nie może być pusta!");
                    } else if (listaZakupow.contains(nowyProdukt)) {
                        System.out.println("Błąd: Produkt '" + nowyProdukt + "' znajduje się już na liście!");
                    } else {
                        listaZakupow.add(nowyProdukt);
                        System.out.println("Dodano produkt: " + nowyProdukt);
                    }
                    break;

                case 2:
                    if (listaZakupow.isEmpty()) {
                        System.out.println("Lista jest pusta, nie ma czego usuwać.");
                        break;
                    }
                    System.out.print("Podaj nazwę produktu lub jego numer z listy do usunięcia: ");
                    String wpis = scanner.nextLine().trim();

                    try {
                        int numer = Integer.parseInt(wpis);
                        int indeks = numer - 1;

                        if (indeks >= 0 && indeks < listaZakupow.size()) {
                            String usuniety = listaZakupow.remove(indeks);
                            System.out.println("Usunięto produkt o numerze " + numer + ": " + usuniety);
                        } else {
                            System.out.println("Błąd: Nie ma produktu o takim numerze!");
                        }
                    } catch (NumberFormatException e) {
                        if (listaZakupow.contains(wpis)) {
                            listaZakupow.remove(wpis);
                            System.out.println("Usunięto produkt: " + wpis);
                        } else {
                            System.out.println("Błąd: Produkt '" + wpis + "' nie istnieje na liście!");
                        }
                    }
                    break;

                case 3:
                    if (listaZakupow.isEmpty()) {
                        System.out.println("Twoja lista zakupów jest pusta.");
                    } else {
                        System.out.println("LISTA ZAKUPÓW");
                        for (int i = 0; i < listaZakupow.size(); i++) {
                            System.out.println((i + 1) + ". " + listaZakupow.get(i));
                        }
                    }
                    break;

                case 4:
                    listaZakupow.clear();
                    System.out.println("Lista zakupów została wyczyszczona.");
                    break;

                case 0:
                    System.out.println("Koniec programu. Do zobaczenia na zakupach!");
                    break;

                default:
                    System.out.println("Niepoprawna opcja! Wybierz liczbę od 0 do 4.");
            }
        }
        scanner.close();

    }
}
