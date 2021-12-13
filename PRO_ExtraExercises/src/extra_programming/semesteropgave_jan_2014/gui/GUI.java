package extra_programming.semesteropgave_jan_2014.gui;

import extra_programming.semesteropgave_jan_2014.application.controller.Controller;
import extra_programming.semesteropgave_jan_2014.application.model.Arrangement;
import extra_programming.semesteropgave_jan_2014.application.model.Event;
import extra_programming.semesteropgave_jan_2014.application.model.WrongDateException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class GUI extends Application {

    private ListView<Arrangement> lvwArrangementer;
    private TextField txfEventNavn, txfArrangementNavn, txfAnsvarlig, txfPris, txfEventAfholdes;
    private DatePicker dtpEventStart, dtpEventSlut, dtpArrangement, dtpEventAfholdes;
    private Button btnAddEvent, btnVisEvent;

    private Arrangement arrangement;

    @Override
    public void init () {
        Controller.initStorage();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Arrangements administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblArrangementer = new Label("Arrangementer:");
        pane.add(lblArrangementer, 0, 0, 2, 1);

        this.lvwArrangementer = new ListView<>();
        this.lvwArrangementer.setPrefSize(200, 300);
        this.lvwArrangementer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.arrangementPicked(newValue));
        pane.add(this.lvwArrangementer, 0, 1, 2, 6);

        Label lblEventNavn = new Label("Event navn");
        pane.add(lblEventNavn, 0, 7);

        this.txfEventNavn = new TextField();
        this.txfEventNavn.setDisable(true);
        pane.add(this.txfEventNavn, 1, 7);

        Label lblEventStart = new Label("Event start");
        pane.add(lblEventStart, 0, 8);

        this.dtpEventStart = new DatePicker();
        this.dtpEventStart.setDisable(true);
        pane.add(this.dtpEventStart, 1, 8);

        Label lblEventSlut = new Label("Event slut");
        pane.add(lblEventSlut, 0, 9);

        this.dtpEventSlut = new DatePicker();
        this.dtpEventSlut.setDisable(true);
        pane.add(this.dtpEventSlut, 1, 9);

        this.btnAddEvent = new Button("Tilføj event");
        this.btnAddEvent.setOnAction(event -> this.addEventAction());
        this.btnAddEvent.setDisable(true);
        pane.add(this.btnAddEvent, 1, 10);

        GridPane arrangementPane = new GridPane();
        arrangementPane.setPadding(new Insets(10));
        arrangementPane.setVgap(10);
        arrangementPane.setHgap(10);

        Label lblArrangementNavn = new Label("Arrangement:");
        arrangementPane.add(lblArrangementNavn, 0, 0);

        this.txfArrangementNavn = new TextField();
        arrangementPane.add(this.txfArrangementNavn, 1, 0);

        Label lblAnsvarlig = new Label("Ansvarlig:");
        arrangementPane.add(lblAnsvarlig, 0, 1);

        this.txfAnsvarlig = new TextField();
        arrangementPane.add(this.txfAnsvarlig, 1, 1);

        Label lblArrangementDato = new Label("Præmieredato:");
        arrangementPane.add(lblArrangementDato, 0, 2);

        this.dtpArrangement = new DatePicker();
        arrangementPane.add(this.dtpArrangement, 1, 2);

        Label lblPris = new Label("Pris:");
        arrangementPane.add(lblPris, 0, 3);

        this.txfPris = new TextField();
        arrangementPane.add(this.txfPris, 1, 3);

        Button btnOpretArrangement = new Button("Opret");
        btnOpretArrangement.setOnAction(event -> opretArrangementAction());
        arrangementPane.add(btnOpretArrangement, 1, 4);

        pane.add(arrangementPane, 2, 0, 3, 6);

        Label lblEventAfholdes = new Label("Event der afholdes på:");
        pane.add(lblEventAfholdes, 2, 6);

        this.dtpEventAfholdes = new DatePicker();
        this.dtpEventAfholdes.setDisable(true);
        pane.add(this.dtpEventAfholdes, 3, 6);

        this.btnVisEvent = new Button("Vis Event");
        this.btnVisEvent.setOnAction(event -> visEventAction());
        this.btnVisEvent.setDisable(true);
        pane.add(this.btnVisEvent, 4, 6);

        this.txfEventAfholdes = new TextField();
        this.txfEventAfholdes.setEditable(false);
        pane.add(this.txfEventAfholdes, 2, 7, 3, 1);

        this.updateArrangementer();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateArrangementer () {
        this.lvwArrangementer.getItems().setAll(Controller.getArrangementer());
        this.arrangement = null;
    }

    private void updateControls () {
        clearArrangementControls();
        clearEventControls();

        setDisableEventControls(this.arrangement == null);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void clearEventControls () {
        this.txfEventNavn.clear();
        this.dtpEventStart.setValue(LocalDate.now());
        this.dtpEventSlut.setValue(LocalDate.now());
        this.dtpEventAfholdes.setValue(LocalDate.now());
    }

    private void setDisableEventControls (boolean disabled) {
        this.txfEventNavn.setDisable(disabled);
        this.dtpEventStart.setDisable(disabled);
        this.dtpEventSlut.setDisable(disabled);
        this.btnAddEvent.setDisable(disabled);
        this.dtpEventAfholdes.setDisable(disabled);
        this.btnVisEvent.setDisable(disabled);
    }

    private void clearArrangementControls () {
        this.txfArrangementNavn.clear();
        this.txfAnsvarlig.clear();
        this.dtpArrangement.setValue(LocalDate.now());
        this.txfPris.clear();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void arrangementPicked (Arrangement arrangement) {
        this.arrangement = arrangement;

        this.updateControls();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void addEventAction () {
        String eventNavn = this.txfEventNavn.getText().trim();
        LocalDate eventStart = this.dtpEventStart.getValue();
        LocalDate eventSlut = this.dtpEventSlut.getValue();

        try {
            Controller.createEvent(this.arrangement, eventNavn, eventStart, eventSlut);
        } catch (WrongDateException ex) {
            System.out.println(ex.getMessage());
        }

        updateControls();
    }

    private void opretArrangementAction () {
        String navn = this.txfArrangementNavn.getText().trim();
        String ansvarlig = this.txfAnsvarlig.getText().trim();
        LocalDate dato = this.dtpArrangement.getValue();
        String prisString = this.txfPris.getText().trim();

        int pris;
        try {
            pris = Integer.parseInt(prisString);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        Controller.createArrangement(navn, ansvarlig, dato, pris);

        this.updateArrangementer();
        this.updateControls();
    }

    private void visEventAction () {
        LocalDate dato = this.dtpEventAfholdes.getValue();

        Event event = this.arrangement.eventOnDate(dato);

        if (event != null) {
            this.txfEventAfholdes.setText(event.toString());
        } else {
            this.txfEventAfholdes.setText("Ingen event fundet");
        }
    }
}
