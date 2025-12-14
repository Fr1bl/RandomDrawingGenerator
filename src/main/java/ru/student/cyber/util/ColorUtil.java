package ru.student.cyber.util;

import javafx.scene.paint.Color;
import java.util.Random;

public class ColorUtil {
    private static final Random random = new Random();

    public static Color randomColor() {
        return Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }
}
