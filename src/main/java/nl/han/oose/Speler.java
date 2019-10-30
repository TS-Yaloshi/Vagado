package nl.han.oose;

import nl.han.oose.vragen.Vragenlijst;

import java.util.*;

public class Speler {
    private static final int START_SALDO = 100;
    private String naam;
    private int munten;
    private List<Vragenlijst> vragenlijsten = new ArrayList<>();
    private Map<Vragenlijst, Integer> lifetimeBest = new HashMap<>();

    public Speler(String naam) {
        this.naam = naam;
        munten = START_SALDO;
    }

    public void addVragenlijst(Vragenlijst lijst) {
        this.vragenlijsten.add(lijst);
    }

    public void speelQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("<-- Mijn Vragenlijsten -->");

        int index = 1;
        for (Vragenlijst lijst: vragenlijsten) {
            System.out.println(index + ". " + lijst.getNaam() + "   (" + lijst.getThemaNaam() + ").");
            index++;
        }

        System.out.println("_______________________");
        System.out.print("--> ");

        boolean vragenlijstNietGevonden = true;

        while (vragenlijstNietGevonden) {
            try {
                int input = Integer.parseInt(scanner.nextLine())-1;
                if (input < vragenlijsten.size() && input >= 0) {
                    vragenlijstNietGevonden = false;
                    var vragenlijst = vragenlijsten.get(input);
                    var performance = vragenlijst.start();
                    int aantalGoed = performance[0];
                    int score = performance[1];

                    updateMunten(aantalGoed);
                    updateScore(vragenlijst, score);


                } else {
                    System.out.println();
                    System.out.println("Vragenlijst niet gevonden..");
                    System.out.println("_______________________");
                    System.out.print("--> ");
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Incorrecte invoer!");
                System.out.println("_______________________");
                System.out.print("--> ");
            }
        }

    }

    private void updateMunten(int aantalGoed) {
        if (aantalGoed >=10) {
            System.out.println("2 munten toegevoegd!");
            munten += 2;
        }
    }

    private void updateScore(Vragenlijst vragenlijst, int score) {
        if (checkLifetimeBest(vragenlijst, score)) {
            System.out.println("Nieuwe Lifetime Best!");
            setLifetimeBest(vragenlijst, score);
        }
    }

    private boolean checkLifetimeBest(Vragenlijst vragenlijst, int nieuweScore) {
        if (lifetimeBest.containsKey(vragenlijst)) {
            int oudeScore = lifetimeBest.get(vragenlijst);
            return oudeScore < nieuweScore;
        } else {
            return true;
        }
    }

    private void setLifetimeBest(Vragenlijst vragenlijst, int score) {
        if (lifetimeBest.containsKey(vragenlijst)) lifetimeBest.replace(vragenlijst, score);

        lifetimeBest.put(vragenlijst, score);
    }

    public String getNaam() {
        return naam;
    }
}
