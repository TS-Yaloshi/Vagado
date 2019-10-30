package nl.han.oose.vragen;

import nl.han.oose.puntentelling.PuntenStrategie;
import nl.han.oose.puntentelling.TweeMuntenPuntenStrategie;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VragenlijstDutchImpl implements Vragenlijst {
    private static final int aantalRandomVragen = 10;
    private PuntenStrategie puntenStrategie = new TweeMuntenPuntenStrategie();
    private Scanner scanner;
    private StopWatch stopwatch;
    private String naam;
    private List<Vraag> vragenlijst;
    private Thema thema;

    public VragenlijstDutchImpl(String naam, List<Vraag> vragenlijst, Thema thema) {
        this.naam = naam;
        this.vragenlijst = vragenlijst;
        this.thema = thema;
        scanner = new Scanner(System.in);
        stopwatch = new StopWatch();
    }

    public int[] start() {
        int aantalGoed;

        stopwatch.reset();
        stopwatch.start();
        aantalGoed = stelVragen(getRandomVragen());
        stopwatch.stop();

        long tijd = stopwatch.getTime(TimeUnit.SECONDS);
        int score = puntenStrategie.bereken(aantalGoed, tijd);

        System.out.println("De quiz is afgelopen!");
        System.out.println("Uw score: " + score);
        System.out.println("U heeft " + tijd + " seconden over de quiz gedaan.");
        System.out.println("Aantal goede antwoorden: " + aantalGoed);

        return new int[]{aantalGoed, score};
    }

    public String getNaam() {
        return this.naam;
    }

    public String getVolledigThema() {
        return thema.getThema() +" - "+ thema.getSubThema();
    }

    private List<Vraag> getRandomVragen() {
        List<Vraag> returnLijst = new ArrayList<>();
        Random random = new Random();
        while (returnLijst.size() != aantalRandomVragen) {
            Vraag vraag = vragenlijst.get(random.nextInt(vragenlijst.size()));
            boolean alGevraagd = false;
            for (Vraag value : returnLijst) {
                if (vraag == value) {
                    alGevraagd = true;
                    break;
                }
            }
            if (!alGevraagd) {
                returnLijst.add(vraag);
            }
        }
        return returnLijst;
    }

    private int stelVragen(List<Vraag> vragenlijstQuiz) {
        int index = 1;
        int aantalGoed = 0;
        for (Vraag vraag : vragenlijstQuiz) {
            System.out.println();
            vraag.stelVraag(index);
            index++;
            System.out.print("--> ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("stop")) {
                return 0;
            }
            if (vraag.controleerAntwoord(input)) {
                aantalGoed++;
            }
        }
        return aantalGoed;
    }
}