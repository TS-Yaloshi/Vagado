package nl.han.oose;

import java.util.List;

public interface Vragenlijst {
    String getNaam();

    List<Vraag> getRandomVragen();

    String getThemaNaam();
}
