package application.Ctrls;  // Adjust package as needed (e.g., match your project structure)
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

public class AddStudentController {
    private List<Student> students = new ArrayList<>();

    public AddStudentController() {
        loadStudentsFromFile();
    }

    private void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("masterfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 15) {  // Ensure all fields are present
                    Student student = new Student();
                    student.setId(parts[0]);
                    student.setFirstName(parts[1]);
                    student.setLastName(parts[2]);
                    student.setMiddleInitial(parts[3]);
                    student.setEmail(parts[4]);
                    student.setContactNumber(parts[5]);
                    student.setCourse(parts[6]);
                    student.setYear(parts[7]);
                    student.setSection(parts[8]);
                    student.setAge(parts[9]);
                    student.setSex(parts[10]);
                    student.setBirthday(parts[11]);
                    student.setNationality(parts[12]);
                    student.setAddress(parts[13]);
                    student.setImagePath(parts[14]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            // File might not exist yet, ignore
        }
    }
    
    public Student addStudent(String firstName, String lastName, String middleInitial, String email,
                              String contactNumber, String course, String year, String section,
                              String age, String sex, String birthday, String nationality,
                              String address, File selectedImageFile) {

        firstName = firstName.trim();
        lastName = lastName.trim();
        middleInitial = middleInitial.trim();
        email = email.trim();
        contactNumber = contactNumber.trim();
        course = course != null ? course.trim() : "";
        year = year != null ? year.trim() : "";
        section = section != null ? section.trim() : "";
        age = age.trim();
        sex = sex != null ? sex.trim(): "";
        birthday = birthday.trim();
        nationality = nationality.trim();
        address = address.trim();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || email.isEmpty() || age.isEmpty() || sex.isEmpty()) {
            // Show error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();
            return null;
        }

        // Basic email validation (must contain @ and .)
        if (!email.contains("@") || !email.contains(".")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Email");
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
            return null;
        }

        String imagePath = "";
            if (selectedImageFile != null) {
            try {
                // Create images directory if it doesn't exist
                Path imagesDir = Paths.get("images");
                Files.createDirectories(imagesDir);
                // Copy image to images/ with a unique name
                String fileName = "student_" + System.currentTimeMillis() + "_" + selectedImageFile.getName();
                Path targetPath = imagesDir.resolve(fileName);
                Files.copy(selectedImageFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                imagePath = targetPath.toString();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Image Copy Failed");
                alert.setContentText("Could not save the image: " + ex.getMessage());
                alert.showAndWait();
                return null;
            }
        }

        Student newStudent = new Student( null, firstName, lastName, middleInitial, email, contactNumber,
                                        course, year, section, age, sex, birthday, nationality, address, imagePath, null);

        students.add(newStudent);

        try {
            // Save to masterfile.txt (append mode for multiple records)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("masterfile.txt", true))) {
                writer.write(String.join(",",
                    newStudent.getId(),
                    newStudent.getFirstName(),
                    newStudent.getLastName(),
                    newStudent.getMiddleInitial(),
                    newStudent.getEmail(),
                    newStudent.getContactNumber(),
                    newStudent.getCourse(),
                    newStudent.getYear(),
                    newStudent.getSection(),
                    newStudent.getAge(),
                    newStudent.getSex(),
                    newStudent.getBirthday(),
                    newStudent.getNationality(),
                    newStudent.getAddress(),
                    newStudent.getImagePath()));
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
            return newStudent;

            } catch (IOException ex) {
                // Error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Save Failed");
                alert.setContentText("An error occurred while saving: " + ex.getMessage());
                alert.showAndWait();
                return null;
        }
    }

    public boolean updateStudent(Student updatedStudent) {
        // Find and update in-memory list
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(updatedStudent.getId())) {
                students.set(i, updatedStudent);
                break;
            }
        }

        // Update masterfile.txt: Read all lines, replace the matching one, write back
        try {
            Path masterFilePath = Paths.get("masterfile.txt");
            List<String> lines = Files.readAllLines(masterFilePath);
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                if (line.startsWith(updatedStudent.getId() + ",")) {
                    // Replace with updated data
                    updatedLines.add(String.join(",",
                        updatedStudent.getId(),
                        updatedStudent.getFirstName(),
                        updatedStudent.getLastName(),
                        updatedStudent.getMiddleInitial(),
                        updatedStudent.getEmail(),
                        updatedStudent.getContactNumber(),
                        updatedStudent.getCourse(),
                        updatedStudent.getYear(),
                        updatedStudent.getSection(),
                        updatedStudent.getAge(),
                        updatedStudent.getSex(),
                        updatedStudent.getBirthday(),
                        updatedStudent.getNationality(),
                        updatedStudent.getAddress(),
                        updatedStudent.getImagePath()));
                } else {
                    updatedLines.add(line);
                }
            }
            Files.write(masterFilePath, updatedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // Log update in transaction.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("transaction.txt", true))) {
                String timestamp = LocalDateTime.now().toString();
                writer.write("[" + timestamp + "] Student record updated: " + updatedStudent.getFirstName() + " " + updatedStudent.getLastName());
                writer.newLine();
            }

            return true;
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Update Failed");
            alert.setContentText("An error occurred while updating: " + ex.getMessage());
            alert.showAndWait();
            return false;
        }
    }

    public void deleteStudent(Student student) {
        try {
            // Define file paths (adjust based on your project structure)
            Path masterFilePath = Paths.get("masterfile.txt");
            Path transactionFilePath = Paths.get("transaction.txt");

            // Read masterfile.txt, remove matching student
            List<String> masterLines = Files.readAllLines(masterFilePath);
            List<String> updatedMasterLines = new ArrayList<>();
            for (String line : masterLines) {
                // Assume each line is a student record (e.g., "ID,FirstName,LastName,...")
                // Match by a unique field (e.g., ID or email). Adjust logic as needed.
                if (!line.contains(student.getId())) {  // Assuming Student has getId()
                    updatedMasterLines.add(line);
                }
            }
            Files.write(masterFilePath, updatedMasterLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // Read transaction.txt, remove matching student (if logging deletions)
            List<String> transactionLines = Files.readAllLines(transactionFilePath);
            List<String> updatedTransactionLines = new ArrayList<>();
            for (String line : transactionLines) {
                if (!line.contains(student.getId())) {  // Same matching logic
                    updatedTransactionLines.add(line);
                }
            }
            // Optionally, add a deletion log entry
            updatedTransactionLines.add("DELETED: " + student.getId() + " at " + java.time.LocalDateTime.now());
            Files.write(transactionFilePath, updatedTransactionLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // Remove from in-memory list
            students.remove(student);

            System.out.println("Student deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error (e.g., show alert in UI)
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}