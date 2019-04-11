package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.Objects;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal() {
    }

    public Artikal(String sve) {
        String[] niz_sve = sve.split(",");
        if(niz_sve.length != 3) throw new IllegalArgumentException("Nekorektni parametri");
        setSifra(niz_sve[0]);
        setNaziv(niz_sve[1]);
        setCijena(Double.parseDouble(niz_sve[2]));
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra == null || sifra.equals("")) throw new IllegalArgumentException("Ne!");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv == null || naziv.equals("")) throw new IllegalArgumentException("Ne!");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0) throw new IllegalArgumentException("Ne!");
        this.cijena = cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikal artikal = (Artikal) o;
        return Double.compare(artikal.cijena, cijena) == 0 &&
                Objects.equals(sifra, artikal.sifra) &&
                Objects.equals(naziv, artikal.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifra, naziv, cijena);
    }

    @Override
    public String toString() {
        return sifra + "," + naziv + "," + cijena + "\n";
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli) {
        for(int i=0; i<artikli.size(); i++) {
            for(int j=i+1; j<artikli.size(); j++) {
                if(artikli.get(i).equals(artikli.get(j))) {
                    artikli.remove(j);
                }
            }
        }
        return artikli;
    }
}
