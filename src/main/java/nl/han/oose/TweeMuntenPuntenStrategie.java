package nl.han.oose;

public class TweeMuntenPuntenStrategie implements PuntenStrategie {
    @Override
    public int berekenPunten(Vraag vraag) {
        return 1;
    }

    @Override
    public int berekenMunten(int aantalGoed) {
        if (aantalGoed >= 10) {
            return 2;
        }
        return 0;
    }
}
