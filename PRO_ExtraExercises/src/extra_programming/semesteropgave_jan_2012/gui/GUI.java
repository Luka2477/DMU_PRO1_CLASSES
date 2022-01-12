package extra_programming.semesteropgave_jan_2012.gui;

import extra_programming.semesteropgave_jan_2012.application.controller.Controller;
import extra_programming.semesteropgave_jan_2012.application.model.Hold;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {

    private ListView<Hold> lvwHold;
    private TextField txfNavn, txfDisciplin, txfMaxAntal, txfAdresse, txfAntal;
    private Button btnOpdater, btnAntalMedAdresse;
    private Label lblError;

    private Hold hold;

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

        pane.add(new Label("Hold"), 0, 0);

        this.lvwHold = new ListView<>();
        this.lvwHold.setPrefSize(200, 200);
        this.lvwHold.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.holdSelected(newValue));
        pane.add(this.lvwHold, 0, 1, 1, 5);

        pane.add(new Label("Navn:"), 1, 0);
        pane.add(new Label("Disciplin:"), 1, 1);
        pane.add(new Label("Max Antal:"), 1, 2);
        pane.add(new Label("Adresse:"), 1, 4);
        pane.add(new Label("Antal med adresse:"), 1, 5);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 2, 0);

        this.txfDisciplin = new TextField();
        pane.add(this.txfDisciplin, 2, 1);

        this.txfMaxAntal = new TextField();
        pane.add(this.txfMaxAntal, 2, 2);

        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> this.opretAction());

        this.btnOpdater = new Button("Opdater");
        this.btnOpdater.setDisable(true);
        this.btnOpdater.setOnAction(event -> this.opdaterAction());

        Button btnClear = new Button("Ryd");
        btnClear.setOnAction(event -> this.clearAction());

        HBox hBoxBtn = new HBox(btnOpret, this.btnOpdater, btnClear);
        hBoxBtn.setSpacing(10);
        pane.add(hBoxBtn, 2, 3);

        this.txfAdresse = new TextField();
        this.txfAdresse.setDisable(true);

        this.btnAntalMedAdresse = new Button("Find");
        this.btnAntalMedAdresse.setDisable(true);
        this.btnAntalMedAdresse.setOnAction(event -> this.antalMedAdresseAction());

        HBox hBoxAdresse = new HBox(this.txfAdresse, this.btnAntalMedAdresse);
        hBoxAdresse.setSpacing(10);
        pane.add(hBoxAdresse, 2, 4);

        this.txfAntal = new TextField();
        this.txfAntal.setEditable(false);
        pane.add(this.txfAntal, 2, 5);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        this.lblError.setWrapText(true);
        pane.add(this.lblError, 0, 6, 3, 1);

        //--------------------------------------------------------------------------------------------------------------

        this.updateHold();
    }

    //------------------------------------------------------------------------------------------------------------------

    private void holdSelected (Hold hold) {
        this.hold = hold;

        this.updateControls();
    }

    //------------------------------------------------------------------------------------------------------------------

    private boolean validateInput () {
        String navn = this.txfNavn.getText().trim();
        String disciplin = this.txfDisciplin.getText().trim();
        String maxAntal = this.txfMaxAntal.getText().trim();

        if (!navn.isEmpty() && !disciplin.isEmpty() && !maxAntal.isEmpty()) {
            try {
                Integer.parseInt(maxAntal);
                return true;
            } catch (NumberFormatException ex) {
                this.lblError.setText("Max antal skal være et heltal");
                return false;
            }
        } else {
            this.lblError.setText("Alle felter skal være udfyldt");
        }

        return false;
    }

    private void opretAction () {
        if (this.validateInput()) {
            String navn = this.txfNavn.getText().trim();
            String disciplin = this.txfDisciplin.getText().trim();
            int maxAntal = Integer.parseInt(this.txfMaxAntal.getText().trim());

            Controller.createHold(navn, disciplin, maxAntal);
            this.clearAction();
            this.updateHold();
        }
    }

    private void opdaterAction () {
        if (this.validateInput()) {
            String navn = this.txfNavn.getText().trim();
            String disciplin = this.txfDisciplin.getText().trim();
            int maxAntal = Integer.parseInt(this.txfMaxAntal.getText().trim());

            Controller.updateHold(this.hold, navn, disciplin, maxAntal);
            this.clearAction();
            this.updateHold();
        }
    }

    private void clearAction () {
        this.txfNavn.clear();
        this.txfDisciplin.clear();
        this.txfMaxAntal.clear();
        this.txfAntal.clear();
        this.lblError.setText("");
    }

    private void antalMedAdresseAction () {
        String adresse = this.txfAdresse.getText().trim();

        if (!adresse.isEmpty()) {
            this.txfAntal.setText(Integer.toString(this.hold.getAntalTilmeldinger(adresse)));
        } else {
            this.lblError.setText("Adresse skal være udfyldt");
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private void disableHoldBtns (boolean disable) {
        this.btnOpdater.setDisable(disable);
        this.btnAntalMedAdresse.setDisable(disable);
        this.txfAdresse.setDisable(disable);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateHold () {
        this.lvwHold.getItems().setAll(Controller.getAlleHold());
    }

    private void updateControls () {
        boolean holdIsNull = this.hold == null;
        this.disableHoldBtns(holdIsNull);

        if (!holdIsNull) {
            this.txfNavn.setText(this.hold.getNavn());
            this.txfDisciplin.setText(this.hold.getDisciplin());
            this.txfMaxAntal.setText(Integer.toString(this.hold.getMaxAntal()));
        }
    }

}
