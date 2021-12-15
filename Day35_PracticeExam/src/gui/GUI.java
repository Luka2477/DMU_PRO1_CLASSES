package gui;

import application.controller.Controller;
import application.model.Bil;
import application.model.Bilmærke;
import application.model.Parkeringshus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private ListView<Parkeringshus> lvwParkeringshuse;
    private ListView<String> lvwOptagePladser;
    private TextField txfBilNummer;
    private Button btnOpret;

    private Parkeringshus parkeringshus;

    @Override
    public void init () {
        Controller.initStorage();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Parkeringshuse og pladser");
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

        Label lblParkeringshuse = new Label("Parkeringshuse");
        pane.add(lblParkeringshuse, 0, 0);

        this.lvwParkeringshuse = new ListView<>();
        this.lvwParkeringshuse.setPrefSize(200, 100);
        this.lvwParkeringshuse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.parkeringshusSelected(newValue));
        this.lvwParkeringshuse.getItems().setAll(Controller.getParkeringshuse());
        pane.add(this.lvwParkeringshuse, 0, 1);

        Label lblOpretBil = new Label("Opret bil med nummer:");
        pane.add(lblOpretBil, 0, 2);

        Label lblOptagnePladser = new Label("Optagne pladser");
        pane.add(lblOptagnePladser, 1, 0);

        this.lvwOptagePladser = new ListView<>();
        this.lvwOptagePladser.setPrefSize(250, 200);
        pane.add(this.lvwOptagePladser, 1, 1);

        this.txfBilNummer = new TextField();
        this.txfBilNummer.setDisable(true);
        pane.add(this.txfBilNummer, 1, 2);

        this.btnOpret = new Button("Opret");
        this.btnOpret.setOnAction(event -> this.opretBilAction());
        this.btnOpret.setDisable(true);
        pane.add(this.btnOpret, 1, 3);
    }

    private void parkeringshusSelected (Parkeringshus newParkeringshus) {
        this.parkeringshus = newParkeringshus;

        this.updateOptagnePladser();
        this.clearOpretBil();
        this.disableOpretBil(false);
    }

    private void updateOptagnePladser () {
        if (this.parkeringshus != null) {
            this.lvwOptagePladser.getItems().setAll(this.parkeringshus.optagnePladser());
        }
    }

    private void disableOpretBil (boolean disable) {
        this.txfBilNummer.setDisable(disable);
        this.btnOpret.setDisable(disable);
    }

    private void clearOpretBil () {
        this.txfBilNummer.clear();
    }

    private void opretBilAction () {
        String regNummer = this.txfBilNummer.getText().trim();

        if (!regNummer.isEmpty()) {
            Bil bil = Controller.createBil(regNummer, Bilmærke.VW);
            Controller.parkerBil(this.parkeringshus, bil);
        }

        this.updateOptagnePladser();
        this.clearOpretBil();
    }

}
