package nl.han.oose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vagado {
    private static Speler speler;
    private Shop shop;

    public static void main( String[] args ) {
        setup();
        kiesMenu();
    }

    private static void kiesMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom in het menu.");
        System.out.println("Typ 1 om een nieuwe quiz te beginnen of exit om het spel af te sluiten.");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            speler.createQuiz();
        } else if (input.equals("exit")) {
            return;
        }
        kiesMenu();
    }

    private static void setup() {
        List<Vraag> vraagList = new ArrayList<>();
        vraagList.add(new Meerkeuzevraag("Wie heeft de gouden schoen gewonnen in 2011?", "Messi", "C.Ronaldo", "Kaka", "Drogba"));
        vraagList.add(new Meerkeuzevraag("Hoe vaak stond Nederland in een WK finale?", "3 keer", "1 keer", "2 keer", "4 keer"));
        List<String> persieList = new ArrayList<>();
        persieList.add("Persie");
        persieList.add("van Persie");
        persieList.add("Robin van Persie");
        vraagList.add(new OpenVraag("Wie is topscorer alle tijden van Oranje?", persieList));
        vraagList.add(new Meerkeuzevraag("Welke broers waren erbij tijdens het EK 1988?", "Ronald en Erwin Koeman", "Siem en Luuk de Jong", "Frank en Ronald de Boer", "Rafael en Nadal"));
        vraagList.add(new Meerkeuzevraag("Wie was bondscoach tijdens het gewonnen EK in 1988?", "Rinus Michels", "Co Adriaansen", "Guus Hiddink", "Louis van Gaal"));
        vraagList.add(new Meerkeuzevraag("Waar was het WK voetbal 2006?", "Duitsland", "Zuid-Afrika", "Brazilië", "Engeland"));
        vraagList.add(new Meerkeuzevraag("Wie zijn vader heeft bij AJAX en Sparta gespeeld?", "Daley Blind", "Zinedine Zidane", "Luis Figo", "Erwin Zoetebier"));
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

        Thema thema = new Thema("Sport");

        Vragenlijst vragenlijst = new VragenlijstDutchImpl("Sport - Voetbal", vraagList, thema);
        speler = new Speler("Jantje", 100);
        speler.addVragenlijst(vragenlijst);

    }
}
