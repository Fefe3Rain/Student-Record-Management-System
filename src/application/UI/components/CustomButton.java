package application.UI.components;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class CustomButton extends Button {
    public CustomButton(double x, double y, double width, double height, String text, Color color) {
        super(text);
        setLayoutX(x);
        setLayoutY(y);
        setPrefWidth(width);
        setPrefHeight(height);
        setStyle("-fx-background-color: " + toRgbString(color) + "; -fx-text-fill: white;");
    }
    private String toRgbString(Color color) {
        return String.format("#%02X%02X%02X", (int)(color.getRed()*255), (int)(color.getGreen()*255), (int)(color.getBlue()*255));
    }
}
    