package ru.student.cyber.service;

import org.junit.jupiter.api.Test;
import ru.student.cyber.model.Shape;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomShapeGeneratorTest {

    @Test
    void testGenerateShapes() {
        RandomShapeGenerator gen = new RandomShapeGenerator(); // конструктор без параметров

        // Генерируем 10 фигур в области 200x200
        List<Shape> shapes = gen.generateShapes(10, 200, 200);

        assertEquals(10, shapes.size(), "Должно быть сгенерировано 10 фигур");

        // Проверяем, что у всех фигур задан цвет
        for (Shape shape : shapes) {
            assertNotNull(shape, "Фигура не должна быть null");
        }
    }

    @Test
    void testGenerateShapesDifferentSize() {
        RandomShapeGenerator gen = new RandomShapeGenerator();

        List<Shape> shapes = gen.generateShapes(5, 100, 50);

        assertEquals(5, shapes.size(), "Должно быть сгенерировано 5 фигур");
    }
}
