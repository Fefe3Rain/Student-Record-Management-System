/* package application;

import javafx.application.Application;
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

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1300, 700, Color.web("F9FAFB"));

        Image icon = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/TUP Logo.png");
        stage.getIcons().add(icon);

        Rectangle navBar = new Rectangle(0, 0, 1300, 70);
        navBar.setFill(Color.web("FFFFFF"));
        navBar.setStrokeWidth(0.2);
        navBar.setStroke(Color.DIMGRAY);

        Image Logo = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/TUP Logo.png");
        ImageView logoView = new ImageView(Logo);
        logoView.setX(80);
        logoView.setY(10);
        logoView.setFitWidth(53);
        logoView.setFitHeight(53);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(false);
        
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

        Image Background = new Image("file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/Images/Haligi ng Bayan.jpg");
        ImageView BGView = new ImageView(Background);
        BGView.setX(0);
        BGView.setY(70);
        BGView.setPreserveRatio(true);
        BGView.setSmooth(true);
        BGView.setCache(false);

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

        Text text5 = new Text("Password");
        text5.setX(900);
        text5.setY(340);
        text5.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 14));
        text5.setFill(Color.web("374151"));

        TextField pwField = new TextField();
        pwField.setLayoutX(900);
        pwField.setLayoutY(350);
        pwField.setPrefWidth(350);
        pwField.setPrefHeight(45);
        pwField.setPromptText("********");

        Text text6 = new Text(930, 420, "Remember me?");
        text6.setFont(Font.font("Inter", FontWeight.LIGHT, 12));
        text6.setFill(Color.web("6B7280"));

        Text text7 = new Text(1150, 420, "Forgot Password?");
        text7.setFont(Font.font("Inter", FontWeight.MEDIUM, 12));
        text7.setFill(Color.web("#E52949"));

        Line line = new Line(900, 594, 1250, 594);
        line.setStrokeWidth(1.5);
        line.setStroke(Color.web("E5E7EB"));
        line.setOpacity(0.8);

        Text text8 = new Text(950, 620, "Privacy Policy     |     Terms of Service     |     Contact Us");
        text8.setFont(Font.font("Inter", FontWeight.LIGHT, 11));
        text8.setFill(Color.web("#9CA3AF"));

        root.getChildren().add(navBar);
        root.getChildren().add(logoView);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(BGView);
        root.getChildren().add(text);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(unField);
        root.getChildren().add(text5);
        root.getChildren().add(pwField);
        root.getChildren().add(text6);
        root.getChildren().add(text7);
        root.getChildren().add(line);
        root.getChildren().add(text8);
        stage.setTitle("TUP-M SRMS");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/