package nl.han.oose.puntentelling;

public class TweeMuntenPuntenStrategie implements PuntenStrategie {

    @Override
    public int berekenScore(int aantalGoed) {
        return aantalGoed*100;
    }

    @Override
    public int berekenMunten(int aantalGoed) {
        if (aantalGoed >= 10) {
            return 2;
        }
        return 0;
    }
}
