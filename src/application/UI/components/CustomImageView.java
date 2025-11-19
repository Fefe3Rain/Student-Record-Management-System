package application.UI.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class CustomImageView extends ImageView {
    public CustomImageView(double x, double y, double width, double height, String imagePath, Color color) {
        setLayoutX(x);
        setLayoutY(y);
        setFitWidth(width);
        setFitHeight(height);
        setPreserveRatio(true);
        setSmooth(true);
        setCache(false);
        if (imagePath != null) setImage(new Image(imagePath));
        // Color not directly applicable for ImageView; ignore or use for styling if needed
    }
}
