package application.UI.components;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class CustomText extends Text {
    public CustomText(double x, double y, String text, int fontSize, FontWeight weight, Color color) {
        super(text);
        setLayoutX(x);
        setLayoutY(y);
        setFont(Font.font("Inter", weight, fontSize));
        setFill(color);
    }
}