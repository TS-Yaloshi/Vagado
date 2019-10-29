package nl.han.oose;

import java.util.*;

public class Speler {
    private String naam;
    private int saldo;
    private List<Vragenlijst> vragenlijstList = new ArrayList<>();
    private Map<String, Integer> lifetimeBest = new HashMap<>();

    public Speler(String naam, int saldo) {
        this.naam = naam;
        this.saldo = saldo;
    }

    public void addVragenlijst(Vragenlijst lijst) {
        this.vragenlijstList.add(lijst);
    }

    public void createQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies een vragenlijst.");
        for (int i = 0; i < vragenlijstList.size(); i++) {
            System.out.println(i + ": " + "Thema: " + vragenlijstList.get(i).getThemaNaam() + " Vragenlijst: " + vragenlijstList.get(i).getNaam());
        }
        int input = Integer.parseInt(scanner.nextLine());
        if (input <= vragenlijstList.size()) {
            Quiz quiz = new Quiz(vragenlijstList.get(input));
            quiz.startQuiz(this);
        }
    }

    public void voegMuntenToe(int verdiendeMunten) {
        this.saldo += verdiendeMunten;
    }

    public boolean checkLifetimeBest(String vragenlijstNaam, int aantalGoed) {
        if (lifetimeBest.containsKey(vragenlijstNaam)) {
            int currentBest = lifetimeBest.get(vragenlijstNaam);
            if (currentBest < aantalGoed) {
                lifetimeBest.replace(vragenlijstNaam, aantalGoed);
                return true;
            } else {
                return false;
            }
        } else {
            lifetimeBest.put(vragenlijstNaam, aantalGoed);
            return true;
        }
    }
}
