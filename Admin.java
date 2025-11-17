/* package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1300, 700, Color.web("#F9FAFB"));

        Image icon = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/TUP Logo.png");

        Rectangle sideBar = new Rectangle(0, 0, 200, 700);
        sideBar.setFill(Color.web("#4B4B4B"));

        Image Logo = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/TUP Logo.png");
        ImageView logoView = new ImageView(Logo);
        logoView.setX(12);
        logoView.setY(14);
        logoView.setFitWidth(42);
        logoView.setFitHeight(42);  
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(false);

        Text text1 = new Text("Admin Portal");
        text1.setX(60);
        text1.setY(42);
        text1.setFont(Font.font("Inter", FontWeight.BOLD, 20));
        text1.setFill(Color.web("#F3F4F6"));

        Rectangle navBar = new Rectangle(200, 0, 1100, 70);
        navBar.setFill(Color.web("#FFFFFF"));

        Image menu = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Icons/Menu.png");
        ImageView menuView = new ImageView(menu);
        menuView.setX(208);
        menuView.setY(10);
        menuView.setFitWidth(53);
        menuView.setFitHeight(53);
        menuView.setPreserveRatio(true);
        menuView.setSmooth(true);
        menuView.setCache(false);

        Text text2 = new Text("TechnoDash");
        text2.setX(260);
        text2.setY(45);
        text2.setFont(Font.font("Inter", FontWeight.BOLD, 32));
        text2.setFill(Color.web("#111827"));

        Text text3 = new Text("Executive Information System");
        text3.setX(260);
        text3.setY(58);
        text3.setFont(Font.font("Inter", FontWeight.LIGHT, 12));
        text3.setFill(Color.web("#333333"));

        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(370);
        searchField.setPrefHeight(35);
        
        ImageView seaIcon = new ImageView(new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Icons/Search icon.png"));
        seaIcon .setFitWidth(45);
        seaIcon .setFitHeight(45);

        StackPane.setAlignment(seaIcon, Pos.CENTER_RIGHT);
        StackPane.setMargin(seaIcon, new Insets(0, 0, 0, 0)); // right padding

        StackPane searchContainer = new StackPane(searchField, seaIcon);
        searchContainer.setLayoutX(490);
        searchContainer.setLayoutY(14);

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

        root.getChildren().add(sideBar);
        root.getChildren().add(logoView);
        root.getChildren().add(text1);
        root.getChildren().add(navBar);
        root.getChildren().add(menuView);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(searchContainer);
        root.getChildren().add(undg);
        root.getChildren().add(grad);
        root.getChildren().add(fcty);
        root.getChildren().add(rate);
        root.getChildren().add(stat);
        root.getChildren().add(rank);
        root.getChildren().add(crss);
        root.getChildren().add(evnt);

        stage.getIcons().add(icon);
        stage.setTitle("TUP-M SRMS");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
} */