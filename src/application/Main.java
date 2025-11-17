package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import application.UI.screens.RegisterScene;
import application.UI.screens.LoginScene;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("TUP-M SRMS");  // Updated title to match design
        primaryStage.setResizable(false);     // Match design
        // Set icon (adjust path as needed)
        Image icon = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png");
        primaryStage.getIcons().add(icon);
        // Check if account.txt is empty
        File accountFile = new File("account.txt");
        boolean isEmpty = !accountFile.exists() || Files.readString(Paths.get("account.txt")).trim().isEmpty();
        if (isEmpty) {
            // Show register scene
            RegisterScene registerScene = new RegisterScene();
            primaryStage.setScene(registerScene.getScene());
        } else {
            // Show login scene
            LoginScene loginScene = new LoginScene();
            primaryStage.setScene(loginScene.getScene());
        }
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    // Static method for other classes to switch scenes
    public static void switchScene(Scene newScene) {
        primaryStage.setScene(newScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}