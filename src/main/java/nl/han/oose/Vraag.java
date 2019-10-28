package nl.han.oose;

public abstract class Vraag {
    protected String vraag;

    public Vraag(String vraag) {
        this.vraag = vraag;
    }

    public String getVraag() {
        return this.vraag;
    }

    public void stelVraag() {
    }

    public boolean controleerAntwoord(String input) {
        return true;
    }
}