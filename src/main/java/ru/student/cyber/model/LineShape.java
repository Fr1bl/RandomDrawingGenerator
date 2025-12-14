package ru.student.cyber.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineShape implements Shape {
    private double startX, startY, endX, endY;
    private Color color;

    public LineShape(double startX, double startY, double endX, double endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(startX, startY, endX, endY);
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
    public void setStartX(double startX) { this.startX = startX; }
    public void setStartY(double startY) { this.startY = startY; }
    public void setEndX(double endX) { this.endX = endX; }
    public void setEndY(double endY) { this.endY = endY; }
}
