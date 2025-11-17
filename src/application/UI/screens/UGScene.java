package application.UI.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import application.UI.screens.DashboardScene;

public class UGScene {
    private Scene scene;

    public UGScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("#F9FAFB"));

        // Sidebar
        Rectangle sideBar = new Rectangle(0, 0, 200, 700);
        sideBar.setFill(Color.web("#4B4B4B"));

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
        Text text1 = new Text("Undergraduate Scene");
        text1.setX(60);
        text1.setY(42);
        text1.setFont(Font.font("Inter", FontWeight.BOLD, 20));
        text1.setFill(Color.web("#F3F4F6"));

        // Navbar
        Rectangle navBar = new Rectangle(200, 0, 1100, 70);
        navBar.setFill(Color.web("#FFFFFF"));
        navBar.setStrokeWidth(0.2);
        navBar.setStroke(Color.DIMGRAY);

        Rectangle details = new Rectangle(213, 83, 450, 600);
        details.setFill(Color.web("#FFFFFF"));

        Text text2 = new Text(238, 98, "Student Details");
        text2.setFont(Font.font("Inter", FontWeight.BOLD, 13));

        Text text3 = new Text(239, 130, "First Name");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField fnField = new TextField();
        fnField.setLayoutX(238);
        fnField.setLayoutY(145);
        fnField.setPrefWidth(175);
        fnField.setPrefHeight(25);


        Text text4 = new Text(428, 130, "Last Name");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField lnField = new TextField();
        lnField.setLayoutX(427);
        lnField.setLayoutY(145);
        lnField.setPrefWidth(175);
        lnField.setPrefHeight(25);

        Text text5 = new Text(617, 130, "M.I.");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField miField = new TextField();
        miField.setLayoutX(616);
        miField.setLayoutY(145);
        miField.setPrefWidth(22);
        miField.setPrefHeight(25);
    
        Text text6 = new Text(239, 187, "Email");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField emField = new TextField();
        emField.setLayoutX(238);
        emField.setLayoutY(203);
        emField.setPrefWidth(400);
        emField.setPrefHeight(25);

        Text text7 = new Text(239, 247, "Contact number");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField cnField = new TextField();
        cnField.setLayoutX(238);
        cnField.setLayoutY(263);
        cnField.setPrefWidth(400);
        cnField.setPrefHeight(25);

        Text text8 = new Text(239, 307, "Course");
        text3.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        ComboBox<String> courseop = new ComboBox<>();
        courseop.getItems().addAll("BSIT", "BSCS", "BSIS");
        courseop.setPromptText("Select an option");
        courseop.setLayoutX(238);    // x position
        courseop.setLayoutY(323);    // y position
        courseop.setPrefWidth(400); // width
        courseop.setPrefHeight(25); // height

        

        // Add all elements to root
        root.getChildren().addAll(sideBar, logoView, text1, navBar, details, text2, text3, fnField, text4, lnField, text5, miField, text6, emField, text7, cnField, text8, courseop);
    }

    public Scene getScene() {
        return scene;
    }   
    
}
