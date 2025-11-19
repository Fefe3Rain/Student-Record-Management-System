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
// Added for Table component
import application.UI.components.*;
import application.UI.screens.DashboardScene;
import application.Models.Student;
import application.Ctrls.AddStudentController;

public class UGScene {
    private Scene scene;
    private AddStudentController controller = new AddStudentController();
    private Table<Student> studentTable;  // Added: Table instance
    private ObservableList<Student> studentData = FXCollections.observableArrayList();  // Added: Data for table
    private Student currentStudent = null;

    public UGScene() {
        Group root = new Group();
        scene = new Scene(root, 1300, 700, Color.web("#F9FAFB"));  // Updated height for table

        // Sidebar
        CustomRectangle sideBar = new CustomRectangle(0, 0, 200, 700, Color.web("#4B4B4B"), null);

        // Logo (adjust path as needed)
        CustomImageView logoView = new CustomImageView(12, 14, 42, 42, "file:///C:/Users/Rain Sidney/OneDrive/Documents/BSIT College Files/2nd Year 1st Sem/OOP/Student Record Management System/src/Images/TUP Logo.png", null);

        // Admin Portal Text
        CustomText text1 = new CustomText(60, 42, "Admin Portal", 18, FontWeight.BOLD, Color.web("#F3F4F6"));

        // Navbar
        CustomRectangle navBar = new CustomRectangle(200, 0, 1100, 70, Color.web("#FFFFFF"), Color.DIMGRAY);

        CustomRectangle details = new CustomRectangle(213, 83, 450, 600, Color.web("#FFFFFF"), null);

        CustomText text2 = new CustomText(238, 98, "Student Details", 13, FontWeight.BOLD, Color.web("#000000"));

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

        CustomText text8 = new CustomText(239, 307, "Course", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text8.setOpacity(0.6);

        CustomComboBox<String> courseop = new CustomComboBox<>(238, 323, 400, 25, List.of("BSIT", "BSCS", "BSIS"), "Select an option", null);
        
        CustomText text9 = new CustomText(239, 367, "Year", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text9.setOpacity(0.6);

        CustomComboBox<String> yearop = new CustomComboBox<>(238, 383, 49, 25, List.of("1", "2", "3", "4", "5"), "Select an option", null);

        CustomText text10 = new CustomText(300, 367, "Section", 12, FontWeight.SEMI_BOLD, Color.web("#000000"));
        text10.setOpacity(0.6);

        CustomComboBox<String> secop = new CustomComboBox<>(300, 383, 49, 25, List.of("A", "B", "C", "D"), "Select an option", null);

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
            // Collect data (same as before)
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
            String birthday = bdayPicker.getFormattedDate();
            String nationality = NatField.getText().trim();
            String address = AdsField.getText().trim();
            // ... (collect all data)

            if (currentStudent == null) {
                // Add new student
                Student newStudent = controller.addStudent(firstName, lastName, middleInitial, email, contactNumber,
                                                        course, year, section, age, sex, birthday, nationality,
                                                        address, selectedImageFile[0]);
                if (newStudent != null) {
                    studentData.add(newStudent);
                    fnField.clear();
                    lnField.clear();
                    miField.clear();
                    emField.clear();
                    cnField.clear();
                    courseop.setValue(null);
                    yearop.setValue(null);
                    secop.setValue(null);
                    ageField.clear();
                    sexop.setValue(null);
                    NatField.clear();
                    AdsField.clear();
                    imageView.setImage(null);  // Clear image display
                    selectedImageFile[0] = null;  // Reset selected file
                    studentTable.refreshData();
                }
            } else {
                // Update existing student
                currentStudent.setFirstName(firstName);
                // ... set all fields on currentStudent
                if (controller.updateStudent(currentStudent)) {
                    studentTable.refreshData();
                    // Clear fields and reset
                    currentStudent = null;
                    Subbut.setText("Submit");
                    // Clear fields
                }
            }
        });
        studentData.addAll(controller.getStudents());

        // Define action callbacks for table buttons
        Consumer<Student> onDelete = student -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete this student?", ButtonType.YES, ButtonType.NO);
            if (confirm.showAndWait().get() == ButtonType.YES) {
                controller.deleteStudent(student);
                studentData.remove(student);
                studentTable.refreshData();

                // Clear form fields and reset state after deletion
                fnField.clear();
                lnField.clear();
                miField.clear();
                emField.clear();
                cnField.clear();
                courseop.setValue(null);
                yearop.setValue(null);
                secop.setValue(null);
                ageField.clear();
                sexop.setValue(null);
                bdayPicker.setValue(null);
                NatField.clear();
                AdsField.clear();
                imageView.setImage(null);
                selectedImageFile[0] = null;
                currentStudent = null;  // Reset for new submissions
                Subbut.setText("Submit");  // Reset button text
            }
        };

        Consumer<Student> onEdit = student -> {
            currentStudent = student;
            // Populate fields (as before)
            fnField.setText(student.getFirstName());
            lnField.setText(student.getLastName());
            miField.setText(student.getMiddleInitial());
            emField.setText(student.getEmail());
            cnField.setText(student.getContactNumber());
            courseop.setValue(student.getCourse());
            yearop.setValue(student.getYear());
            secop.setValue(student.getSection());
            ageField.setText(student.getAge());
            sexop.setValue(student.getSex());
            bdayPicker.setValue(java.time.LocalDate.parse(student.getBirthday(), java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            NatField.setText(student.getNationality());
            AdsField.setText(student.getAddress());
            // Load image if available
            if (student.getImagePath() != null && !student.getImagePath().isEmpty()) {
                imageView.setImage(new Image("file:" + student.getImagePath()));
            }

            // Explicitly enable all fields for editing
            fnField.setDisable(false);
            lnField.setDisable(false);  // Ensure this is enabled
            miField.setDisable(false);
            emField.setDisable(false);
            cnField.setDisable(false);
            courseop.setDisable(false);
            yearop.setDisable(false);
            secop.setDisable(false);
            ageField.setDisable(false);
            sexop.setDisable(false);
            bdayPicker.setDisable(false);
            NatField.setDisable(false);
            AdsField.setDisable(false);
            uploadButton.setDisable(false);  // Allow re-uploading image
            Subbut.setText("Update");
            Subbut.setDisable(false);
        };

        Consumer<Student> onView = student -> {
            // Populate fields with student data
            fnField.setText(student.getFirstName());
            lnField.setText(student.getLastName());
            miField.setText(student.getMiddleInitial());
            emField.setText(student.getEmail());
            cnField.setText(student.getContactNumber());
            courseop.setValue(student.getCourse());
            yearop.setValue(student.getYear());
            secop.setValue(student.getSection());
            ageField.setText(student.getAge());
            sexop.setValue(student.getSex());
            bdayPicker.setValue(java.time.LocalDate.parse(student.getBirthday(), java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            NatField.setText(student.getNationality());
            AdsField.setText(student.getAddress());
            // Load image if available
            if (student.getImagePath() != null && !student.getImagePath().isEmpty()) {
                imageView.setImage(new Image("file:" + student.getImagePath()));
            }

            // Disable fields for viewing
            fnField.setDisable(true);
            lnField.setDisable(true);
            // ... disable all other fields similarly
            Subbut.setDisable(true); // Hide submit button
        };
    
        // Instantiate the table
        studentTable = new Table<>(studentData, "Course", onDelete, onEdit, onView);
        studentTable.setLayoutX(676);  // Align with form's left edge
        studentTable.setLayoutY(120);  
            
        // Add all elements to root
        root.getChildren().addAll(sideBar, logoView, text1, navBar, details, text2, text3, fnField, text4, lnField, text5, miField, text6, emField, text7, cnField, text8, courseop, text9, yearop, text10, secop, text11, ageField, text12, sexop, text13, uploadButton, imageView, text14, bdayPicker, text15, NatField, text16, line, text17, AdsField, text18, Subbut, studentTable);
    }

    public Scene getScene() {
        return scene;
    }  

}
