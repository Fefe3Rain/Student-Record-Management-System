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
import application.UI.screens.LoginScene;

public class DashboardScene {
    private Scene scene;

    public DashboardScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("#F9FAFB"));

        // Sidebar
        Rectangle sideBar = new Rectangle(0, 0, 200, 700);
        sideBar.setFill(Color.web("#4B4B4B"));

        Button udgbut = new Button("undergraduate");
        udgbut.setLayoutX(0);
        udgbut.setLayoutY(160);
        udgbut.setPrefWidth(200);
        udgbut.setPrefHeight(35);

        udgbut.setOnAction(e -> {
            UGScene ugScene = new UGScene();
            Main.switchScene(ugScene.getScene());
        });

        // Logo (adjust path as needed)
        Image Logo = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png");
        ImageView logoView = new ImageView(Logo);
        logoView.setX(12);
        logoView.setY(14);
        logoView.setFitWidth(42);
        logoView.setFitHeight(42);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(false);

        // Admin Portal Text
        Text text1 = new Text("Admin Portal");
        text1.setX(60);
        text1.setY(42);
        text1.setFont(Font.font("Inter", FontWeight.BOLD, 20));
        text1.setFill(Color.web("#F3F4F6"));

        // Navbar
        Rectangle navBar = new Rectangle(200, 0, 1100, 70);
        navBar.setFill(Color.web("#FFFFFF"));

        // Menu Icon (adjust path as needed)
        Image menu = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Icons/Menu.png");
        ImageView menuView = new ImageView(menu);
        menuView.setX(208);
        menuView.setY(10);
        menuView.setFitWidth(53);
        menuView.setFitHeight(53);
        menuView.setPreserveRatio(true);
        menuView.setSmooth(true);
        menuView.setCache(false);

        // TechnoDash Title
        Text text2 = new Text("TechnoDash");
        text2.setX(260);
        text2.setY(45);
        text2.setFont(Font.font("Inter", FontWeight.BOLD, 32));
        text2.setFill(Color.web("#111827"));

        // Subtitle
        Text text3 = new Text("Executive Information System");
        text3.setX(260);
        text3.setY(58);
        text3.setFont(Font.font("Inter", FontWeight.LIGHT, 12));
        text3.setFill(Color.web("#333333"));

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
        root.getChildren().addAll(sideBar, udgbut, logoView, text1, navBar, menuView, text2, text3, searchContainer, undg, grad, fcty, rate, stat, rank, crss, evnt, logoutButton);
    }

    public Scene getScene() {
        return scene;
    }
}
