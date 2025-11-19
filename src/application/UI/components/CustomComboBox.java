package application.UI.components;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import java.util.List;

public class CustomComboBox<T> extends ComboBox<T> {
    public CustomComboBox(double x, double y, double width, double height, List<T> items, String promptText, Color color) {
        setLayoutX(x);
        setLayoutY(y);
        setPrefWidth(width);
        setPrefHeight(height);
        if (items != null) getItems().addAll(items);
        if (promptText != null) setPromptText(promptText);
        if (color != null) setStyle("-fx-background-color: " + toRgbString(color) + ";");
    }
    private String toRgbString(Color color) {
        return String.format("#%02X%02X%02X", (int)(color.getRed()*255), (int)(color.getGreen()*255), (int)(color.getBlue()*255));
    }
}
