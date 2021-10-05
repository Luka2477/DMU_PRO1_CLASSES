package exercise_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        int x = 10;
        double y = gc.getCanvas().getHeight() - 30;
        double offset = gc.getCanvas().getWidth() / 12;
        int tickHalfHeight = 5;

        for(int i=0; i<11; i++) {
            if(i % 5 == 0) {
                gc.strokeLine(x, y + tickHalfHeight * 2, x, y - tickHalfHeight * 2);
                gc.fillText(""+i, x, y + 20);
            } else {
                gc.strokeLine(x, y + tickHalfHeight, x, y - tickHalfHeight);
            }

            x += offset;
        }

        gc.strokeLine(0, y, x, y);
        gc.strokeLine(x, y, x-10, y-5);
        gc.strokeLine(x, y, x-10, y+5);
    }
}
