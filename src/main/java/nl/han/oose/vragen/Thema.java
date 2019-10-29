package nl.han.oose.vragen;

public class Thema {
    private String thema;
    private String subThema;

    public Thema(String thema, String subThema) {
        this.thema = thema;
        this.subThema = subThema;
    }

    public String getThema() {
        return thema;
    }

    public String getSubThema() {
        return subThema;
    }
}
