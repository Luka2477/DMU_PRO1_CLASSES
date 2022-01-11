package threeLayerArchitectureTemplate.gui;

import javafx.scene.control.*;
import threeLayerArchitectureTemplate.application.controller.Controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void init () {
        Controller.initStorage();
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

        // TODO GUI

        //--------------------------------------------------------------------------------------------------------------

        initControls();
    }

    private void javaFXDatatypeTemplates (GridPane pane) {
        // TODO REMEMBER TO DELETE BEFORE SUBMISSION

        TextField txf = new TextField();
        pane.add(txf, 0, 0);

        Label lbl = new Label("Template");
        pane.add(lbl, 0, 1);

        Button btn = new Button("Template");
        btn.setOnAction(event -> System.out.println("This is a template"));
        pane.add(btn, 0, 2);

        ListView<String> lvw = new ListView<>();
        lvw.setPrefSize(100, 200);
        lvw.getItems().setAll("hello", "to", "you", "this", "is", "a", "template");
        lvw.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.printf("The old value is %s and the new value is %s.%n", oldValue, newValue));
        pane.add(lvw, 0, 3);

        TextArea txa = new TextArea();
        txa.setPrefSize(200, 100);
        txa.setText("Hello\nThis is a template.");
        txa.setEditable(false);
        pane.add(txa, 0, 4);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void initControls () {
        // TODO
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateControls () {
        // TODO
    }

}
