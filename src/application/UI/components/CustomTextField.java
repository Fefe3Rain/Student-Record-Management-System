package application.UI.components;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CustomTextField extends TextField {
    public CustomTextField(double x, double y, double width, double height, String promptText, Color color) {
        setLayoutX(x);
        setLayoutY(y);
        setPrefWidth(width);
        setPrefHeight(height);
        if (promptText != null) setPromptText(promptText);
        if (color != null) setStyle("-fx-background-color: " + toRgbString(color) + ";");
    }
    private String toRgbString(Color color) {
        return String.format("#%02X%02X%02X", (int)(color.getRed()*255), (int)(color.getGreen()*255), (int)(color.getBlue()*255));
    }
}
