package nl.han.oose.vragen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VragenlijstDutchImpl implements Vragenlijst {
    private static final int aantalRandomVragen = 10;
    private String naam;
    private List<Vraag> vragenlijst;
    private Thema thema;

    public VragenlijstDutchImpl(String naam, List<Vraag> vragenlijst, Thema thema) {
        this.naam = naam;
        this.vragenlijst = vragenlijst;
        this.thema = thema;
    }

    public String getNaam() {
        return this.naam;
    }

    public List<Vraag> getRandomVragen() {
        List<Vraag> returnLijst = new ArrayList<>();
        Random random = new Random();
        while (returnLijst.size() != aantalRandomVragen) {
            Vraag vraag = vragenlijst.get(random.nextInt(vragenlijst.size()));
            boolean alGevraagd = false;
            for (Vraag value : returnLijst) {
                if (vraag == value) {
                    alGevraagd = true;
                    break;
                }
            }
            if (!alGevraagd) {
                returnLijst.add(vraag);
            }
        }
        return returnLijst;
    }

    public String getVolledigThema() {
        return thema.getThema() +" - "+ thema.getSubThema();
    }
}