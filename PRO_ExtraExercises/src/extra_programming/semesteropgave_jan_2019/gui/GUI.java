package extra_programming.semesteropgave_jan_2019.gui;

import extra_programming.semesteropgave_jan_2019.application.controller.Controller;
import extra_programming.semesteropgave_jan_2019.application.model.Forestilling;
import extra_programming.semesteropgave_jan_2019.application.model.Kunde;
import extra_programming.semesteropgave_jan_2019.application.model.Plads;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class GUI extends Application {

    private ListView<Forestilling> lvwForestillinger;
    private ListView<Kunde> lvwKunder;
    private TextArea txaBestiltePladser;
    private TextField txfNavn, txfNummer;
    private DatePicker dtpDato;
    private Button btnVisBestiltePladser;

    private Forestilling forestilling;
    private Kunde kunde;

    @Override
    public void init () {
        Controller.initStorage();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Tester bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(new Label("Forestillinger"), 0, 0);

        this.lvwForestillinger = new ListView<>();
        this.lvwForestillinger.setPrefSize(200, 300);
        this.lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        this.lvwForestillinger.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.forestillingSelected(newValue));
        pane.add(this.lvwForestillinger, 0, 1, 1, 4);

        pane.add(new Label("Kunder"), 1, 0);

        this.lvwKunder = new ListView<>();
        this.lvwKunder.setPrefSize(150, 300);
        this.lvwKunder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.kundeSelected(newValue));
        pane.add(this.lvwKunder, 1, 1, 1, 4);

        pane.add(new Label("Kunde navn:"), 1, 5);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 1, 6);

        pane.add(new Label("Kunde mobil:"), 1, 7);

        this.txfNummer = new TextField();
        pane.add(this.txfNummer, 1, 8);

        Button btnOpretKunde = new Button("Opret kunde");
        btnOpretKunde.setOnAction(event -> this.opretKundeAction());
        pane.add(btnOpretKunde, 1, 9);

        pane.add(new Label("Dato:"), 2, 0);

        this.dtpDato = new DatePicker(LocalDate.now());
        this.dtpDato.setDisable(true);
        pane.add(dtpDato, 2, 1);

        this.btnVisBestiltePladser = new Button("Vis bestilte pladser");
        this.btnVisBestiltePladser.setOnAction(event -> this.visBestiltePladserAction());
        this.btnVisBestiltePladser.setDisable(true);
        pane.add(this.btnVisBestiltePladser, 2, 2);

        pane.add(new Label("Bestilte pladser"), 2, 3);

        this.txaBestiltePladser = new TextArea();
        this.txaBestiltePladser.setPrefSize(150, 200);
        this.txaBestiltePladser.setEditable(false);
        pane.add(this.txaBestiltePladser, 2, 4);

        this.updateKunder();
    }

    private void updateKunder () {
        this.lvwKunder.getItems().setAll(Controller.getKunder());
    }

    private void clearKundeControls () {
        this.txfNummer.clear();
        this.txfNavn.clear();
    }

    private void clearBestiltePladserControls () {
        this.dtpDato.setValue(LocalDate.now());
        this.txaBestiltePladser.clear();
    }

    private void disableBestiltePladserControls (boolean disable) {
        this.dtpDato.setDisable(disable);
        this.btnVisBestiltePladser.setDisable(disable);
    }

    private void forestillingSelected (Forestilling forestilling) {
        this.forestilling = forestilling;
    }

    private void kundeSelected (Kunde kunde) {
        this.kunde = kunde;

        clearBestiltePladserControls();

        disableBestiltePladserControls(this.forestilling == null || this.kunde == null);
    }

    private void opretKundeAction () {
        String navn = this.txfNavn.getText().trim();
        String nummer = this.txfNummer.getText().trim();

        if (!navn.isEmpty() && !nummer.isEmpty()) {
            Controller.createKunde(navn, nummer);

            clearKundeControls();
            updateKunder();
        } else {
            throw new RuntimeException("Kunde navn og mobil skal være udfyldt");
        }
    }

    private void visBestiltePladserAction () {
        LocalDate dato = this.dtpDato.getValue();
        StringBuilder stringBuilder = new StringBuilder();

        for (Plads plads : this.kunde.bestiltePladserTilForestillingPåDag(this.forestilling, dato)) {
            stringBuilder.append(plads).append("\n");
        }

        this.txaBestiltePladser.setText(stringBuilder.toString());
    }
}
