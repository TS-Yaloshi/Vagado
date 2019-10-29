package nl.han.oose.vragen;

import java.util.List;

public class OpenVraag extends Vraag {

    public OpenVraag(String vraag, List<String> correcteAntwoorden) {
        super(vraag, correcteAntwoorden);
    }

    @Override
    public void stelVraag(int nummer) {
        System.out.println("Vraag "+ nummer +": "+vraag);
    }
}
