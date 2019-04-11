package ba.unsa.etf.rs.tut4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    public ChoiceBox<Artikal> artikalChoice;
    public Spinner spinnerKolicina;
    public TextArea sourceArea;
    public TextArea destinationArea;
    public TextArea racunArea;
    private ArrayList<Artikal> artikals;
    private Racun racun;
    private ObservableList<Artikal> lista = FXCollections.observableArrayList();
    private ArrayList<Artikal> result_lista;

    public void dodajArtikle(ActionEvent actionEvent) {
        String str = sourceArea.getText();
        String[] niz_str = str.split("\n");
        ArrayList<Artikal> artikli = new ArrayList<>();

        for(String element : niz_str) {
            artikli.add(new Artikal(element));
        }
        Artikal.izbaciDuplikate(artikli);
        artikals = new ArrayList<>(artikli);

        String result = "";
        for(Artikal element : artikli) {
            result += element;
        }
        destinationArea.setText(result);

        racun = new Racun();
        result_lista = new ArrayList<>(artikli);
        lista.addAll(result_lista);
        artikalChoice.setItems(lista);
    }

    public void dodajNaRacun(ActionEvent actionEvent) {
        racun.dodajStavku(artikalChoice.getSelectionModel().getSelectedItem(), (Integer) spinnerKolicina.getValue());
        racunArea.setText(racun.toString());
    }
}
