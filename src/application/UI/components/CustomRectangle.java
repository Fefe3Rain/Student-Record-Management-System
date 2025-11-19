package application.UI.components;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class CustomRectangle extends Rectangle {
    public CustomRectangle(double x, double y, double width, double height, Color fillColor, Color strokeColor) {
        super(x, y, width, height);
        setFill(fillColor);
        if (strokeColor != null) {
            setStroke(strokeColor);
            setStrokeWidth(0.2);
        }
    }
}
    