package application.Ctrls;  // Adjust package as needed (e.g., match your project structure)
import application.Models.Faculty;
import application.Models.Student;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddFacultyController {
    private List<Faculty> Teacher = new ArrayList<>();

    public AddFacultyController() {
        loadTeachersFromFile();
    }

    private void loadTeachersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("masterfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 15) {  // Ensure all fields are present
                    Faculty faculty = new Faculty();
                    faculty.setId(parts[0]);
                    faculty.setFirstName(parts[1]);
                    faculty.setLastName(parts[2]);
                    faculty.setMiddleInitial(parts[3]);
                    faculty.setEmail(parts[4]);
                    faculty.setContactNumber(parts[5]);
                    faculty.setmajor(parts[6]);
                    faculty.setlevel(parts[7]);
                    faculty.setcollege(parts[8]);
                    faculty.setAge(parts[9]);
                    faculty.setSex(parts[10]);
                    faculty.setBirthday(parts[11]);
                    faculty.setNationality(parts[12]);
                    faculty.setAddress(parts[13]);
                    faculty.setImagePath(parts[14]);
                    Teacher.add(faculty);
                }
            }
        } catch (IOException e) {
            // File might not exist yet, ignore
        }
    }
    
    public boolean addTeacher(String firstName, String lastName, String middleInitial, String email, 
                          String contactNumber, String major, String level, String college, 
                          String age, String sex, String birthday, String nationality, 
                          String address, File selectedImageFile) {

        // Trim inputs (unchanged)
        firstName = firstName.trim();
        lastName = lastName.trim();
        middleInitial = middleInitial.trim();
        email = email.trim();
        contactNumber = contactNumber.trim();
        major = major != null ? major.trim() : "";
        level = level != null ? level.trim() : "";
        college = college != null ? college.trim() : "";
        age = age.trim();
        sex = sex != null ? sex.trim() : "";
        birthday = birthday.trim();
        nationality = nationality.trim();
        address = address.trim();

        // Validation (unchanged)
        if (firstName.isEmpty() || lastName.isEmpty() || major.isEmpty() || email.isEmpty() || age.isEmpty() || sex.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Email");
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
            return false;
        }

        // Image handling (unchanged, but adjusted filename prefix to "faculty_")
        String imagePath = "";
        if (selectedImageFile != null) {
            try {
                Path imagesDir = Paths.get("images");
                Files.createDirectories(imagesDir);
                String fileName = "faculty_" + System.currentTimeMillis() + "_" + selectedImageFile.getName();
                Path targetPath = imagesDir.resolve(fileName);
                Files.copy(selectedImageFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                imagePath = targetPath.toString();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Image Copy Failed");
                alert.setContentText("Could not save the image: " + ex.getMessage());
                alert.showAndWait();
                return false;
            }
        }

        // Create Faculty object (assuming Faculty has a constructor like Student)
        Faculty newTeacher = new Faculty(null, firstName, lastName, middleInitial, email, contactNumber, 
                                        major, level, college, age, sex, birthday, nationality, address, imagePath, null);

        // Add to list (unchanged)
        Teacher.add(newTeacher);

        // Call the separate save methods
        boolean masterSaved = saveToMasterFile(newTeacher);
        boolean transactionSaved = saveToTransactionFile(firstName, lastName, major);

        if (masterSaved && transactionSaved) {
            // Success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Record Saved");
            alert.setContentText("Faculty details have been saved successfully.");
            alert.showAndWait();
            return true;
        } else {
            // Error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Save Failed");
            alert.setContentText("An error occurred while saving the record.");
            alert.showAndWait();
            return false;
        }
    }

    private boolean saveToMasterFile(Faculty faculty) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("masterfile.txt", true))) {
            writer.write(String.join(",",
                faculty.getId(),
                faculty.getFirstName(),
                faculty.getLastName(),
                faculty.getMiddleInitial(),
                faculty.getEmail(),
                faculty.getContactNumber(),
                faculty.getmajor(),
                faculty.getlevel(),  
                faculty.getcollege(),  
                faculty.getAge(),
                faculty.getSex(),
                faculty.getBirthday(),
                faculty.getNationality(),
                faculty.getAddress(),
                faculty.getImagePath()));
            writer.newLine();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private boolean saveToTransactionFile(String firstName, String lastName, String major) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transaction.txt", true))) {
            String timestamp = LocalDateTime.now().toString();
            writer.write("[" + timestamp + "] Faculty record submitted: " + firstName + " " + lastName + " (" + major + ")");
            writer.newLine();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void deleteTeacher(Faculty faculty) {
        try {
            // Define file paths (adjust based on your project structure)
            Path masterFilePath = Paths.get("masterfile.txt");
            Path transactionFilePath = Paths.get("transaction.txt");

            // Read masterfile.txt, remove matching faculty
            List<String> masterLines = Files.readAllLines(masterFilePath);
            List<String> updatedMasterLines = new ArrayList<>();
            for (String line : masterLines) {
                // Assume each line is a faculty record (e.g., "ID,FirstName,LastName,...")
                // Match by a unique field (e.g., ID or email). Adjust logic as needed.
                if (!line.contains(faculty.getId())) {
                    updatedMasterLines.add(line);
                }
            }
            Files.write(masterFilePath, updatedMasterLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // Read transaction.txt, remove matching faculty (if logging deletions)
            List<String> transactionLines = Files.readAllLines(transactionFilePath);
            List<String> updatedTransactionLines = new ArrayList<>();
            for (String line : transactionLines) {
                if (!line.contains(faculty.getId())) {  // Same matching logic
                    updatedTransactionLines.add(line);
                }
            }
            // Optionally, add a deletion log entry
            updatedTransactionLines.add("DELETED: " + faculty.getId() + " at " + java.time.LocalDateTime.now());
            Files.write(transactionFilePath, updatedTransactionLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // Remove from in-memory list
            Teacher.remove(faculty);

            System.out.println("Faculty deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error (e.g., show alert in UI)
        }
    }

    public List<Faculty> getTeachers() {
        return Teacher;
    }
}