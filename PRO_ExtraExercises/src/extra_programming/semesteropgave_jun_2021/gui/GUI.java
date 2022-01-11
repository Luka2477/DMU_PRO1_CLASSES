package extra_programming.semesteropgave_jun_2021.gui;

import extra_programming.semesteropgave_jun_2021.application.controller.Controller;
import extra_programming.semesteropgave_jun_2021.application.model.Kamp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GUI extends Application {

    private ListView<Kamp> lvwKampe;
    private TextField txfSted, txfDato, txfTid;
    private Button btnOpdater, btnLavFil;
    private Label lblError;

    private Kamp kamp;

    @Override
    public void init () {
        Controller.createSomeObjects();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Administration af tutorer og arrangementer");
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
        pane.setGridLinesVisible(false);

        //--------------------------------------------------------------------------------------------------------------

        pane.add(new Label("Kampe"), 0, 0);

        this.lvwKampe = new ListView<>();
        this.lvwKampe.setPrefSize(200, 100);
        this.lvwKampe.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.kampSelected(newValue));
        pane.add(this.lvwKampe, 0, 1, 1, 5);

        pane.add(new Label("Spillested:"), 1, 0);
        pane.add(new Label("Spilledato:"), 1, 1);
        pane.add(new Label("Spilletid:"), 1, 2);

        this.txfSted = new TextField();
        pane.add(this.txfSted, 2, 0);

        this.txfDato = new TextField();
        pane.add(this.txfDato, 2, 1);

        this.txfTid = new TextField();
        pane.add(this.txfTid, 2, 2);

        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> this.opretAction());

        this.btnOpdater = new Button("Opdater");
        this.btnOpdater.setDisable(true);
        this.btnOpdater.setOnAction(event -> this.opdaterAction());

        HBox hBox = new HBox(btnOpret, this.btnOpdater);
        hBox.setSpacing(10);
        pane.add(hBox, 2, 3);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        pane.add(this.lblError, 2, 4);

        this.btnLavFil = new Button("Lav fil");
        this.btnLavFil.setDisable(true);
        this.btnLavFil.setOnAction(event -> this.lavFilAction());
        pane.add(this.btnLavFil, 2, 5);

        //--------------------------------------------------------------------------------------------------------------

        this.updateKampe();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void kampSelected (Kamp newKamp) {
        this.kamp = newKamp;

        this.updateControls();
    }

    //------------------------------------------------------------------------------------------------------------------

    private boolean validateInput () {
        String sted = this.txfSted.getText().trim();
        String dato = this.txfDato.getText().trim();
        String tid = this.txfTid.getText().trim();

        if (!sted.isEmpty()) {
            if (!dato.isEmpty()) {
                try {
                    LocalDate.parse(dato);
                } catch (DateTimeParseException ex) {
                    this.lblError.setText("Spilledato skal være i åååå-mm-dd format");
                    return false;
                }

                if (!tid.isEmpty()) {
                    try {
                        LocalTime.parse(tid);
                    } catch (DateTimeParseException ex) {
                        this.lblError.setText("Spilletid skal være i tt-mm format");
                        return false;
                    }

                    return true;
                } else {
                    this.lblError.setText("Spilletid skal være udfyldt");
                }
            } else {
                this.lblError.setText("Spilledato skal være udfyldt");
            }
        } else {
            this.lblError.setText("Spillested skal være udfyldt");
        }

        return false;
    }

    private void opretAction () {
        if (this.validateInput()) {
            String sted = this.txfSted.getText().trim();
            LocalDate dato = LocalDate.parse(this.txfDato.getText().trim());
            LocalTime tid = LocalTime.parse(this.txfTid.getText().trim());

            this.kamp = Controller.createKamp(sted, dato, tid);
            this.lvwKampe.getItems().add(this.kamp);
        }
    }

    private void opdaterAction () {
        if (this.validateInput()) {
            String sted = this.txfSted.getText().trim();
            LocalDate dato = LocalDate.parse(this.txfDato.getText().trim());
            LocalTime tid = LocalTime.parse(this.txfTid.getText().trim());

            Controller.updateKamp(this.kamp, sted, dato, tid);
            this.lvwKampe.getItems().set(this.lvwKampe.getSelectionModel().getSelectedIndex(), this.kamp);
        }
    }

    private void lavFilAction () {
        this.kamp.spillerHonorar("pro_extraexercises/src/extra_programming/semesteropgave_jun_2021/textfiler/" + this.kamp.getSted().toLowerCase() + ".txt");
    }

    //------------------------------------------------------------------------------------------------------------------

    private void clearKampe () {
        this.lvwKampe.getItems().clear();
    }

    private void clearControls () {
        this.txfSted.clear();
        this.txfDato.clear();
        this.txfTid.clear();
        this.lblError.setText("");

        this.btnOpdater.setDisable(true);
        this.btnLavFil.setDisable(true);
    }

    private void updateKampe () {
        this.lvwKampe.getItems().setAll(Controller.getKampe());
    }

    private void updateControls () {
        this.clearControls();

        if (this.kamp != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            this.txfSted.setText(kamp.getSted());
            this.txfDato.setText(kamp.getDato().format(dtf));
            this.txfTid.setText(kamp.getTid().toString());

            this.btnOpdater.setDisable(false);
            this.btnLavFil.setDisable(false);
        }
    }

}
