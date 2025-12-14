package ru.student.cyber.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ParabolaShape implements Shape {
    private double startX, startY, endX, endY, a;
    private Color color;

    public ParabolaShape(double startX, double startY, double endX, double endY, double a, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.a = a;
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        int steps = 100;
        double[] xs = new double[steps];
        double[] ys = new double[steps];
        for (int i = 0; i < steps; i++) {
            double t = i / (double)(steps - 1);
            xs[i] = startX + t * (endX - startX);
            ys[i] = startY + t * (endY - startY) - a * t * t;
        }
        gc.strokePolyline(xs, ys, steps);
    }

    @Override
    public void setColor(Color color) { this.color = color; }
    @Override
    public Color getColor() { return color; }

    // Геттеры и сеттеры
    public double getStartX() { return startX; }
    public double getStartY() { return startY; }
    public double getEndX() { return endX; }
    public double getEndY() { return endY; }
    public double getA() { return a; }
    public void setStartX(double startX) { this.startX = startX; }
    public void setStartY(double startY) { this.startY = startY; }
    public void setEndX(double endX) { this.endX = endX; }
    public void setEndY(double endY) { this.endY = endY; }
    public void setA(double a) { this.a = a; }
}
