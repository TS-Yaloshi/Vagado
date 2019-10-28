package nl.han.oose;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private Vragenlijst vragenlijst;
    private PuntenStrategie puntenStrategie = new TweeMuntenPuntenStrategie();

    public Quiz(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }

    public void startQuiz(Speler speler) {
        Scanner scanner = new Scanner(System.in);
        List<Vraag> lijst = vragenlijst.getRandomVragen();
        int score = 0;
        int aantalGoed = 0;

        for (Vraag vraag : lijst) {
            vraag.stelVraag();
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                return;
            }
            if (vraag.controleerAntwoord(input)) {
                score += puntenStrategie.berekenPunten(vraag);
                aantalGoed++;
            }
        }
        int verdiendeMunten = puntenStrategie.berekenMunten(aantalGoed);
        speler.voegMuntenToe(verdiendeMunten);
        System.out.println("De quiz is afgelopen!");
        System.out.println("Uw score: " + score);
        System.out.println("Aantal goede antwoorden: " + aantalGoed);
        System.out.println("U heeft " + verdiendeMunten + " munten verdiend.");
        System.out.println("U wordt doorgeleid naar het menu.");
    }
}
