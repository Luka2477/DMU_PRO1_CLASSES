package exercise_4;

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
        //this.drawShapes1(canvas.getGraphicsContext2D());
        //this.drawShapes2(canvas.getGraphicsContext2D());
        this.drawShapes3(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes1(GraphicsContext gc)
    {
        int radius = 20;
        int x = 100;
        int y = 100;
        while(radius <= 100) {
            gc.strokeOval(x - radius, y - radius, radius*2, radius*2);
            radius += 20;
        }
    }

    private void drawShapes2(GraphicsContext gc) {
        int radius = 10;
        int x = 20;
        int y = 100;
        while(radius <= 80) {
            gc.strokeOval(x - radius, y - radius, radius*2, radius*2);
            radius += 10;
            x += 10;
        }
    }

    private void drawShapes3(GraphicsContext gc) {
        int w = 20;
        int h = 50;
        int x = 100;
        int y = 100;
        while(w <= 100) {
            gc.strokeOval(x - w, y - h, w*2, h*2);
            w += 10;
        }
    }
}
