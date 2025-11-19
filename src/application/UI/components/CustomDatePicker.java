package application.UI.components;

import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDatePicker extends DatePicker {
private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

public CustomDatePicker(double x, double y, double width, double height, String promptText, Color color) {
    setLayoutX(x);
    setLayoutY(y);
    setPrefWidth(width);
    setPrefHeight(height);
    if (promptText != null) setPromptText(promptText);
    if (color != null) setStyle("-fx-background-color: " + toRgbString(color) + ";");
    // Set default value to current date or null
    setValue(null); // Or set to LocalDate.now() if you want a default
    // Optional: Set converter for custom formatting
    setConverter(new javafx.util.StringConverter<LocalDate>() {
        @Override
        public String toString(LocalDate date) {
            return date != null ? date.format(FORMATTER) : "";
        }
        @Override
        public LocalDate fromString(String string) {
            return string != null && !string.isEmpty() ? LocalDate.parse(string, FORMATTER) : null;
        }
    });
}

private String toRgbString(Color color) {
    return String.format("#%02X%02X%02X", (int)(color.getRed()*255), (int)(color.getGreen()*255), (int)(color.getBlue()*255));
}

// Method to get the selected date as a formatted string
public String getFormattedDate() {
    LocalDate date = getValue();
    return date != null ? date.format(FORMATTER) : "";
}
}
