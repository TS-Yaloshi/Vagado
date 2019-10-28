package nl.han.oose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Speler {
    private String naam;
    private int saldo;
    private List<Vragenlijst> vragenlijstList = new ArrayList<>();

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
}
