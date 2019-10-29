package nl.han.oose.puntentelling;

import nl.han.oose.vragen.Vraag;

public interface PuntenStrategie {

    int berekenScore(int aantalGoed);

    int berekenMunten(int aantalGoed);
}
