package extra_programming.semesteropgave_jan_2016.gui;

import extra_programming.semesteropgave_jan_2016.application.controller.Service;
import extra_programming.semesteropgave_jan_2016.application.model.Bane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OpretBaneWindow extends Stage {

    private TextField txfNummer, txfInfo;

    private Bane bane;

    public OpretBaneWindow () {
        this.setTitle("Opret bane");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 0);

        this.txfNummer = new TextField();
        pane.add(this.txfNummer, 1, 0);

        Label lblInfo = new Label("Info:");
        pane.add(lblInfo, 0, 1);

        this.txfInfo = new TextField();
        pane.add(this.txfInfo, 1, 1);

        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOk = new Button("OK");
        btnOk.setOnAction(event -> this.okAction());

        HBox hBox = new HBox(btnCancel, btnOk);
        hBox.setSpacing(10);
        pane.add(hBox, 0, 2);
    }

    private void cancelAction () {
        this.hide();
    }

    private void okAction () {
        String nummer = this.txfNummer.getText().trim();
        String info = this.txfInfo.getText().trim();

        int num;
        try {
            num = Integer.parseInt(nummer);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return;
        }

        this.bane = Service.createBane(num, info);

        this.hide();
    }

    public Bane getBane () {
        return this.bane;
    }

}
