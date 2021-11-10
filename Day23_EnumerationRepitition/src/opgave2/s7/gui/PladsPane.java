package opgave2.s7.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import opgave2.s7.application.controller.Controller;
import opgave2.s7.application.model.Omraade;
import opgave2.s7.application.model.Plads;

public class PladsPane extends Application {

    @Override
    public void init () {
        Controller.init();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Netcafe Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // ----------------------------------------------------------------

    private ListView<Plads> lvwPladser;
    private ToggleGroup tglGroup;
    private TextField txfNummer;
    private Label lblError;

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblPladser = new Label("Pladser:");
        pane.add(lblPladser, 0, 0);

        this.lvwPladser = new ListView<>();
        this.lvwPladser.setPrefSize(200, 300);
        this.lvwPladser.getItems().setAll(Controller.getPladser());
        pane.add(this.lvwPladser, 0, 1, 3, 1);

        Label lblOmraade = new Label("Område:");
        pane.add(lblOmraade, 0, 2);

        String[] radioButtonLabels = {"Standard", "VIP", "Børne", "Turnering"};
        Omraade[] radioButtonValues = {Omraade.STANDARD, Omraade.VIP, Omraade.BOERNE, Omraade.TURNERING};

        this.tglGroup = new ToggleGroup();

        VBox vBox = new VBox();
        pane.add(vBox, 2, 2);

        for (int i=0; i<radioButtonLabels.length; i++) {
            RadioButton rdoButton = new RadioButton();
            rdoButton.setText(radioButtonLabels[i]);
            rdoButton.setUserData(radioButtonValues[i]);
            rdoButton.setToggleGroup(this.tglGroup);
            vBox.getChildren().add(rdoButton);
        }

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 3);

        this.txfNummer = new TextField();
        pane.add(txfNummer, 1, 3, 2, 1);

        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> this.opretAction());
        pane.add(btnOpret, 1, 4);

        this.lblError = new Label();
        this.lblError.setStyle("-fx-text-fill: red;");
        pane.add(this.lblError, 0, 5, 3, 1);
    }

    // -----------------------------------------------------------------------------------

    private void opretAction () {
        Omraade omraade;
        try {
            RadioButton rdoButton = (RadioButton) this.tglGroup.getSelectedToggle();
            omraade = (Omraade) rdoButton.getUserData();
        } catch (Exception ex) {
            this.lblError.setText("Venligst vælg et område!");
            return;
        }

        int nummer;
        try {
            nummer = Integer.parseInt(this.txfNummer.getText().trim());
        } catch (NumberFormatException ex) {
            this.lblError.setText("Venligst angive et gyldigt nummer!");
            return;
        }

        Controller.createPlads(nummer, omraade);

        this.clearPane();
        this.updatePane();
    }

    private void clearPane () {
        this.tglGroup.getSelectedToggle().setSelected(false);
        this.txfNummer.clear();
        this.lblError.setText("");
    }

    private void updatePane () {
        this.lvwPladser.getItems().setAll(Controller.getPladser());
    }
}
