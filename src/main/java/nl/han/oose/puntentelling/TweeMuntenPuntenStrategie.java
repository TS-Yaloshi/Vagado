package nl.han.oose.puntentelling;

public class TweeMuntenPuntenStrategie implements PuntenStrategie {

    @Override
    public int bereken(int aantalGoed, long tijd) {
        int score = aantalGoed*100;
        score += (1000/(tijd+10))*aantalGoed;
        return score;
    }
}
