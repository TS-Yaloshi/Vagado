package nl.han.oose;

public class Meerkeuzevraag extends Vraag {
    private String antwoord;
    private String a;
    private String b;
    private String c;
    private String d;

    public Meerkeuzevraag(String vraag, String antwoord, String verkeerdAntwoord1, String verkeerdAntwoord2, String verkeerdAntwoord3) {
        super(vraag);
        this.antwoord = "A";
        this.a = antwoord;
        this.b = verkeerdAntwoord1;
        this.c = verkeerdAntwoord2;
        this.d = verkeerdAntwoord3;
    }

    @Override
    public void stelVraag() {
        System.out.println(vraag);
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
    }

    @Override
    public boolean controleerAntwoord(String input) {
        return input.equals(antwoord);
    }
}
