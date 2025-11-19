    package application.UI.components;

    import javafx.scene.shape.Line;
    import javafx.scene.paint.Color;

    public class CustomLine extends Line {
        public CustomLine(double x1, double y1, double x2, double y2, double strokeWidth, Color color) {
            super(x1, y1, x2, y2);
            setStrokeWidth(strokeWidth);
            setStroke(color);
            setOpacity(0.6);
        }
    }
    