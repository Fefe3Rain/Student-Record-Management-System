package application.UI.screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.shape.Line;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
        text4.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField lnField = new TextField();
        lnField.setLayoutX(427);
        lnField.setLayoutY(145);
        lnField.setPrefWidth(175);
        lnField.setPrefHeight(25);

        Text text5 = new Text(617, 130, "M.I.");
        text5.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField miField = new TextField();
        miField.setLayoutX(616);
        miField.setLayoutY(145);
        miField.setPrefWidth(22);
        miField.setPrefHeight(25);
    
        Text text6 = new Text(239, 187, "Email");
        text6.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField emField = new TextField();
        emField.setLayoutX(238);
        emField.setLayoutY(203);
        emField.setPrefWidth(400);
        emField.setPrefHeight(25);

        Text text7 = new Text(239, 247, "Contact number");
        text7.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField cnField = new TextField();
        cnField.setLayoutX(238);
        cnField.setLayoutY(263);
        cnField.setPrefWidth(400);
        cnField.setPrefHeight(25);

        Text text8 = new Text(239, 307, "Course");
        text8.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        ComboBox<String> courseop = new ComboBox<>();
        courseop.getItems().addAll("BSIT", "BSCS", "BSIS");
        courseop.setPromptText("Select an option");
        courseop.setLayoutX(238);    // x position
        courseop.setLayoutY(323);    // y position
        courseop.setPrefWidth(400); // width
        courseop.setPrefHeight(25); // 
        
        Text text9 = new Text(239, 367, "Year");
        text9.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        ComboBox<String> yearop = new ComboBox<>();
        yearop.getItems().addAll("1", "2", "3", "4", "5");
        yearop.setPromptText("Select an option");
        yearop.setLayoutX(238);    // x position
        yearop.setLayoutY(383);    // y position
        yearop.setPrefWidth(49); // width
        yearop.setPrefHeight(25); // 

        Text text10 = new Text(300, 367, "Section");
        text10.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        ComboBox<String> secop = new ComboBox<>();
        secop.getItems().addAll("A", "B", "C", "D");
        secop.setPromptText("Select an option");
        secop.setLayoutX(300);    // x position
        secop.setLayoutY(383);    // y position
        secop.setPrefWidth(49); // width
        secop.setPrefHeight(25); // 

        Text text11 = new Text(364, 367, "Age");
        text11.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField ageField = new TextField();
        ageField.setLayoutX(364);
        ageField.setLayoutY(383);
        ageField.setPrefWidth(32);
        ageField.setPrefHeight(25);

        Text text12 = new Text(414, 367, "Sex");
        text12.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        ComboBox<String> sexop = new ComboBox<>();
        sexop.getItems().addAll("Male", "Female");
        sexop.setPromptText("Select an option");
        sexop.setLayoutX(414);    // x position
        sexop.setLayoutY(383);    // y position
        sexop.setPrefWidth(90); // width
        sexop.setPrefHeight(25); // 

        Text text13 = new Text(530, 367, "ID Picture (2x2)");
        text13.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        Button uploadButton = new Button("Upload Image");
        uploadButton.setLayoutX(518);
        uploadButton.setLayoutY(381);
        uploadButton.setPrefWidth(120);
        uploadButton.setPrefHeight(125);

        ImageView imageView = new ImageView();
        imageView.setLayoutX(518);
        imageView.setLayoutY(381);
        imageView.setFitWidth(120);  // Set display size
        imageView.setFitHeight(125);
        imageView.setPreserveRatio(true);

        // Set up FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        // Button action: Open file chooser and load image
        uploadButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(Main.getPrimaryStage());  // Use the passed stage
            if (selectedFile != null) {
                try {
                    Image image = new Image(selectedFile.toURI().toString());
                    imageView.setImage(image);
                } catch (Exception ex) {
                    System.out.println("Error loading image: " + ex.getMessage());
                    // Optionally, show an Alert dialog
                }
            }
        });

        Text text14 = new Text(239, 417, "Birthday");
        text14.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField BdayField = new TextField();
        BdayField.setLayoutX(238);
        BdayField.setLayoutY(433);
        BdayField.setPrefWidth(266);
        BdayField.setPrefHeight(25);

        Text text15 = new Text(239, 467, "Nationality");
        text15.setFont(Font.font("Inter", FontWeight.NORMAL, 12));

        TextField NatField = new TextField();
        NatField.setLayoutX(238);
        NatField.setLayoutY(483);
        NatField.setPrefWidth(266);
        NatField.setPrefHeight(25);

        Text text16 = new Text(238, 517, "Person's Address");
        text16.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 13));

        Line line = new Line(238, 540, 638, 540);
        line.setStrokeWidth(0.5);
        line.setStroke(Color.web("000000"));
        line.setOpacity(0.6);

        Text text17 = new Text(238, 559, "Present Address");
        text15.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 13));

        TextField AdsField = new TextField();
        AdsField.setLayoutX(238);
        AdsField.setLayoutY(575);
        AdsField.setPrefWidth(400);
        AdsField.setPrefHeight(25);

        Text text18 = new Text(266, 620, "Please verify the data before submission.\nEnsure all information entered is accurate and complete.\nIncorrect or incomplete data may result in errors, delays, or\ninvalid records.");
        text18.setFont(Font.font("Inter", FontWeight.NORMAL, 10));
        text18.setFill(Color.web("#000000"));

        Button Subbut = new Button("Submit");
        Subbut.setLayoutX(573);
        Subbut.setLayoutY(629);
        Subbut.setPrefWidth(68);
        Subbut.setPrefHeight(24);
        Subbut.setStyle("-fx-background-color: #E52949; -fx-text-fill: white; -fx-font-size: 12px;");

        // Add action to save data
        Subbut.setOnAction(e -> {
            // Collect data from fields
            String firstName = fnField.getText().trim();
            String lastName = lnField.getText().trim();
            String middleInitial = miField.getText().trim();
            String email = emField.getText().trim();
            String contactNumber = cnField.getText().trim();
            String course = courseop.getValue() != null ? courseop.getValue() : "";
            String year = yearop.getValue() != null ? yearop.getValue() : "";
            String section = secop.getValue() != null ? secop.getValue() : "";
            String age = ageField.getText().trim();
            String sex = sexop.getValue() != null ? sexop.getValue() : "";
            String birthday = BdayField.getText().trim();
            String nationality = NatField.getText().trim();
            String address = AdsField.getText().trim();
            
            // Handle image: Get the file path if an image is loaded
            String imagePath = "";
            if (imageView.getImage() != null) {
                // Assuming the image was loaded from a file, store the original path
                // If you want to copy the image, see notes below
                imagePath = imageView.getImage().getUrl();  // This gives the file:// URL; extract path if needed
                if (imagePath.startsWith("file://")) {
                    imagePath = imagePath.substring(7);  // Remove "file://" prefix
                }
            }

            // Validate required fields (basic example)
            if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty()) {
                // Show error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Missing Information");
                alert.setContentText("Please fill in all required fields.");
                alert.showAndWait();
                return;
            }

            try {
                // Save to masterfile.txt (append mode for multiple records)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("masterfile.txt", true))) {
                    // Format: FirstName,LastName,MiddleInitial,Email,Contact,Course,Year,Section,Age,Sex,Birthday,Nationality,Address,ImagePath
                    writer.write(String.join(",", firstName, lastName, middleInitial, email, contactNumber, course, year, section, age, sex, birthday, nationality, address, imagePath));
                    writer.newLine();
                }

                // Save to transaction.txt (log with timestamp)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("transaction.txt", true))) {
                    String timestamp = LocalDateTime.now().toString();
                    writer.write("[" + timestamp + "] Student record submitted: " + firstName + " " + lastName + " (" + course + ")");
                    writer.newLine();
                }

                // Success alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Record Saved");
                alert.setContentText("Student details have been saved successfully.");
                alert.showAndWait();

                // Optional: Switch back to login or another scene
                // LoginScene loginScene = new LoginScene();
                // Main.switchScene(loginScene.getScene());

            } catch (IOException ex) {
                // Error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Save Failed");
                alert.setContentText("An error occurred while saving: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Add all elements to root
        root.getChildren().addAll(sideBar, logoView, text1, navBar, details, text2, text3, fnField, text4, lnField, text5, miField, text6, emField, text7, cnField, text8, courseop, text9, yearop, text10, secop, text11, ageField, text12, sexop, text13, uploadButton, imageView, text14, BdayField, text15, NatField, text16, line, text17, AdsField, text18, Subbut);
    }

    public Scene getScene() {
        return scene;
    }   
    
}
