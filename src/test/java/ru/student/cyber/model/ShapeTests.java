package ru.student.cyber.model;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import ru.student.cyber.service.RandomShapeGenerator;

import java.util.List;

public class ShapeTests {

    @Test
    public void testCircleShape() {
        CircleShape circle = new CircleShape(10, 20, 5, Color.RED);
        assertEquals(10, circle.getX());
        assertEquals(20, circle.getY());
        assertEquals(5, circle.getRadius());
        assertEquals(Color.RED, circle.getColor());

        circle.setColor(Color.BLUE);
        assertEquals(Color.BLUE, circle.getColor());
    }

    @Test
    public void testRectangleShape() {
        RectangleShape rect = new RectangleShape(0, 0, 10, 20, Color.GREEN);
        assertEquals(0, rect.getX());
        assertEquals(0, rect.getY());
        assertEquals(10, rect.getWidth());
        assertEquals(20, rect.getHeight());
        assertEquals(Color.GREEN, rect.getColor());

        rect.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, rect.getColor());
    }

    @Test
    public void testTriangleShape() {
        double[] xs = {0, 10, 5};
        double[] ys = {0, 0, 10};
        TriangleShape tri = new TriangleShape(xs, ys, Color.BROWN);
        assertArrayEquals(xs, tri.getXPoints());
        assertArrayEquals(ys, tri.getYPoints());
        assertEquals(Color.BROWN, tri.getColor());
    }

    @Test
    public void testTrapezoidShape() {
        double[] xs = {0, 10, 8, 2};
        double[] ys = {0, 0, 5, 5};
        TrapezoidShape trap = new TrapezoidShape(xs, ys, Color.PINK);
        assertArrayEquals(xs, trap.getXPoints());
        assertArrayEquals(ys, trap.getYPoints());
        assertEquals(Color.PINK, trap.getColor());
    }

    @Test
    public void testLineShape() {
        LineShape line = new LineShape(0, 0, 10, 10, Color.BLACK);
        assertEquals(0, line.getStartX());
        assertEquals(0, line.getStartY());
        assertEquals(10, line.getEndX());
        assertEquals(10, line.getEndY());
        assertEquals(Color.BLACK, line.getColor());
    }

    @Test
    public void testParabolaShape() {
        ParabolaShape para = new ParabolaShape(0, 0, 10, 20, 5, Color.PURPLE); // добавлен параметр a = 5
        assertEquals(0, para.getStartX());
        assertEquals(0, para.getStartY());
        assertEquals(10, para.getEndX());
        assertEquals(20, para.getEndY());
        assertEquals(5, para.getA()); // проверка коэффициента
        assertEquals(Color.PURPLE, para.getColor());

        para.setColor(Color.ORANGE);
        assertEquals(Color.ORANGE, para.getColor());
    }

    @Test
    public void testRandomShapeGenerator() {
        RandomShapeGenerator gen = new RandomShapeGenerator(); // без аргументов
        List<Shape> shapes = gen.generateShapes(10, 200, 200);

        assertEquals(10, shapes.size());
        for (Shape shape : shapes) {
            assertNotNull(shape);
            assertNotNull(shape.getColor());
        }
    }
}
