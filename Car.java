package edu.wctc.racecar;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Car extends Group {
    private static final double CAR_WIDTH = 50;
    private static final double OFFSET = 2;
    private static int numCars = 0;

    private double carX = OFFSET;
    private int speed;

    public Car() {
        // Pick a random speed between 0 and 6 (higher is faster)
        this.speed = (int) Math.floor(Math.random() * 6);
        // Set the baseline for this car. Successive cars are drawn
        // 40 pixels above each other.
        double baseline = Main.SCENE_HEIGHT - OFFSET - (40 * numCars++);
        // Generate a color for the car with three random RGB values
        Random rand = new Random();
        Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1.0);

        // Two circles for the tires
        Circle tire = new Circle(OFFSET + 15, baseline - 8, 5);
        getChildren().add(tire);
        tire = new Circle(OFFSET + 35, baseline - 8, 5);
        getChildren().add(tire);
        // A rectangle for the car bottom
        Rectangle rect = new Rectangle(OFFSET, baseline - 20, CAR_WIDTH, 10);
        rect.setFill(color);
        getChildren().add(rect);
        // A polygon for the car top
        Polygon poly = new Polygon();
        poly.getPoints().addAll(OFFSET + 15, baseline - 20);
        poly.getPoints().addAll(OFFSET + 5, baseline - 20);
        poly.getPoints().addAll(OFFSET + 20, baseline - 30);
        poly.getPoints().addAll(OFFSET + 30, baseline - 30);
        poly.getPoints().addAll(OFFSET + 40, baseline - 22);
        poly.setFill(color);
        getChildren().add(poly);
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        // Update the X position of the car by one pixel.
        // Calling this method more frequently will cause
        // the car to appear to drive faster.
        double newCarX = carX + 1;
        if (newCarX > Main.SCENE_WIDTH - CAR_WIDTH - OFFSET) {
            newCarX = 0;
        }

        carX = newCarX;
        setTranslateX(newCarX);
    }


}
