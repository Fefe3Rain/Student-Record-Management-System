package application.UI.screens;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.function.Consumer;

import application.Main;
import application.UI.components.*;
import application.UI.screens.DashboardScene;
import application.Models.Faculty;
import application.Ctrls.AddFacultyController;
import application.UI.components.Table;  // Added for Table component

public class FacultyScene {
    private Scene scene;
    private AddFacultyController controller = new AddFacultyController();
    private Table<application.Models.Faculty> facultyTable;  // Added: Table instance
    private ObservableList<application.Models.Faculty> facultyData = FXCollections.observableArrayList();  // Added: Data for table
    public FacultyScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("#f9fbfbff"));  // Updated height for table

        // Sidebar
        CustomRectangle sideBar = new CustomRectangle(0, 0, 200, 700, Color.web("#4B4B4B"), null);

        // Logo (adjust path as needed)
        CustomImageView logoView = new CustomImageView(12, 14, 42, 42, "file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png", null);

        // Admin Portal Text
        CustomText text1 = new CustomText(60, 42, "Admin Portal", 18, FontWeight.BOLD, Color.web("#F3F4F6"));

        // Navbar
        CustomRectangle navBar = new CustomRectangle(200, 0, 1100, 70, Color.web("#FFFFFF"), Color.DIMGRAY);

        CustomRectangle details = new CustomRectangle(213, 83, 450, 600, Color.web("#FFFFFF"), null);

        CustomText text2 = new CustomText(238, 98, "Faculty Details", 13, FontWeight.BOLD, Color.web("#000000"));

        CustomText text3 = new CustomText(239, 130, "First Name", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text3.setOpacity(0.6);

        CustomTextField fnField = new CustomTextField(238, 145, 175, 25, "Juan", null);

        CustomText text4 = new CustomText(428, 130, "Last Name", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text4.setOpacity(0.6);

        CustomTextField lnField = new CustomTextField(427, 145, 175, 25, "Dela Cruz", null);

        CustomText text5 = new CustomText(617, 130, "M.I.", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text5.setOpacity(0.6);

        CustomTextField miField = new CustomTextField(613, 145, 24, 25, "R",  null);

        CustomText text6 = new CustomText(238, 187, "Email", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text6.setOpacity(0.6);

        CustomTextField emField = new CustomTextField(238, 203, 400, 25, "juandelacruz@gmail.com", null);

        CustomText text7 = new CustomText(239, 247, "Contact", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text7.setOpacity(0.6);

        CustomTextField cnField = new CustomTextField(238, 263, 400, 25, "099123456789", null);

        CustomText text8 = new CustomText(239, 307, "Major", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text8.setOpacity(0.6);

        CustomComboBox<String> majorop = new CustomComboBox<>(238, 323, 400, 25, List.of("Science", "Computer", "Programming", "Math", "Development"), "Select an option", null);
        
        CustomText text9 = new CustomText(239, 367, "Level", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text9.setOpacity(0.6);

        CustomComboBox<String> levelop = new CustomComboBox<>(238, 383, 49, 25, List.of("I", "II", "III", "IV", "V"), "Select an option", null);

        CustomText text10 = new CustomText(300, 367, "College", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text10.setOpacity(0.6);

        CustomComboBox<String> colop = new CustomComboBox<>(300, 383, 49, 25, List.of("COE", "COS", "CAFA", "CIT"), "Select an option", null);

        CustomText text11 = new CustomText(364, 367, "Age", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text11.setOpacity(0.6);

        CustomTextField ageField = new CustomTextField(364, 383, 32, 25, "20", null);

        CustomText text12 = new CustomText(414, 367, "Sex", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text12.setOpacity(0.6);

        CustomComboBox<String> sexop = new CustomComboBox<>(414, 383, 90, 25, List.of("Male", "Female"), "Select an option", null);

        CustomText text13 = new CustomText(530, 367, "ID Picture (2x2)", 12, FontWeight.SEMI_BOLD, Color.web("000000"));

        CustomButton uploadButton = new CustomButton(518, 381, 120, 125, "Upload Image", Color.WHITE);
        CustomImageView imageView = new CustomImageView(518, 381, 120, 120, "file://", null);

        // Set up FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        
        final File[] selectedImageFile = {null};
        // Button action: Open file chooser and load image
        uploadButton.setOnAction(e -> {
            File File = fileChooser.showOpenDialog(Main.getPrimaryStage());  // Use the passed stage
            if (File != null) {
                try {
                    Image image = new Image(File.toURI().toString());
                    imageView.setImage(image);
                    selectedImageFile[0] = File;
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Image Load Failed");
                    alert.setContentText("Could not load the image: " + ex.getMessage());
                    alert.showAndWait();
                }
            }
        });
        CustomText text14 = new CustomText(239, 417, "Birthday", 12, FontWeight.SEMI_BOLD, Color.web("000000"));
        text14.setOpacity(0.6);

        CustomDatePicker bdayPicker = new CustomDatePicker(238, 433, 266, 25, "MM/dd/yyyy", null);

        CustomText text15 = new CustomText(239, 467, "Nationality", 12, FontWeight.SEMI_BOLD, Color.web("000000"));
        text15.setOpacity(0.6);

        CustomTextField NatField = new CustomTextField(238, 483, 266, 25, "Pinoy", null);

        CustomText text16 = new CustomText(238, 517, "Person's Address", 12, FontWeight.SEMI_BOLD, Color.web("000000"));
        text16.setOpacity(0.6);

        CustomLine line = new CustomLine(238, 540, 638, 540, 0.5, Color.web("#000000"));
        
        CustomText text17 = new CustomText(238, 559, "Present Address", 12, FontWeight.SEMI_BOLD, Color.web("000000"));
        text17.setOpacity(0.6);
        
        CustomTextField AdsField = new CustomTextField(238, 575, 400, 25, null, null);

        CustomText text18 = new CustomText(266, 620, 
                        "Please verify the data before submission.\n" + //
                        "Ensure all information entered is accurate and complete.\n" + //
                        "Incorrect or incomplete data may result in errors, delays,\n" + //
                        "or invalid records.", 12, FontWeight.SEMI_BOLD, null);
        text18.setFill(Color.web("#000000"));
        text18.setOpacity(0.6);

        CustomButton Subbut = new CustomButton(573, 629, 68, 24, "Submit", Color.web("#FFFFFF"));
        Subbut.setStyle("-fx-background-color: #E52949; -fx-text-fill: white; -fx-font-size: 12px;");

        // Add action to save data
        Subbut.setOnAction(e -> {
            // Collect data from fields
            String firstName = fnField.getText().trim();
            String lastName = lnField.getText().trim();
            String middleInitial = miField.getText().trim();
            String email = emField.getText().trim();
            String contactNumber = cnField.getText().trim();
            String course = majorop.getValue() != null ? majorop.getValue() : "";
            String year = levelop.getValue() != null ? levelop.getValue() : "";
            String section = colop.getValue() != null ? colop.getValue() : "";
            String age = ageField.getText().trim();
            String sex = sexop.getValue() != null ? sexop.getValue() : "";
            String birthday = bdayPicker.getFormattedDate();
            String nationality = NatField.getText().trim();
            String address = AdsField.getText().trim();

            boolean success = controller.addTeacher(firstName, lastName, middleInitial, email, contactNumber, 
                                                    course, year, section, age, sex, birthday, nationality, 
                                                    address, selectedImageFile[0]);

            if (success) {
                fnField.clear();
                lnField.clear();
                miField.clear();
                emField.clear();
                cnField.clear();
                majorop.setValue(null);
                levelop.setValue(null);
                colop.setValue(null);
                ageField.clear();
                sexop.setValue(null);
                NatField.clear();
                AdsField.clear();
                imageView.setImage(null);  // Clear image display
                selectedImageFile[0] = null;  // Reset selected file
                facultyTable.refreshData();  // Refresh table
            }
        });

        // Load initial student data from controller
        facultyData.addAll(controller.getTeachers());

        // Define action callbacks for table buttons
        Consumer<application.Models.Faculty> onDelete = teacher -> {
            // Remove from files (e.g., masterfile.txt) - add logic here
            controller.deleteTeacher(teacher);  // Assume you add this to AddStudentController
            // Optional: Show confirmation alert
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete this faculty?", ButtonType.YES, ButtonType.NO);
            if (confirm.showAndWait().get() == ButtonType.YES) {
                // Proceed with delete
            }
        };

        Consumer<application.Models.Faculty> onEdit = faculty -> {
            // Open edit dialog or scene (e.g., populate form with faculty data)
            System.out.println("Edit: " + faculty.getFirstName());  // Placeholder - replace with actual logic
        };

        Consumer<application.Models.Faculty> onView = faculty -> {
            // Open view dialog (e.g., display read-only details)
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("View Faculty");
            alert.setContentText("Details: " + faculty.toString());
            alert.showAndWait();
        };
    
        // Instantiate the table
        facultyTable = new Table<>(facultyData, "Major", onDelete, onEdit, onView);
        facultyTable.setLayoutX(676);  // Align with form's left edge
        facultyTable.setLayoutY(120);  
            
        // Add all elements to root
        root.getChildren().addAll(sideBar, logoView, text1, navBar, details, text2, text3, fnField, text4, lnField, text5, miField, text6, emField, text7, cnField, text8, majorop, text9, levelop, text10, colop, text11, ageField, text12, sexop, text13, uploadButton, imageView, text14, bdayPicker, text15, NatField, text16, line, text17, AdsField, text18, Subbut, facultyTable);
    }

    public Scene getScene() {
        return scene;
    }  
}
