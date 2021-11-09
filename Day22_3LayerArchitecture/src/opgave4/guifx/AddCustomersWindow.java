package opgave4.guifx;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import opgave4.application.controller.Controller;
import opgave4.application.model.Company;
import opgave4.application.model.Customer;

public class AddCustomersWindow extends Stage {

    private final Company company;

    public AddCustomersWindow (String title, Company company) {
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

    private Label lblHeader, lblError;
    private ListView<Customer> lvwCustomers;

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        this.lblHeader = new Label();
        pane.add(this.lblHeader, 0, 0);
        this.lblHeader.setFont(new Font(20));

        Label lblCustomers = new Label("Customers");
        pane.add(lblCustomers, 0, 1);

        this.lvwCustomers = new ListView<>();
        pane.add(this.lvwCustomers, 0, 2);
        this.lvwCustomers.setPrefWidth(200);
        this.lvwCustomers.setPrefHeight(200);
        this.lvwCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
        this.lblHeader.setText("Adding customers to " + this.company.getName());

        for (Customer customer : Controller.getCustomers()) {
            if (!this.company.getCustomers().contains(customer)) {
                this.lvwCustomers.getItems().add(customer);
            }
        }
    }

    // -----------------------------------------------------------------------

    private void cancelAction () {
        this.hide();
    }

    private void okAction () {
        ObservableList<Customer> customers = this.lvwCustomers.getSelectionModel().getSelectedItems();

        if (customers.size() <= 0) {
            this.lblError.setText("You have to choose customers to add");
        } else {
            for (Customer customer : customers) {
                Controller.addCustomerToCompany(customer, this.company);
            }

            this.hide();
        }
    }
}
