package nl.han.oose.vragen;

import java.util.List;

public abstract class Vraag {
    String vraag;
    private List<String> antwoorden;

    public Vraag(String vraag, List<String> antwoorden) {
        this.vraag = vraag;
        this.antwoorden = antwoorden;
    }

    public abstract void stelVraag(int nummer);

    public boolean controleerAntwoord(String input) {
        for (String antwoord : antwoorden) {
            if (input.toLowerCase().equals(antwoord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}