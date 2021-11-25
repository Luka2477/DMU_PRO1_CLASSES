package extra_programming.opgave_med_gui_11_17.opgave6.gui;

import extra_programming.opgave_med_gui_11_17.opgave6.application.controller.Controller;
import extra_programming.opgave_med_gui_11_17.opgave6.application.model.Facilitet;
import extra_programming.opgave_med_gui_11_17.opgave6.application.model.Gruppe;
import extra_programming.opgave_med_gui_11_17.opgave6.application.model.PersonChip;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {

    private Gruppe gruppe;
    private int nr = 1;

    private TextField txfNr, txfNavn, txfAlder, txfMaxsaldo;
    private Label lblError;
    private ListView<PersonChip> lvwPersonChips;
    private ListView<Facilitet> lvwFaciliteter;

    @Override
    public void init () {
        Controller.createSomeObjects();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Holliday Paradise");
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

        Label lblGruppe = new Label("Gruppe:");
        pane.add(lblGruppe, 0, 0);

        Label lblNr = new Label("Nr:");
        pane.add(lblNr, 0, 1);

        this.txfNr = new TextField();
        pane.add(this.txfNr, 1, 1);

        Button btnOpretGruppe = new Button("Opret gruppe");
        btnOpretGruppe.setOnAction(event -> this.opretGruppeAction());
        GridPane.setHalignment(btnOpretGruppe, HPos.CENTER);
        pane.add(btnOpretGruppe, 0, 2, 2, 1);

        Label lblPerson = new Label("Person:");
        pane.add(lblPerson, 0, 3);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 4);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 1, 4);

        Label lblAlder = new Label("Alder:");
        pane.add(lblAlder, 0, 5);

        this.txfAlder = new TextField();
        pane.add(this.txfAlder, 1, 5);

        Label lblMaxsaldo = new Label("Maxsaldo:");
        pane.add(lblMaxsaldo, 0, 6);

        this.txfMaxsaldo = new TextField();
        pane.add(this.txfMaxsaldo, 1, 6);

        Button btnAddPerson = new Button("Tilføj person til gruppe");
        btnAddPerson.setOnAction(event -> this.addPersonAction());
        GridPane.setHalignment(btnAddPerson, HPos.CENTER);
        pane.add(btnAddPerson, 0, 7, 2, 1);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        pane.add(this.lblError, 0, 10, 3, 1);

        Label lblPersoner = new Label("Personer:");
        pane.add(lblPersoner, 2, 0);

        this.lvwPersonChips = new ListView<>();
        this.lvwPersonChips.setPrefSize(200, 100);
        pane.add(this.lvwPersonChips, 2, 1, 1, 5);

        Label lblFaciliteter = new Label("Faciliteter:");
        pane.add(lblFaciliteter, 2, 7);

        this.lvwFaciliteter = new ListView<>();
        this.lvwFaciliteter.setPrefSize(200, 100);
        pane.add(this.lvwFaciliteter, 2, 8);

        Button btnAddFacilitetToPerson = new Button("Person bruger facilitet");
        btnAddFacilitetToPerson.setOnAction(event -> this.addFacilitetToPersonAction());
        GridPane.setHalignment(btnAddFacilitetToPerson, HPos.CENTER);
        pane.add(btnAddFacilitetToPerson, 2, 9);

        this.updateControls();
    }

    private void opretGruppeAction () {
        String nr = this.txfNr.getText().trim();

        if (!nr.isEmpty()) {
            int nrInt;
            try {
                nrInt = Integer.parseInt(nr);
            } catch (NumberFormatException ex) {
                this.lblError.setText("Nr skal være et heltal.");
                return;
            }

            this.gruppe = Controller.createGruppe(nrInt);
        } else {
            this.lblError.setText("Nr skal indtastes.");
        }
    }

    private void addPersonAction () {
        if (this.gruppe != null) {
            String navn = this.txfNavn.getText().trim();
            String alder = this.txfAlder.getText().trim();
            String maxSaldo = this.txfMaxsaldo.getText().trim();

            if (!navn.isEmpty()) {
                if (!alder.isEmpty()) {
                    if (!maxSaldo.isEmpty()) {
                        int alderInt;
                        try {
                            alderInt = Integer.parseInt(alder);
                        } catch (NumberFormatException ex) {
                            this.lblError.setText("Alder skal være et heltal.");
                            return;
                        }

                        int maxSaldoInt;
                        try {
                            maxSaldoInt = Integer.parseInt(maxSaldo);
                        } catch (NumberFormatException ex) {
                            this.lblError.setText("Maxsaldo skal være et heltal.");
                            return;
                        }

                        Controller.createPersonChip(this.gruppe, this.nr, navn, maxSaldoInt, alderInt);
                        this.nr++;

                        this.updateControls();
                    } else {
                        this.lblError.setText("Maxsaldo skal indtastes.");
                    }
                } else {
                    this.lblError.setText("Alder skal indtastes.");
                }
            } else {
                this.lblError.setText("Navn skal indtastes.");
            }
        }
    }

    private void addFacilitetToPersonAction () {
        PersonChip personChip = this.lvwPersonChips.getSelectionModel().getSelectedItem();
        Facilitet facilitet = this.lvwFaciliteter.getSelectionModel().getSelectedItem();

        if (personChip != null) {
            if (facilitet != null) {
                personChip.addFacilitet(facilitet);
            } else {
                this.lblError.setText("Venligst vælge et facilitet.");
            }
        } else {
            this.lblError.setText("Venligst vælge en person.");
        }
    }

    private void updateControls () {
        if (this.gruppe != null) {
            this.lvwPersonChips.getItems().setAll(this.gruppe.getPersonChips());
        }
        this.lvwFaciliteter.getItems().setAll(Controller.getFaciliteter());
    }
}
