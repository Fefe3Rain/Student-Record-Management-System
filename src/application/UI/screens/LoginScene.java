package application.UI.screens;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import application.Main;
import application.UI.screens.DashboardScene;

public class LoginScene {
    private Scene scene;

    public LoginScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("F9FAFB"));

        // NavBar
        Rectangle navBar = new Rectangle(0, 0, 1300, 70);
        navBar.setFill(Color.web("FFFFFF"));
        navBar.setStrokeWidth(0.2);
        navBar.setStroke(Color.DIMGRAY);

        // Logo (adjust path as needed)
        Image Logo = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png");
        ImageView logoView = new ImageView(Logo);
        logoView.setX(80);
        logoView.setY(10);
        logoView.setFitWidth(53);
        logoView.setFitHeight(53);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(false);

        // University Text
        Text text1 = new Text("Technological University of the Philippines");
        text1.setX(140);
        text1.setY(35);
        text1.setFont(Font.font("Inter", FontWeight.BOLD, 20));
        text1.setFill(Color.web("1F2937"));

        Text text2 = new Text("Student Management System");
        text2.setX(143);
        text2.setY(50);
        text2.setFont(Font.font("Inter", FontWeight.LIGHT, 12));
        text2.setFill(Color.web("6B7280"));

        // Background Image (adjust path as needed)
        Image Background = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/Haligi ng Bayan.jpg");
        ImageView BGView = new ImageView(Background);
        BGView.setX(0);
        BGView.setY(70);
        BGView.setPreserveRatio(true);
        BGView.setSmooth(true);
        BGView.setCache(false);

        // Login Title and Subtitle
        Text text = new Text("Admin Login");
        text.setX(995);
        text.setY(150);
        text.setFont(Font.font("Inter", FontWeight.BOLD, 30));
        text.setFill(Color.web("1F2937"));

        Text text3 = new Text("Enter your credentials to access your account.");
        text3.setX(925);
        text3.setY(185);
        text3.setFont(Font.font("Inter", FontWeight.LIGHT, 15));
        text3.setFill(Color.web("6B7280"));

        // Username Label and Field
        Text text4 = new Text("Username");
        text4.setX(900);
        text4.setY(240);
        text4.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 14));
        text4.setFill(Color.web("374151"));

        TextField unField = new TextField();
        unField.setLayoutX(900);
        unField.setLayoutY(250);
        unField.setPrefWidth(350);
        unField.setPrefHeight(45);
        unField.setPromptText("Juan Dela Cruz");

        // Password Label and Field (changed to PasswordField)
        Text text5 = new Text("Password");
        text5.setX(900);
        text5.setY(340);
        text5.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 14));
        text5.setFill(Color.web("374151"));

        PasswordField pwField = new PasswordField();  // Changed for security
        pwField.setLayoutX(900);
        pwField.setLayoutY(350);
        pwField.setPrefWidth(350);
        pwField.setPrefHeight(45);
        pwField.setPromptText("********");

        // Remember Me and Forgot Password
        Text text6 = new Text(930, 420, "Remember me?");
        text6.setFont(Font.font("Inter", FontWeight.LIGHT, 12));
        text6.setFill(Color.web("6B7280"));

        Text text7 = new Text(1150, 420, "Forgot Password?");
        text7.setFont(Font.font("Inter", FontWeight.MEDIUM, 12));
        text7.setFill(Color.web("#E52949"));

        // Login Button (added for functionality)
        Button loginButton = new Button("Login");
        loginButton.setLayoutX(900);
        loginButton.setLayoutY(430);
        loginButton.setPrefWidth(350);
        loginButton.setPrefHeight(45);
        loginButton.setStyle("-fx-background-color: #E52949; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");

        // Message Label (added for feedback)
        Label messageLabel = new Label();
        messageLabel.setLayoutX(900);
        messageLabel.setLayoutY(480);
        messageLabel.setStyle("-fx-text-fill: #E52949; -fx-font-size: 12px;");

        // Login Button Action
        loginButton.setOnAction(e -> {
            String username = unField.getText().trim();
            String password = pwField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields.");
                return;
            }

            boolean valid = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Student Record Management System\\src\\application\\Data\\masterfiles\\admin_accounts.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                        valid = true;
                        break;
                    }
                }
            } catch (IOException ex) {
                messageLabel.setText("Error reading accounts: " + ex.getMessage());
                return;
            }

            if (valid) {
                messageLabel.setText("Login successful! Loading dashboard...");
                // Switch to dashboard
                DashboardScene dashboardScene = new DashboardScene();
                Main.switchScene(dashboardScene.getScene());
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        });

        // Footer Line and Text
        Line line = new Line(900, 594, 1250, 594);
        line.setStrokeWidth(1.5);
        line.setStroke(Color.web("E5E7EB"));
        line.setOpacity(0.8);

        Text text8 = new Text(950, 620, "Privacy Policy     |     Terms of Service     |     Contact Us");
        text8.setFont(Font.font("Inter", FontWeight.LIGHT, 11));
        text8.setFill(Color.web("#9CA3AF"));

        // Add all elements to root
        root.getChildren().addAll(navBar, logoView, text1, text2, BGView, text, text3, text4, unField, text5, pwField, text6, text7, loginButton, messageLabel, line, text8);
    }

    public Scene getScene() {
        return scene;
    }
}
