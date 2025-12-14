package ru.student.cyber.service;

import javafx.scene.paint.Color;
import ru.student.cyber.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapeGenerator {

    private final Random random = new Random();

    // Генерация случайных фигур по параметрам
    public List<Shape> generateShapes(int count, double width, double height) {
        List<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int type = random.nextInt(6); // 0..5 для 6 типов фигур
            Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());

            switch (type) {
                case 0 -> { // Круг
                    double radius = random.nextDouble() * 50;
                    shapes.add(new CircleShape(random.nextDouble() * width,
                            random.nextDouble() * height,
                            radius, color));
                }
                case 1 -> { // Прямоугольник
                    double w = random.nextDouble() * 100;
                    double h = random.nextDouble() * 100;
                    shapes.add(new RectangleShape(random.nextDouble() * (width - w),
                            random.nextDouble() * (height - h),
                            w, h, color));
                }
                case 2 -> { // Линия
                    double x1 = random.nextDouble() * width;
                    double y1 = random.nextDouble() * height;
                    double x2 = random.nextDouble() * width;
                    double y2 = random.nextDouble() * height;
                    shapes.add(new LineShape(x1, y1, x2, y2, color));
                }
                case 3 -> { // Треугольник
                    double[] xs = {random.nextDouble() * width, random.nextDouble() * width, random.nextDouble() * width};
                    double[] ys = {random.nextDouble() * height, random.nextDouble() * height, random.nextDouble() * height};
                    shapes.add(new TriangleShape(xs, ys, color));
                }
                case 4 -> { // Парабола
                    double startX = random.nextDouble() * width;
                    double startY = random.nextDouble() * height;
                    double endX = random.nextDouble() * width;
                    double endY = random.nextDouble() * height;
                    double a = random.nextDouble() * 0.01; // сила изгиба
                    shapes.add(new ParabolaShape(startX, startY, endX, endY, a, color));
                }
                case 5 -> { // Трапеция
                    double x = random.nextDouble() * width;
                    double y = random.nextDouble() * height;
                    double wTop = random.nextDouble() * 50;
                    double wBottom = random.nextDouble() * 100;
                    double h = random.nextDouble() * 50;

                    double[] xs = {x, x + wTop, x + wBottom, x + (wBottom - wTop)};
                    double[] ys = {y, y, y + h, y + h};
                    shapes.add(new TrapezoidShape(xs, ys, color));
                }
            }
        }
        return shapes;
    }

    // Отрисовка сетки
    public void drawGrid(javafx.scene.canvas.GraphicsContext gc, double width, double height, double gridStep) {
        gc.setStroke(Color.LIGHTGRAY);
        for (double x = 0; x <= width; x += gridStep) {
            gc.strokeLine(x, 0, x, height);
        }
        for (double y = 0; y <= height; y += gridStep) {
            gc.strokeLine(0, y, width, y);
        }
    }
}
