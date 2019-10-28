package nl.han.oose;

import java.util.List;

public class OpenVraag extends Vraag {
    private List<String> antwoorden;

    public OpenVraag(String vraag, List<String> antwoorden) {
        super(vraag);
        this.antwoorden = antwoorden;
    }

    @Override
    public void stelVraag() {
        System.out.println(vraag);
    }

    @Override
    public boolean controleerAntwoord(String input) {
        for (String antwoord : antwoorden) {
            if (input.equals(antwoord)) {
                return true;
            }
        }
        return false;
    }
}
