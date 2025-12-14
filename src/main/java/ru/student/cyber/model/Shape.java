package ru.student.cyber.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Shape {
    void draw(GraphicsContext gc);
    void setColor(Color color);
    Color getColor();
}
