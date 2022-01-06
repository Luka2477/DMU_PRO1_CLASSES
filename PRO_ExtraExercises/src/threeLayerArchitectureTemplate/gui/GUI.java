package threeLayerArchitectureTemplate.gui;

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

    //------------------------------------------------------------------------------------------------------------------

    private void initControls () {
        // TODO
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateControls () {
        // TODO
    }

}
