package extra_programming.semesteropgave_jan_2014.gui;

import extra_programming.semesteropgave_jan_2014.application.controller.Controller;
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
        stage.setTitle("Arrangements administration");
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

        
    }
}
