package application.UI.screens;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.FileWriter;
import java.io.IOException;
import application.Main;
import application.UI.screens.LoginScene;

public class RegisterScene {
    private Scene scene;

    public RegisterScene() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label title = new Label("Register Admin Account");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button registerButton = new Button("Register");
        Label messageLabel = new Label();

        registerButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields.");
                return;
            }

            try {
                // Save to admin_accounts.txt (append mode)
                FileWriter writer = new FileWriter("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Student Record Management System\\src\\application\\Data\\masterfiles\\admin_accounts.txt", true);
                writer.write(username + ":" + password + "\n");
                writer.close();

                // Mark account.txt as non-empty (e.g., write "registered")
                FileWriter accountWriter = new FileWriter("account.txt");
                accountWriter.write("registered");
                accountWriter.close();

                messageLabel.setText("Registration successful! Switching to login...");

                // Switch to login scene
                LoginScene loginScene = new LoginScene();
                Main.switchScene(loginScene.getScene());
            } catch (IOException ex) {
                messageLabel.setText("Error saving account: " + ex.getMessage());
            }
        });

        layout.getChildren().addAll(title, usernameField, passwordField, registerButton, messageLabel);
        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
