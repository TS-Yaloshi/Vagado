package nl.han.oose.vragen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Meerkeuzevraag extends Vraag {
    private String[] antwoordKeuzes = new String[4];

    public Meerkeuzevraag(String vraag, String correcteAntwoord, String antwoordKeuzeA, String antwoordKeuzeB, String antwoordKeuzeC, String antwoordKeuzeD) {
        super(vraag, Collections.singletonList(correcteAntwoord));
        antwoordKeuzes[0] = "A: " + antwoordKeuzeA;
        antwoordKeuzes[1] = "B: " + antwoordKeuzeB;
        antwoordKeuzes[2] = "C: " + antwoordKeuzeC;
        antwoordKeuzes[3] = "D: " + antwoordKeuzeD;
    }

    @Override
    public void stelVraag(int nummer) {
        System.out.println();
        System.out.println("Vraag " + nummer + " - " + vraag);
        Arrays.stream(antwoordKeuzes).forEach(System.out::println);
    }
}
