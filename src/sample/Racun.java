package sample;
import java.util.ArrayList;

public class Racun {
    private ArrayList<Stavka> stavke;
    public Racun() {
        stavke = new ArrayList<>();
    }
    public void dodajStavku(Artikal artikal, int kolicina) {
        stavke.add(new Stavka(artikal, kolicina));
    }
    public double ukupanIznos() {
        double iznos=0;
        for(Stavka s: stavke) {
            iznos += s.kolicina + s.artikal.getCijena();
        }
        return iznos;
    }

    private class Stavka {
        int kolicina;
        Artikal artikal;

        Stavka() {}
        Stavka(Artikal art, int kol) {
            artikal = art;
            kolicina = kol;
        }
    }
}
