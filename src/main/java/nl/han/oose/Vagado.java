package nl.han.oose;

import nl.han.oose.exceptions.PlayerNotFoundException;
import nl.han.oose.vragen.*;

import java.util.*;

public class Vagado {
    private static Spel spel;

    public static void main( String[] args ) throws PlayerNotFoundException {
        setup();
        spel.speelQuiz("Jantje");
    }

    private static void setup() {
        List<Vraag> vraagList = new ArrayList<>();
        vraagList.add(new Meerkeuzevraag("Wie heeft de gouden schoen gewonnen in 2011?", "a", "Messi", "C.Ronaldo", "Kaka", "Drogba"));
        vraagList.add(new Meerkeuzevraag("Hoe vaak stond Nederland in een WK finale?", "a", "3 keer", "1 keer", "2 keer", "4 keer"));
        List<String> persieList = new ArrayList<>();
        persieList.add("Persie");
        persieList.add("van Persie");
        persieList.add("Robin van Persie");
        vraagList.add(new OpenVraag("Wie is topscorer alle tijden van Oranje?", persieList));
        vraagList.add(new Meerkeuzevraag("Welke broers waren erbij tijdens het EK 1988?", "a", "Ronald en Erwin Koeman", "Siem en Luuk de Jong", "Frank en Ronald de Boer", "Rafael en Nadal"));
        vraagList.add(new Meerkeuzevraag("Wie was bondscoach tijdens het gewonnen EK in 1988?", "a", "Rinus Michels", "Co Adriaansen", "Guus Hiddink", "Louis van Gaal"));
        vraagList.add(new Meerkeuzevraag("Waar was het WK voetbal 2006?","a", "Duitsland", "Zuid-Afrika", "Brazilië", "Engeland"));
        vraagList.add(new Meerkeuzevraag("Wie zijn vader heeft bij AJAX en Sparta gespeeld?", "a", "Daley Blind", "Zinedine Zidane", "Luis Figo", "Erwin Zoetebier"));
        List<String> ajaxList = new ArrayList<>();
        ajaxList.add("Erik");
        ajaxList.add("Erik ten Hag");
        ajaxList.add("ten Hag");
        vraagList.add(new OpenVraag("Wie is de coach van Ajax (2019)?", ajaxList));
        List<String> coachNederland = new ArrayList<>();
        coachNederland.add("Ronald");
        coachNederland.add("Ronald Koeman");
        coachNederland.add("Koeman");
        vraagList.add(new OpenVraag("Wie is de coach van Nederland (2019)?", coachNederland));
        List<String> feyenoordList = new ArrayList<>();
        feyenoordList.add("Jaap");
        feyenoordList.add("Jaap Stam");
        feyenoordList.add("Stam");
        vraagList.add(new OpenVraag("Wie is de coach van Feyenoord (2019)?", feyenoordList));
        List<String> psvList = new ArrayList<>();
        psvList.add("Mark");
        psvList.add("Mark van Bommel");
        psvList.add("van Bommel");
        vraagList.add(new OpenVraag("Wie is de coach van PSV (2019)?", psvList));
        List<String> azList = new ArrayList<>();
        azList.add("Arne");
        azList.add("Arne Slot");
        azList.add("Slot");
        vraagList.add(new OpenVraag("Wie is de coach van AZ (2019)?", azList));
        List<String> keeperList = new ArrayList<>();
        keeperList.add("Jasper");
        keeperList.add("Jasper Cillessen");
        keeperList.add("Cillessen");
        vraagList.add(new OpenVraag("Wie is de keeper van Nederland (2019)?", keeperList));
        List<String> aanvoerderList = new ArrayList<>();
        aanvoerderList.add("Virgil");
        aanvoerderList.add("Virgil van Dijk");
        aanvoerderList.add("van Dijk");
        vraagList.add(new OpenVraag("Wie is de aanvoerder van Nederland (2019)?", aanvoerderList));

        Thema thema = new Thema("Sport", "Voetbal");

        Vragenlijst vragenlijst = new VragenlijstDutchImpl("De voetbalQuiz", vraagList, thema);
        List<Speler> spelers = new ArrayList<>();
        var speler = new Speler("Jantje");
        speler.addVragenlijst(vragenlijst);
        spelers.add(speler);
        spel = new Spel(spelers);

    }
}
