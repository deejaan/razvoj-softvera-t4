package sample;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;
    public Artikal() {}
    public Artikal(String unos) {
        String[] ulazni_podaci = unos.split(",");
        sifra = ulazni_podaci[0];
        naziv = ulazni_podaci[1];
        cijena = Double.parseDouble(ulazni_podaci[2]);
    }

    public boolean equals(Object o) {
        Artikal artikal = (Artikal)o;
        if(this.sifra.equals(artikal.sifra) && this.naziv.equals(artikal.naziv) && this.cijena==artikal.cijena)
            return true;
        else return false;
    }
    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli) {
        ArrayList<Artikal> rezultat = new ArrayList<Artikal>();
        return rezultat;
    }

    public String toString() {
        return sifra + ',' + naziv + ',' + cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
        if(sifra==null) throw new IllegalArgumentException();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
        if(naziv==null) throw new IllegalArgumentException();
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
        if(cijena <= 0) throw new IllegalArgumentException();
    }
}
