package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle circle1 = new Circle(70, 70, 15);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.BLACK);

        Circle circle2 = new Circle(70, 70, 30);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.rgb(25, 25, 150, 0));
        circle2.setStroke(Color.BLACK);
    }
}
