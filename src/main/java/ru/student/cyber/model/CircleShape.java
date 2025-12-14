package ru.student.cyber.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleShape implements Shape {
    private double x, y, radius;
    private Color color;

    public CircleShape(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) { this.color = color; }
    @Override
    public Color getColor() { return color; }

    // Геттеры и сеттеры
    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRadius(double radius) { this.radius = radius; }
}
