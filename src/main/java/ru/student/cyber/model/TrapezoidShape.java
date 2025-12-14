package ru.student.cyber.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TrapezoidShape implements Shape {
    private double[] xPoints;
    private double[] yPoints;
    private Color color;

    public TrapezoidShape(double[] xPoints, double[] yPoints, Color color) {
        if (xPoints.length != 4 || yPoints.length != 4)
            throw new IllegalArgumentException("Trapezoid must have 4 points");
        this.xPoints = xPoints.clone();
        this.yPoints = yPoints.clone();
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillPolygon(xPoints, yPoints, 4);
    }

    @Override
    public void setColor(Color color) { this.color = color; }
    @Override
    public Color getColor() { return color; }

    // Геттеры и сеттеры
    public double[] getXPoints() { return xPoints.clone(); }
    public double[] getYPoints() { return yPoints.clone(); }
    public void setXPoints(double[] xPoints) {
        if (xPoints.length != 4) throw new IllegalArgumentException();
        this.xPoints = xPoints.clone();
    }
    public void setYPoints(double[] yPoints) {
        if (yPoints.length != 4) throw new IllegalArgumentException();
        this.yPoints = yPoints.clone();
    }
}
