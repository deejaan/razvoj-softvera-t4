package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea unos;
    public TextArea rezultat;

    public ChoiceBox<Artikal> cbartikli;
    public Spinner spkolicina;
    public TextArea aktuelniracun;

    private ArrayList<Artikal> artikli = new ArrayList<>();
    private ObservableList<Artikal> observableList = FXCollections.observableArrayList();
    private Racun racun = new Racun();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableList.setAll(artikli);
        cbartikli.setItems(observableList);
    }

    public void dodajArtikle(ActionEvent actionEvent) {
        String[] artikliStr = unos.getText().split("\n");

        for(String linija: artikliStr) artikli.add(new Artikal(linija));
        Artikal.izbaciDuplikate(artikli);

        observableList.clear();
        observableList.setAll(artikli);
       // cbartikli.getSelectionModel().selectFirst();


        String res = "";
        for(Artikal artikal: artikli) res += artikal + "\n";

        rezultat.setText(res);
    }

    public void obracunaj(ActionEvent actionEvent) {
        Artikal trenutni = cbartikli.getSelectionModel().getSelectedItem();
        int kolicina = (int)spkolicina.getValue();
        racun.dodajStavku(trenutni, kolicina);
    }
}
