package extra_programming.semesteropgave_jan_2016.gui;

import extra_programming.semesteropgave_jan_2016.application.controller.Service;
import extra_programming.semesteropgave_jan_2016.application.model.Bane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GUI extends Application {

    private DatePicker dtpDato;
    private ListView<Bane> lvwBaner;
    private ListView<String> lvwLedigeTider;

    private LocalDate date;
    private Bane bane;

    @Override
    public void init () {
        Service.initStorage();
    }

    @Override
    public void start (Stage stage) {
        stage.setTitle("Booking af tennisbaner");
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

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);

        this.dtpDato = new DatePicker();
        this.dtpDato.valueProperty().addListener((observable, oldValue, newValue) -> this.onDatePicked(newValue));
        pane.add(this.dtpDato, 0, 1);

        Label lblBaner = new Label("Baner:");
        pane.add(lblBaner, 0, 2);

        this.lvwBaner = new ListView<>();
        this.lvwBaner.setPrefSize(200, 200);
        this.lvwBaner.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.onBanerPicked(newValue));
        pane.add(lvwBaner, 0, 3);

        Button btnOpretBane = new Button("Opret bane");
        btnOpretBane.setOnAction(event -> this.opretBaneAction());
        pane.add(btnOpretBane, 0, 4);

        Label lblLedigeTider = new Label("Ledige tider:");
        pane.add(lblLedigeTider, 1, 0);

        this.lvwLedigeTider = new ListView<>();
        this.lvwLedigeTider.setPrefWidth(100);
        pane.add(lvwLedigeTider, 1, 1, 1, 3);

        this.initControls();
    }

    private void initControls () {
        this.lvwBaner.getItems().setAll(Service.getBaner());
    }

    private void updateLedigeTider () {
        if (this.bane != null && this.date != null) {
            ArrayList<String> ledigeTider = new ArrayList<>();

            for (LocalTime localTime : this.bane.getLedigeTiderPaaDag(this.date)) {
                ledigeTider.add(localTime.format(DateTimeFormatter.ofPattern("HH:mm")));
            }

            this.lvwLedigeTider.getItems().setAll(ledigeTider);
        }
    }

    private void onDatePicked (LocalDate date) {
        this.date = date;

        this.updateLedigeTider();
    }

    private void onBanerPicked (Bane bane) {
        this.bane = bane;

        this.updateLedigeTider();
    }

    private void opretBaneAction () {
        OpretBaneWindow dia = new OpretBaneWindow();
        dia.showAndWait();

        this.initControls();
        this.bane = dia.getBane();
        this.lvwBaner.getSelectionModel().select(this.bane);
        this.updateLedigeTider();
    }
}
