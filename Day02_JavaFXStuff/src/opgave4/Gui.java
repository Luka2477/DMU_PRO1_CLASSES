package opgave4;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		Pane root = initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(1600, 900);
		drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		// Define and initialize all variables
		Color background_color = Color.BLACK;
		double center_x = pane.getPrefWidth() / 2; // Define a variable for the x-coordinate of the center of the screen,
		double center_y = pane.getPrefHeight() / 2; // because it is used multiple times.
		double planet_offset = center_x / 10; // Define standard space between planets.
		double mercury_rotational_force = 58.6667; // Used to calculate the time spent for a full rotation.
		double mercury_velocity = 1.607; // Used to calculate the speed the planet should traverse its path.
		double venus_rotational_force = 243.0181;
		double venus_velocity = 1.174;
		double earth_rotational_force = 1;
		double earth_velocity = 1;
		double mars_rotational_force = 1.0388;
		double mars_velocity = 0.802;
		double jupiter_rotational_force = 0.4132;
		double jupiter_velocity = 0.434;
		double saturn_rotational_force = 0.4396;
		double saturn_velocity = 0.323;
		double uranus_rotational_force = 0.7181;
		double uranus_velocity = 0.228;
		double neptune_rotational_force = 0.6667;
		double neptune_velocity = 0.182;

		// Define and initialize a rectangle covering the whole screen. Used as a background.
		Rectangle background = new Rectangle(0, 0, pane.getPrefWidth(), pane.getPrefHeight());
		background.setFill(background_color);
		pane.getChildren().add(background);

		// Groups are used to store all stars and planets, so they can be added to the pane object later.
		Group group_stars = generateStars(pane);
		Group group_planets = new Group();

		Circle sun = new Circle(center_x, center_y, 50);
		Circle mercury = new Circle(center_x + planet_offset * 1, center_y, 10);
		Circle venus = new Circle(center_x + planet_offset * 2, center_y, 15);
		Circle earth = new Circle(center_x + planet_offset * 3, center_y, 20);
		Circle mars = new Circle(center_x + planet_offset * 4, center_y, 15);
		Circle jupiter = new Circle(center_x + planet_offset * 5, center_y, 30);
		Circle saturn = new Circle(center_x + planet_offset * 6.5, center_y, 30);
		Circle uranus = new Circle(center_x + planet_offset * 7.5, center_y, 21);
		Circle neptune = new Circle(center_x + planet_offset * 8.5, center_y, 18);

		// I'm using arrays to store the different variables, so I can iterate through them and call the
		// generatePlanet method on each element of the arrays.
		// This looks better than calling the generatePlanets method 9 times, but may be slower for larger datasets.
		Circle[] array_planets = {sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune};
		String[] array_image_filenames = {
				"sun.jpg",
				"mercury.png",
				"venus.jpg",
				"earth.jpg",
				"mars.jpg",
				"jupiter.jpg",
				"saturn.jpg",
				"uranus.jpg",
				"neptune.jpg"
		};
		double[] array_rotational_forces = {
				0,
				mercury_rotational_force,
				venus_rotational_force,
				earth_rotational_force,
				mars_rotational_force,
				jupiter_rotational_force,
				saturn_rotational_force,
				uranus_rotational_force,
				neptune_rotational_force
		};
		double[] array_velocities = {
				0,
				mercury_velocity,
				venus_velocity,
				earth_velocity,
				mars_velocity,
				jupiter_velocity,
				saturn_velocity,
				uranus_velocity,
				neptune_velocity
		};

		// Iterate from index 0 to the length of the planets array, then call the generatePlanet method
		// with the respective data stored in the separate arrays
		for(int i = 0; i < array_planets.length; i++) {
			generatePlanet(pane, array_planets[i], array_image_filenames[i], array_rotational_forces[i], array_velocities[i], group_planets);
		}

		// Append all stars and planets to the pane object
		pane.getChildren().add(group_stars);
		pane.getChildren().add(group_planets);
	}

	private Group generateStars(Pane pane) {
		// Define and initialize variables used for generating stars.
		double stars_density = 0.0005; // Percentage of stars relative to screen size.
		int stars_amount = (int)(pane.getPrefWidth() * pane.getPrefHeight() * stars_density); // Calculate amount of stars.
		double[] stars_size_range = {0.15, 1.25}; // Define size range for stars. Min = first element, Max = second element.
		int[] stars_pulse_time_delta_range = {1000, 2000}; // Define time range for animation duration.
		double stars_animation_scale = 1.25; // Define how much the stars should grow throughout the animation.
		Group stars = new Group(); // Define an array used to store all stars.

		// Loop from 0-stars_amount and generate a star and its relative animation for each iteration.
		for(int i = 0; i < stars_amount; i++) {
			Circle star = new Circle(
					Math.random() * pane.getPrefWidth(), // Randomize the x-coordinate from 0-end of screen.
					Math.random() * pane.getPrefHeight(), // Randomize the y-coordinate from 0-end of screen.
					stars_size_range[0] + Math.random() * (stars_size_range[1] - stars_size_range[0])); // Randomize the radius of the circle relative to the defined min and max size range.
			star.setFill(Color.WHITE); // Set color of the star to WHITE.
			stars.getChildren().add(star); // Append star as child of pane.

			// Calculate randomized duration for animation, from time range element 0 to 1.
			int duration = (int)(stars_pulse_time_delta_range[0] + Math.random() * (stars_pulse_time_delta_range[1] - stars_pulse_time_delta_range[0]));
			ScaleTransition animation = new ScaleTransition(Duration.millis(duration), star); // Initialize scale animation with duration and node.
			animation.setByX(stars_animation_scale); // Set the scale difference from start of animation to end for x-coordinate.
			animation.setByY(stars_animation_scale); // Same, but for y-coordinate.
			animation.setCycleCount(Animation.INDEFINITE); // Set animation to run indefinitely.
			animation.setAutoReverse(true); // Set animation to reverse by itself, as in get bigger and smaller automatically.
			animation.play(); // Start the animation.
		}

		return stars;
	}

	private void generatePlanet(Pane pane, Circle planet, String image_filename, double rotational_force, double velocity, Group group) {
		// These variables are only to make the code more readable
		double center_x = pane.getPrefWidth() / 2;
		double center_y = pane.getPrefHeight() / 2;

		// Define and initialize a circle that is transparent, but has a very small white stroke
		// This is used to show the trajectory or the path of each planet
		Circle planet_trajectory = new Circle(center_x, center_y, planet.getCenterX() - center_x);
		planet_trajectory.setFill(Color.TRANSPARENT);
		planet_trajectory.setStroke(Color.WHITE);
		planet_trajectory.setStrokeWidth(0.5);

		// Add an image to the Circle object as a texture
		Image image = new Image("/opgave4/sprites/" + image_filename);
		ImagePattern image_pattern = new ImagePattern(image);
		planet.setFill(image_pattern);

		// This defines the animation that rotates the planet. The duration of the rotation is
		// relative to the given rotational_force argument.
		RotateTransition animation = new RotateTransition(Duration.millis(10000 * rotational_force), planet);
		animation.setByAngle(360); // Make the animation rotate 360 degrees
		animation.setInterpolator(Interpolator.LINEAR); // Make the animation rotate linearly, otherwise it would stop after each full rotation
		animation.setCycleCount(Animation.INDEFINITE); // Make the animation run forever
		animation.setAutoReverse(false);
		animation.play();

		// Append the trajectory/path and planet Circle objects to the given group
		group.getChildren().add(planet_trajectory);
		group.getChildren().add(planet);
	}
}
