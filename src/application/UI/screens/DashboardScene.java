package application.UI.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import application.Main;
import application.UI.components.*;
import application.UI.screens.LoginScene;

public class DashboardScene {
    private Scene scene;

    public DashboardScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("#F9FAFB"));

        // Sidebar
        CustomRectangle sideBar = new CustomRectangle(0, 0, 200, 700, Color.web("#4B4B4B"), null);

        CustomButton udgbut = new CustomButton(0, 160, 200, 35, "Undergraduate", Color.web("#FFFFFF"));
        udgbut.setStyle("-fx-background-color: #D9D9D9; -fx-text-fill: white; -fx-font-size: 23x;");

        udgbut.setOnAction(e -> {
            UGScene ugScene = new UGScene();
            Main.switchScene(ugScene.getScene());
        });

        CustomButton facbut = new CustomButton(0, 224, 200, 35, "Faculty", Color.web("#FFFFFF"));
        facbut.setStyle("-fx-background-color: #D9D9D9; -fx-text-fill: white; -fx-font-size: 23x;");

        facbut.setOnAction(e -> {
            FacultyScene faculty = new FacultyScene();
            Main.switchScene(faculty.getScene());
        });

        // Logo (adjust path as needed)
        CustomImageView logoView = new CustomImageView(12, 14, 42, 42, "file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png", null);

        // Admin Portal Text
        CustomText text1 = new CustomText(60, 42, "Admin Portal", 18, FontWeight.BOLD, Color.web("#F3F4F6"));

        // Navbar
        CustomRectangle navBar = new CustomRectangle(200, 0, 1100, 70, Color.web("#FFFFFF"), Color.DIMGRAY);

        // Menu Icon (adjust path as needed)
        CustomImageView menuView = new CustomImageView(208, 10, 53, 53, "file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Icons/Menu.png", null);

        // TechnoDash Title
        CustomText text2 = new CustomText(260, 45, "TechnoDash", 32, FontWeight.BOLD, Color.web("#111827"));

        // Subtitle
        CustomText text3 = new CustomText(260, 58, "Executive Information System", 12, FontWeight.LIGHT, Color.web("#333333"));

        // Search Field with Icon      
        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(370);
        searchField.setPrefHeight(35);

        ImageView seaIcon = new ImageView(new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Icons/Search icon.png"));
        seaIcon.setFitWidth(45);
        seaIcon.setFitHeight(45);

        StackPane.setAlignment(seaIcon, Pos.CENTER_RIGHT);
        StackPane.setMargin(seaIcon, new Insets(0, 0, 0, 0)); // right padding

        StackPane searchContainer = new StackPane(searchField, seaIcon);
        searchContainer.setLayoutX(490);
        searchContainer.setLayoutY(14);

        // Content Rectangles (placeholders)
        Rectangle undg = new Rectangle(218, 100, 255, 120);
        undg.setFill(Color.web("#FFFFFF"));

        Rectangle grad = new Rectangle(488, 100, 255, 120);
        grad.setFill(Color.web("#FFFFFF"));

        Rectangle fcty = new Rectangle(758, 100, 255, 120);
        fcty.setFill(Color.web("#FFFFFF"));

        Rectangle rate = new Rectangle(1028, 100, 255, 120);
        rate.setFill(Color.web("#FFFFFF"));

        Rectangle stat = new Rectangle(218, 237, 795, 300);
        stat.setFill(Color.web("#FFFFFF"));

        Rectangle rank = new Rectangle(1028, 237, 255, 437);
        rank.setFill(Color.web("#FFFFFF"));

        Rectangle crss = new Rectangle(218, 554, 385, 120);
        crss.setFill(Color.web("#FFFFFF"));

        Rectangle evnt = new Rectangle(625, 554, 385, 120);
        evnt.setFill(Color.web("#FFFFFF"));

        // Logout Button (positioned in navbar)
        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(1150);
        logoutButton.setLayoutY(20);
        logoutButton.setPrefWidth(100);
        logoutButton.setPrefHeight(30);
        logoutButton.setStyle("-fx-background-color: #E52949; -fx-text-fill: white; -fx-font-size: 12px;");

        logoutButton.setOnAction(e -> {
            // Switch back to login scene
            LoginScene loginScene = new LoginScene();
            Main.switchScene(loginScene.getScene());
        });

        // Add all elements to root
        root.getChildren().addAll(sideBar, udgbut, facbut, logoView, text1, navBar, menuView, text2, text3, searchContainer, undg, grad, fcty, rate, stat, rank, crss, evnt, logoutButton);
    }

    public Scene getScene() {
        return scene;
    }
}
