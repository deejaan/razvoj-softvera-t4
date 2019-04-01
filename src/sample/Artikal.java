package sample;

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
