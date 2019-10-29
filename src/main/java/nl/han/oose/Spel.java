package nl.han.oose;

import nl.han.oose.exceptions.PlayerNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Spel {

    private List<Speler> spelers;

    public Spel(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public void kiesMenu(Speler speler) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________");
        System.out.println("<--  Main Menu  -->");
        System.out.println("1. Start Quiz");
        System.out.println("2. Exit");
        System.out.println("______________________");
        System.out.println("Maak een keuze uit het Menu: ");
        System.out.print("--> ");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("1")) {
            speler.speelQuiz();
        } else if (input.equals("2")) {
            return;
        }
        kiesMenu(speler);
    }

    public void speelQuiz(String spelerNaam) throws PlayerNotFoundException {
        Speler speler = getSpelerByName(spelerNaam);

        kiesMenu(speler);
    }

    private Speler getSpelerByName(String spelerNaam) throws PlayerNotFoundException {
        for (Speler speler : spelers
        ) {
            if (speler.getNaam().toLowerCase().equals(spelerNaam.toLowerCase())) {
                return speler;
            }
        }
        throw new PlayerNotFoundException();
    }
}
