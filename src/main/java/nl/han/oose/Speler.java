package nl.han.oose;

import nl.han.oose.vragen.Vragenlijst;

import java.util.*;

public class Speler {
    private static final int START_SALDO = 100;
    private String naam;
    private int saldo;
    private List<Vragenlijst> vragenlijsten = new ArrayList<>();
    private Map<Vragenlijst, Integer> lifetimeBest = new HashMap<>();

    public Speler(String naam) {
        this.naam = naam;
        saldo = START_SALDO;
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
            System.out.println(index + ". " + lijst.getNaam() + "   (" + lijst.getVolledigThema() + ").");
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
                    Quiz quiz = new Quiz(vragenlijst);
                    quiz.start(this);
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

    public void voegMuntenToe(int verdiendeMunten) {
        this.saldo += verdiendeMunten;
    }

    public boolean checkLifetimeBest(Vragenlijst vragenlijst, int nieuweScore) {
        if (lifetimeBest.containsKey(vragenlijst)) {
            int oudeScore = lifetimeBest.get(vragenlijst);
            return oudeScore < nieuweScore;
        } else {
            return true;
        }
    }

    public void setLifetimeBest(Vragenlijst vragenlijst, int score) {
        if (lifetimeBest.containsKey(vragenlijst)) lifetimeBest.replace(vragenlijst, score);

        lifetimeBest.put(vragenlijst, score);
    }

    public String getNaam() {
        return naam;
    }
}
