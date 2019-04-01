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

}
