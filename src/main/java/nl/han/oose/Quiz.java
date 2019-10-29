package nl.han.oose;

import nl.han.oose.puntentelling.PuntenStrategie;
import nl.han.oose.puntentelling.TweeMuntenPuntenStrategie;
import nl.han.oose.vragen.Vraag;
import nl.han.oose.vragen.Vragenlijst;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Quiz {
    private Vragenlijst vragenlijst;
    private PuntenStrategie puntenStrategie = new TweeMuntenPuntenStrategie();
    private Scanner scanner;
    private List<Vraag> vragenlijstQuiz;
    private StopWatch stopwatch;
    private int aantalGoed;

    public Quiz(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
        scanner = new Scanner(System.in);
        stopwatch = new StopWatch();
    }

    public void start(Speler speler) {
        vragenlijstQuiz = vragenlijst.getRandomVragen();

        stopwatch.start();
        this.stelVragen(vragenlijstQuiz);
        stopwatch.stop();
        long tijd = stopwatch.getTime(TimeUnit.SECONDS);
        int score = puntenStrategie.berekenScore(aantalGoed);
        int verdiendeMunten = puntenStrategie.berekenMunten(aantalGoed);

        speler.voegMuntenToe(verdiendeMunten);
        System.out.println("De quiz is afgelopen!");
        if (speler.checkLifetimeBest(vragenlijst, score) && score > 0) {
            System.out.println("Uw score: " + score + ". Dit is een nieuw lifetime best!");
            speler.setLifetimeBest(vragenlijst, score);
        } else {
            System.out.println("Uw score: " + score);
        }
        System.out.println("U heeft " + tijd + " seconden over de quiz gedaan.");
        System.out.println("Aantal goede antwoorden: " + aantalGoed);
        System.out.println("U heeft " + verdiendeMunten + " munten verdiend.");
        System.out.println("U wordt doorgeleid naar het Main Menu.");
    }

    private void stelVragen(List<Vraag> vragenlijstQuiz) {
        int index = 1;
        for (Vraag vraag : vragenlijstQuiz) {
            vraag.stelVraag(index);
            index++;
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("stop")) {
                return;
            }
            if (vraag.controleerAntwoord(input)) {
                aantalGoed++;
            }
        }
    }
}
