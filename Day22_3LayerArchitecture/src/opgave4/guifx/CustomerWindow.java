package opgave4.guifx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import opgave4.application.controller.Controller;
import opgave4.application.model.Company;

public class CustomerWindow extends Stage {

    private final Company company;

    public CustomerWindow (String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // ---------------------------------------------------------------------

    private TextField txfName;
    private Label lblHeader, lblError;

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        this.lblHeader = new Label();
        pane.add(this.lblHeader, 0, 0);
        this.lblHeader.setFont(new Font(20));

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 1);

        this.txfName = new TextField();
        pane.add(this.txfName, 0, 2);
        this.txfName.setPrefWidth(200);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 3);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());
        btnCancel.setCancelButton(true);

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 3);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
        btnOK.setDefaultButton(true);

        this.lblError = new Label();
        pane.add(this.lblError, 0, 4);
        this.lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls () {
        this.lblHeader.setText("Creating customer for " + this.company.getName());
        this.txfName.clear();
    }

    // -----------------------------------------------------------------------

    private void cancelAction () {
        this.hide();
    }

    private void okAction () {
        String name = this.txfName.getText().trim();

        if (name.isEmpty()) {
            this.lblError.setText("Name can not be empty");
        } else {
            Controller.createCustomer(name, company);

            this.hide();
        }
    }
}
