package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField firstSplit = new TextField();
    private final TextField secondSplit = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        TextField fullName = new TextField();
        pane.add(fullName, 0, 0, 2, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(this.firstSplit, 0, 1);
        pane.add(this.secondSplit, 1, 1);
   

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Split");
        pane.add(btnUpperCase, 0, 2);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnUpperCase.setOnAction(event -> this.splitAction(fullName.getText().trim()));
    }

    // -------------------------------------------------------------------------

    private void splitAction(String fullName) {
        String[] temp = fullName.split(" ");
        this.firstSplit.setText(temp[0]);
        this.secondSplit.setText(temp[1]);
    }
}
