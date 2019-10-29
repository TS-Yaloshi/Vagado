package nl.han.oose.vragen;

import java.util.List;

public interface Vragenlijst {
    String getNaam();

    List<Vraag> getRandomVragen();

    String getVolledigThema();
}
