package opgaver_i_noter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Polygon;
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
        //this.opgave1(pane);
        //this.opgave2(pane);
        this.opgave3(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void opgave1(Pane pane) {
        Circle circle = new Circle(pane.getPrefWidth() / 2, pane.getPrefHeight() / 4, 50);
        Rectangle rectangle = new Rectangle(pane.getPrefWidth() / 2 - 100, pane.getPrefHeight() / 4 * 3 - 50, 200, 100);
        Line line = new Line(0, pane.getPrefHeight() / 2, pane.getPrefWidth(), pane.getPrefHeight() / 2);

        javafx.scene.shape.Shape[] shapeArray = {circle, rectangle, line};

        circle.setFill(Color.BLUE);
        rectangle.setFill(Color.RED);

        for(javafx.scene.shape.Shape shape : shapeArray) {
            pane.getChildren().add(shape);
        }
    }

    private void opgave2(Pane pane) {
        int coordinate_x = 100;
        int coordinate_y = 0;
        Color shape_color = Color.YELLOW;

        Circle circle = new Circle(coordinate_x, coordinate_y + 50, 50);
        Rectangle rectangle = new Rectangle(coordinate_x, coordinate_y + 100, 200, 100);
        Line line = new Line(coordinate_x, coordinate_y + 200, pane.getPrefWidth(), coordinate_y + 200);

        Shape[] shapeArray = {circle, rectangle, line};

        for (Shape shape : shapeArray) {
            shape.setFill(shape_color);
            pane.getChildren().add(shape);
        }
    }

    private void opgave3(Pane pane) {
        Color background_color = Color.DEEPSKYBLUE;
        int house_width = 120;
        int house_height = 120;
        int house_x = 60;
        int house_y = 200;
        Color house_color = Color.RED;
        int roof_overhang = 30;
        int roof_width = house_width + roof_overhang * 2;
        int roof_height = house_height / 2;
        int roof_bottom_left_x = house_x - roof_overhang;
        Color roof_color = Color.GREEN;
        int window_size = 50;
        int window_x = house_x + house_width / 5;
        int window_y = house_y + house_height / 5;
        Color window_color = Color.BLACK;
        int sun_radius = 35;
        int sun_x = 300;
        int sun_y = 100;
        Color sun_color = Color.YELLOW;
        Color garden_color = Color.DARKOLIVEGREEN;

        Rectangle background = new Rectangle(0, 0, pane.getPrefWidth(), pane.getPrefHeight());
        Rectangle house = new Rectangle(house_x, house_y, house_width, house_height);
        Rectangle window = new Rectangle(window_x, window_y, window_size, window_size);
        Polygon roof = new Polygon(
                roof_bottom_left_x, house_y,
                roof_bottom_left_x + roof_width / 2.0, house_y - roof_height,
                roof_bottom_left_x + roof_width, house_y);
        Circle sun = new Circle(sun_x, sun_y, sun_radius);
        Rectangle garden = new Rectangle(
                0, house_y + house_height,
                pane.getPrefWidth(), pane.getPrefHeight() - (house_y + house_height));

        Shape[] shapes_array = {background, house, window, roof, sun, garden};
        Color[] colors_array = {background_color, house_color, window_color, roof_color, sun_color, garden_color};

        for(int i = 0; i < shapes_array.length; i++) {
            shapes_array[i].setFill(colors_array[i]);
            shapes_array[i].setStroke(Color.BLACK);
            shapes_array[i].setStrokeWidth(2);
            pane.getChildren().add(shapes_array[i]);
        }
    }
}
