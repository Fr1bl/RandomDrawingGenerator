package ru.student.cyber.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.student.cyber.model.Shape;
import ru.student.cyber.service.RandomShapeGenerator;

import java.util.List;

public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @FXML
    private Canvas canvas;

    @FXML
    private TextField countField, widthField, heightField, gridStepField;

    private final RandomShapeGenerator generator = new RandomShapeGenerator();

    @FXML
    private void onGenerate() {
        try {
            int count = Integer.parseInt(countField.getText());
            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            double gridStep = Double.parseDouble(gridStepField.getText());

            logger.info(String.format("Генерация фигур: count=%d, width=%.2f, height=%.2f, gridStep=%.2f",
                    count, width, height, gridStep));

            canvas.setWidth(width);
            canvas.setHeight(height);

            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, width, height);

            // Рисуем сетку
            logger.debug("Рисуем сетку");
            generator.drawGrid(gc, width, height, gridStep);

            // Генерируем и рисуем фигуры
            List<Shape> shapes = generator.generateShapes(count, width, height);
            logger.info("Сгенерировано фигур: " + shapes.size());

            for (Shape shape : shapes) {
                shape.draw(gc);
                logger.debug("Нарисована фигура: " + shape.getClass().getSimpleName());
            }

        } catch (NumberFormatException e) {
            logger.error("Ошибка ввода числовых значений: ", e);
        } catch (Exception e) {
            logger.error("Ошибка при генерации или рисовании фигур: ", e);
        }
    }
}
