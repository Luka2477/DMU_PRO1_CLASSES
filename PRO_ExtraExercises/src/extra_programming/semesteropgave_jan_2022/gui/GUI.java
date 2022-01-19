package extra_programming.semesteropgave_jan_2022.gui;

import extra_programming.semesteropgave_jan_2022.application.controller.Controller;
import extra_programming.semesteropgave_jan_2022.application.model.Loeb;
import extra_programming.semesteropgave_jan_2022.application.model.Note;
import extra_programming.semesteropgave_jan_2022.application.model.Tilmelding;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {

    private ListView<Loeb> lvwLøb;
    private ListView<Tilmelding> lvwTilmeldinger;
    private TextArea txaNoter;
    private Button btnVinder, btnRegistrerNote;
    private TextField txfVinder, txfForhindringsNavn, txfStrafSekunder;
    private Label lblError;

    private Loeb løb;
    private Tilmelding tilmelding;

    @Override
    public void init () {
        Controller.initStorage();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("OCR Administrationssystem");
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

        pane.add(new Label("Løb"), 0, 0);
        pane.add(new Label("Tilmeldinger"), 1, 0);
        pane.add(new Label("Noter"), 2, 0);

        this.lvwLøb = new ListView<>();
        this.lvwLøb.setPrefSize(200, 200);
        this.lvwLøb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.løbSelected(newValue));
        pane.add(this.lvwLøb, 0, 1);

        this.lvwTilmeldinger = new ListView<>();
        this.lvwTilmeldinger.setPrefSize(200, 200);
        this.lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.tilmeldingSelected(newValue));
        pane.add(this.lvwTilmeldinger, 1, 1);

        this.txaNoter = new TextArea();
        this.txaNoter.setPrefSize(200, 200);
        this.txaNoter.setEditable(false);
        pane.add(this.txaNoter, 2, 1);

        this.btnVinder = new Button("Vinder");
        this.btnVinder.setDisable(true);
        this.btnVinder.setOnAction(event -> this.vinderAction());

        this.txfVinder = new TextField();
        this.txfVinder.setEditable(false);
        this.txfVinder.setDisable(true);

        HBox hBoxVinder = new HBox(this.btnVinder, this.txfVinder);
        hBoxVinder.setSpacing(10);
        pane.add(hBoxVinder, 0, 2);

        Label lblForhindringsNavn = new Label("Navn forhindring:");

        this.txfForhindringsNavn = new TextField();
        this.txfForhindringsNavn.setDisable(true);

        HBox hBoxForhindring = new HBox(lblForhindringsNavn, this.txfForhindringsNavn);
        hBoxForhindring.setSpacing(10);
        pane.add(hBoxForhindring, 1, 2);

        Label lblStrafSekunder = new Label("Straf sekunder:");

        this.txfStrafSekunder = new TextField();
        this.txfStrafSekunder.setDisable(true);

        HBox hBoxStrafSekunder = new HBox(lblStrafSekunder, this.txfStrafSekunder);
        hBoxStrafSekunder.setSpacing(10);
        pane.add(hBoxStrafSekunder, 1, 3);

        this.btnRegistrerNote = new Button("Registrer note");
        this.btnRegistrerNote.setDisable(true);
        this.btnRegistrerNote.setOnAction(event -> registrerNoteAction());
        pane.add(this.btnRegistrerNote, 2, 3);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        this.lblError.setWrapText(true);
        pane.add(this.lblError, 0, 4, 3, 1);

        //--------------------------------------------------------------------------------------------------------------

        updateLøb();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void løbSelected (Loeb løb) {
        this.løb = løb;

        this.updateTilmeldinger();
        this.updateControls();
    }

    private void tilmeldingSelected (Tilmelding tilmelding) {
        this.tilmelding = tilmelding;

        this.updateNoter();
        this.updateControls();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void vinderAction () {
        this.txfVinder.setText(this.løb.getVinder());
    }

    private void registrerNoteAction () {
        String forhindringsNavn = this.txfForhindringsNavn.getText().trim();
        String strafSekunder = this.txfStrafSekunder.getText().trim();

        if (!forhindringsNavn.isEmpty() && !strafSekunder.isEmpty()) {
            try {
                int strafSekunderInt = Integer.parseInt(strafSekunder);

                this.registrerNote(forhindringsNavn, strafSekunderInt);
            } catch (NumberFormatException ex) {
                this.lblError.setText("Straf sekunder skal være et heltal");
            }
        } else {
            this.lblError.setText("Navn og straf sekunder skal være udfyldt");
        }
    }

    private void registrerNote (String forhindringsNavn, int strafSekunder) {
        if (Controller.createNote(this.tilmelding, strafSekunder, forhindringsNavn) != null) {
            this.clearError();
            this.clearForhindringControls();
            this.updateNoter();
        } else {
            this.lblError.setText("Forhindring kunne ikke findes");
        }
    }

                                //------------------------------------------------------------------------------------------------------------------

    private void disableVinderControls (boolean disable) {
        this.btnVinder.setDisable(disable);
        this.txfVinder.setDisable(disable);
    }

    private void disableForhindringControls (boolean disable) {
        this.txfForhindringsNavn.setDisable(disable);
        this.txfStrafSekunder.setDisable(disable);
        this.btnRegistrerNote.setDisable(disable);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void clearForhindringControls () {
        this.txfForhindringsNavn.clear();
        this.txfStrafSekunder.clear();
    }

    private void clearError () {
        this.lblError.setText("");
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateLøb () {
        this.lvwLøb.getItems().setAll(Controller.getLøb());
    }

    private void updateTilmeldinger () {
        if (this.løb != null) {
            this.lvwTilmeldinger.getItems().setAll(this.løb.getTilmeldinger());
        }
    }

    private void updateNoter () {
        StringBuilder builder = new StringBuilder();

        if (this.tilmelding != null) {
            for (Note note : this.tilmelding.getNoter()) {
                builder.append(note).append("\n");
            }
        }

        this.txaNoter.setText(builder.toString());
    }

    private void updateControls () {
        this.disableVinderControls(this.løb == null);
        this.disableForhindringControls(this.tilmelding == null);
    }

}
