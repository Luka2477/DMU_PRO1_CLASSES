package opgave5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    private final TextField fahrenheit = new TextField();
    private final TextField celcius = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblFahrenheit = new Label("Fahrenheit:");
        pane.add(lblFahrenheit, 0, 0);

        Label lblCelcius = new Label("Celcius:");
        pane.add(lblCelcius, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(this.fahrenheit, 1, 0);
        pane.add(this.celcius, 1, 1);

        this.fahrenheit.setOnKeyPressed(this::celciusAction);
        this.celcius.setOnKeyPressed(this::fahrenheitAction);
    }

    // -------------------------------------------------------------------------

    private void fahrenheitAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            double temp = !this.celcius.getText().isEmpty()
                    ? Double.parseDouble(this.celcius.getText())
                    : 0;
            if (temp != 0)
                this.fahrenheit.setText(Double.toString(9 / 5.0 * temp + 32));
        }
    }

    private void celciusAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            double temp = !this.fahrenheit.getText().isEmpty()
                    ? Double.parseDouble(this.fahrenheit.getText())
                    : 0;
            if (temp != 0)
                this.celcius.setText(Double.toString(5 * (temp - 32) / 9));
        }
    }
}
