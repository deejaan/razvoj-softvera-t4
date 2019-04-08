package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    public TextArea unos;
    public TextArea rezultat;

    private ArrayList<Artikal> artikli = new ArrayList<>();
    public void dodajArtikle(ActionEvent actionEvent) {
        String[] artikliStr = unos.getText().split("\n");

        for(String linija: artikliStr) artikli.add(new Artikal(linija));
        Artikal.izbaciDuplikate(artikli);

        String res = "";
        for(Artikal artikal: artikli) res += artikal + "\n";

        rezultat.setText(res);
    }
}
